package com.reina.koios.client.api;

import com.reina.koios.client.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for PoolApi
 */
public class PoolApiTest {

    private PoolApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(PoolApi.class);
    }


    /**
     * Pool Blocks
     * <p>
     * Return information about blocks minted by a given pool in current epoch (or _epoch_no if provided)
     */
    @Test
    public void poolBlocksGetTest() {
        String _poolBech32 = null;
        String _epochNo = null;
        // Void response = api.poolBlocksGet(_poolBech32, _epochNo);

        // TODO: test validations
    }

    /**
     * Pool Delegators List
     * <p>
     * Return information about delegators by a given pool and optional epoch (current if omitted)
     */
    @Test
    public void poolDelegatorsGetTest() {
        String _poolBech32 = null;
        String _epochNo = null;
        // Void response = api.poolDelegatorsGet(_poolBech32, _epochNo);

        // TODO: test validations
    }

    /**
     * Pool Information
     * <p>
     * Current pool status and details for specified pool id
     */
    @Test
    public void poolInfoGetTest() {
        String _poolBech32 = null;
        // Void response = api.poolInfoGet(_poolBech32);

        // TODO: test validations
    }

    /**
     * Pool List
     * <p>
     * A list of all currently registered/retiring (not retired) pools
     */
    @Test
    public void poolListGetTest() {
        // PoolList response = api.poolListGet();

        // TODO: test validations
    }

    /**
     * Pool Metadata
     * <p>
     * Metadata(on &amp; off-chain) for all currently registered/retiring (not retired) pools
     */
    @Test
    public void poolMetadataGetTest() {
        // Void response = api.poolMetadataGet();

        // TODO: test validations
    }

    /**
     * Pool Relays
     * <p>
     * A list of registered relays for all currently registered/retiring (not retired) pools
     */
    @Test
    public void poolRelaysGetTest() {
        // Void response = api.poolRelaysGet();

        // TODO: test validations
    }

    /**
     * Pool Updates (History)
     * <p>
     * Return all pool updates for all pools or only updates for specific pool if specified
     */
    @Test
    public void poolUpdatesGetTest() {
        String _poolBech32 = null;
        // Void response = api.poolUpdatesGet(_poolBech32);

        // TODO: test validations
    }
}
