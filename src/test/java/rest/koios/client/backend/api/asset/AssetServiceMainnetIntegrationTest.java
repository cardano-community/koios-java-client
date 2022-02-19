package rest.koios.client.backend.api.asset;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.asset.model.*;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

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
        Result<List<Asset>> assetsResult = assetService.getAssetList(options);
        Assertions.assertTrue(assetsResult.isSuccessful());
        Assertions.assertNotNull(assetsResult.getValue());
        log.info(assetsResult.getValue().toString());
        assertEquals(10, assetsResult.getValue().size());
    }

    @Test
    void getAssetsAddressListTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        Result<List<AssetAddress>> assetAddressesResult = assetService.getAssetsAddressList(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetAddressesResult.isSuccessful());
        Assertions.assertNotNull(assetAddressesResult.getValue());
        log.info(assetAddressesResult.getValue().toString());
    }

    @Test
    void getAssetsAddressListBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetsAddressList(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetInformationTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        Result<List<AssetInformation>> assetInformationResult = assetService.getAssetInformation(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetInformationResult.isSuccessful());
        Assertions.assertNotNull(assetInformationResult.getValue());
        log.info(assetInformationResult.getValue().toString());
    }

    @Test
    void getAssetInformationBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetInformation(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetHistoryTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        Result<List<AssetHistory>> assetHistoriesResult = assetService.getAssetHistory(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetHistoriesResult.isSuccessful());
        Assertions.assertNotNull(assetHistoriesResult.getValue());
        log.info(assetHistoriesResult.getValue().toString());
    }

    @Test
    void getAssetHistoryBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetHistory(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetPolicyInformationTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        Result<List<AssetPolicyInfo>> assetPolicyInfosResult = assetService.getAssetPolicyInformation(assetPolicy);
        Assertions.assertTrue(assetPolicyInfosResult.isSuccessful());
        Assertions.assertNotNull(assetPolicyInfosResult.getValue());
        log.info(assetPolicyInfosResult.getValue().toString());
    }

    @Test
    void getAssetPolicyInformationBadRequestTest() {
        String assetPolicy = "test";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetPolicyInformation(assetPolicy));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetSummaryTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        Result<List<AssetSummary>> assetSummariesResult = assetService.getAssetSummary(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetSummariesResult.isSuccessful());
        Assertions.assertNotNull(assetSummariesResult.getValue());
        log.info(assetSummariesResult.getValue().toString());
    }

    @Test
    void getAssetSummaryBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetSummary(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetTxsTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        Result<List<AssetTx>> assetTxsResult = assetService.getAssetTransactionHistory(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetTxsResult.isSuccessful());
        Assertions.assertNotNull(assetTxsResult.getValue());
        log.info(assetTxsResult.getValue().toString());
    }

    @Test
    void getAssetTxsBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetTransactionHistory(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
    }
}
