package rest.koios.client.backend.api.address;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.address.model.AddressAsset;
import rest.koios.client.backend.api.address.model.AddressInfo;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.common.TxHash;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Options;

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
    void getAddressInformationBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressInformation(address));
        assertInstanceOf(ApiException.class, exception);
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
        Result<List<TxHash>> txHashesResult = addressService.getTransactionsByPaymentCredentials(List.of(paymentCredentials),250, Options.EMPTY);
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
