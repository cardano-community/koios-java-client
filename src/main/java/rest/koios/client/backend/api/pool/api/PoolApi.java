package rest.koios.client.backend.api.pool.api;

import rest.koios.client.backend.api.pool.model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Pool API
 */
public interface PoolApi {

    /**
     * A list of all currently registered/retiring (not retired) pools
     *
     * @param paramsMap Options and Filters Map
     * @return List of {@link Pool}
     */
    @GET("pool_list")
    Call<List<Pool>> getPoolList(@QueryMap Map<String, String> paramsMap);

    /**
     * Current pool statuses and details for a specified list of pool ids
     *
     * @param requestBody Pool Ids Body
     * @param paramsMap   Options and Filters Map
     * @return List of {@link PoolInfo}
     */
    @POST("pool_info")
    Call<List<PoolInfo>> getPoolInformation(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * Pool Stake Snapshot
     * Returns Mark, Set and Go stake snapshots for the selected pool, useful for leaderlog calculation
     *
     * @param poolBech32 Pool ID in bech32 format
     * @param paramsMap Options and Filters Map
     * @return List of {@link PoolStakeSnapshot}
     */
    @GET("pool_stake_snapshot")
    Call<List<PoolStakeSnapshot>> getPoolStakeSnapshot(@Query("_pool_bech32") String poolBech32, @QueryMap Map<String, String> paramsMap);

    /**
     * Return information about delegators by a given pool and for current epoch
     *
     * @param poolBech32 Pool ID in bech32 format
     * @param paramsMap  Options and Filters Map
     * @return List of {@link PoolDelegator}
     */
    @GET("pool_delegators")
    Call<List<PoolDelegator>> getPoolDelegatorsList(@Query("_pool_bech32") String poolBech32, @QueryMap Map<String, String> paramsMap);

    /**
     * Return information about active delegators (incl. history) for a given pool and epoch number - current epoch if not provided.
     *
     * @param poolBech32 Pool ID in bech32 format
     * @param epochNo    Epoch Number to fetch details for
     * @param paramsMap  Options and Filters Map
     * @return List of {@link PoolDelegatorHistory}
     */
    @GET("pool_delegators_history")
    Call<List<PoolDelegatorHistory>> getPoolDelegatorsHistory(@Query("_pool_bech32") String poolBech32, @Query("_epoch_no") Integer epochNo, @QueryMap Map<String, String> paramsMap);

    /**
     * Return information about blocks minted by a given pool for epoch specified by epochNo
     *
     * @param poolBech32 Pool ID in bech32 format
     * @param epochNo    Epoch Number to fetch details for
     * @param paramsMap  Options and Filters Map
     * @return List of {@link PoolBlock}
     */
    @GET("pool_blocks")
    Call<List<PoolBlock>> getPoolBlocksByEpoch(@Query("_pool_bech32") String poolBech32, @Query("_epoch_no") Integer epochNo, @QueryMap Map<String, String> paramsMap);

    /**
     * Return information about blocks minted by a given pool in current epoch
     *
     * @param poolBech32 Pool ID in bech32 format
     * @param paramsMap  Options and Filters Map
     * @return List of {@link PoolBlock}
     */
    @GET("pool_blocks")
    Call<List<PoolBlock>> getPoolBlocks(@Query("_pool_bech32") String poolBech32, @QueryMap Map<String, String> paramsMap);

    /**
     * Return information about pool stake, block and reward history in a given epoch _epoch_no (or all epochs that pool existed for, in descending order if no _epoch_no was provided)
     *
     * @param poolBech32 Pool ID in bech32 format
     * @param epochNo    Epoch Number to fetch details for
     * @param paramsMap  Options and Filters Map
     * @return List of {@link PoolHistory}
     */
    @GET("pool_history")
    Call<List<PoolHistory>> getPoolHistoryByEpoch(@Query("_pool_bech32") String poolBech32, @Query("_epoch_no") Integer epochNo, @QueryMap Map<String, String> paramsMap);

    /**
     * Return information about pool stake, block and reward history for all epochs that pool existed for.
     * (descending order by default)
     *
     * @param poolBech32 Pool ID in bech32 format
     * @param paramsMap  Options and Filters Map
     * @return List of {@link PoolHistory}
     */
    @GET("pool_history")
    Call<List<PoolHistory>> getPoolHistory(@Query("_pool_bech32") String poolBech32, @QueryMap Map<String, String> paramsMap);

    /**
     * Return all pool updates for specific pool
     *
     * @param poolBech32 Pool ID in bech32 format
     * @param paramsMap  Options and Filters Map
     * @return List of {@link PoolUpdate}
     */
    @GET("pool_updates")
    Call<List<PoolUpdate>> getPoolUpdatesByPoolBech32(@Query("_pool_bech32") String poolBech32, @QueryMap Map<String, String> paramsMap);

    /**
     * Return all pool updates for all pools
     *
     * @param paramsMap Options and Filters Map
     * @return List of {@link PoolUpdate}
     */
    @GET("pool_updates")
    Call<List<PoolUpdate>> getPoolUpdates(@QueryMap Map<String, String> paramsMap);

    /**
     * Pool Registrations
     * Return all pool registrations initiated in the requested epoch
     *
     * @param paramsMap Options and Filters Map
     * @return List of {@link PoolStatus}
     */
    @GET("pool_registrations")
    Call<List<PoolStatus>> getPoolRegistrations(@Query("_epoch_no") Integer epochNo, @QueryMap Map<String, String> paramsMap);

    /**
     * Pool Retirements
     * Return all pool retirements initiated in the requested epoch
     *
     * @param paramsMap Options and Filters Map
     * @return List of {@link PoolStatus}
     */
    @GET("pool_retirements")
    Call<List<PoolStatus>> getPoolRetirements(@Query("_epoch_no") Integer epochNo, @QueryMap Map<String, String> paramsMap);

    /**
     * A list of registered relays for all currently registered/retiring (not retired) pools
     *
     * @param paramsMap Options and Filters Map
     * @return List of {@link PoolRelay}
     */
    @GET("pool_relays")
    Call<List<PoolRelay>> getPoolRelays(@QueryMap Map<String, String> paramsMap);

    /**
     * Metadata (on and off-chain) for all currently registered/retiring (not retired) pools
     *
     * @param requestBody Array of Cardano pool IDs (bech32 format)
     * @param paramsMap   Options and Filters Map
     * @return List of {@link PoolMetadata}
     */
    @POST("pool_metadata")
    Call<List<PoolMetadata>> getPoolMetadata(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);
}
