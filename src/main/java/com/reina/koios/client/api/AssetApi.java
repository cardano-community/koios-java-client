package com.reina.koios.client.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AssetApi {
    /**
     * Assets Address List
     * Get a list of all addresses for a given asset
     *
     * @param _assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param _assetName   Asset Name in hexadecimal format (hex) (required)
     * @return Call&lt;Void&gt;
     */
    @GET("asset_address_list")
    Call<Void> assetAddressListGet(
            @Query("_asset_policy") String _assetPolicy, @Query("_asset_name") String _assetName
    );

    /**
     * Asset Information
     * Get the information of an asset incl first minting &amp; token registry metadata
     *
     * @param _assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param _assetName   Asset Name in hexadecimal format (hex) (required)
     * @return Call&lt;Void&gt;
     */
    @GET("asset_info")
    Call<Void> assetInfoGet(
            @Query("_asset_policy") String _assetPolicy, @Query("_asset_name") String _assetName
    );

    /**
     * Asset Summary
     * Get the summary of an asset (total transactions exclude minting/total wallets include only wallets with asset balance)
     *
     * @param _assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param _assetName   Asset Name in hexadecimal format (hex) (required)
     * @return Call&lt;Void&gt;
     */
    @GET("asset_txs")
    Call<Void> assetTxsGet(
            @Query("_asset_policy") String _assetPolicy, @Query("_asset_name") String _assetName
    );

}
