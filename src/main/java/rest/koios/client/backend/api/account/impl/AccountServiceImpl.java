package rest.koios.client.backend.api.account.impl;

import rest.koios.client.backend.api.account.AccountService;
import rest.koios.client.backend.api.account.api.AccountApi;
import rest.koios.client.backend.api.account.model.*;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Account Service Implementation
 */
public class AccountServiceImpl extends BaseService implements AccountService {

    private final AccountApi accountApi;

    /**
     * Account Service Implementation Constructor
     *
     * @param baseService Base Service
     */
    public AccountServiceImpl(BaseService baseService) {
        super(baseService);
        accountApi = getRetrofit().create(AccountApi.class);
    }

    @Override
    public Result<List<StakeAddress>> getAccountList(Options options) throws ApiException {
        Call<List<StakeAddress>> call = accountApi.getAccountList(optionsToParamMap(options));
        try {
            Response<List<StakeAddress>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<AccountInfo> getAccountInformation(List<String> addressList) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        Call<List<AccountInfo>> call = accountApi.getAccountInformation(buildBody("_stake_addresses", addressList, null));
        try {
            Response<List<AccountInfo>> response = (Response) execute(call);
            return processResponseGetOne(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AccountRewards>> getAccountRewards(List<String> addressList, Integer epochNo) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        if (epochNo != null) {
            validateEpoch(epochNo);
        }
        Call<List<AccountRewards>> call = accountApi.getAccountRewards(buildBody("_stake_addresses", addressList, epochNo));
        try {
            Response<List<AccountRewards>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AccountUpdates>> getAccountUpdates(List<String> addressList, Integer epochNo) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        if (epochNo != null) {
            validateEpoch(epochNo);
        }
        Call<List<AccountUpdates>> call = accountApi.getAccountUpdates(buildBody("_stake_addresses", addressList, epochNo));
        try {
            Response<List<AccountUpdates>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AccountAddress>> getAccountAddresses(List<String> addressList, Integer epochNo) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        if (epochNo != null) {
            validateEpoch(epochNo);
        }
        Call<List<AccountAddress>> call = accountApi.getAccountAddresses(buildBody("_stake_addresses", addressList, epochNo));
        try {
            Response<List<AccountAddress>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AccountAssets>> getAccountAssets(List<String> addressList, Integer epochNo) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        if (epochNo != null) {
            validateEpoch(epochNo);
        }
        Call<List<AccountAssets>> call = accountApi.getAccountAssets(buildBody("_stake_addresses", addressList, epochNo));
        try {
            Response<List<AccountAssets>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AccountHistory>> getAccountHistory(List<String> addressList, Integer epochNo) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        if (epochNo != null) {
            validateEpoch(epochNo);
        }
        Call<List<AccountHistory>> call = accountApi.getAccountHistory(buildBody("_stake_addresses", addressList, epochNo));
        try {
            Response<List<AccountHistory>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    private Map<String, Object> buildBody(String arrayObjString, List<String> list, Integer epochNo) {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put(arrayObjString, list);
        if (epochNo != null) {
            bodyMap.put("_epoch_no", epochNo);
        }
        return bodyMap;
    }
}
