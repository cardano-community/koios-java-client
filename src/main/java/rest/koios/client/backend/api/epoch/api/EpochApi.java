package rest.koios.client.backend.api.epoch.api;

import rest.koios.client.backend.api.epoch.model.EpochBlockProtocols;
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

    /**
     * Epoch's Block Protocols
     * Get the information about block protocol distribution in epoch
     *
     * @param paramsMap Options and Filters Map
     * @return List of {@link EpochParams}
     */
    @GET("epoch_block_protocols")
    Call<List<EpochBlockProtocols>> getEpochBlockProtocols(@QueryMap Map<String, String> paramsMap);

    /**
     * Epoch's Block Protocols By Epoch
     * Get the information about block protocol distribution in epoch
     *
     * @param epochNo Epoch Number to fetch details for
     * @return List of {@link EpochParams}
     */
    @GET("epoch_block_protocols")
    Call<List<EpochBlockProtocols>> getEpochBlockProtocolsByEpoch(@Query("_epoch_no") Integer epochNo);
}
