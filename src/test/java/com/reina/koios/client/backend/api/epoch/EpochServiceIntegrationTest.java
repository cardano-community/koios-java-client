package com.reina.koios.client.backend.api.epoch;

import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.epoch.model.EpochInfo;
import com.reina.koios.client.backend.api.epoch.model.EpochParams;
import com.reina.koios.client.backend.factory.BackendFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EpochServiceIntegrationTest {

    private EpochService epochService;

    @BeforeAll
    public void setup() {
        epochService = BackendFactory.getKoiosTestnetService().getEpochService();
    }

    @Test
    void getEpochInformationTest() throws ApiException {
        String epochNo = "180";
        EpochInfo[] epochInformation = epochService.getEpochInformation(epochNo);
        log.info(Arrays.toString(epochInformation));
        Assertions.assertNotNull(epochInformation);
        Assertions.assertEquals(epochNo, String.valueOf(epochInformation[0].getEpochNo()));
    }

    @Test
    void getEpochParametersTest() throws ApiException {
        String epochNo = "180";
        EpochParams[] epochParameters = epochService.getEpochParameters(epochNo);
        log.info(Arrays.toString(epochParameters));
        Assertions.assertNotNull(epochParameters);
        Assertions.assertEquals(epochNo, String.valueOf(epochParameters[0].getEpochNo()));
    }
}
