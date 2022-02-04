package com.reina.koios.client.backend.api.pool.impl;

import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.pool.PoolService;
import com.reina.koios.client.backend.api.pool.model.*;
import com.reina.koios.client.backend.factory.OperationType;
import com.reina.koios.client.backend.factory.options.Options;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

public class PoolServiceImpl extends BaseService implements PoolService {

    public PoolServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public Pool[] getPoolList(Options options) throws ApiException {
        try {
            return (Pool[]) sendGetRequest("/pool_list", options, Pool[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public PoolInfo[] getPoolInformation(List<String> poolIds) throws ApiException {
        for (String poolId : poolIds) {
            validateBech32(poolId);
        }
        try {
            return getWebClient().post()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/pool_info").build())
                    .bodyValue(buildPoolInfoBody(poolIds))
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(PoolInfo[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public PoolDelegator[] getPoolDelegatorsList(String poolBech32, Long epochNo) throws ApiException {
        validateEpoch(epochNo);
        validateBech32(poolBech32);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/pool_delegators")
                            .queryParam("_pool_bech32", poolBech32)
                            .queryParam("_epoch_no", epochNo)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(PoolDelegator[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public PoolDelegator[] getPoolDelegatorsList(String poolBech32, Options options) throws ApiException {
        validateBech32(poolBech32);
        try {
            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add("_pool_bech32", poolBech32);
            return (PoolDelegator[]) sendGetRequest("/pool_delegators", multiValueMap, options, PoolDelegator[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public PoolBlock[] getPoolBlocks(String poolBech32, Long epochNo) throws ApiException {
        validateEpoch(epochNo);
        validateBech32(poolBech32);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/pool_blocks")
                            .queryParam("_pool_bech32", poolBech32)
                            .queryParam("_epoch_no", epochNo)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(PoolBlock[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public PoolBlock[] getPoolBlocks(String poolBech32, Options options) throws ApiException {
        validateBech32(poolBech32);
        try {
            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add("_pool_bech32", poolBech32);
            return (PoolBlock[]) sendGetRequest("/pool_blocks", multiValueMap, options, PoolBlock[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public PoolUpdate[] getPoolUpdates(String poolBech32) throws ApiException {
        validateBech32(poolBech32);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/pool_updates")
                            .queryParam("_pool_bech32", poolBech32)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(PoolUpdate[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public PoolUpdate[] getPoolUpdates(Options options) throws ApiException {
        try {
            return (PoolUpdate[]) sendGetRequest("/pool_updates", options, PoolUpdate[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public PoolRelay[] getPoolRelays(Options options) throws ApiException {
        try {
            return (PoolRelay[]) sendGetRequest("/pool_relays", options, PoolRelay[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public PoolMetadata[] getPoolMetadata(Options options) throws ApiException {
        try {
            return (PoolMetadata[]) sendGetRequest("/pool_metadata", options, PoolMetadata[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    private String buildPoolInfoBody(List<String> poolIds) {
        if (poolIds == null || poolIds.isEmpty()) {
            return null;
        }
        StringBuilder jsonBodyValue = new StringBuilder("{\"_pool_bech32_ids\":[");
        for (int i = 0; i < poolIds.size(); i++) {
            jsonBodyValue.append("\"").append(poolIds.get(i)).append("\"");
            if (i < poolIds.size() - 1) {
                jsonBodyValue.append(",");
            }
        }
        jsonBodyValue.append("]}");
        return jsonBodyValue.toString();
    }
}
