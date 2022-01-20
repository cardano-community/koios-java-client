package com.reina.koios.client.api;

import com.reina.koios.client.ApiClient;
import org.junit.Before;
import org.junit.Test;


/**
 * API tests for AssetApi
 */
public class AssetApiTest {

    private AssetApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AssetApi.class);
    }


    /**
     * Assets Address List
     * <p>
     * Get a list of all addresses for a given asset
     */
    @Test
    public void assetAddressListGetTest() {
        String _assetPolicy = null;
        String _assetName = null;
        // Void response = api.assetAddressListGet(_assetPolicy, _assetName);

        // TODO: test validations
    }

    /**
     * Asset Information
     * <p>
     * Get the information of an asset incl first minting &amp; token registry metadata
     */
    @Test
    public void assetInfoGetTest() {
        String _assetPolicy = null;
        String _assetName = null;
        // Void response = api.assetInfoGet(_assetPolicy, _assetName);

        // TODO: test validations
    }

    /**
     * Asset Summary
     * <p>
     * Get the summary of an asset (total transactions exclude minting/total wallets include only wallets with asset balance)
     */
    @Test
    public void assetTxsGetTest() {
        String _assetPolicy = null;
        String _assetName = null;
        // Void response = api.assetTxsGet(_assetPolicy, _assetName);

        // TODO: test validations
    }
}
