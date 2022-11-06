package rest.koios.client.backend.api.asset.api;

import rest.koios.client.backend.api.common.TxHash;
import rest.koios.client.backend.api.asset.model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * Asset API
 */
public interface AssetApi {

    @GET("asset_list")
    Call<List<Asset>> getAssetList(@QueryMap Map<String, String> paramsMap);

    @GET("asset_address_list")
    Call<List<AssetAddress>> getAssetsAddressList(@Query("_asset_policy") String assetPolicy, @Query("_asset_name") String assetName, @QueryMap Map<String, String> paramsMap);

    @GET("asset_info")
    Call<List<AssetInformation>> getAssetInformation(@Query("_asset_policy") String assetPolicy, @Query("_asset_name") String assetName);

    @GET("asset_history")
    Call<List<AssetHistory>> getAssetHistory(@Query("_asset_policy") String assetPolicy, @Query("_asset_name") String assetName, @QueryMap Map<String, String> paramsMap);

    @GET("asset_policy_info")
    Call<List<PolicyAsset>> getAssetPolicyInformation(@Query("_asset_policy") String assetPolicy);

    @GET("asset_summary")
    Call<List<AssetSummary>> getAssetSummary(@Query("_asset_policy") String assetPolicy, @Query("_asset_name") String assetName);

    @GET("asset_txs")
    Call<List<TxHash>> getAssetTransactionHistory(@Query("_asset_policy") String assetPolicy, @Query("_asset_name") String assetName, @QueryMap Map<String, String> paramsMap);
}
