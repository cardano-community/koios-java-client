package com.reina.koios.client.backend.api.asset.impl;

import com.reina.koios.client.backend.api.asset.AssetService;
import com.reina.koios.client.backend.api.asset.model.Asset;
import com.reina.koios.client.backend.api.asset.model.AssetAddress;
import com.reina.koios.client.backend.api.asset.model.AssetInformation;
import com.reina.koios.client.backend.api.asset.model.AssetTx;
import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.factory.OperationType;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class AssetServiceImpl extends BaseService implements AssetService {

    public AssetServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
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
    public AssetTx[] getAssetTxs(String assetPolicy, String assetName) throws ApiException {
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

    @Override
    public Asset[] getAssetList() throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/asset_list").build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Asset[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
