package com.reina.koios.client.backend.api.block;

import com.reina.koios.client.backend.api.TxHash;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.block.model.Block;
import com.reina.koios.client.backend.api.block.model.BlockInfo;
import com.reina.koios.client.backend.factory.BackendFactory;
import com.reina.koios.client.backend.factory.options.Limit;
import com.reina.koios.client.backend.factory.options.Options;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BlockServiceMainnetIntegrationTest {

    private BlockService blockService;

    @BeforeAll
    public void setup() {
        blockService = BackendFactory.getKoiosMainnetService().getBlockService();
    }

    @Test
    void getBlockListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Block[] blockList = blockService.getBlockList(options);
        log.info(Arrays.toString(blockList));
        Assertions.assertNotNull(blockList);
        Assertions.assertEquals(10,blockList.length);
    }

    @Test
    void getBlockInformationTest() throws ApiException {
        String hash = "f6192a1aaa6d3d05b4703891a6b66cd757801c61ace86cbe5ab0d66e07f601ab";
        BlockInfo[] blockInformation = blockService.getBlockInformation(hash);
        log.info(Arrays.toString(blockInformation));
        Assertions.assertNotNull(blockInformation);
        Assertions.assertEquals(hash,blockInformation[0].getHash());
    }

    @Test
    void getBlockInformationBadRequestTest() {
        String hash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> blockService.getBlockInformation(hash));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getBlockTransactionsTest() throws ApiException {
        String hash = "f6192a1aaa6d3d05b4703891a6b66cd757801c61ace86cbe5ab0d66e07f601ab";
        TxHash[] blockTransactions = blockService.getBlockTransactions(hash);
        log.info(Arrays.toString(blockTransactions));
        Assertions.assertNotNull(blockTransactions);
    }

    @Test
    void getBlockTransactionsBadRequestTest() {
        String hash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> blockService.getBlockTransactions(hash));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }
}
