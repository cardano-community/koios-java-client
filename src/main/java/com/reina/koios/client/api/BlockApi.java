package com.reina.koios.client.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BlockApi {
  /**
   * Block Information
   * Get detailed information about a specific block
   * @param _blockHash Block Hash in hex format (required)
   * @return Call&lt;Void&gt;
   */
  @GET("block_info")
  Call<Void> blockInfoGet(
        @Query("_block_hash") String _blockHash
  );

  /**
   * Block Transactions
   * Get a list of all transactions included in a provided block
   * @param _blockHash Block Hash in hex format (required)
   * @return Call&lt;Void&gt;
   */
  @GET("block_txs")
  Call<Void> blockTxsGet(
        @Query("_block_hash") String _blockHash
  );

  /**
   * Block List
   * Get summarised details about all blocks (paginated - latest first)
   * @return Call&lt;Void&gt;
   */
  @GET("blocks")
  Call<Void> blocksGet();
    

}
