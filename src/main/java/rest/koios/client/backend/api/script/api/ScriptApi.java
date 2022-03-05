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

    @GET("native_script_list")
    Call<List<NativeScript>> getNativeScriptList(@QueryMap Map<String, String> paramsMap);

    @GET("plutus_script_list")
    Call<List<PlutusScript>> getPlutusScriptList(@QueryMap Map<String, String> paramsMap);

    @GET("script_redeemers")
    Call<List<ScriptRedeemer>> getScriptRedeemers(@Query("_script_hash") String scriptHash, @QueryMap Map<String, String> paramsMap);
}
