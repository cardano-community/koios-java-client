package com.reina.koios.client.backend.api.asset.impl;

import com.reina.koios.client.backend.api.asset.AssetService;
import com.reina.koios.client.backend.api.asset.model.*;
import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.factory.OperationType;
import com.reina.koios.client.backend.factory.options.Options;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class AssetServiceImpl extends BaseService implements AssetService {

    public AssetServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public Asset[] getAssetList(Options options) throws ApiException {
        try {
            return (Asset[]) sendGetRequest("/asset_list", options, Asset[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AssetAddress[] getAssetsAddressList(String assetPolicy, String assetName) throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/asset_address_list")
                            .queryParam("_asset_policy", assetPolicy)
                            .queryParam("_asset_name", assetName).build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(AssetAddress[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AssetInformation[] getAssetInformation(String assetPolicy, String assetName) throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/asset_info")
                            .queryParam("_asset_policy", assetPolicy)
                            .queryParam("_asset_name", assetName).build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(AssetInformation[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AssetSummary[] getAssetSummary(String assetPolicy, String assetName) throws ApiException {
        try {
            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add("_asset_policy", assetPolicy);
            multiValueMap.add("_asset_name", assetName);
            return (AssetSummary[]) sendGetRequest("/asset_summary", multiValueMap, getEmptyOptions(), AssetSummary[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AssetTx[] getAssetTransactionHistory(String assetPolicy, String assetName) throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/asset_txs")
                            .queryParam("_asset_policy", assetPolicy)
                            .queryParam("_asset_name", assetName).build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(AssetTx[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
