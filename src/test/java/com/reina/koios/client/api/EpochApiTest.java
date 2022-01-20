package com.reina.koios.client.api;

import com.reina.koios.client.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for EpochApi
 */
public class EpochApiTest {

    private EpochApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(EpochApi.class);
    }


    /**
     * Epoch Information
     * <p>
     * Get the epoch information, all epochs if no epoch specified
     */
    @Test
    public void epochInfoGetTest() {
        String _epochNo = null;
        // EpochInfo response = api.epochInfoGet(_epochNo);

        // TODO: test validations
    }

    /**
     * Epoch&#x27;s Protocol Parameters
     * <p>
     * Get the protocol parameters for specific epoch, returns information about all epochs if no epoch specified
     */
    @Test
    public void epochParamsGetTest() {
        String _epochNo = null;
        // EpochParams response = api.epochParamsGet(_epochNo);

        // TODO: test validations
    }
}
