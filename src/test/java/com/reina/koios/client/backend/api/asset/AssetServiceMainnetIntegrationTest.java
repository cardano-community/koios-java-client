package com.reina.koios.client.backend.api.asset;

import com.reina.koios.client.backend.api.asset.model.*;
import com.reina.koios.client.backend.api.base.exception.ApiException;
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

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AssetServiceMainnetIntegrationTest {

    private AssetService assetService;

    @BeforeAll
    public void setup() {
        assetService = BackendFactory.getKoiosMainnetService().getAssetService();
    }

    @Test
    void getAssetListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Asset[] assets = assetService.getAssetList(options);
        log.info(Arrays.toString(assets));
        Assertions.assertNotNull(assets);
        Assertions.assertEquals(10, assets.length);
    }

    @Test
    void getAssetsAddressListTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        AssetAddress[] assetAddresses = assetService.getAssetsAddressList(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetAddresses));
        Assertions.assertNotNull(assetAddresses);
    }

    @Test
    void getAssetsAddressListBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetsAddressList(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAssetInformationTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        AssetInformation[] assetInformation = assetService.getAssetInformation(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetInformation));
        Assertions.assertNotNull(assetInformation);
    }

    @Test
    void getAssetInformationBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetInformation(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAssetHistoryTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        AssetHistory[] assetHistories = assetService.getAssetHistory(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetHistories));
        Assertions.assertNotNull(assetHistories);
    }

    @Test
    void getAssetHistoryBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetHistory(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAssetPolicyInformationTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        AssetPolicyInfo[] assetPolicyInfos = assetService.getAssetPolicyInformation(assetPolicy);
        log.info(Arrays.toString(assetPolicyInfos));
        Assertions.assertNotNull(assetPolicyInfos);
    }

    @Test
    void getAssetPolicyInformationBadRequestTest() {
        String assetPolicy = "test";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetPolicyInformation(assetPolicy));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAssetSummaryTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        AssetSummary[] assetSummary = assetService.getAssetSummary(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetSummary));
        Assertions.assertNotNull(assetSummary);
    }

    @Test
    void getAssetSummaryBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetSummary(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAssetTxsTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        AssetTx[] assetTxs = assetService.getAssetTransactionHistory(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetTxs));
        Assertions.assertNotNull(assetTxs);
    }

    @Test
    void getAssetTxsBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetTransactionHistory(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }
}
