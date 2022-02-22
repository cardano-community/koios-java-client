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

    @GET("account_list")
    Call<List<StakeAddress>> getAccountList(@QueryMap Map<String, String> paramsMap);

    @GET("account_info")
    Call<List<AccountInfo>> getAccountInformation(@Query("_address") String address);

    @GET("account_rewards")
    Call<List<AccountRewards>> getAccountRewardsByEpoch(@Query("_stake_address") String stakeAddress, @Query("_epoch_no") Long epochNo);

    @GET("account_rewards")
    Call<List<AccountRewards>> getAccountRewards(@Query("_stake_address") String stakeAddress, @QueryMap Map<String, String> paramsMap);

    @GET("account_updates")
    Call<List<AccountUpdates>> getAccountUpdates(@Query("_stake_address") String stakeAddress, @QueryMap Map<String, String> paramsMap);

    @GET("account_addresses")
    Call<List<AccountAddress>> getAccountAddresses(@Query("_address") String address, @QueryMap Map<String, String> paramsMap);

    @GET("account_assets")
    Call<List<AccountAsset>> getAccountAssets(@Query("_address") String address, @QueryMap Map<String, String> paramsMap);

    @GET("account_history")
    Call<List<AccountHistory>> getAccountHistory(@Query("_address") String address, @QueryMap Map<String, String> paramsMap);
}
