package rest.koios.client.backend.api.account;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Options;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Exercises {@link AccountService} against a local {@link MockWebServer}, so request shape can be
 * asserted without depending on a live instance.
 */
class AccountServiceOfflineTest {

    private static final String STAKE =
            "stake1uyrx65wjqjgeeksd8hptmcgl5jfyrqkfq0xe8xlp367kphsckq250";
    private static final List<String> STAKES = Collections.singletonList(STAKE);

    private MockWebServer server;
    private AccountService accountService;

    @BeforeEach
    void setup() throws IOException {
        server = new MockWebServer();
        server.start();
        accountService = BackendFactory
                .getCustomRPCService(server.url("/api/v1/").toString()).getAccountService();
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    private void enqueue(int count) {
        for (int i = 0; i < count; i++) {
            server.enqueue(new MockResponse().setResponseCode(200)
                    .setHeader("Content-Type", "application/json").setBody("[]"));
        }
    }

    @Test
    void everyEndpointIsReachedTest() throws ApiException, InterruptedException {
        enqueue(13);

        accountService.getAccountList(Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_list"));

        accountService.getAccountInformation(STAKES, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_info"));

        accountService.getCachedAccountInformation(STAKES, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_info_cached"));

        accountService.getAccountUTxOs(STAKES, false, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_utxos"));

        accountService.getAccountTxs(STAKE, null, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_txs"));

        accountService.getAccountRewards(STAKES, null, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_rewards"));

        accountService.getAccountUpdates(STAKES, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_updates"));

        accountService.getAccountAddresses(STAKES, false, false, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_addresses"));

        accountService.getAccountAssets(STAKES, null, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_assets"));

        accountService.getAccountHistory(STAKES, null, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_history"));

        accountService.getAccountStakeHistory(STAKES, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_stake_history"));

        accountService.getAccountRewardHistory(STAKES, null, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_reward_history"));

        accountService.getAccountUpdateHistory(STAKES, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/account_update_history"));

        Assertions.assertEquals(13, server.getRequestCount());
    }

    @Test
    void stakeAddressesArePostedInTheBodyTest() throws ApiException, InterruptedException {
        enqueue(1);
        accountService.getAccountInformation(STAKES, Options.EMPTY);
        RecordedRequest request = server.takeRequest();
        Assertions.assertEquals("POST", request.getMethod());
        Assertions.assertTrue(request.getBody().readUtf8().contains(STAKE));
    }

    @Test
    void epochFilterIsAppliedWhenGivenTest() throws ApiException, InterruptedException {
        enqueue(1);
        accountService.getAccountRewards(STAKES, 500, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getBody().readUtf8().contains("500"));
    }

    @Test
    void invalidInputIsRejectedBeforeSendingTest() {
        Assertions.assertThrows(ApiException.class,
                () -> accountService.getAccountRewards(STAKES, -1, Options.EMPTY));
        Assertions.assertThrows(ApiException.class,
                () -> accountService.getAccountTxs("not-a-stake-address", null, Options.EMPTY));
        Assertions.assertEquals(0, server.getRequestCount(), "nothing should have been sent");
    }
}
