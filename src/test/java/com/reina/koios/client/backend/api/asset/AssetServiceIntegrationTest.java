package com.reina.koios.client.backend.api.asset;

import com.reina.koios.client.backend.api.asset.model.Asset;
import com.reina.koios.client.backend.api.asset.model.AssetAddress;
import com.reina.koios.client.backend.api.asset.model.AssetInformation;
import com.reina.koios.client.backend.api.asset.model.AssetTx;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.factory.BackendFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AssetServiceIntegrationTest {

    private AssetService assetService;

    @BeforeAll
    public void setup() {
        assetService = BackendFactory.getKoiosTestnetService().getAssetService();
    }

    @Test
    void getAssetsAddressListTest() throws ApiException {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        AssetAddress[] assetAddresses = assetService.getAssetsAddressList(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetAddresses));
        Assertions.assertNotNull(assetAddresses);
    }

    @Test
    void getAssetsAddressListBadRequestTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetsAddressList(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAssetInformationTest() throws ApiException {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        AssetInformation[] assetInformation = assetService.getAssetInformation(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetInformation));
        Assertions.assertNotNull(assetInformation);
    }

    @Test
    void getAssetInformationBadRequestTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetInformation(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAssetTxsTest() throws ApiException {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        AssetTx[] assetTxs = assetService.getAssetTxs(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetTxs));
        Assertions.assertNotNull(assetTxs);
    }

    @Test
    void getAssetTxsBadRequestTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetTxs(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAssetListTest() throws ApiException {
        Asset[] assets = assetService.getAssetList();
        log.info(Arrays.toString(assets));
        Assertions.assertNotNull(assets);
    }
}
