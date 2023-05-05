package rest.koios.client.backend.api.asset.impl;

import rest.koios.client.backend.api.common.TxHash;
import rest.koios.client.backend.api.asset.AssetService;
import rest.koios.client.backend.api.asset.api.AssetApi;
import rest.koios.client.backend.api.asset.model.*;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.utils.Tuple;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
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
     * @param baseService Base Service
     */
    public AssetServiceImpl(BaseService baseService) {
        super(baseService);
        assetApi = getRetrofit().create(AssetApi.class);
    }

    @Override
    public Result<List<Asset>> getAssetList(Options options) throws ApiException {
        Call<List<Asset>> call = assetApi.getAssetList(optionsToParamMap(options));
        try {
            Response<List<Asset>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AssetTokenRegistry>> getAssetTokenRegistry(Options options) throws ApiException {
        Call<List<AssetTokenRegistry>> call = assetApi.getAssetTokenRegistry(optionsToParamMap(options));
        try {
            Response<List<AssetTokenRegistry>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AssetAddress>> getAssetsAddresses(String assetPolicy, String assetName, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        Call<List<AssetAddress>> call = assetApi.getAssetsAddresses(assetPolicy, assetName, optionsToParamMap(options));
        try {
            Response<List<AssetAddress>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AssetAddress>> getAssetsAddressList(String assetPolicy, String assetName, Options options) throws ApiException {
        return this.getAssetsAddresses(assetPolicy, assetName, options);
    }

    @Override
    public Result<List<AssetAddress>> getNFTAddress(String assetPolicy, String assetName, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        Call<List<AssetAddress>> call = assetApi.getNFTAddress(assetPolicy, assetName, optionsToParamMap(options));
        try {
            Response<List<AssetAddress>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<AssetInformation> getAssetInformation(String assetPolicy, String assetName) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        Call<List<AssetInformation>> call = assetApi.getAssetInformation(assetPolicy, assetName);
        try {
            Response<List<AssetInformation>> response = (Response) execute(call);
            return processResponseGetOne(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<AssetInformation> getAssetInformationBulk(List<Tuple<String, String>> assetList, Options options) throws ApiException {
        if (assetList == null) {
            return badRequestResult("The server cannot process the request due to invalid input");
        }
        for (Tuple<String, String> tuple : assetList) {
            validateHexFormat(tuple._1);
            validateHexFormat(tuple._2);
        }
        Call<List<AssetInformation>> call = assetApi.getAssetInformationBulk(buildBody("_asset_list", assetList), optionsToParamMap(options));
        try {
            Response<List<AssetInformation>> response = (Response) execute(call);
            return processResponseGetOne(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AssetHistory>> getAssetHistory(String assetPolicy, String assetName, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        Call<List<AssetHistory>> call = assetApi.getAssetHistory(assetPolicy, assetName, optionsToParamMap(options));
        try {
            Response<List<AssetHistory>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<PolicyAssetInfo>> getPolicyAssetInformation(String assetPolicy, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        Call<List<PolicyAssetInfo>> call = assetApi.getPolicyAssetInformation(assetPolicy, optionsToParamMap(options));
        try {
            Response<List<PolicyAssetInfo>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<PolicyAssetInfo>> getAssetPolicyInformation(String assetPolicy, Options options) throws ApiException {
        return getPolicyAssetInformation(assetPolicy, options);
    }

    @Override
    public Result<List<PolicyAsset>> getPolicyAssetList(String assetPolicy, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        Call<List<PolicyAsset>> call = assetApi.getPolicyAssetList(assetPolicy, optionsToParamMap(options));
        try {
            Response<List<PolicyAsset>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<AssetSummary> getAssetSummary(String assetPolicy, String assetName) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        Call<List<AssetSummary>> call = assetApi.getAssetSummary(assetPolicy, assetName);
        try {
            Response<List<AssetSummary>> response = (Response) execute(call);
            return processResponseGetOne(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
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
        try {
            Response<List<TxHash>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
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
}
