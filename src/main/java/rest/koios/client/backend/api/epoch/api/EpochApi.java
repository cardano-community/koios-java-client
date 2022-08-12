package rest.koios.client.backend.api.epoch.api;

import rest.koios.client.backend.api.epoch.model.EpochInfo;
import rest.koios.client.backend.api.epoch.model.EpochParams;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * Epoch API
 */
public interface EpochApi {

    @GET("epoch_info")
    Call<List<EpochInfo>> getEpochInformationByEpoch(@Query("_epoch_no") Integer epochNo);

    @GET("epoch_info")
    Call<List<EpochInfo>> getEpochInformation(@QueryMap Map<String, String> paramsMap);

    @GET("epoch_params")
    Call<List<EpochParams>> getEpochParametersByEpoch(@Query("_epoch_no") Integer epochNo);

    @GET("epoch_params")
    Call<List<EpochParams>> getEpochParameters(@QueryMap Map<String, String> paramsMap);
}
