package com.reina.koios.client.api;

import com.reina.koios.client.model.EpochInfo;
import com.reina.koios.client.model.EpochParams;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EpochApi {
  /**
   * Epoch Information
   * Get the epoch information, all epochs if no epoch specified
   * @param _epochNo Epoch Number to fetch details for (optional)
   * @return Call&lt;EpochInfo&gt;
   */
  @GET("epoch_info")
  Call<EpochInfo> epochInfoGet(
        @Query("_epoch_no") String _epochNo
  );

  /**
   * Epoch&#x27;s Protocol Parameters
   * Get the protocol parameters for specific epoch, returns information about all epochs if no epoch specified
   * @param _epochNo Epoch Number to fetch details for (optional)
   * @return Call&lt;EpochParams&gt;
   */
  @GET("epoch_params")
  Call<EpochParams> epochParamsGet(
        @Query("_epoch_no") String _epochNo
  );

}
