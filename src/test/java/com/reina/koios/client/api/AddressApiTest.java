package com.reina.koios.client.api;

import com.reina.koios.client.ApiClient;
import org.junit.Before;
import org.junit.Test;


/**
 * API tests for AddressApi
 */
public class AddressApiTest {

    private AddressApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AddressApi.class);
    }


    /**
     * Address Assets
     * <p>
     * Get the list of all the assets (policy, name and quantity) for a given address
     */
    @Test
    public void addressAssetsGetTest() {
        String _address = null;
        // Void response = api.addressAssetsGet(_address);

        // TODO: test validations
    }

    /**
     * Address Information
     * <p>
     * Get address info - balance, associated stake address (if any) and UTXO set
     */
    @Test
    public void addressInfoGetTest() {
        String _address = null;
        // Void response = api.addressInfoGet(_address);

        // TODO: test validations
    }

    /**
     * Address Transactions
     * <p>
     * Get the transaction hash list of input address array, optionally filtering after specified block height (inclusive)
     */
    @Test
    public void addressTxsPostTest() {
        Object body = null;
        // Void response = api.addressTxsPost(body);

        // TODO: test validations
    }

    /**
     * Transactions from payment credentials
     * <p>
     * Get the transaction hash list of input payment credential array, optionally filtering after specified block height (inclusive)
     */
    @Test
    public void credentialTxsPostTest() {
        Object body = null;
        // Void response = api.credentialTxsPost(body);

        // TODO: test validations
    }
}
