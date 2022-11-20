package rest.koios.client.backend.api.asset.impl;

import rest.koios.client.backend.api.common.TxHash;
import rest.koios.client.backend.api.asset.AssetService;
import rest.koios.client.backend.api.asset.api.AssetApi;
import rest.koios.client.backend.api.asset.model.*;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

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
    public Result<List<AssetAddress>> getAssetsAddressList(String assetPolicy, String assetName, Options options) throws ApiException {
        validateHexFormat(assetPolicy);
        validateHexFormat(assetName);
        Call<List<AssetAddress>> call = assetApi.getAssetsAddressList(assetPolicy, assetName, optionsToParamMap(options));
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
    public Result<List<PolicyAsset>> getAssetPolicyInformation(String assetPolicy) throws ApiException {
        validateHexFormat(assetPolicy);
        Call<List<PolicyAsset>> call = assetApi.getAssetPolicyInformation(assetPolicy);
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
}
