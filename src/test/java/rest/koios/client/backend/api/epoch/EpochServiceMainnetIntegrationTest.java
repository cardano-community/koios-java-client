package rest.koios.client.backend.api.epoch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.epoch.model.EpochBlockProtocols;
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
        Integer epochNo = 294;
        Result<EpochInfo> epochInformationResult = epochService.getEpochInformationByEpoch(epochNo);
        Assertions.assertTrue(epochInformationResult.isSuccessful());
        Assertions.assertNotNull(epochInformationResult.getValue());
        log.info(epochInformationResult.getValue().toString());
        assertEquals(epochNo, epochInformationResult.getValue().getEpochNo());
    }

    @Test
    void getLatestEpochInformationTest() throws ApiException {
        Result<EpochInfo> epochInformationResult = epochService.getLatestEpochInfo();
        Assertions.assertTrue(epochInformationResult.isSuccessful());
        Assertions.assertNotNull(epochInformationResult.getValue());
        log.info(epochInformationResult.getValue().toString());
    }

    @Test
    void getEpochInformationLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<EpochInfo>> epochInformationResult = epochService.getEpochInformation(false, options);
        Assertions.assertTrue(epochInformationResult.isSuccessful());
        log.info(epochInformationResult.getValue().toString());
        Assertions.assertNotNull(epochInformationResult.getValue());
        assertEquals(10, epochInformationResult.getValue().size());
    }

    @Test
    void getEpochParametersTest() throws ApiException {
        Integer epochNo = 294;
        Result<EpochParams> epochParametersResult = epochService.getEpochParametersByEpoch(epochNo);
        Assertions.assertTrue(epochParametersResult.isSuccessful());
        Assertions.assertNotNull(epochParametersResult.getValue());
        log.info(epochParametersResult.getValue().toString());
        assertEquals(epochNo, epochParametersResult.getValue().getEpochNo());
    }

    @Test
    void getLatestEpochParametersTest() throws ApiException {
        Result<EpochParams> epochParametersResult = epochService.getLatestEpochParameters();
        Assertions.assertTrue(epochParametersResult.isSuccessful());
        Assertions.assertNotNull(epochParametersResult.getValue());
        log.info(epochParametersResult.getValue().toString());
    }

    @Test
    void getEpochParametersLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<EpochParams>> epochParametersResult = epochService.getEpochParameters(options);
        Assertions.assertTrue(epochParametersResult.isSuccessful());
        Assertions.assertNotNull(epochParametersResult.getValue());
        log.info(epochParametersResult.getValue().toString());
        assertEquals(10, epochParametersResult.getValue().size());
    }

    @Test
    void getEpochBlockProtocolsByEpochTest() throws ApiException {
        Integer epochNo = 294;
        Integer blocks = 13704;
        Result<EpochBlockProtocols> epochBlockProtocolsResult = epochService.getEpochBlockProtocolsByEpoch(epochNo);
        Assertions.assertTrue(epochBlockProtocolsResult.isSuccessful());
        Assertions.assertNotNull(epochBlockProtocolsResult.getValue());
        log.info(epochBlockProtocolsResult.getValue().toString());
        assertEquals(blocks, epochBlockProtocolsResult.getValue().getBlocks());
    }

    @Test
    void getEpochBlocksProtocolsTest() throws ApiException {
        Result<List<EpochBlockProtocols>> epochBlockProtocolsResult = epochService.getEpochBlockProtocols(Options.EMPTY);
        Assertions.assertTrue(epochBlockProtocolsResult.isSuccessful());
        Assertions.assertNotNull(epochBlockProtocolsResult.getValue());
        log.info(epochBlockProtocolsResult.getValue().toString());
    }
}
