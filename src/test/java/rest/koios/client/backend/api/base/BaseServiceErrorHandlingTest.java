package rest.koios.client.backend.api.base;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.asset.model.AssetInformation;
import rest.koios.client.backend.api.network.model.Tip;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.BackendService;

import java.io.IOException;
import java.util.List;

/**
 * Error handling tests that run against a local {@link MockWebServer} instead of a live Koios
 * instance, so server failures and the retry loop can be exercised deterministically.
 */
class BaseServiceErrorHandlingTest {

    private MockWebServer server;
    private BackendService backendService;

    @BeforeEach
    void setup() throws IOException {
        server = new MockWebServer();
        server.start();
        backendService = BackendFactory.getCustomRPCService(server.url("/api/v1/").toString());
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    @Test
    void successfulResponseIsReturnedTest() throws ApiException {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("[{\"hash\":\"abc\",\"epoch_no\":655,\"era\":\"Conway\"}]"));

        Result<Tip> result = backendService.getNetworkService().getChainTip();

        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertEquals(200, result.getCode());
        Assertions.assertEquals(655, result.getValue().getEpochNo());
        Assertions.assertEquals("Conway", result.getValue().getEra());
    }

    @Test
    void locallyRejectedRequestIsSyntheticTest() throws ApiException {
        // rejected by client-side validation, so no request is ever sent
        Result<List<AssetInformation>> result =
                backendService.getAssetService().getAssetInformationBulk(null, Options.EMPTY);

        Assertions.assertFalse(result.isSuccessful());
        Assertions.assertEquals(400, result.getCode());
        Assertions.assertTrue(result.isSynthetic(), "no request was sent, so the 400 is the client's");
        Assertions.assertNull(result.getError());
        Assertions.assertEquals(0, server.getRequestCount(), "nothing should have been sent");
    }

    @Test
    void successCarriesNoErrorTest() throws ApiException {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("[{\"hash\":\"abc\",\"epoch_no\":655,\"era\":\"Conway\"}]"));

        Result<Tip> result = backendService.getNetworkService().getChainTip();

        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNull(result.getError());
        Assertions.assertFalse(result.isSynthetic());
    }

    @Test
    void partialErrorBodyIsParsedTest() throws ApiException {
        server.enqueue(new MockResponse()
                .setResponseCode(400)
                .setHeader("Content-Type", "application/json")
                .setBody("{\"message\":\"request body too large\",\"hint\":\"send fewer ids\"}"));

        Result<Tip> result = backendService.getNetworkService().getChainTip();

        KoiosError error = result.getError();
        Assertions.assertNotNull(error);
        Assertions.assertEquals("request body too large", error.getMessage());
        Assertions.assertEquals("send fewer ids", error.getHint());
        Assertions.assertNull(error.getCode());
    }

    @Test
    void serverErrorBodyIsSurfacedTest() throws ApiException {
        String postgrestError = "{\"code\":\"42703\",\"details\":null,\"hint\":null," +
                "\"message\":\"column pgrst_call.ticker does not exist\"}";
        server.enqueue(new MockResponse()
                .setResponseCode(400)
                .setHeader("Content-Type", "application/json")
                .setBody(postgrestError));

        Result<Tip> result = backendService.getNetworkService().getChainTip();

        Assertions.assertFalse(result.isSuccessful());
        Assertions.assertEquals(400, result.getCode());
        Assertions.assertFalse(result.isSynthetic(), "a real server 400 is not synthetic");
        Assertions.assertEquals(postgrestError, result.getResponse());
        Assertions.assertNull(result.getValue());
        // the same body, parsed
        KoiosError error = result.getError();
        Assertions.assertNotNull(error);
        Assertions.assertEquals("42703", error.getCode());
        Assertions.assertEquals("column pgrst_call.ticker does not exist", error.getMessage());
        Assertions.assertNull(error.getDetails());
        Assertions.assertNull(error.getHint());
    }

    @Test
    void internalServerErrorIsSurfacedTest() throws ApiException {
        server.enqueue(new MockResponse().setResponseCode(500).setBody("upstream failure"));

        Result<Tip> result = backendService.getNetworkService().getChainTip();

        Assertions.assertFalse(result.isSuccessful());
        Assertions.assertEquals(500, result.getCode());
        Assertions.assertFalse(result.isSynthetic(), "a real server 500 is not synthetic");
        Assertions.assertEquals("upstream failure", result.getResponse());
        // a plain-text body is not a structured error; the raw text is still available
        Assertions.assertNull(result.getError());
    }

    @Test
    void payloadTooLargeIsSurfacedTest() throws ApiException {
        server.enqueue(new MockResponse().setResponseCode(413).setBody("Request body too large"));

        Result<Tip> result = backendService.getNetworkService().getChainTip();

        Assertions.assertFalse(result.isSuccessful());
        Assertions.assertEquals(413, result.getCode());
    }

    @Test
    void emptyResponseBodyReportsNotFoundTest() throws ApiException {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("[]"));

        Result<Tip> result = backendService.getNetworkService().getChainTip();

        Assertions.assertFalse(result.isSuccessful());
        // the server returned 200; this 404 is the client's, not Koios's
        Assertions.assertEquals(404, result.getCode());
        Assertions.assertTrue(result.isSynthetic(), "an empty body yields a client-generated code");
        Assertions.assertNull(result.getError());
        Assertions.assertEquals("Response Body is Empty", result.getResponse());
    }

    @Test
    void malformedJsonThrowsApiExceptionTest() {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("{not json at all"));

        Assertions.assertThrows(ApiException.class,
                () -> backendService.getNetworkService().getChainTip());
    }

    @Test
    void tooManyRequestsIsRetriedThenSucceedsTest() throws ApiException {
        server.enqueue(new MockResponse().setResponseCode(429));
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("[{\"hash\":\"abc\",\"epoch_no\":655,\"era\":\"Conway\"}]"));

        Result<Tip> result = backendService.getNetworkService().getChainTip();

        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertEquals(655, result.getValue().getEpochNo());
        Assertions.assertEquals(2, server.getRequestCount(), "the 429 should have been retried once");
    }

    @Test
    void gatewayTimeoutIsRetriedThenSucceedsTest() throws ApiException {
        server.enqueue(new MockResponse().setResponseCode(504));
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("[{\"hash\":\"abc\",\"epoch_no\":655,\"era\":\"Conway\"}]"));

        Result<Tip> result = backendService.getNetworkService().getChainTip();

        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertEquals(2, server.getRequestCount(), "the 504 should have been retried once");
    }

    @Test
    void retriesAreExhaustedAfterRetriesCountAttemptsTest() {
        for (int i = 0; i < 10; i++) {
            server.enqueue(new MockResponse().setResponseCode(429));
        }

        long startedAt = System.nanoTime();
        ApiException exception = Assertions.assertThrows(ApiException.class,
                () -> backendService.getNetworkService().getChainTip());
        long elapsedMillis = (System.nanoTime() - startedAt) / 1_000_000;

        Assertions.assertTrue(exception.getMessage().contains("429"), exception.getMessage());
        Assertions.assertEquals(5, server.getRequestCount(),
                "retriesCount defaults to 5, so 5 attempts should have been made");
        // Surefire sets KOIOS_JAVA_LIB_RETRY_SLEEP_TIME_SEC=1, so the backoff between the five
        // attempts is 1s + 2s + 3s + 4s. Asserting a floor of 5s catches the backoff being
        // applied in milliseconds instead of seconds, which made it 1000x too short.
        Assertions.assertTrue(elapsedMillis >= 5_000,
                "expected a real backoff between retries, took only " + elapsedMillis + "ms");
    }
}
