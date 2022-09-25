package rest.koios.client.backend.api.address.impl;

import rest.koios.client.backend.api.TxHash;
import rest.koios.client.backend.api.address.AddressService;
import rest.koios.client.backend.api.address.api.AddressApi;
import rest.koios.client.backend.api.address.model.AddressAsset;
import rest.koios.client.backend.api.address.model.AddressInfo;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.backend.factory.options.SortType;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Address Service Implementation
 */
public class AddressServiceImpl extends BaseService implements AddressService {

    private final AddressApi addressApi;

    /**
     * Address Service Implementation Constructor
     *
     * @param baseService Base Service
     */
    public AddressServiceImpl(BaseService baseService) {
        super(baseService);
        addressApi = getRetrofit().create(AddressApi.class);
    }

    @Override
    public Result<AddressInfo> getAddressInformation(String address) throws ApiException {
        return getAddressInformation(List.of(address), SortType.DESC, null);
    }

    @Override
    public Result<AddressInfo> getAddressInformation(List<String> addressList, SortType utxoSortType, Options options) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        Call<List<AddressInfo>> call = addressApi.getAddressInformation(buildBody("_addresses", addressList, null), optionsToParamMap(options));
        try {
            Response<List<AddressInfo>> response = (Response) execute(call);
            Result<AddressInfo> result = processResponseGetOne(response);
            //Sort
            if (utxoSortType == SortType.DESC) {
                result.getValue().setUtxoSet(new TreeSet<>(result.getValue().getUtxoSet()).descendingSet());
            } else {
                result.getValue().setUtxoSet(new TreeSet<>(result.getValue().getUtxoSet()));
            }
            return result;
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<TxHash>> getAddressTransactions(List<String> addressList, Options options) throws ApiException {
        return getAddressTransactions(addressList,0,options);
    }

    @Override
    public Result<List<TxHash>> getAddressTransactions(List<String> addressList, Integer afterBlockHeight, Options options) throws ApiException {
        if (afterBlockHeight < 0) {
            throw new ApiException("Non Positive \"afterBlockHeight\" Value");
        }
        for (String address : addressList) {
            validateBech32(address);
        }
        Call<List<TxHash>> call = addressApi.getAddressTransactions(buildBody("_addresses", addressList, afterBlockHeight), optionsToParamMap(options));
        try {
            Response<List<TxHash>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AddressAsset>> getAddressAssets(List<String> addressList, Options options) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        Call<List<AddressAsset>> call = addressApi.getAddressAssets(buildBody("_addresses", addressList, null), optionsToParamMap(options));
        try {
            Response<List<AddressAsset>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<TxHash>> getTransactionsByPaymentCredentials(List<String> paymentCredentialsList, Options options) throws ApiException {
        return getTransactionsByPaymentCredentials(paymentCredentialsList, 0, options);
    }

    @Override
    public Result<List<TxHash>> getTransactionsByPaymentCredentials(List<String> paymentCredentialsList, Integer afterBlockHeight, Options options) throws ApiException {
        if (afterBlockHeight < 0) {
            throw new ApiException("Non Positive \"afterBlockHeight\" Value");
        }
        for (String paymentCredentials : paymentCredentialsList) {
            validateHexFormat(paymentCredentials);
        }
        Call<List<TxHash>> call = addressApi.getTransactionsByPaymentCredentials(buildBody("_payment_credentials", paymentCredentialsList, afterBlockHeight), optionsToParamMap(options));
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
        if (afterBlockHeight != null) {
            bodyMap.put("_after_block_height", afterBlockHeight);
        }
        return bodyMap;
    }
}
