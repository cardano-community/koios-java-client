package rest.koios.client.backend.api.script.api;

import rest.koios.client.backend.api.script.model.NativeScript;
import rest.koios.client.backend.api.script.model.PlutusScript;
import rest.koios.client.backend.api.script.model.ScriptRedeemer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * Script API
 */
public interface ScriptApi {

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
}
