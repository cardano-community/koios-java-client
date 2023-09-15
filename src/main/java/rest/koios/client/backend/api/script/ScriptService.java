package rest.koios.client.backend.api.script;

import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.script.model.DatumInfo;
import rest.koios.client.backend.api.script.model.NativeScript;
import rest.koios.client.backend.api.script.model.PlutusScript;
import rest.koios.client.backend.api.script.model.ScriptRedeemer;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

/**
 * Script Service
 */
public interface ScriptService {

    /**
     * Native Script List with Filtering, Pagination, Ordering Options
     * List of all existing native script hashes along with their creation transaction hashes
     * <p><b>200</b> - List of script and creation tx hash pairs
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PlutusScript}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<NativeScript>> getNativeScriptList(Options options) throws ApiException;

    /**
     * Native Script by Script Hash
     * Get Specific native script by script hash along with their creation transaction hashes
     * <p><b>200</b> - native script and creation tx hash pairs
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param scriptHash Hash of a script
     * @return Result of Type {@link NativeScript}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<NativeScript> getNativeScript(String scriptHash) throws ApiException;

    /**
     * Plutus Script List with Filtering, Pagination, Ordering Options
     * List of all existing Plutus script hashes along with their creation transaction hashes
     * <p><b>200</b> - List of script and creation tx hash pairs
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PlutusScript}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PlutusScript>> getPlutusScriptList(Options options) throws ApiException;

    /**
     * Script Redeemers with Filtering, Pagination, Ordering Options
     * List of all redeemers for a given script hash
     * <p><b>200</b> - List of all redeemers for a given script hash
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param scriptHash Script hash in hexadecimal format (hex) (required)
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of all {@link ScriptRedeemer} for a given script hash
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<ScriptRedeemer>> getScriptRedeemers(String scriptHash, Options options) throws ApiException;

    /**
     * Datum Information with Filtering, Pagination, Ordering Options
     * List of datum information for given datum hashes
     * <p><b>200</b> - List of datum information for given datum hashes
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param datumHashes List of Cardano datum hashes (required)
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of all {@link DatumInfo} for a given script hash
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<DatumInfo>> getDatumInformation(List<String> datumHashes, Options options) throws ApiException;
}
