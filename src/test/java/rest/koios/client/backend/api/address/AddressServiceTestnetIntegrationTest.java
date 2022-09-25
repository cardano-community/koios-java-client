package rest.koios.client.backend.api.address;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.TxHash;
import rest.koios.client.backend.api.address.model.AddressAsset;
import rest.koios.client.backend.api.address.model.AddressInfo;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddressServiceTestnetIntegrationTest {

    private AddressService addressService;

    @BeforeAll
    public void setup() {
        addressService = BackendFactory.getKoiosTestnetService().getAddressService();
    }

    @Test
    void getAddressInformationTest() throws ApiException {
        String address = "addr_test1qz0xcyfuwkf6a2c8g0mhjdaxxvtuw2u04dqjx7tt2gwaq5522z65y7wauh6rryspdn7xrg5u7nkf5ung6qk5dn3a7u8syvce7n";
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
        String address = "addr_test1qz0xcyfuwkf6a2c8g0mhjdaxxvtuw2u04dqjx7tt2gwaq5522z65y7wauh6rryspdn7xrg5u7nkf5ung6qk5dn3a7u8syvce7n";
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

        String address = "addr_test1qz0xcyfuwkf6a2c8g0mhjdaxxvtuw2u04dqjx7tt2gwaq5522z65y7wauh6rryspdn7xrg5u7nkf5ung6qk5dn3a7u8syvce7n";
        exception = assertThrows(ApiException.class, () -> addressService.getAddressTransactions(List.of(address),-5, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAddressAssetsTest() throws ApiException {
        String address = "addr_test1qz0xcyfuwkf6a2c8g0mhjdaxxvtuw2u04dqjx7tt2gwaq5522z65y7wauh6rryspdn7xrg5u7nkf5ung6qk5dn3a7u8syvce7n";
        Result<List<AddressAsset>> assetInfosResult = addressService.getAddressAssets(List.of(address), Options.EMPTY);
        Assertions.assertTrue(assetInfosResult.isSuccessful());
        Assertions.assertNotNull(assetInfosResult.getValue());
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
        String paymentCredentials = "d38191f836e65ae4a8072ba07fa3b0bd6256ffed4a95895008ba5f1b";
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

        String paymentCredentials = "d38191f836e65ae4a8072ba07fa3b0bd6256ffed4a95895008ba5f1b";
        exception = assertThrows(ApiException.class, () -> addressService.getTransactionsByPaymentCredentials(List.of(paymentCredentials),-5, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }
}
