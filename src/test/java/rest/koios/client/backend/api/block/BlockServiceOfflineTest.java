package rest.koios.client.backend.api.block;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.block.model.Block;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Options;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

class BlockServiceOfflineTest {

    private static final String BLOCK_HASH =
            "88265b6b01bd9516009285eabaddedea18d42f6c778e5942b200afec232aca1e";
    private static final List<String> HASHES = Collections.singletonList(BLOCK_HASH);

    private MockWebServer server;
    private BlockService blockService;

    @BeforeEach
    void setup() throws IOException {
        server = new MockWebServer();
        server.start();
        blockService = BackendFactory
                .getCustomRPCService(server.url("/api/v1/").toString()).getBlockService();
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    private void enqueue(int count, String body) {
        for (int i = 0; i < count; i++) {
            server.enqueue(new MockResponse().setResponseCode(200)
                    .setHeader("Content-Type", "application/json").setBody(body));
        }
    }

    @Test
    void everyEndpointIsReachedTest() throws ApiException, InterruptedException {
        enqueue(6, "[]");

        blockService.getBlockList(Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/blocks"));

        blockService.getBlocksInformation(HASHES, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/block_info"));

        blockService.getBlockTransactions(HASHES, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/block_txs"));

        blockService.getBlockTransactionsCbor(HASHES, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/block_tx_cbor"));

        blockService.getBlockTransactionsInfo(HASHES, true, true, true, true, true, true, true, Options.EMPTY);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/block_tx_info"));

        blockService.getBlockInformation(BLOCK_HASH);
        Assertions.assertTrue(server.takeRequest().getPath().startsWith("/api/v1/block_info"));
    }

    @Test
    void latestBlockReturnsTheFirstRowTest() throws ApiException, InterruptedException {
        server.enqueue(new MockResponse().setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("[{\"hash\":\"" + BLOCK_HASH + "\",\"block_height\":13917803,\"epoch_no\":655}]"));

        Result<Block> result = blockService.getLatestBlock();

        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertEquals(BLOCK_HASH, result.getValue().getHash());
        String path = server.takeRequest().getPath();
        Assertions.assertTrue(path.startsWith("/api/v1/blocks"), path);
        Assertions.assertTrue(path.contains("limit=1"), path);
    }

    @Test
    void emptyListYieldsASyntheticNotFoundTest() throws ApiException {
        enqueue(1, "[]");

        Result<Block> result = blockService.getLatestBlock();

        Assertions.assertFalse(result.isSuccessful());
        Assertions.assertEquals(404, result.getCode());
        Assertions.assertTrue(result.isSynthetic());
    }

    @Test
    void invalidBlockHashIsRejectedBeforeSendingTest() {
        Assertions.assertThrows(ApiException.class,
                () -> blockService.getBlockInformation("not-hex"));
        Assertions.assertEquals(0, server.getRequestCount(), "nothing should have been sent");
    }
}
