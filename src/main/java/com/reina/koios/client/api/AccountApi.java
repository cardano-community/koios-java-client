package com.reina.koios.client.api;

import com.reina.koios.client.model.AccountHistory;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AccountApi {

    /**
     * Account Addresses
     * Get all addresses associated with an account
     *
     * @param _address Cardano payment or staking address in bech32 format (required)
     * @return Call&lt;Void&gt;
     */
    @GET("account_addresses")
    Call<Void> accountAddressesGet(@Query("_address") String _address);

    /**
     * Account Assets
     * Get the native asset balance of an account
     *
     * @param _address Cardano payment or staking address in bech32 format (required)
     * @return Call&lt;Void&gt;
     */
    @GET("account_assets")
    Call<Void> accountAssetsGet(@Query("_address") String _address);

    /**
     * Account History
     * Get the staking history of an account
     *
     * @param _address Cardano payment or staking address in bech32 format (required)
     * @return Call&lt;AccountHistory&gt;
     */
    @GET("account_history")
    Call<AccountHistory> accountHistoryGet(@Query("_address") String _address);

    /**
     * Account Information
     * Get the account info of any (payment or staking) address
     *
     * @param _address Cardano payment or staking address in bech32 format (required)
     * @return Call&lt;Void&gt;
     */
    @GET("account_info")
    Call<Void> accountInfoGet(@Query("_address") String _address);

    /**
     * Get a list of all accounts
     *
     * @return Call&lt;Void&gt;
     */
    @GET("account_list")
    Call<Void> accountListGet();


    /**
     * Account Rewards
     * Get the full rewards history (including MIR) for a stake address, or certain epoch if specified
     *
     * @param _stakeAddress Cardano staking address (reward account) in bech32 format (required)
     * @param _epochNo      Filter for earned rewards Epoch Number (optional)
     * @return Call&lt;Void&gt;
     */
    @GET("account_rewards")
    Call<Void> accountRewardsGet(@Query("_stake_address") String _stakeAddress, @Query("_epoch_no") String _epochNo);

    /**
     * Account Updates (History)
     * Get the account updates (registration, deregistration, delegation and withdrawals)
     *
     * @param _stakeAddress Cardano staking address (reward account) in bech32 format (required)
     * @return Call&lt;Void&gt;
     */
    @GET("account_updates")
    Call<Void> accountUpdatesGet(@Query("_stake_address") String _stakeAddress);

}
