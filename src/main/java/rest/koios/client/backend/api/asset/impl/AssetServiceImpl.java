package rest.koios.client.backend.api.asset.impl;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import rest.koios.client.backend.api.asset.AssetService;
import rest.koios.client.backend.api.asset.model.*;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.OperationType;
import rest.koios.client.backend.factory.options.Options;

/**
 * Asset Service Implementation
 */
public class AssetServiceImpl extends BaseService implements AssetService {

    /**
     * Asset Service Implementation Constructor
     *
     * @param operationType Operation Type
     * @param webClient     webClient
     */
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
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        try {
            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add("_asset_policy", assetPolicy);
            multiValueMap.add("_asset_name", assetName);
            return (AssetAddress[]) sendGetRequest("/asset_address_list", multiValueMap, getEmptyOptions(), AssetAddress[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AssetHistory[] getAssetHistory(String assetPolicy, String assetName) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        try {
            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add("_asset_policy", assetPolicy);
            multiValueMap.add("_asset_name", assetName);
            return (AssetHistory[]) sendGetRequest("/asset_history", multiValueMap, getEmptyOptions(), AssetHistory[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AssetPolicyInfo[] getAssetPolicyInformation(String assetPolicy) throws ApiException {
        validateHexFormat(assetPolicy);
        try {
            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add("_asset_policy", assetPolicy);
            return (AssetPolicyInfo[]) sendGetRequest("/asset_policy_info", multiValueMap, getEmptyOptions(), AssetPolicyInfo[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AssetInformation[] getAssetInformation(String assetPolicy, String assetName) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        try {
            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add("_asset_policy", assetPolicy);
            multiValueMap.add("_asset_name", assetName);
            return (AssetInformation[]) sendGetRequest("/asset_info", multiValueMap, getEmptyOptions(), AssetInformation[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AssetSummary[] getAssetSummary(String assetPolicy, String assetName) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
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
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        try {
            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add("_asset_policy", assetPolicy);
            multiValueMap.add("_asset_name", assetName);
            return (AssetTx[]) sendGetRequest("/asset_txs", multiValueMap, getEmptyOptions(), AssetTx[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
