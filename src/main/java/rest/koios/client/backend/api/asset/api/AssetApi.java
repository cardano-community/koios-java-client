package rest.koios.client.backend.api.asset.api;

import rest.koios.client.backend.api.common.TxHash;
import rest.koios.client.backend.api.asset.model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Asset API
 */
public interface AssetApi {

    @GET("asset_list")
    Call<List<Asset>> getAssetList(@QueryMap Map<String, String> paramsMap);

    /**
     * Get Asset Addresses
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex)
     * @param assetName   Asset Name in hexadecimal format (hex), empty asset name returns royalties
     * @param paramsMap   Query Params
     * @return List of payment addresses holding the given token (including balances)
     */
    @GET("asset_addresses")
    Call<List<AssetAddress>> getAssetsAddresses(@Query("_asset_policy") String assetPolicy, @Query("_asset_name") String assetName, @QueryMap Map<String, String> paramsMap);

    /**
     * Get NFT Address
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex)
     * @param assetName   Asset Name in hexadecimal format (hex)
     * @param paramsMap   Query Params
     * @return List of payment addresses holding the given token
     */
    @GET("asset_nft_address")
    Call<List<AssetAddress>> getNFTAddress(String assetPolicy, String assetName, @QueryMap Map<String, String> paramsMap);

    @GET("asset_info")
    Call<List<AssetInformation>> getAssetInformation(@Query("_asset_policy") String assetPolicy, @Query("_asset_name") String assetName);

    /**
     * Get Asset Information (Bulk)
     *
     * @param assetList List of List of policy ID and asset names (hex)
     * @param paramsMap Query Params
     * @return List of detailed asset information
     */
    @POST("asset_info")
    Call<List<AssetInformation>> getAssetInformationBulk(@Body Map<String, Object> assetList, @QueryMap Map<String, String> paramsMap);

    @GET("asset_history")
    Call<List<AssetHistory>> getAssetHistory(@Query("_asset_policy") String assetPolicy, @Query("_asset_name") String assetName, @QueryMap Map<String, String> paramsMap);

    @GET("policy_asset_info")
    Call<List<PolicyAssetInfo>> getPolicyAssetInformation(@Query("_asset_policy") String assetPolicy, @QueryMap Map<String, String> paramsMap);

    /**
     * Get Policy Asset List
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex)
     * @param paramsMap   Query Params
     * @return List of detailed information of assets under the same policy
     */
    @GET("policy_asset_list")
    Call<List<PolicyAsset>> getPolicyAssetList(@Query("_asset_policy") String assetPolicy, @QueryMap Map<String, String> paramsMap);

    @GET("asset_summary")
    Call<List<AssetSummary>> getAssetSummary(@Query("_asset_policy") String assetPolicy, @Query("_asset_name") String assetName);

    @GET("asset_txs")
    Call<List<TxHash>> getAssetTransactionHistory(@Query("_asset_policy") String assetPolicy, @Query("_asset_name") String assetName, @Query("_after_block_height") Integer afterBlockHeight, @Query("_history") Boolean history, @QueryMap Map<String, String> paramsMap);
}
