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

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AssetServiceTestnetIntegrationTest {

    private AssetService assetService;

    @BeforeAll
    public void setup() {
        assetService = BackendFactory.getKoiosTestnetService().getAssetService();
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
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<List<AssetAddress>> assetAddressesResult = assetService.getAssetsAddressList(assetPolicy, assetNameHex, null);
        Assertions.assertTrue(assetAddressesResult.isSuccessful());
        Assertions.assertNotNull(assetAddressesResult.getValue());
        log.info(assetAddressesResult.getValue().toString());
    }

    @Test
    void getAssetsAddressListBadRequestTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetsAddressList(assetPolicy, assetNameHex, null));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetInformationTest() throws ApiException {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<AssetInformation> assetInformationResult = assetService.getAssetInformation(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetInformationResult.isSuccessful());
        Assertions.assertNotNull(assetInformationResult.getValue());
        Assertions.assertNotNull(assetInformationResult.getValue().getMintingTxMetadata());
        log.info(assetInformationResult.getValue().toString());
    }

    @Test
    void getAssetInformationTokenTest() throws ApiException {
        String assetPolicy = "34250edd1e9836f5378702fbf9416b709bc140e04f668cc355208518";
        String assetName = "ATADAcoin";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<AssetInformation> assetInformationResult = assetService.getAssetInformation(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetInformationResult.isSuccessful());
        Assertions.assertNotNull(assetInformationResult.getValue());
        Assertions.assertNotNull(assetInformationResult.getValue().getTokenRegistryMetadata());
        log.info(assetInformationResult.getValue().toString());
    }

    @Test
    void getAssetInformationBadRequestTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetInformation(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetHistoryTest() throws ApiException {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<List<AssetHistory>> assetHistoriesResult = assetService.getAssetHistory(assetPolicy, assetNameHex, null);
        Assertions.assertTrue(assetHistoriesResult.isSuccessful());
        Assertions.assertNotNull(assetHistoriesResult.getValue());
        log.info(assetHistoriesResult.getValue().toString());
    }

    @Test
    void getAssetHistoryBadRequestTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetHistory(assetPolicy, assetNameHex, null));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetPolicyInformationTest() throws ApiException {
        String assetPolicy = "34250edd1e9836f5378702fbf9416b709bc140e04f668cc355208518";
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
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<AssetSummary> assetSummaryResult = assetService.getAssetSummary(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetSummaryResult.isSuccessful());
        Assertions.assertNotNull(assetSummaryResult.getValue());
        log.info(assetSummaryResult.getValue().toString());
    }

    @Test
    void getAssetSummaryBadRequestTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetSummary(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetTxsTest() throws ApiException {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<List<AssetTx>> assetTxsResult = assetService.getAssetTransactionHistory(assetPolicy, assetNameHex, null);
        Assertions.assertTrue(assetTxsResult.isSuccessful());
        Assertions.assertNotNull(assetTxsResult.getValue());
        log.info(assetTxsResult.getValue().toString());
    }

    @Test
    void getAssetTxsBadRequestTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetTransactionHistory(assetPolicy, assetNameHex, null));
        assertInstanceOf(ApiException.class, exception);
    }
}
