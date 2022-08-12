package rest.koios.client.backend.api.account.api;

import rest.koios.client.backend.api.account.model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * Account API
 */
public interface AccountApi {

    /**
     * Get Account List
     *
     * @param paramsMap Query Params
     * @return List of Stake Addresses
     */
    @GET("account_list")
    Call<List<StakeAddress>> getAccountList(@QueryMap Map<String, String> paramsMap);

    /**
     * Get Account Information
     *
     * @param address Cardano payment or staking address in bech32 format
     * @return Account info of any (payment or staking) address
     */
    @GET("account_info")
    Call<List<AccountInfo>> getAccountInformation(@Query("_address") String address);

    /**
     * Get Account Rewards by Epoch
     *
     * @param stakeAddress Cardano staking address (reward account) in bech32 format
     * @param epochNo      Filter for earned rewards Epoch Number (optional)
     * @return Full rewards history (including MIR) for a stake address, or certain epoch if specified
     */
    @GET("account_rewards")
    Call<List<AccountRewards>> getAccountRewardsByEpoch(@Query("_stake_address") String stakeAddress, @Query("_epoch_no") Long epochNo);

    /**
     * Get Account Rewards
     *
     * @param stakeAddress Cardano staking address (reward account) in bech32 format
     * @param paramsMap    Filtering Options Query Parameters
     * @return Full rewards history (including MIR) for a stake address, or certain epoch if specified
     */
    @GET("account_rewards")
    Call<List<AccountRewards>> getAccountRewards(@Query("_stake_address") String stakeAddress, @QueryMap Map<String, String> paramsMap);

    /**
     * Get Account Updates
     *
     * @param stakeAddress Cardano staking address (reward account) in bech32 format
     * @param paramsMap    Filtering Options Query Parameters
     * @return Account updates (registration, deregistration, delegation and withdrawals)
     */
    @GET("account_updates")
    Call<List<AccountUpdates>> getAccountUpdates(@Query("_stake_address") String stakeAddress, @QueryMap Map<String, String> paramsMap);

    /**
     * Get Account Addresses
     *
     * @param address   Cardano payment or staking address in bech32 format
     * @param paramsMap Filtering Options Query Parameters
     * @return All addresses associated with an account
     */
    @GET("account_addresses")
    Call<List<AccountAddress>> getAccountAddresses(@Query("_address") String address, @QueryMap Map<String, String> paramsMap);

    /**
     * Get Account Assets
     *
     * @param address   Cardano payment or staking address in bech32 format
     * @param paramsMap Filtering Options Query Parameters
     * @return Native asset balance of an account
     */
    @GET("account_assets")
    Call<List<AccountAsset>> getAccountAssets(@Query("_address") String address, @QueryMap Map<String, String> paramsMap);

    /**
     * Get Account History
     *
     * @param address   Cardano payment or staking address in bech32 format
     * @param paramsMap Filtering Options Query Parameters
     * @return Staking history of an account
     */
    @GET("account_history")
    Call<List<AccountHistory>> getAccountHistory(@Query("_address") String address, @QueryMap Map<String, String> paramsMap);
}
