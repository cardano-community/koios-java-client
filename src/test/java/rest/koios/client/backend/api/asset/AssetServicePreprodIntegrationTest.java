package rest.koios.client.backend.api.asset;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.asset.model.*;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.common.TxHash;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AssetServicePreprodIntegrationTest {

    private AssetService assetService;

    @BeforeAll
    public void setup() {
        assetService = BackendFactory.getKoiosPreprodService().getAssetService();
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
        String assetPolicy = "80de4ee0ffde8ba05726707f2adba0e65963eff5aaba164af358e71b";
        String assetName = "StabilityPool_Test";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<List<AssetAddress>> assetAddressesResult = assetService.getAssetsAddressList(assetPolicy, assetNameHex, Options.EMPTY);
        Assertions.assertTrue(assetAddressesResult.isSuccessful());
        Assertions.assertNotNull(assetAddressesResult.getValue());
        log.info(assetAddressesResult.getValue().toString());
    }

    @Test
    void getAssetsAddressListBadRequestTest() {
        String assetPolicy = "80de4ee0ffde8ba05726707f2adba0e65963eff5aaba164af358e71b";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetsAddressList(assetPolicy, assetNameHex, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetInformationTest() throws ApiException {
        String assetPolicy = "80de4ee0ffde8ba05726707f2adba0e65963eff5aaba164af358e71b";
        String assetName = "StabilityPool_Test";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<AssetInformation> assetInformationResult = assetService.getAssetInformation(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetInformationResult.isSuccessful());
        Assertions.assertNotNull(assetInformationResult.getValue());
        Assertions.assertNotNull(assetInformationResult.getValue().getMintingTxMetadata());
        log.info(assetInformationResult.getValue().toString());
    }

    @Test
    void getAssetInformationTokenTest() throws ApiException {
        String assetPolicy = "025146866af908340247fe4e9672d5ac7059f1e8534696b5f920c9e6";
        String assetName = "cbTHC";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<AssetInformation> assetInformationResult = assetService.getAssetInformation(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetInformationResult.isSuccessful());
        Assertions.assertNotNull(assetInformationResult.getValue());
        log.info(assetInformationResult.getValue().toString());
    }

    @Test
    void getAssetInformationBadRequestTest() {
        String assetPolicy = "80de4ee0ffde8ba05726707f2adba0e65963eff5aaba164af358e71b";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetInformation(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetHistoryTest() throws ApiException {
        String assetPolicy = "80de4ee0ffde8ba05726707f2adba0e65963eff5aaba164af358e71b";
        String assetName = "StabilityPool_Test";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<List<AssetHistory>> assetHistoriesResult = assetService.getAssetHistory(assetPolicy, assetNameHex, Options.EMPTY);
        Assertions.assertTrue(assetHistoriesResult.isSuccessful());
        Assertions.assertNotNull(assetHistoriesResult.getValue());
        log.info(assetHistoriesResult.getValue().toString());
    }

    @Test
    void getAssetHistoryBadRequestTest() {
        String assetPolicy = "80de4ee0ffde8ba05726707f2adba0e65963eff5aaba164af358e71b";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetHistory(assetPolicy, assetNameHex, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetPolicyInformationTest() throws ApiException {
        String assetPolicy = "80de4ee0ffde8ba05726707f2adba0e65963eff5aaba164af358e71b";
        Result<List<PolicyAsset>> assetPolicyInfoResult = assetService.getAssetPolicyInformation(assetPolicy);
        Assertions.assertTrue(assetPolicyInfoResult.isSuccessful());
        Assertions.assertNotNull(assetPolicyInfoResult.getValue());
        log.info(assetPolicyInfoResult.getValue().toString());
    }

    @Test
    void getAssetPolicyInformationBadRequestTest() {
        String assetPolicy = "test";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetPolicyInformation(assetPolicy));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetSummaryTest() throws ApiException {
        String assetPolicy = "80de4ee0ffde8ba05726707f2adba0e65963eff5aaba164af358e71b";
        String assetName = "StabilityPool_Test";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<AssetSummary> assetSummaryResult = assetService.getAssetSummary(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetSummaryResult.isSuccessful());
        Assertions.assertNotNull(assetSummaryResult.getValue());
        Assertions.assertEquals("53746162696c697479506f6f6c5f54657374", assetSummaryResult.getValue().getAssetName());
        log.info(assetSummaryResult.getValue().toString());
    }

    @Test
    void getAssetSummaryBadRequestTest() {
        String assetPolicy = "80de4ee0ffde8ba05726707f2adba0e65963eff5aaba164af358e71b";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetSummary(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetTxsTest() throws ApiException {
        String assetPolicy = "80de4ee0ffde8ba05726707f2adba0e65963eff5aaba164af358e71b";
        String assetName = "StabilityPool_Test";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<List<TxHash>> assetTxsResult = assetService.getAssetTransactions(assetPolicy, assetNameHex, Options.EMPTY);
        Assertions.assertEquals("d1df563b2cca417a0281725360dd359d030b403732ef7968dbf99e246a3547cb", assetTxsResult.getValue().get(0).getTxHash());
        Assertions.assertTrue(assetTxsResult.isSuccessful());
        Assertions.assertNotNull(assetTxsResult.getValue());
        log.info(assetTxsResult.getValue().toString());
    }

    @Test
    void getAssetTxsBadRequestTest() {
        String assetPolicy = "80de4ee0ffde8ba05726707f2adba0e65963eff5aaba164af358e71b";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetTransactions(assetPolicy, assetNameHex, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }
}
