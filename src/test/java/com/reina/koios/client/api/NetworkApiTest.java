package com.reina.koios.client.api;

import com.reina.koios.client.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for NetworkApi
 */
public class NetworkApiTest {

    private NetworkApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(NetworkApi.class);
    }


    /**
     * Get Genesis info
     *
     * Get the Genesis parameters used to start specific era on chain
     */
    @Test
    public void genesisGetTest() {
        // Genesis response = api.genesisGet();

        // TODO: test validations
    }

    /**
     * Query Chain Tip
     *
     * Get the tip info about the latest block seen by chain
     */
    @Test
    public void tipGetTest() {
        // Tip response = api.tipGet();

        // TODO: test validations
    }

    /**
     * Get historical tokenomic stats
     *
     * Get the circulating utxo, treasury, rewards, supply and reserves in lovelace for specified epoch, all epochs if empty
     */
    @Test
    public void totalsGetTest() {
        String _epochNo = null;
        // Totals response = api.totalsGet(_epochNo);

        // TODO: test validations
    }
}
