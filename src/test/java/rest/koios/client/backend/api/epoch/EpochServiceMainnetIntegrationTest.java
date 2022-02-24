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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EpochServiceMainnetIntegrationTest {

    private EpochService epochService;

    @BeforeAll
    public void setup() {
        epochService = BackendFactory.getKoiosMainnetService().getEpochService();
    }

    @Test
    void getEpochInformationTest() throws ApiException {
        Long epochNo = 294L;
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

        Result<EpochInfo> epochInformationResult2 = epochService.getLatestEpochInfo();
        Assertions.assertTrue(epochInformationResult2.isSuccessful());
        Assertions.assertNotNull(epochInformationResult2.getValue());

        assertEquals(epochInformationResult.getValue().get(0), epochInformationResult2.getValue());
    }

    @Test
    void getEpochParametersTest() throws ApiException {
        Long epochNo = 294L;
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

        Result<EpochParams> epochParametersResult2 = epochService.getLatestEpochParameters();
        Assertions.assertTrue(epochParametersResult2.isSuccessful());
        Assertions.assertNotNull(epochParametersResult2.getValue());

        assertEquals(epochParametersResult.getValue().get(0), epochParametersResult2.getValue());
    }
}
