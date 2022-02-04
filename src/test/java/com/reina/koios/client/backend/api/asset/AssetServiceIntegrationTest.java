package com.reina.koios.client.backend.api.asset;

import com.reina.koios.client.backend.api.asset.model.*;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.factory.BackendFactory;
import com.reina.koios.client.backend.factory.options.Limit;
import com.reina.koios.client.backend.factory.options.Options;
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
    void getAssetListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Asset[] assets = assetService.getAssetList(options);
        log.info(Arrays.toString(assets));
        Assertions.assertNotNull(assets);
        Assertions.assertEquals(10, assets.length);
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
    void getAssetSummaryTest() throws ApiException {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        AssetSummary[] assetSummary = assetService.getAssetSummary(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetSummary));
        Assertions.assertNotNull(assetSummary);
    }

    @Test
    void getAssetSummaryBadRequestTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetSummary(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAssetTxsTest() throws ApiException {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetName = "MusicBong359";
        String assetNameHex = String.format("%x", new BigInteger(1, assetName.getBytes()));
        AssetTx[] assetTxs = assetService.getAssetTransactionHistory(assetPolicy, assetNameHex);
        log.info(Arrays.toString(assetTxs));
        Assertions.assertNotNull(assetTxs);
    }

    @Test
    void getAssetTxsBadRequestTest() {
        String assetPolicy = "654ebfc69ea9b582d09755a0760fdac7b3e16718ef47acd958708035";
        String assetNameHex = "53706f6f6b79426f782331asdsadsa";
        ApiException exception = assertThrows(ApiException.class, () -> assetService.getAssetTransactionHistory(assetPolicy, assetNameHex));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }
}
