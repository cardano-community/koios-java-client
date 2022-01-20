package com.reina.koios.client.api;

import retrofit2.Call;
import retrofit2.http.*;

public interface AddressApi {
  /**
   * Address Assets
   * Get the list of all the assets (policy, name and quantity) for a given address
   * @param _address Cardano payment address in bech32 format (required)
   * @return Call&lt;Void&gt;
   */
  @GET("address_assets")
  Call<Void> addressAssetsGet(
        @Query("_address") String _address
  );

  /**
   * Address Information
   * Get address info - balance, associated stake address (if any) and UTXO set
   * @param _address Cardano payment address in bech32 format (required)
   * @return Call&lt;Void&gt;
   */
  @GET("address_info")
  Call<Void> addressInfoGet(
        @Query("_address") String _address
  );

  /**
   * Address Transactions
   * Get the transaction hash list of input address array, optionally filtering after specified block height (inclusive)
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("address_txs")
  Call<Void> addressTxsPost(
                    @Body Object body
  );

  /**
   * Transactions from payment credentials
   * Get the transaction hash list of input payment credential array, optionally filtering after specified block height (inclusive)
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("credential_txs")
  Call<Void> credentialTxsPost(
                    @Body Object body
  );

}
