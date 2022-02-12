package com.reina.koios.client.backend.api.pool;

import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.pool.model.*;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PoolServiceTestnetIntegrationTest {

    private PoolService poolService;

    @BeforeAll
    public void setup() {
        poolService = BackendFactory.getKoiosTestnetService().getPoolService();
    }

    @Test
    void getPoolListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Pool[] poolList = poolService.getPoolList(options);
        log.info(Arrays.toString(poolList));
        Assertions.assertNotNull(poolList);
        Assertions.assertEquals(10, poolList.length);
    }

    @Test
    void getPoolInformationTest() throws ApiException {
        String poolId = "pool1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8";
        PoolInfo[] poolInfos = poolService.getPoolInformation(List.of(poolId));
        log.info(Arrays.toString(poolInfos));
        Assertions.assertNotNull(poolInfos);
    }

    @Test
    void getPoolInformationBadRequestTest() {
        String poolId = "asdsa";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolInformation(List.of(poolId)));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getPoolDelegatorsListTest() throws ApiException {
        String poolBech32 = "pool1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8";
        PoolDelegator[] poolDelegators = poolService.getPoolDelegatorsList(poolBech32, 180L);
        log.info(Arrays.toString(poolDelegators));
        Assertions.assertNotNull(poolDelegators);
    }

    @Test
    void getPoolDelegatorsListLimitTest() throws ApiException {
        String poolBech32 = "pool1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8";
        Options options = Options.builder().option(Limit.of(2)).build();
        PoolDelegator[] poolDelegators = poolService.getPoolDelegatorsList(poolBech32, options);
        log.info(Arrays.toString(poolDelegators));
        Assertions.assertNotNull(poolDelegators);
        Assertions.assertEquals(2, poolDelegators.length);
    }

    @Test
    void getPoolDelegatorsListBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolDelegatorsList(poolBech32, 180L));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getPoolBlocksTest() throws ApiException {
        String poolBech32 = "pool1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8";
        PoolBlock[] poolBlocks = poolService.getPoolBlocks(poolBech32, 180L);
        log.info(Arrays.toString(poolBlocks));
        Assertions.assertNotNull(poolBlocks);
    }

    @Test
    void getPoolBlocksLimitTest() throws ApiException {
        String poolBech32 = "pool1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8";
        Options options = Options.builder().option(Limit.of(10)).build();
        PoolBlock[] poolBlocks = poolService.getPoolBlocks(poolBech32, options);
        log.info(Arrays.toString(poolBlocks));
        Assertions.assertNotNull(poolBlocks);
        Assertions.assertEquals(10, poolBlocks.length);
    }

    @Test
    void getPoolBlocksBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolBlocks(poolBech32, 180L));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getPoolUpdatesTest() throws ApiException {
        String poolBech32 = "pool1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8";
        PoolUpdate[] poolUpdates = poolService.getPoolUpdates(poolBech32);
        log.info(Arrays.toString(poolUpdates));
        Assertions.assertNotNull(poolUpdates);
    }

    @Test
    void getPoolUpdatesLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        PoolUpdate[] poolUpdates = poolService.getPoolUpdates(options);
        log.info(Arrays.toString(poolUpdates));
        Assertions.assertNotNull(poolUpdates);
        Assertions.assertEquals(10, poolUpdates.length);
    }

    @Test
    void getPoolUpdatesBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolUpdates(poolBech32));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getPoolRelaysLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        PoolRelay[] poolRelays = poolService.getPoolRelays(options);
        log.info(Arrays.toString(poolRelays));
        Assertions.assertNotNull(poolRelays);
        Assertions.assertEquals(10, poolRelays.length);
    }

    @Test
    void getPoolMetadataLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        PoolMetadata[] poolMetadata = poolService.getPoolMetadata(options);
        log.info(Arrays.toString(poolMetadata));
        Assertions.assertNotNull(poolMetadata);
        Assertions.assertEquals(10, poolMetadata.length);
    }
}
