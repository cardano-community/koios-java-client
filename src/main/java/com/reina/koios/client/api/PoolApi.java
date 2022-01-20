package com.reina.koios.client.api;

import com.reina.koios.client.model.PoolList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PoolApi {
    /**
     * Pool Blocks
     * Return information about blocks minted by a given pool in current epoch (or _epoch_no if provided)
     *
     * @param _poolBech32 Pool ID in bech32 format (required)
     * @param _epochNo    Epoch Number to fetch details for (optional)
     * @return Call&lt;Void&gt;
     */
    @GET("pool_blocks")
    Call<Void> poolBlocksGet(
            @Query("_pool_bech32") String _poolBech32, @Query("_epoch_no") String _epochNo
    );

    /**
     * Pool Delegators List
     * Return information about delegators by a given pool and optional epoch (current if omitted)
     *
     * @param _poolBech32 Pool ID in bech32 format (required)
     * @param _epochNo    Epoch Number to fetch details for (optional)
     * @return Call&lt;Void&gt;
     */
    @GET("pool_delegators")
    Call<Void> poolDelegatorsGet(
            @Query("_pool_bech32") String _poolBech32, @Query("_epoch_no") String _epochNo
    );

    /**
     * Pool Information
     * Current pool status and details for specified pool id
     *
     * @param _poolBech32 Pool ID in bech32 format (required)
     * @return Call&lt;Void&gt;
     */
    @GET("pool_info")
    Call<Void> poolInfoGet(
            @Query("_pool_bech32") String _poolBech32
    );

    /**
     * Pool List
     * A list of all currently registered/retiring (not retired) pools
     *
     * @return Call&lt;PoolList&gt;
     */
    @GET("pool_list")
    Call<PoolList> poolListGet();


    /**
     * Pool Metadata
     * Metadata(on &amp; off-chain) for all currently registered/retiring (not retired) pools
     *
     * @return Call&lt;Void&gt;
     */
    @GET("pool_metadata")
    Call<Void> poolMetadataGet();


    /**
     * Pool Relays
     * A list of registered relays for all currently registered/retiring (not retired) pools
     *
     * @return Call&lt;Void&gt;
     */
    @GET("pool_relays")
    Call<Void> poolRelaysGet();


    /**
     * Pool Updates (History)
     * Return all pool updates for all pools or only updates for specific pool if specified
     *
     * @param _poolBech32 Pool ID in bech32 format (optional) (optional)
     * @return Call&lt;Void&gt;
     */
    @GET("pool_updates")
    Call<Void> poolUpdatesGet(
            @Query("_pool_bech32") String _poolBech32
    );

}
