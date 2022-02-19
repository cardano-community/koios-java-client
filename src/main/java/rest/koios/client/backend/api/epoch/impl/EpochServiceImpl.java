package rest.koios.client.backend.api.epoch.impl;

import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.epoch.EpochService;
import rest.koios.client.backend.api.epoch.api.EpochApi;
import rest.koios.client.backend.api.epoch.model.EpochInfo;
import rest.koios.client.backend.api.epoch.model.EpochParams;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Epoch Service Implementation
 */
public class EpochServiceImpl extends BaseService implements EpochService {

    private final EpochApi epochApi;

    /**
     * Epoch Service Implementation Constructor
     *
     * @param baseUrl Base URL
     */
    public EpochServiceImpl(String baseUrl) {
        super(baseUrl);
        epochApi = getRetrofit().create(EpochApi.class);
    }

    @Override
    public Result<List<EpochInfo>> getEpochInformation(Long epochNo) throws ApiException {
        validateEpoch(epochNo);
        Call<List<EpochInfo>> call = epochApi.getEpochInformation(epochNo);
        try {
            Response<List<EpochInfo>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<EpochInfo>> getEpochInformation(Options options) throws ApiException {
        Call<List<EpochInfo>> call = epochApi.getEpochInformation(options.toMap());
        try {
            Response<List<EpochInfo>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<EpochParams>> getEpochParameters(Long epochNo) throws ApiException {
        validateEpoch(epochNo);
        Call<List<EpochParams>> call = epochApi.getEpochParameters(epochNo);
        try {
            Response<List<EpochParams>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<EpochParams>> getEpochParameters(Options options) throws ApiException {
        Call<List<EpochParams>> call = epochApi.getEpochParameters(options.toMap());
        try {
            Response<List<EpochParams>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }
}
