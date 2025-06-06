package rest.koios.client.backend.api.pool.impl;

import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.pool.PoolService;
import rest.koios.client.backend.api.pool.api.PoolApi;
import rest.koios.client.backend.api.pool.model.*;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;

import java.util.Collections;
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
     * @param baseUrl  Base Url
     * @param apiToken Authorization Bearer JWT Token
     */
    public PoolServiceImpl(String baseUrl, String apiToken) {
        super(baseUrl, apiToken);
        poolApi = getRetrofit().create(PoolApi.class);
    }

    @Override
    public Result<List<Pool>> getPoolList(Options options) throws ApiException {
        Call<List<Pool>> call = poolApi.getPoolList(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolInfo>> getPoolInformation(List<String> poolIds, Options options) throws ApiException {
        for (String poolId : poolIds) {
            validateBech32(poolId);
        }
        Call<List<PoolInfo>> call = poolApi.getPoolInformation(buildBody(poolIds), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolStakeSnapshot>> getPoolStakeSnapshot(String poolBech32, Options options) throws ApiException {
        validateBech32(poolBech32);
        Call<List<PoolStakeSnapshot>> call = poolApi.getPoolStakeSnapshot(poolBech32, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolDelegator>> getPoolDelegatorsList(String poolBech32, Options options) throws ApiException {
        validateBech32(poolBech32);
        Call<List<PoolDelegator>> call = poolApi.getPoolDelegatorsList(poolBech32, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolDelegatorHistory>> getPoolDelegatorsHistory(String poolBech32, Integer epochNo, Options options) throws ApiException {
        if (epochNo != null) {
            validateEpoch(epochNo);
        }
        validateBech32(poolBech32);
        Call<List<PoolDelegatorHistory>> call = poolApi.getPoolDelegatorsHistory(poolBech32, epochNo, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolBlock>> getPoolBlocksByEpoch(String poolBech32, Integer epochNo, Options options) throws ApiException {
        validateEpoch(epochNo);
        validateBech32(poolBech32);
        Call<List<PoolBlock>> call = poolApi.getPoolBlocksByEpoch(poolBech32, epochNo, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolBlock>> getPoolBlocks(String poolBech32, Options options) throws ApiException {
        validateBech32(poolBech32);
        Call<List<PoolBlock>> call = poolApi.getPoolBlocks(poolBech32, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolOwnerHistory>> getPoolOwnerHistory(List<String> poolIds, Options options) throws ApiException {
        for (String poolId : poolIds) {
            validateBech32(poolId);
        }
        Call<List<PoolOwnerHistory>> call = poolApi.getPoolOwnerHistory(buildBody(poolIds), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<PoolHistory> getPoolHistoryByEpoch(String poolBech32, Integer epochNo, Options options) throws ApiException {
        validateBech32(poolBech32);
        validateEpoch(epochNo);
        Call<List<PoolHistory>> call = poolApi.getPoolHistoryByEpoch(poolBech32, epochNo, optionsToParamMap(options));
        return processResponseGetOne(call);
    }

    @Override
    public Result<List<PoolHistory>> getPoolHistory(String poolBech32, Options options) throws ApiException {
        validateBech32(poolBech32);
        Call<List<PoolHistory>> call = poolApi.getPoolHistory(poolBech32, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolUpdate>> getPoolUpdatesByPoolBech32(String poolBech32, Options options) throws ApiException {
        validateBech32(poolBech32);
        Call<List<PoolUpdate>> call = poolApi.getPoolUpdatesByPoolBech32(poolBech32, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolUpdate>> getPoolUpdates(Options options) throws ApiException {
        Call<List<PoolUpdate>> call = poolApi.getPoolUpdates(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolStatus>> getPoolRegistrations(Integer epochNo, Options options) throws ApiException {
        Call<List<PoolStatus>> call = poolApi.getPoolRegistrations(epochNo, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolStatus>> getPoolRetirements(Integer epochNo, Options options) throws ApiException {
        Call<List<PoolStatus>> call = poolApi.getPoolRetirements(epochNo, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolRelay>> getPoolRelays(Options options) throws ApiException {
        Call<List<PoolRelay>> call = poolApi.getPoolRelays(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolGroup>> getPoolGroups(Options options) throws ApiException {
        Call<List<PoolGroup>> call = poolApi.getPoolGroups(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolMetadata>> getPoolMetadata(Options options) throws ApiException {
        return getPoolMetadata(Collections.emptyList(), options);
    }

    @Override
    public Result<List<PoolMetadata>> getPoolMetadata(List<String> poolIds, Options options) throws ApiException {
        for (String poolId : poolIds) {
            validateBech32(poolId);
        }
        Call<List<PoolMetadata>> call = poolApi.getPoolMetadata(buildBody(poolIds), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolCalidusKey>> getPoolCalidusKeys(Options options) throws ApiException {
        Call<List<PoolCalidusKey>> call = poolApi.getPoolCalidusKeys(optionsToParamMap(options));
        return processResponse(call);
    }

    private Map<String, Object> buildBody(List<String> poolIds) {
        Map<String, Object> bodyMap = new HashMap<>();
        if (!poolIds.isEmpty()) {
            bodyMap.put("_pool_bech32_ids", poolIds);
        }
        return bodyMap;
    }
}
