package rest.koios.client.backend.api.address;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.address.model.AddressAsset;
import rest.koios.client.backend.api.address.model.AddressInfo;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.base.common.TxHash;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.backend.factory.options.SortType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddressServicePreprodIntegrationTest {

    private AddressService addressService;

    @BeforeAll
    public void setup() {
        addressService = BackendFactory.getKoiosPreprodService().getAddressService();
    }

    @Test
    void getAddressInformationTest() throws ApiException {
        String address = "addr_test1qzr0g2kvyknzhyez3aatyjwpaw5z5n65cwfxc5ctcqq28ed3hcc035r9r76tkxehlr9wdla9twe02dpv843nru6czj6qycpamy";
        Result<AddressInfo> addressInformationResult = addressService.getAddressInformation(address);
        Assertions.assertTrue(addressInformationResult.isSuccessful());
        Assertions.assertNotNull(addressInformationResult.getValue());
        log.info(addressInformationResult.getValue().toString());
    }

    @Test
    void getAddressInformationTest2() throws ApiException {
        List<String> addresses = List.of("addr_test1vzpwq95z3xyum8vqndgdd9mdnmafh3djcxnc6jemlgdmswcve6tkw",
                "addr_test1vpfwv0ezc5g8a4mkku8hhy3y3vp92t7s3ul8g778g5yegsgalc6gc");
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
        List<String> addresses = List.of("addr_test1vzpwq95z3xyum8vqndgdd9mdnmafh3djcxnc6jemlgdmswcve6tkw",
                "addr_test1vpfwv0ezc5g8a4mkku8hhy3y3vp92t7s3ul8g778g5yegsgalc6gc");
        Result<List<UTxO>> addressUTxOsResult = addressService.getAddressUTxOs(addresses, true, Options.EMPTY);
        Assertions.assertTrue(addressUTxOsResult.isSuccessful());
        Assertions.assertNotNull(addressUTxOsResult.getValue());
        log.info(addressUTxOsResult.getValue().toString());
    }

    @Test
    void getAddressUTxOsBadRequestTest() {
        List<String> addresses = List.of("asdf123",
                "addr_test1vpfwv0ezc5g8a4mkku8hhy3y3vp92t7s3ul8g778g5yegsgalc6gc");
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressUTxOs(addresses, false, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getUTxOsFromPaymentCredentialsTest() throws ApiException {
        List<String> addresses = List.of("b429738bd6cc58b5c7932d001aa2bd05cfea47020a556c8c753d4436",
                "82e016828989cd9d809b50d6976d9efa9bc5b2c1a78d4b3bfa1bb83b");
        Result<List<UTxO>> addressUTxOsResult = addressService.getUTxOsFromPaymentCredentials(addresses, true, Options.EMPTY);
        Assertions.assertTrue(addressUTxOsResult.isSuccessful());
        Assertions.assertNotNull(addressUTxOsResult.getValue());
        log.info(addressUTxOsResult.getValue().toString());
    }

    @Test
    void getAddressTransactionsTest() throws ApiException {
        String address = "addr_test1qzr0g2kvyknzhyez3aatyjwpaw5z5n65cwfxc5ctcqq28ed3hcc035r9r76tkxehlr9wdla9twe02dpv843nru6czj6qycpamy";
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

        String address = "addr_test1qzr0g2kvyknzhyez3aatyjwpaw5z5n65cwfxc5ctcqq28ed3hcc035r9r76tkxehlr9wdla9twe02dpv843nru6czj6qycpamy";
        exception = assertThrows(ApiException.class, () -> addressService.getAddressTransactions(List.of(address),-5, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAddressAssetsTest() throws ApiException {
        String address = "addr_test1zrgfhr82d6nlv8as6x7sg9rur6x7ke3rdgu2t4y37phzxpd3hcc035r9r76tkxehlr9wdla9twe02dpv843nru6czj6qxzlq5e";
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
        String paymentCredentials = "b429738bd6cc58b5c7932d001aa2bd05cfea47020a556c8c753d4436";
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

        String paymentCredentials = "b429738bd6cc58b5c7932d001aa2bd05cfea47020a556c8c753d4436";
        exception = assertThrows(ApiException.class, () -> addressService.getTransactionsByPaymentCredentials(List.of(paymentCredentials),-5, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }
}
