package rest.koios.client.backend.api.epoch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.epoch.model.EpochInfo;
import rest.koios.client.backend.api.epoch.model.EpochParams;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.backend.factory.options.Order;
import rest.koios.client.backend.factory.options.SortType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EpochServiceTestnetIntegrationTest {

    private EpochService epochService;

    @BeforeAll
    public void setup() {
        epochService = BackendFactory.getKoiosTestnetService().getEpochService();
    }

    @Test
    void getEpochInformationTest() throws ApiException {
        Long epochNo = 180L;
        Result<EpochInfo> epochInformationResult = epochService.getEpochInformationByEpoch(epochNo);
        Assertions.assertTrue(epochInformationResult.isSuccessful());
        Assertions.assertNotNull(epochInformationResult.getValue());
        log.info(epochInformationResult.getValue().toString());
        Assertions.assertEquals(epochNo, epochInformationResult.getValue().getEpochNo());
    }

    @Test
    void getEpochInformationLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<EpochInfo>> epochInformationResult = epochService.getEpochInformation(options);
        Assertions.assertTrue(epochInformationResult.isSuccessful());
        log.info(epochInformationResult.getValue().toString());
        Assertions.assertNotNull(epochInformationResult.getValue());
        assertEquals(10, epochInformationResult.getValue().size());
    }

    @Test
    void getLatestEpochInformationTest() throws ApiException {
        Options options = Options.builder().option(Order.by("epoch_no", SortType.DESC)).option(Limit.of(1)).build();
        Result<List<EpochInfo>> epochInformationResult = epochService.getEpochInformation(options);
        Assertions.assertTrue(epochInformationResult.isSuccessful());
        log.info(epochInformationResult.getValue().toString());
        Assertions.assertNotNull(epochInformationResult.getValue());
        assertEquals(1, epochInformationResult.getValue().size());
    }

    @Test
    void getEpochParametersTest() throws ApiException {
        Long epochNo = 180L;
        Result<EpochParams> epochParametersResult = epochService.getEpochParametersByEpoch(epochNo);
        Assertions.assertTrue(epochParametersResult.isSuccessful());
        Assertions.assertNotNull(epochParametersResult.getValue());
        log.info(epochParametersResult.getValue().toString());
        Assertions.assertEquals(epochNo, epochParametersResult.getValue().getEpochNo());
    }

    @Test
    void getEpochParametersLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<EpochParams>> epochParametersResult = epochService.getEpochParameters(options);
        Assertions.assertTrue(epochParametersResult.isSuccessful());
        log.info(epochParametersResult.getValue().toString());
        Assertions.assertNotNull(epochParametersResult.getValue());
        assertEquals(10, epochParametersResult.getValue().size());
    }
}
