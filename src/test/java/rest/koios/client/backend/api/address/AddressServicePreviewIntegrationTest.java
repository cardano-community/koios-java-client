package rest.koios.client.backend.api.address;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.common.TxHash;
import rest.koios.client.backend.api.address.model.AddressAsset;
import rest.koios.client.backend.api.address.model.AddressInfo;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.backend.factory.options.SortType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddressServicePreviewIntegrationTest {

    private AddressService addressService;

    @BeforeAll
    public void setup() {
        addressService = BackendFactory.getKoiosPreviewService().getAddressService();
    }

    @Test
    void getAddressInformationTest() throws ApiException {
        String address = "addr_test1qrvaadv0h7atv366u6966u4rft2svjlf5uajy8lkpsgdrc24rnskuetxz2u3m5ac22s3njvftxcl2fc8k8kjr088ge0qz98xmv";
        Result<AddressInfo> addressInformationResult = addressService.getAddressInformation(address);
        Assertions.assertTrue(addressInformationResult.isSuccessful());
        Assertions.assertNotNull(addressInformationResult.getValue());
        log.info(addressInformationResult.getValue().toString());
    }

    @Test
    void getAddressInformationTest2() throws ApiException {
        List<String> addresses = List.of("addr_test1vpfwv0ezc5g8a4mkku8hhy3y3vp92t7s3ul8g778g5yegsgalc6gc",
                "addr_test1vqneq3v0dqh3x3muv6ee3lt8e5729xymnxuavx6tndcjc2cv24ef9");
        Result<List<AddressInfo>> addressInformationResult = addressService.getAddressInformation(addresses, SortType.ASC, Options.EMPTY);
        Assertions.assertTrue(addressInformationResult.isSuccessful());
        Assertions.assertNotNull(addressInformationResult.getValue());
        log.info(addressInformationResult.getValue().toString());
    }

    @Test
    void getAddressInformationBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressInformation(address));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAddressUTxOsTest() throws ApiException {
        List<String> addresses = List.of("addr_test1vpfwv0ezc5g8a4mkku8hhy3y3vp92t7s3ul8g778g5yegsgalc6gc",
                "addr_test1vqneq3v0dqh3x3muv6ee3lt8e5729xymnxuavx6tndcjc2cv24ef9");
        Result<List<UTxO>> addressUTxOsResult = addressService.getAddressUTxOs(addresses, true, Options.EMPTY);
        Assertions.assertTrue(addressUTxOsResult.isSuccessful());
        Assertions.assertNotNull(addressUTxOsResult.getValue());
        log.info(addressUTxOsResult.getValue().toString());
    }

    @Test
    void getAddressUTxOsBadRequestTest() {
        List<String> addresses = List.of("asdf123",
                "addr_test1vqneq3v0dqh3x3muv6ee3lt8e5729xymnxuavx6tndcjc2cv24ef9");
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressUTxOs(addresses, false, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getUTxOsFromPaymentCredentialsTest() throws ApiException {
        List<String> addresses = List.of("33c378cee41b2e15ac848f7f6f1d2f78155ab12d93b713de898d855f",
                "52e63f22c5107ed776b70f7b92248b02552fd08f3e747bc745099441");
        Result<List<UTxO>> addressUTxOsResult = addressService.getUTxOsFromPaymentCredentials(addresses, true, Options.EMPTY);
        Assertions.assertTrue(addressUTxOsResult.isSuccessful());
        Assertions.assertNotNull(addressUTxOsResult.getValue());
        log.info(addressUTxOsResult.getValue().toString());
    }

    @Test
    void getAddressTransactionsTest() throws ApiException {
        String address = "addr_test1qrvaadv0h7atv366u6966u4rft2svjlf5uajy8lkpsgdrc24rnskuetxz2u3m5ac22s3njvftxcl2fc8k8kjr088ge0qz98xmv";
        Result<List<TxHash>> txHashesResult = addressService.getAddressTransactions(List.of(address),250, Options.EMPTY);
        Assertions.assertTrue(txHashesResult.isSuccessful());
        Assertions.assertNotNull(txHashesResult.getValue());
        log.info(txHashesResult.getValue().toString());
    }

    @Test
    void getAddressTransactionsBadRequestTest() {
        String badAddress = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressTransactions(List.of(badAddress),250, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);

        String address = "addr_test1qrvaadv0h7atv366u6966u4rft2svjlf5uajy8lkpsgdrc24rnskuetxz2u3m5ac22s3njvftxcl2fc8k8kjr088ge0qz98xmv";
        exception = assertThrows(ApiException.class, () -> addressService.getAddressTransactions(List.of(address),-5, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAddressAssetsTest() throws ApiException {
        String address = "addr_test1qrvaadv0h7atv366u6966u4rft2svjlf5uajy8lkpsgdrc24rnskuetxz2u3m5ac22s3njvftxcl2fc8k8kjr088ge0qz98xmv";
        Result<List<AddressAsset>> assetInfosResult = addressService.getAddressAssets(List.of(address), Options.EMPTY);
        Assertions.assertTrue(assetInfosResult.isSuccessful());
        Assertions.assertNotNull(assetInfosResult.getValue());
        Assertions.assertFalse(assetInfosResult.getValue().isEmpty());
        log.info(assetInfosResult.getValue().toString());
    }

    @Test
    void getAddressAssetsBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressAssets(List.of(address), Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getTransactionsByPaymentCredentialsTest() throws ApiException {
        String paymentCredentials = "33c378cee41b2e15ac848f7f6f1d2f78155ab12d93b713de898d855f";
        Result<List<TxHash>> txHashesResult = addressService.getTransactionsByPaymentCredentials(List.of(paymentCredentials), Options.EMPTY);
        Assertions.assertTrue(txHashesResult.isSuccessful());
        Assertions.assertNotNull(txHashesResult.getValue());
        log.info(txHashesResult.getValue().toString());
    }

    @Test
    void getTransactionsByPaymentCredentialsBadRequestTest() {
        String badPaymentCredentials = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getTransactionsByPaymentCredentials(List.of(badPaymentCredentials),250, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);

        String paymentCredentials = "33c378cee41b2e15ac848f7f6f1d2f78155ab12d93b713de898d855f";
        exception = assertThrows(ApiException.class, () -> addressService.getTransactionsByPaymentCredentials(List.of(paymentCredentials),-5, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }
}
