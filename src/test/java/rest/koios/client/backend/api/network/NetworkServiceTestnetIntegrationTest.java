package rest.koios.client.backend.api.network;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.network.model.Genesis;
import rest.koios.client.backend.api.network.model.Tip;
import rest.koios.client.backend.api.network.model.Totals;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NetworkServiceTestnetIntegrationTest {

    private NetworkService networkService;

    @BeforeAll
    public void setup() {
        networkService = BackendFactory.getKoiosTestnetService().getNetworkService();
    }

    @Test
    void getChainTipTest() throws ApiException {
        Result<Tip> tipResult = networkService.getChainTip();
        Assertions.assertTrue(tipResult.isSuccessful());
        Assertions.assertNotNull(tipResult.getValue());
        log.info(tipResult.getValue().toString());
    }

    @Test
    void getGenesisInfoTest() throws ApiException {
        Result<Genesis> genesisResult = networkService.getGenesisInfo();
        Assertions.assertTrue(genesisResult.isSuccessful());
        Assertions.assertNotNull(genesisResult.getValue());
        log.info(genesisResult.getValue().toString());
        Assertions.assertEquals("45000000000000000", genesisResult.getValue().getMaxlovelacesupply());
    }

    @Test
    void getHistoricalTokenomicStatsTest() throws ApiException {
        Integer epochNo = 180;
        Result<Totals> historicalTokenomicStatsResult = networkService.getHistoricalTokenomicStatsByEpoch(epochNo);
        Assertions.assertTrue(historicalTokenomicStatsResult.isSuccessful());
        Assertions.assertNotNull(historicalTokenomicStatsResult.getValue());
        log.info(historicalTokenomicStatsResult.getValue().toString());
        Assertions.assertEquals(epochNo,historicalTokenomicStatsResult.getValue().getEpochNo());
    }

    @Test
    void getHistoricalTokenomicStatsLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<Totals>> historicalTokenomicStatsResult = networkService.getHistoricalTokenomicStats(options);
        Assertions.assertTrue(historicalTokenomicStatsResult.isSuccessful());
        Assertions.assertNotNull(historicalTokenomicStatsResult.getValue());
        log.info(historicalTokenomicStatsResult.getValue().toString());
        Assertions.assertEquals(10,historicalTokenomicStatsResult.getValue().size());
    }

    @Test
    void getHistoricalTokenomicStatsBadRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> networkService.getHistoricalTokenomicStatsByEpoch(-5));
        assertInstanceOf(ApiException.class, exception);
    }
}
