package rest.koios.client.backend.api.account.api;

import rest.koios.client.backend.api.account.model.*;
import retrofit2.Call;
import retrofit2.http.*;

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
     * @param requestBody Array of Cardano stake address(es) in bech32 format
     * @return Account info of any (payment or staking) address
     */
    @POST("account_info")
    Call<List<AccountInfo>> getAccountInformation(@Body Map<String, Object> requestBody);

    /**
     * Get Account Rewards
     *
     * @param requestBody Array of Cardano stake address(es) in bech32 format
     * @return Full rewards history (including MIR) for a stake address, or certain epoch if specified
     */
    @POST("account_rewards")
    Call<List<AccountRewards>> getAccountRewards(@Body Map<String, Object> requestBody);

    /**
     * Get Account Updates
     *
     * @param requestBody Array of Cardano stake address(es) in bech32 format
     * @return Account updates (registration, deregistration, delegation and withdrawals)
     */
    @POST("account_updates")
    Call<List<AccountUpdates>> getAccountUpdates(@Body Map<String, Object> requestBody);

    /**
     * Get Account Addresses
     *
     * @param requestBody Array of Cardano stake address(es) in bech32 format
     * @return All addresses associated with an account
     */
    @POST("account_addresses")
    Call<List<AccountAddress>> getAccountAddresses(@Body Map<String, Object> requestBody);

    /**
     * Get Account Assets
     *
     * @param requestBody Array of Cardano stake address(es) in bech32 format
     * @return Native asset balance of an account
     */
    @POST("account_assets")
    Call<List<AccountAssets>> getAccountAssets(@Body Map<String, Object> requestBody);

    /**
     * Get Account History
     *
     * @param requestBody Array of Cardano stake address(es) in bech32 format
     * @return Staking history of an account
     */
    @POST("account_history")
    Call<List<AccountHistory>> getAccountHistory(@Body Map<String, Object> requestBody);
}
