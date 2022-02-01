package com.reina.koios.client.backend.api.pool;

import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.pool.model.*;
import com.reina.koios.client.backend.factory.BackendFactory;
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
class PoolServiceIntegrationTest {

    private PoolService poolService;

    @BeforeAll
    public void setup() {
        poolService = BackendFactory.getKoiosTestnetService().getPoolService();
    }

    @Test
    void getPoolListTest() throws ApiException {
        Pool[] poolList = poolService.getPoolList();
        log.info(Arrays.toString(poolList));
        Assertions.assertNotNull(poolList);
    }

    @Test
    void getPoolInformationTest() throws ApiException {
        String poolId = "pool1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8";
        PoolInfo[] poolInfos = poolService.getPoolInformation(poolId);
        log.info(Arrays.toString(poolInfos));
        Assertions.assertNotNull(poolInfos);
    }

    @Test
    void getPoolInformationBadRequestTest() {
        String poolId = "asdsa";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolInformation(poolId));
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
    void getPoolUpdatesBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolUpdates(poolBech32));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getPoolRelaysTest() throws ApiException {
        PoolRelay[] poolRelays = poolService.getPoolRelays();
        log.info(Arrays.toString(poolRelays));
        Assertions.assertNotNull(poolRelays);
    }

    @Test
    void getPoolMetadataTest() throws ApiException {
        PoolMetadata[] poolMetadata = poolService.getPoolMetadata();
        log.info(Arrays.toString(poolMetadata));
        Assertions.assertNotNull(poolMetadata);
    }
}
