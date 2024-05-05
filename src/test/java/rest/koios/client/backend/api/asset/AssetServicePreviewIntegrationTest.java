package rest.koios.client.backend.api.asset;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.asset.model.*;
import rest.koios.client.backend.api.base.common.TxHash;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.utils.Tuple;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AssetServicePreviewIntegrationTest {

    private AssetService assetService;

    @BeforeAll
    public void setup() {
        assetService = BackendFactory.getKoiosPreviewService().getAssetService();
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
    void getPolicyAssetListTest() throws ApiException {
        String assetPolicy = "065270479316f1d92e00f7f9f095ebeaac9d009c878dc35ce36d3404";
        Result<List<PolicyAsset>> policyAssetListResult = assetService.getPolicyAssetList(assetPolicy, Options.EMPTY);
        Assertions.assertTrue(policyAssetListResult.isSuccessful());
        Assertions.assertNotNull(policyAssetListResult.getValue());
        log.info(policyAssetListResult.getValue().toString());
    }

    @Test
    void getAssetsAddressListTest() throws ApiException {
        String assetPolicy = "9a50f458ebffb4c3f9d6f9f3d45426b2de6cf2512254f4bfa3d8f410";
        String assetName = "DimensionBox #0063";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<List<AssetAddress>> assetAddressesResult = assetService.getAssetsAddresses(assetPolicy, assetNameHex, Options.EMPTY);
        Assertions.assertTrue(assetAddressesResult.isSuccessful());
        Assertions.assertNotNull(assetAddressesResult.getValue());
        log.info(assetAddressesResult.getValue().toString());
    }

    @Test
    void getAssetsAddressListBadRequestTest() {
        String assetPolicy = "9a50f458ebffb4c3f9d6f9f3d45426b2de6cf2512254f4bfa3d8f410";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetsAddresses(assetPolicy, assetNameHex, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getNFTAddressTest() throws ApiException {
        String assetPolicy = "005b8ca355aec6125531ebea89bf9ef8df90121ea5717f0c55027e35";
        String assetNameHex = "4d43";
        Result<List<PaymentAddress>> assetAddressesResult = assetService.getNFTAddress(assetPolicy, assetNameHex, Options.EMPTY);
        Assertions.assertTrue(assetAddressesResult.isSuccessful());
        Assertions.assertNotNull(assetAddressesResult.getValue());
        log.info(assetAddressesResult.getValue().toString());
    }

    @Test
    void getPolicyAssetAddressListTest() throws ApiException {
        String assetPolicy = "005b8ca355aec6125531ebea89bf9ef8df90121ea5717f0c55027e35";
        Result<List<AssetAddress>> assetAddressesResult = assetService.getPolicyAssetAddressList(assetPolicy, Options.EMPTY);
        Assertions.assertTrue(assetAddressesResult.isSuccessful());
        Assertions.assertNotNull(assetAddressesResult.getValue());
        log.info(assetAddressesResult.getValue().toString());
    }

    @Test
    void getAssetInformationTest() throws ApiException {
        String assetPolicy = "9a50f458ebffb4c3f9d6f9f3d45426b2de6cf2512254f4bfa3d8f410";
        String assetName = "DimensionBox #0063";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<AssetInformation> assetInformationResult = assetService.getAssetInformation(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetInformationResult.isSuccessful());
        Assertions.assertNotNull(assetInformationResult.getValue());
        Assertions.assertNotNull(assetInformationResult.getValue().getMintingTxMetadata());
        log.info(assetInformationResult.getValue().toString());
    }

    @Test
    void getAssetInformationTokenTest() throws ApiException {
        String assetPolicy = "2fe3c3364b443194b10954771c95819b8d6ed464033c21f03f8facb5";
        String assetName = "iBTC";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<AssetInformation> assetInformationResult = assetService.getAssetInformation(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetInformationResult.isSuccessful());
        Assertions.assertNotNull(assetInformationResult.getValue());
        log.info(assetInformationResult.getValue().toString());
    }

    @Test
    void getAssetInformationBadRequestTest() {
        String assetPolicy = "9a50f458ebffb4c3f9d6f9f3d45426b2de6cf2512254f4bfa3d8f410";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetInformation(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetInformationBulkTest() throws ApiException {
        List<Tuple<String, String>> tupleList = List.of(new Tuple<>("065270479316f1d92e00f7f9f095ebeaac9d009c878dc35ce36d3404", "433374"),
                new Tuple<>("189e2c53985411addb8df0f3e09f70e343da69f06746c408aba672a8", "15fc257714a51769e192761d674db2ee2e80137428e522f9b914debb5f785301"));
        Result<AssetInformation> assetInformationBulkResult = assetService.getAssetInformationBulk(tupleList, Options.EMPTY);
        Assertions.assertTrue(assetInformationBulkResult.isSuccessful());
        Assertions.assertNotNull(assetInformationBulkResult.getValue());
        log.info(assetInformationBulkResult.getValue().toString());
    }

    @Test
    void getAssetUTxOsTest() throws ApiException {
        List<Tuple<String, String>> tupleList = List.of(new Tuple<>("065270479316f1d92e00f7f9f095ebeaac9d009c878dc35ce36d3404", "433374"),
                new Tuple<>("189e2c53985411addb8df0f3e09f70e343da69f06746c408aba672a8", "15fc257714a51769e192761d674db2ee2e80137428e522f9b914debb5f785301"));
        Result<List<UTxO>> utxosResult = assetService.getAssetUTxOs(tupleList, true, Options.EMPTY);
        Assertions.assertTrue(utxosResult.isSuccessful());
        Assertions.assertNotNull(utxosResult.getValue());
        log.info(utxosResult.getValue().toString());
    }

    @Test
    void getAssetHistoryTest() throws ApiException {
        String assetPolicy = "9a50f458ebffb4c3f9d6f9f3d45426b2de6cf2512254f4bfa3d8f410";
        String assetName = "DimensionBox #0063";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<List<AssetHistory>> assetHistoriesResult = assetService.getAssetHistory(assetPolicy, assetNameHex, Options.EMPTY);
        Assertions.assertTrue(assetHistoriesResult.isSuccessful());
        Assertions.assertNotNull(assetHistoriesResult.getValue());
        log.info(assetHistoriesResult.getValue().toString());
    }

    @Test
    void getAssetHistoryBadRequestTest() {
        String assetPolicy = "9a50f458ebffb4c3f9d6f9f3d45426b2de6cf2512254f4bfa3d8f410";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetHistory(assetPolicy, assetNameHex, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetPolicyInformationTest() throws ApiException {
        String assetPolicy = "9a50f458ebffb4c3f9d6f9f3d45426b2de6cf2512254f4bfa3d8f410";
        Result<List<PolicyAssetInfo>> assetPolicyInfoResult = assetService.getPolicyAssetInformation(assetPolicy, Options.EMPTY);
        Assertions.assertTrue(assetPolicyInfoResult.isSuccessful());
        Assertions.assertNotNull(assetPolicyInfoResult.getValue());
        log.info(assetPolicyInfoResult.getValue().toString());
    }

    @Test
    void getAssetPolicyInformationBadRequestTest() {
        String assetPolicy = "test";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getPolicyAssetInformation(assetPolicy, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPolicyAssetMintsTest() throws ApiException {
        String assetPolicy = "9a50f458ebffb4c3f9d6f9f3d45426b2de6cf2512254f4bfa3d8f410";
        Result<List<PolicyAssetMint>> policyAssetMintsResult = assetService.getPolicyAssetMints(assetPolicy, Options.EMPTY);
        Assertions.assertTrue(policyAssetMintsResult.isSuccessful());
        Assertions.assertNotNull(policyAssetMintsResult.getValue());
        log.info(policyAssetMintsResult.getValue().toString());
    }

    @Test
    void getPolicyAssetMintsBadRequestTest() {
        String assetPolicy = "test";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getPolicyAssetMints(assetPolicy, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetSummaryTest() throws ApiException {
        String assetPolicy = "9a50f458ebffb4c3f9d6f9f3d45426b2de6cf2512254f4bfa3d8f410";
        String assetName = "DimensionBox #0063";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<AssetSummary> assetSummaryResult = assetService.getAssetSummary(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetSummaryResult.isSuccessful());
        Assertions.assertNotNull(assetSummaryResult.getValue());
        Assertions.assertEquals("44696d656e73696f6e426f78202330303633", assetSummaryResult.getValue().getAssetName());
        log.info(assetSummaryResult.getValue().toString());
    }

    @Test
    void getAssetSummaryBadRequestTest() {
        String assetPolicy = "9a50f458ebffb4c3f9d6f9f3d45426b2de6cf2512254f4bfa3d8f410";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetSummary(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetTxsTest() throws ApiException {
        String assetPolicy = "9a50f458ebffb4c3f9d6f9f3d45426b2de6cf2512254f4bfa3d8f410";
        String assetName = "DimensionBox #0063";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<List<TxHash>> assetTxsResult = assetService.getAssetTransactions(assetPolicy, assetNameHex, Options.EMPTY);
        Assertions.assertEquals("601d8ca24d22b235106af326b8b4415548adb33a93e239546aab69810ac6831d", assetTxsResult.getValue().get(0).getTxHash());
        Assertions.assertTrue(assetTxsResult.isSuccessful());
        Assertions.assertNotNull(assetTxsResult.getValue());
        log.info(assetTxsResult.getValue().toString());
    }

    @Test
    void getAssetTxsBadRequestTest() {
        String assetPolicy = "9a50f458ebffb4c3f9d6f9f3d45426b2de6cf2512254f4bfa3d8f410";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetTransactions(assetPolicy, assetNameHex, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }
}
