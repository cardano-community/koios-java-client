package com.reina.koios.client.backend.api.pool.impl;

import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.pool.PoolService;
import com.reina.koios.client.backend.api.pool.model.*;
import com.reina.koios.client.backend.factory.OperationType;
import com.reina.koios.client.utils.Bech32Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class PoolServiceImpl extends BaseService implements PoolService {

    public PoolServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public Pool[] getPoolList() throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/pool_list").build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Pool[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public PoolInfo[] getPoolInformation(String poolId) throws ApiException {
        if (!Bech32Util.isValid(poolId)) {
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
        }
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/pool_info")
                            .queryParam("_pool_bech32", poolId).build())
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
        if (!Bech32Util.isValid(poolBech32)) {
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
        }
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
    public PoolBlock[] getPoolBlocks(String poolBech32, Long epochNo) throws ApiException {
        if (!Bech32Util.isValid(poolBech32)) {
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
        }
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
    public PoolUpdate[] getPoolUpdates(String poolBech32) throws ApiException {
        if (!Bech32Util.isValid(poolBech32)) {
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
        }
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
    public PoolRelay[] getPoolRelays() throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/pool_relays")
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(PoolRelay[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public PoolMetadata[] getPoolMetadata() throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/pool_metadata")
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(PoolMetadata[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
