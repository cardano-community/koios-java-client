package com.reina.koios.client.backend.api.network;

import com.reina.koios.client.backend.api.network.model.Genesis;
import com.reina.koios.client.backend.api.network.model.Tip;
import com.reina.koios.client.backend.api.network.model.Totals;
import com.reina.koios.client.backend.factory.BackendFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NetworkServiceIntegrationTest {

    private NetworkService networkService;

    @BeforeAll
    public void setup() {
        networkService = BackendFactory.getKoiosTestnetService().getNetworkService();
    }

    @Test
    void getChainTipTest() {
        Tip[] tip = networkService.getChainTip();
        log.info(Arrays.toString(tip));
        Assertions.assertNotNull(tip);
    }

    @Test
    void getGenesisInfoTest() {
        Genesis[] genesis = networkService.getGenesisInfo();
        log.info(Arrays.toString(genesis));
        Assertions.assertNotNull(genesis);
        Assertions.assertEquals("45000000000000000", genesis[0].getMaxlovelacesupply());
    }

    @Test
    void getHistoricalTokenomicStatsTest() {
        String epochNo = "180";
        Totals[] historicalTokenomicStats = networkService.getHistoricalTokenomicStats(epochNo);
        log.info(Arrays.toString(historicalTokenomicStats));
        Assertions.assertNotNull(historicalTokenomicStats);
        Assertions.assertEquals(epochNo,String.valueOf(historicalTokenomicStats[0].getEpochNo()));
    }
}
