package rest.koios.client.backend.api.block;

import rest.koios.client.backend.api.TxHash;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.block.model.Block;
import rest.koios.client.backend.api.block.model.BlockInfo;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;
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
class BlockServiceTestnetIntegrationTest {

    private BlockService blockService;

    @BeforeAll
    public void setup() {
        blockService = BackendFactory.getKoiosTestnetService().getBlockService();
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
        String hash = "50a63ac54ccceb7de3f145e440b93842a7c2c2dab62e9fbd3bd1414585b483e9";
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
        String hash = "50a63ac54ccceb7de3f145e440b93842a7c2c2dab62e9fbd3bd1414585b483e9";
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
