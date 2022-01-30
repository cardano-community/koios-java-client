package com.reina.koios.client.backend.api.asset;

import com.reina.koios.client.backend.api.asset.model.Asset;
import com.reina.koios.client.backend.api.asset.model.AssetAddress;
import com.reina.koios.client.backend.api.asset.model.AssetInformation;
import com.reina.koios.client.backend.api.asset.model.AssetTx;
import com.reina.koios.client.backend.factory.BackendFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigInteger;
import java.util.Arrays;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AssetServiceIntegrationTest {

    private AssetService assetService;

    @BeforeAll
    public void setup() {
        assetService = BackendFactory.getKoiosTestnetService().getAssetService();
    }

    @Test
    void getAssetsAddressListTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        AssetAddress[] assetAddresses = assetService.getAssetsAddressList(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetAddresses));
        Assertions.assertNotNull(assetAddresses);
    }

    @Test
    void getAssetInformationTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        AssetInformation[] assetInformation = assetService.getAssetInformation(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetInformation));
        Assertions.assertNotNull(assetInformation);
    }

    @Test
    void getAssetTxsTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        AssetTx[] assetTxs = assetService.getAssetTxs(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetTxs));
        Assertions.assertNotNull(assetTxs);
    }

    @Test
    void getAssetListTest() {
        Asset[] assets = assetService.getAssetList();
        log.info(Arrays.toString(assets));
        Assertions.assertNotNull(assets);
    }
}
