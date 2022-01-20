package com.reina.koios.client.api;

import com.reina.koios.client.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for ScriptApi
 */
public class ScriptApiTest {

    private ScriptApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ScriptApi.class);
    }

    /**
     * Script List
     * <p>
     * List of all existing script hashes along with their creation transaction hashes
     */
    @Test
    public void scriptListGetTest() {
        // ScriptList response = api.scriptListGet();

        // TODO: test validations
    }

    /**
     * Script Redeemers
     * <p>
     * List of all redeemers for a given script hash
     */
    @Test
    public void scriptRedeemersGetTest() {
        String _scriptHash = null;
        // ScriptRedeemers response = api.scriptRedeemersGet(_scriptHash);

        // TODO: test validations
    }
}
