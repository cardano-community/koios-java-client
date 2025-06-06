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
import rest.koios.client.backend.factory.options.Offset;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.backend.factory.options.filters.Filter;
import rest.koios.client.backend.factory.options.filters.FilterType;
import rest.koios.client.utils.HexUtil;
import rest.koios.client.utils.Tuple;

import java.math.BigInteger;
import java.util.ArrayList;
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
    void getPolicyAssetListTest() throws ApiException {
        String assetPolicy = "750900e4999ebe0d58f19b634768ba25e525aaf12403bfe8fe130501";
        Result<List<PolicyAsset>> policyAssetListResult = assetService.getPolicyAssetList(assetPolicy, Options.EMPTY);
        Assertions.assertTrue(policyAssetListResult.isSuccessful());
        Assertions.assertNotNull(policyAssetListResult.getValue());
        log.info(policyAssetListResult.getValue().toString());
    }

    @Test
    void getAssetTokenRegistryFilteredTest() throws ApiException {
        Options options = Options.builder()
                .option(Filter.of("policy_id", FilterType.EQ, "4d038d08e68f53d21462e8982a5334c6ffbf65e7ae7eb064c568dd1e"))
                .option(Filter.of("asset_name",FilterType.EQ, "464f524745"))
                .build();
        Result<List<AssetTokenRegistry>> assetsResult = assetService.getAssetTokenRegistry(options);
        Assertions.assertTrue(assetsResult.isSuccessful());
        Assertions.assertNotNull(assetsResult.getValue());
        log.info(assetsResult.getValue().toString());
        assertEquals(1, assetsResult.getValue().size());
        assertEquals("FORGE", assetsResult.getValue().get(0).getTicker());
    }

    @Test
    void getAssetsAddressListTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        Result<List<AssetAddress>> assetAddressesResult = assetService.getAssetsAddresses(assetPolicy, assetNameHex, Options.EMPTY);
        Assertions.assertTrue(assetAddressesResult.isSuccessful());
        Assertions.assertNotNull(assetAddressesResult.getValue());
        log.info(assetAddressesResult.getValue().toString());
    }

    @Test
    void getAssetsAddressListBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetsAddresses(assetPolicy, assetNameHex, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getNFTAddressTest() throws ApiException {
        String assetPolicy = "f0ff48bbb7bbe9d59a40f1ce90e9e9d0ff5002ec48f232b49ca0fb9a";
        String assetNameHex = "68616e646c65";
        Result<List<PaymentAddress>> assetAddressesResult = assetService.getNFTAddress(assetPolicy, assetNameHex, Options.EMPTY);
        Assertions.assertTrue(assetAddressesResult.isSuccessful());
        Assertions.assertNotNull(assetAddressesResult.getValue());
        log.info(assetAddressesResult.getValue().toString());
    }

    @Test
    void getPolicyAssetAddressListTest() throws ApiException {
        String assetPolicy = "f0ff48bbb7bbe9d59a40f1ce90e9e9d0ff5002ec48f232b49ca0fb9a";
        Result<List<AssetAddress>> assetAddressesResult = assetService.getPolicyAssetAddressList(assetPolicy, Options.EMPTY);
        Assertions.assertTrue(assetAddressesResult.isSuccessful());
        Assertions.assertNotNull(assetAddressesResult.getValue());
        log.info(assetAddressesResult.getValue().toString());
    }

    @Test
    void getAssetInformationTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        Result<AssetInformation> assetInformationResult = assetService.getAssetInformation(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetInformationResult.isSuccessful());
        Assertions.assertNotNull(assetInformationResult.getValue());
        log.info(assetInformationResult.getValue().toString());
    }

    @Test
    void getAssetInformationTokenTest() throws ApiException {
        String assetPolicy = "14696a4676909f4e3cb1f2e60e2e08e5abed70caf5c02699be971139";
        String assetName = "CUBY";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        Result<AssetInformation> assetInformationResult = assetService.getAssetInformation(assetPolicy, assetNameHex);
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
    void getAssetInformationBulkTest() throws ApiException {
        List<Tuple<String, String>> tupleList = List.of(new Tuple<>("750900e4999ebe0d58f19b634768ba25e525aaf12403bfe8fe130501", "424f4f4b"),
                new Tuple<>("f0ff48bbb7bbe9d59a40f1ce90e9e9d0ff5002ec48f232b49ca0fb9a", "6b6f696f732e72657374"));
        Result<List<AssetInformation>> assetInformationBulkResult = assetService.getAssetInformationBulk(tupleList, Options.EMPTY);
        Assertions.assertTrue(assetInformationBulkResult.isSuccessful());
        Assertions.assertNotNull(assetInformationBulkResult.getValue());
        log.info(assetInformationBulkResult.getValue().toString());
    }

    @Test
    void getAssetUTxOsTest() throws ApiException {
        List<Tuple<String, String>> tupleList = List.of(new Tuple<>("750900e4999ebe0d58f19b634768ba25e525aaf12403bfe8fe130501", "424f4f4b"),
                new Tuple<>("f0ff48bbb7bbe9d59a40f1ce90e9e9d0ff5002ec48f232b49ca0fb9a", "6b6f696f732e72657374"));
        Result<List<UTxO>> utxosResult = assetService.getAssetUTxOs(tupleList, true, Options.EMPTY);
        Assertions.assertTrue(utxosResult.isSuccessful());
        Assertions.assertNotNull(utxosResult.getValue());
        log.info(utxosResult.getValue().toString());
    }

    @Test
    void getAssetHistoryTest() throws ApiException {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        Result<List<AssetHistory>> assetHistoriesResult = assetService.getAssetHistory(assetPolicy, assetNameHex, Options.EMPTY);
        Assertions.assertTrue(assetHistoriesResult.isSuccessful());
        Assertions.assertNotNull(assetHistoriesResult.getValue());
        log.info(assetHistoriesResult.getValue().toString());
    }

    @Test
    void getAssetHistoryBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetHistory(assetPolicy, assetNameHex, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAssetPolicyInformationTest() throws ApiException {
        String assetPolicy = "14696a4676909f4e3cb1f2e60e2e08e5abed70caf5c02699be971139";
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
        String assetPolicy = "14696a4676909f4e3cb1f2e60e2e08e5abed70caf5c02699be971139";
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
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414d";
        Result<AssetSummary> assetSummaryResult = assetService.getAssetSummary(assetPolicy, assetNameHex);
        Assertions.assertTrue(assetSummaryResult.isSuccessful());
        Assertions.assertNotNull(assetSummaryResult.getValue());
        log.info(assetSummaryResult.getValue().toString());
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
        Result<List<TxHash>> assetTxsResult = assetService.getAssetTransactions(assetPolicy, assetNameHex, Options.EMPTY);
        Assertions.assertTrue(assetTxsResult.isSuccessful());
        Assertions.assertNotNull(assetTxsResult.getValue());
        log.info(assetTxsResult.getValue().toString());
    }

    @Test
    void getAssetTxsBadRequestTest() {
        String assetPolicy = "d3501d9531fcc25e3ca4b6429318c2cc374dbdbcf5e99c1c1e5da1ff";
        String assetNameHex = "444f4e545350414dasdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetTransactions(assetPolicy, assetNameHex, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }


    @Test
    void getNFTArrivalDate() throws ApiException {
        String assetPolicy = "2edd9753b85e908ac63c5ae7b3bb013ad871da4a450b5f21a5218c46";
        List<PolicyAsset> policyAssets = getAllPolicyAssetList(assetPolicy);
        policyAssets.forEach(policyAsset -> {
            Result<List<PaymentAddress>> listResult;
            try {
                listResult = assetService.getNFTAddress(assetPolicy, policyAsset.getAssetName(), Options.EMPTY);
                Assertions.assertTrue(listResult.isSuccessful());
                List<PaymentAddress> paymentAddresses = listResult.getValue();
                System.out.println(policyAsset.getFingerprint()+","+new String(HexUtil.decodeHexString(policyAsset.getAssetName()))+","+paymentAddresses);
//                addresses.addAll(paymentAddresses.stream().map(PaymentAddress::toString).collect(Collectors.toList()));
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public List<PolicyAsset> getAllPolicyAssetList(String assetPolicy) throws ApiException {
        List<PolicyAsset> policyAssets = new ArrayList<>();
        int page = 1;
        Options options = Options.builder()
                .option(Limit.of(1000))
                .option(Offset.of(0))
                .build();
        Result<List<PolicyAsset>> policyAssetList = assetService.getPolicyAssetList(assetPolicy, options);
        while (policyAssetList.isSuccessful()) {
            policyAssets.addAll(policyAssetList.getValue());
            if (policyAssetList.getValue().size() != 1000) {
                break;
            } else {
                page++;
                options = Options.builder()
                        .option(Limit.of(1000))
                        .option(Offset.of((long) (page - 1) * 1000))
                        .build();
                policyAssetList = assetService.getPolicyAssetList(assetPolicy, options);
            }
        }
        if (!policyAssetList.isSuccessful()) {
            return policyAssetList.getValue();
        } else {
            return policyAssets;
        }
    }


}
