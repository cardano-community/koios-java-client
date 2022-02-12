package com.reina.koios.client.backend.api.address;

import com.reina.koios.client.backend.api.TxHash;
import com.reina.koios.client.backend.api.address.model.AddressInfo;
import com.reina.koios.client.backend.api.address.model.AssetInfo;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.factory.BackendFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        AddressInfo[] addressInformation = addressService.getAddressInformation(address);
        log.info(Arrays.toString(addressInformation));
        Assertions.assertNotNull(addressInformation);
    }

    @Test
    void getAddressInformationBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressInformation(address));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAddressTransactionsTest() throws ApiException {
        String address = "addr_test1qz0xcyfuwkf6a2c8g0mhjdaxxvtuw2u04dqjx7tt2gwaq5522z65y7wauh6rryspdn7xrg5u7nkf5ung6qk5dn3a7u8syvce7n";
        TxHash[] txHashes = addressService.getAddressTransactions(List.of(address),250);
        log.info(Arrays.toString(txHashes));
        Assertions.assertNotNull(txHashes);
    }

    @Test
    void getAddressTransactionsBadRequestTest() {
        String badAddress = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressTransactions(List.of(badAddress),250));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());

        String address = "addr_test1qz0xcyfuwkf6a2c8g0mhjdaxxvtuw2u04dqjx7tt2gwaq5522z65y7wauh6rryspdn7xrg5u7nkf5ung6qk5dn3a7u8syvce7n";
        exception = assertThrows(ApiException.class, () -> addressService.getAddressTransactions(List.of(address),-5));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAddressAssetsTest() throws ApiException {
        String address = "addr_test1qz0xcyfuwkf6a2c8g0mhjdaxxvtuw2u04dqjx7tt2gwaq5522z65y7wauh6rryspdn7xrg5u7nkf5ung6qk5dn3a7u8syvce7n";
        AssetInfo[] assetInfos = addressService.getAddressAssets(address);
        log.info(Arrays.toString(assetInfos));
        Assertions.assertNotNull(assetInfos);
    }

    @Test
    void getAddressAssetsBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getAddressAssets(address));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getTransactionsByPaymentCredentialsTest() throws ApiException {
        String paymentCredentials = "d38191f836e65ae4a8072ba07fa3b0bd6256ffed4a95895008ba5f1b";
        TxHash[] txHashes = addressService.getTransactionsByPaymentCredentials(List.of(paymentCredentials),250);
        log.info(Arrays.toString(txHashes));
        Assertions.assertNotNull(txHashes);
    }

    @Test
    void getTransactionsByPaymentCredentialsBadRequestTest() {
        String badPaymentCredentials = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> addressService.getTransactionsByPaymentCredentials(List.of(badPaymentCredentials),250));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());

        String paymentCredentials = "d38191f836e65ae4a8072ba07fa3b0bd6256ffed4a95895008ba5f1b";
        exception = assertThrows(ApiException.class, () -> addressService.getTransactionsByPaymentCredentials(List.of(paymentCredentials),-5));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }
}
