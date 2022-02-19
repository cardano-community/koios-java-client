package rest.koios.client.backend.api.pool.impl;

import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.pool.PoolService;
import rest.koios.client.backend.api.pool.api.PoolApi;
import rest.koios.client.backend.api.pool.model.*;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Pool Service Implementation
 */
public class PoolServiceImpl extends BaseService implements PoolService {

    private final PoolApi poolApi;

    /**
     * Pool Service Implementation Constructor
     *
     * @param baseUrl Base URL
     */
    public PoolServiceImpl(String baseUrl) {
        super(baseUrl);
        poolApi = getRetrofit().create(PoolApi.class);
    }

    @Override
    public Result<List<Pool>> getPoolList(Options options) throws ApiException {
        Call<List<Pool>> call = poolApi.getPoolList(options.toMap());
        try {
            Response<List<Pool>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<PoolInfo>> getPoolInformation(List<String> poolIds) throws ApiException {
        for (String poolId : poolIds) {
            validateBech32(poolId);
        }
        Call<List<PoolInfo>> call = poolApi.getPoolInformation(buildBody(poolIds));
        try {
            Response<List<PoolInfo>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<PoolDelegator>> getPoolDelegatorsList(String poolBech32, Long epochNo) throws ApiException {
        validateEpoch(epochNo);
        validateBech32(poolBech32);
        Call<List<PoolDelegator>> call = poolApi.getPoolDelegatorsList(poolBech32, epochNo);
        try {
            Response<List<PoolDelegator>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<PoolDelegator>> getPoolDelegatorsList(String poolBech32, Options options) throws ApiException {
        validateBech32(poolBech32);
        Call<List<PoolDelegator>> call = poolApi.getPoolDelegatorsList(poolBech32, options.toMap());
        try {
            Response<List<PoolDelegator>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<PoolBlock>> getPoolBlocks(String poolBech32, Long epochNo) throws ApiException {
        validateEpoch(epochNo);
        validateBech32(poolBech32);
        Call<List<PoolBlock>> call = poolApi.getPoolBlocks(poolBech32, epochNo);
        try {
            Response<List<PoolBlock>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<PoolBlock>> getPoolBlocks(String poolBech32, Options options) throws ApiException {
        validateBech32(poolBech32);
        Call<List<PoolBlock>> call = poolApi.getPoolBlocks(poolBech32, options.toMap());
        try {
            Response<List<PoolBlock>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<PoolUpdate>> getPoolUpdates(String poolBech32) throws ApiException {
        validateBech32(poolBech32);
        Call<List<PoolUpdate>> call = poolApi.getPoolUpdates(poolBech32);
        try {
            Response<List<PoolUpdate>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<PoolUpdate>> getPoolUpdates(Options options) throws ApiException {
        Call<List<PoolUpdate>> call = poolApi.getPoolUpdates(options.toMap());
        try {
            Response<List<PoolUpdate>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<PoolRelay>> getPoolRelays(Options options) throws ApiException {
        Call<List<PoolRelay>> call = poolApi.getPoolRelays(options.toMap());
        try {
            Response<List<PoolRelay>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<PoolMetadata>> getPoolMetadata(Options options) throws ApiException {
        Call<List<PoolMetadata>> call = poolApi.getPoolMetadata(options.toMap());
        try {
            Response<List<PoolMetadata>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    private Map<String, Object> buildBody(List<String> poolIds) {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("_pool_bech32_ids", poolIds);
        return bodyMap;
    }
}
