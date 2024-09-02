package rest.koios.client.backend.api.asset.impl;

import rest.koios.client.backend.api.asset.AssetService;
import rest.koios.client.backend.api.asset.api.AssetApi;
import rest.koios.client.backend.api.asset.model.*;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.TxHash;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.utils.Tuple;
import retrofit2.Call;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Asset Service Implementation
 */
public class AssetServiceImpl extends BaseService implements AssetService {

    private final AssetApi assetApi;

    /**
     * Asset Service Implementation Constructor
     *
     * @param baseUrl  Base Url
     * @param apiToken Authorization Bearer JWT Token
     */
    public AssetServiceImpl(String baseUrl, String apiToken) {
        super(baseUrl, apiToken);
        assetApi = getRetrofit().create(AssetApi.class);
    }

    @Override
    public Result<List<Asset>> getAssetList(Options options) throws ApiException {
        Call<List<Asset>> call = assetApi.getAssetList(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<AssetTokenRegistry>> getAssetTokenRegistry(Options options) throws ApiException {
        Call<List<AssetTokenRegistry>> call = assetApi.getAssetTokenRegistry(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<AssetAddress>> getAssetsAddresses(String assetPolicy, String assetName, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        Call<List<AssetAddress>> call = assetApi.getAssetsAddresses(assetPolicy, assetName, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PaymentAddress>> getNFTAddress(String assetPolicy, String assetName, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        Call<List<PaymentAddress>> call = assetApi.getNFTAddress(assetPolicy, assetName, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<AssetAddress>> getPolicyAssetAddressList(String assetPolicy, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        Call<List<AssetAddress>> call = assetApi.getPolicyAssetAddressList(assetPolicy, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<AssetInformation> getAssetInformation(String assetPolicy, String assetName) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        Call<List<AssetInformation>> call = assetApi.getAssetInformation(assetPolicy, assetName);
        return processResponseGetOne(call);
    }

    @Override
    public Result<List<AssetInformation>> getAssetInformationBulk(List<Tuple<String, String>> assetList, Options options) throws ApiException {
        if (assetList == null) {
            return badRequestResult("The server cannot process the request due to invalid input");
        }
        for (Tuple<String, String> tuple : assetList) {
            validateHexFormat(tuple._1);
            validateHexFormat(tuple._2);
        }
        Call<List<AssetInformation>> call = assetApi.getAssetInformationBulk(buildBody("_asset_list", assetList), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<UTxO>> getAssetUTxOs(List<Tuple<String, String>> assetList, Boolean extended, Options options) throws ApiException {
        if (assetList == null) {
            return badRequestResult("The server cannot process the request due to invalid input");
        }
        for (Tuple<String, String> tuple : assetList) {
            validateHexFormat(tuple._1);
            validateHexFormat(tuple._2);
        }
        Call<List<UTxO>> call = assetApi.getAssetUTxOs(buildBodyUTxOs(assetList, extended), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<AssetHistory>> getAssetHistory(String assetPolicy, String assetName, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        Call<List<AssetHistory>> call = assetApi.getAssetHistory(assetPolicy, assetName, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PolicyAssetInfo>> getPolicyAssetInformation(String assetPolicy, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        Call<List<PolicyAssetInfo>> call = assetApi.getPolicyAssetInformation(assetPolicy, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PolicyAssetMint>> getPolicyAssetMints(String assetPolicy, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        Call<List<PolicyAssetMint>> call = assetApi.getPolicyAssetMints(assetPolicy, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PolicyAsset>> getPolicyAssetList(String assetPolicy, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        Call<List<PolicyAsset>> call = assetApi.getPolicyAssetList(assetPolicy, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<AssetSummary> getAssetSummary(String assetPolicy, String assetName) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        Call<List<AssetSummary>> call = assetApi.getAssetSummary(assetPolicy, assetName);
        return processResponseGetOne(call);
    }

    @Override
    public Result<List<TxHash>> getAssetTransactions(String assetPolicy, String assetName, Options options) throws ApiException {
        return getAssetTransactions(assetPolicy, assetName, 0, false, options);
    }

    @Override
    public Result<List<TxHash>> getAssetTransactions(String assetPolicy, String assetName, Integer afterBlockHeight, boolean history, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        Call<List<TxHash>> call = assetApi.getAssetTransactionHistory(assetPolicy, assetName, afterBlockHeight, history, optionsToParamMap(options));
        return processResponse(call);
    }

    private Map<String, Object> buildBody(String arrayObjString, List<Tuple<String, String>> list) {
        Map<String, Object> bodyMap = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();
        list.forEach(tuple -> {
            List<String> tupleList = new ArrayList<>();
            tupleList.add(tuple._1);
            tupleList.add(tuple._2);
            lists.add(tupleList);
        });
        bodyMap.put(arrayObjString, lists);
        return bodyMap;
    }

    private Map<String, Object> buildBodyUTxOs(List<Tuple<String, String>> list, boolean extended) {
        Map<String, Object> bodyMap = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();
        list.forEach(tuple -> {
            List<String> tupleList = new ArrayList<>();
            tupleList.add(tuple._1);
            tupleList.add(tuple._2);
            lists.add(tupleList);
        });
        bodyMap.put("_asset_list", lists);
        bodyMap.put("_extended", extended);
        return bodyMap;
    }
}
