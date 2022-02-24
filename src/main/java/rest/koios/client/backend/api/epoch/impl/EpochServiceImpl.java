package rest.koios.client.backend.api.epoch.impl;

import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.epoch.EpochService;
import rest.koios.client.backend.api.epoch.api.EpochApi;
import rest.koios.client.backend.api.epoch.model.EpochInfo;
import rest.koios.client.backend.api.epoch.model.EpochParams;
import rest.koios.client.backend.factory.options.Limit;
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
    public Result<EpochInfo> getLatestEpochInfo() throws ApiException {
        Options options = Options.builder().option(Limit.of(1)).build();
        Call<List<EpochInfo>> call = epochApi.getEpochInformation(optionsToParamMap(options));
        try {
            Response<List<EpochInfo>> response = (Response) execute(call);
            return processResponseGetOne(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<EpochInfo> getEpochInformationByEpoch(Long epochNo) throws ApiException {
        validateEpoch(epochNo);
        Call<List<EpochInfo>> call = epochApi.getEpochInformationByEpoch(epochNo);
        try {
            Response<List<EpochInfo>> response = (Response) execute(call);
            return processResponseGetOne(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<EpochInfo>> getEpochInformation(Options options) throws ApiException {
        Call<List<EpochInfo>> call = epochApi.getEpochInformation(optionsToParamMap(options));
        try {
            Response<List<EpochInfo>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<EpochParams> getLatestEpochParameters() throws ApiException {
        Options options = Options.builder().option(Limit.of(1)).build();
        Call<List<EpochParams>> call = epochApi.getEpochParameters(optionsToParamMap(options));
        try {
            Response<List<EpochParams>> response = (Response) execute(call);
            return processResponseGetOne(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<EpochParams> getEpochParametersByEpoch(Long epochNo) throws ApiException {
        validateEpoch(epochNo);
        Call<List<EpochParams>> call = epochApi.getEpochParametersByEpoch(epochNo);
        try {
            Response<List<EpochParams>> response = (Response) execute(call);
            return processResponseGetOne(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<EpochParams>> getEpochParameters(Options options) throws ApiException {
        Call<List<EpochParams>> call = epochApi.getEpochParameters(optionsToParamMap(options));
        try {
            Response<List<EpochParams>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }
}
