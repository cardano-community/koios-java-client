package com.reina.koios.client.backend.api.script;

import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.script.model.Script;
import com.reina.koios.client.backend.api.script.model.ScriptRedeemer;

public interface ScriptService {

    /**
     * Script List
     * List of all existing script hashes along with their creation transaction hashes
     * <p><b>200</b> - List of script and creation tx hash pairs
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @return Array of {@link Script}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Script[] getScriptList() throws ApiException;

    /**
     * Script Redeemers
     * List of all redeemers for a given script hash
     * <p><b>200</b> - List of all redeemers for a given script hash
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param scriptHash Script hash in hexadecimal format (hex) (required)
     * @return Array of all {@link ScriptRedeemer} for a given script hash
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    ScriptRedeemer[] getScriptRedeemers(String scriptHash) throws ApiException;
}
