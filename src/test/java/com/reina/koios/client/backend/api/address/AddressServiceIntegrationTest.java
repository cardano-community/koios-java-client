package com.reina.koios.client.backend.api.address;

import com.reina.koios.client.backend.api.TxHash;
import com.reina.koios.client.backend.api.address.model.AddressInfo;
import com.reina.koios.client.backend.api.address.model.AssetInfo;
import com.reina.koios.client.backend.factory.BackendFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddressServiceIntegrationTest {

    private AddressService addressService;

    @BeforeAll
    public void setup() {
        addressService = BackendFactory.getKoiosTestnetService().getAddressService();
    }

    @Test
    void getAddressInformationTest() {
        String address = "addr_test1qz0xcyfuwkf6a2c8g0mhjdaxxvtuw2u04dqjx7tt2gwaq5522z65y7wauh6rryspdn7xrg5u7nkf5ung6qk5dn3a7u8syvce7n";
        AddressInfo[] addressInformation = addressService.getAddressInformation(address);
        log.info(Arrays.toString(addressInformation));
        Assertions.assertNotNull(addressInformation);
    }

    @Test
    void getAddressTransactionsTest() {
        String address = "addr_test1qz0xcyfuwkf6a2c8g0mhjdaxxvtuw2u04dqjx7tt2gwaq5522z65y7wauh6rryspdn7xrg5u7nkf5ung6qk5dn3a7u8syvce7n";
        TxHash[] txHashes = addressService.getAddressTransactions(List.of(address),250);
        log.info(Arrays.toString(txHashes));
        Assertions.assertNotNull(txHashes);
    }

    @Test
    void getTransactionsByPaymentCredentialsTest() {
        String paymentCredentials = "d38191f836e65ae4a8072ba07fa3b0bd6256ffed4a95895008ba5f1b";
        TxHash[] txHashes = addressService.getTransactionsByPaymentCredentials(List.of(paymentCredentials),250);
        log.info(Arrays.toString(txHashes));
        Assertions.assertNotNull(txHashes);
    }

    @Test
    void getAddressAssetsTest() {
        String address = "addr_test1qz0xcyfuwkf6a2c8g0mhjdaxxvtuw2u04dqjx7tt2gwaq5522z65y7wauh6rryspdn7xrg5u7nkf5ung6qk5dn3a7u8syvce7n";
        AssetInfo[] assetInfos = addressService.getAddressAssets(address);
        log.info(Arrays.toString(assetInfos));
        Assertions.assertNotNull(assetInfos);
    }
}
