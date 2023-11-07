package rest.koios.client.backend.api.script.api;

import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.script.model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Script API
 */
public interface ScriptApi {

    /**
     * List of script information for given script hashes
     *
     * @param requestBody Array of Cardano script hashes
     * @param paramsMap   Options and Filters Map
     * @return List of {@link ScriptInfo}
     */
    @POST("script_info")
    Call<List<ScriptInfo>> getScriptInformation(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * List of all existing native script hashes along with their creation transaction hashes
     *
     * @param paramsMap Options and Filters Map
     * @return List of {@link NativeScript}
     */
    @GET("native_script_list")
    Call<List<NativeScript>> getNativeScriptList(@QueryMap Map<String, String> paramsMap);

    /**
     * List of all existing Plutus script hashes along with their creation transaction hashes
     *
     * @param paramsMap Options and Filters Map
     * @return List of {@link PlutusScript}
     */
    @GET("plutus_script_list")
    Call<List<PlutusScript>> getPlutusScriptList(@QueryMap Map<String, String> paramsMap);

    /**
     * List of all redeemers for a given script hash
     *
     * @param scriptHash Script hash in hexadecimal format (hex)
     * @param paramsMap  Options and Filters Map
     * @return List of {@link ScriptRedeemer}
     */
    @GET("script_redeemers")
    Call<List<ScriptRedeemer>> getScriptRedeemers(@Query("_script_hash") String scriptHash, @QueryMap Map<String, String> paramsMap);

    /**
     * Script UTXOs
     * List of all UTXOs for a given script hash
     *
     * @param scriptHash Script hash in hexadecimal format (hex)
     * @param extended   Controls whether or not certain optional fields supported by a given endpoint are populated as a part of the call
     * @param paramsMap  Options and Filters Map
     * @return List of {@link ScriptRedeemer}
     */
    @GET("script_utxos")
    Call<List<UTxO>> getScriptUTxOs(@Query("_script_hash") String scriptHash, @Query("_extended") Boolean extended, @QueryMap Map<String, String> paramsMap);

    /**
     * Get Datum Information
     *
     * @param requestBody Array of Cardano datum hashes
     * @param paramsMap   Query Params
     * @return List of datum information for given datum hashes
     */
    @POST("datum_info")
    Call<List<DatumInfo>> getDatumInformation(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);
}
