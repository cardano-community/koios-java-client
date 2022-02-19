package rest.koios.client.backend.api.address.impl;

import rest.koios.client.backend.api.TxHash;
import rest.koios.client.backend.api.address.AddressService;
import rest.koios.client.backend.api.address.api.AddressApi;
import rest.koios.client.backend.api.address.model.AddressInfo;
import rest.koios.client.backend.api.address.model.AssetInfo;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Address Service Implementation
 */
public class AddressServiceImpl extends BaseService implements AddressService {

    private final AddressApi addressApi;

    /**
     * Address Service Implementation Constructor
     *
     * @param baseUrl Base URL
     */
    public AddressServiceImpl(String baseUrl) {
        super(baseUrl);
        addressApi = getRetrofit().create(AddressApi.class);
    }

    @Override
    public Result<List<AddressInfo>> getAddressInformation(String address) throws ApiException {
        validateBech32(address);
        Call<List<AddressInfo>> call = addressApi.getAddressInformation(address);
        try {
            Response<List<AddressInfo>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<TxHash>> getAddressTransactions(List<String> addressList, Integer afterBlockHeight) throws ApiException {
        if (afterBlockHeight < 0) {
            throw new ApiException("Non Positive \"afterBlockHeight\" Value");
        }
        for (String address : addressList) {
            validateBech32(address);
        }
        Call<List<TxHash>> call = addressApi.getAddressTransactions(buildBody("_addresses", addressList, afterBlockHeight));
        try {
            Response<List<TxHash>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AssetInfo>> getAddressAssets(String address) throws ApiException {
        validateBech32(address);
        Call<List<AssetInfo>> call = addressApi.getAddressAssets(address);
        try {
            Response<List<AssetInfo>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<TxHash>> getTransactionsByPaymentCredentials(List<String> paymentCredentialsList, Integer afterBlockHeight) throws ApiException {
        if (afterBlockHeight < 0) {
            throw new ApiException("Non Positive \"afterBlockHeight\" Value");
        }
        for (String paymentCredentials : paymentCredentialsList) {
            validateHexFormat(paymentCredentials);
        }
        Call<List<TxHash>> call = addressApi.getTransactionsByPaymentCredentials(buildBody("_payment_credentials", paymentCredentialsList, afterBlockHeight));
        try {
            Response<List<TxHash>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    private Map<String,Object> buildBody(String arrayObjString, List<String> list, Integer afterBlockHeight) {
        Map<String,Object> bodyMap = new HashMap<>();
        bodyMap.put(arrayObjString,list);
        bodyMap.put("_after_block_height", afterBlockHeight);
        return bodyMap;
    }
}
