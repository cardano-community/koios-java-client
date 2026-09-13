package rest.koios.client.backend.api.pool;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
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

class PoolServiceOfflineTest {

    private static final String POOL = "pool1z5uqdk7dzdxaae5633fqfcu2eqzy3a3rgtuvy087fdld7yws0xt";
    private static final List<String> POOLS = Collections.singletonList(POOL);

    private MockWebServer server;
    private PoolService poolService;

    @BeforeEach
    void setup() throws IOException {
        server = new MockWebServer();
        server.start();
        poolService = BackendFactory
                .getCustomRPCService(server.url("/api/v1/").toString()).getPoolService();
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
        enqueue(16);

        poolService.getPoolList(Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_list"));

        poolService.getPoolInformation(POOLS, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_info"));

        poolService.getPoolStakeSnapshot(POOL, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_stake_snapshot"));

        poolService.getPoolDelegatorsList(POOL, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_delegators"));

        poolService.getPoolDelegatorsHistory(POOL, null, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_delegators_history"));

        poolService.getPoolBlocks(POOL, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_blocks"));

        poolService.getPoolOwnerHistory(POOLS, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_owner_history"));

        poolService.getPoolHistory(POOL, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_history"));

        poolService.getPoolUpdatesByPoolBech32(POOL, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_updates"));

        poolService.getPoolUpdates(Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_updates"));

        poolService.getPoolRegistrations(null, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_registrations"));

        poolService.getPoolRetirements(null, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_retirements"));

        poolService.getPoolRelays(Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_relays"));

        poolService.getPoolGroups(Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_groups"));

        poolService.getPoolMetadata(Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_metadata"));

        poolService.getPoolCalidusKeys(Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/pool_calidus_keys"));

        Assertions.assertEquals(16, server.getRequestCount());
    }

    @Test
    void poolIdsArePostedInTheBodyTest() throws ApiException, InterruptedException {
        enqueue(1);
        poolService.getPoolInformation(POOLS, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getBody().readUtf8().contains(POOL));

        enqueue(1);
        poolService.getPoolMetadata(POOLS, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getBody().readUtf8().contains(POOL));
    }

    @Test
    void epochScopedCallsCarryTheEpochTest() throws ApiException, InterruptedException {
        enqueue(3);

        poolService.getPoolBlocksByEpoch(POOL, 500, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().contains("500"));

        poolService.getPoolRegistrations(500, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().contains("500"));

        poolService.getPoolRetirements(500, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().contains("500"));
    }

    @Test
    void invalidInputIsRejectedBeforeSendingTest() {
        Assertions.assertThrows(ApiException.class,
                () -> poolService.getPoolDelegatorsList("not-a-pool", Options.EMPTY));
        Assertions.assertThrows(ApiException.class,
                () -> poolService.getPoolBlocksByEpoch(POOL, -1, Options.EMPTY));
        Assertions.assertEquals(0, server.getRequestCount(), "nothing should have been sent");
    }
}
