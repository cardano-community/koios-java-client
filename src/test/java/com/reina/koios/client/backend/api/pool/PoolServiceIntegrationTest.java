package com.reina.koios.client.backend.api.pool;

import com.reina.koios.client.backend.api.pool.model.*;
import com.reina.koios.client.backend.factory.BackendFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PoolServiceIntegrationTest {

    private PoolService poolService;

    @BeforeAll
    public void setup() {
        poolService = BackendFactory.getKoiosTestnetService().getPoolService();
    }

    @Test
    void getPoolListTest() {
        Pool[] poolList = poolService.getPoolList();
        log.info(Arrays.toString(poolList));
        Assertions.assertNotNull(poolList);
    }

    @Test
    void getPoolInformationTest() {
        String poolBech32 = "pool1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8";
        PoolInfo[] poolInfos = poolService.getPoolInformation(poolBech32);
        log.info(Arrays.toString(poolInfos));
        Assertions.assertNotNull(poolInfos);
    }

    @Test
    void getPoolDelegatorsListTest() {
        String poolBech32 = "pool1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8";
        long epochNo = 180L;
        PoolDelegator[] poolDelegators = poolService.getPoolDelegatorsList(poolBech32,epochNo);
        log.info(Arrays.toString(poolDelegators));
        Assertions.assertNotNull(poolDelegators);
    }

    @Test
    void getPoolBlocksTest() {
        String poolBech32 = "pool1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8";
        long epochNo = 180L;
        PoolBlock[] poolBlocks = poolService.getPoolBlocks(poolBech32,epochNo);
        log.info(Arrays.toString(poolBlocks));
        Assertions.assertNotNull(poolBlocks);
    }

    @Test
    void getPoolUpdatesTest() {
        String poolBech32 = "pool1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8";
        PoolUpdate[] poolUpdates = poolService.getPoolUpdates(poolBech32);
        log.info(Arrays.toString(poolUpdates));
        Assertions.assertNotNull(poolUpdates);
    }

    @Test
    void getPoolRelaysTest() {
        PoolRelay[] poolRelays = poolService.getPoolRelays();
        log.info(Arrays.toString(poolRelays));
        Assertions.assertNotNull(poolRelays);
    }

    @Test
    void getPoolMetadataTest() {
        PoolMetadata[] poolMetadata = poolService.getPoolMetadata();
        log.info(Arrays.toString(poolMetadata));
        Assertions.assertNotNull(poolMetadata);
    }
}
