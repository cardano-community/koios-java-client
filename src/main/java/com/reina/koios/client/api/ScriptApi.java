package com.reina.koios.client.api;

import com.reina.koios.client.model.ScriptList;
import com.reina.koios.client.model.ScriptRedeemers;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ScriptApi {
  /**
   * Script List
   * List of all existing script hashes along with their creation transaction hashes
   * @return Call&lt;ScriptList&gt;
   */
  @GET("script_list")
  Call<ScriptList> scriptListGet();
    

  /**
   * Script Redeemers
   * List of all redeemers for a given script hash
   * @param _scriptHash Script hash in hexadecimal format (hex) (required)
   * @return Call&lt;ScriptRedeemers&gt;
   */
  @GET("script_redeemers")
  Call<ScriptRedeemers> scriptRedeemersGet(
        @Query("_script_hash") String _scriptHash
  );

}
