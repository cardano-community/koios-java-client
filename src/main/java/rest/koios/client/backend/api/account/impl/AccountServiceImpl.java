package rest.koios.client.backend.api.account.impl;

import rest.koios.client.backend.api.account.AccountService;
import rest.koios.client.backend.api.account.api.AccountApi;
import rest.koios.client.backend.api.account.model.*;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;

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
     * @param baseUrl Base Url
     * @param apiToken Authorization Bearer JWT Token
     */
    public AccountServiceImpl(String baseUrl, String apiToken) {
        super(baseUrl, apiToken);
        accountApi = getRetrofit().create(AccountApi.class);
    }

    @Override
    public Result<List<StakeAddress>> getAccountList(Options options) throws ApiException {
        Call<List<StakeAddress>> call = accountApi.getAccountList(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<AccountInfo>> getAccountInformation(List<String> stakeAddresses, Options options) throws ApiException {
        for (String address : stakeAddresses) {
            validateBech32(address);
        }
        Call<List<AccountInfo>> call = accountApi.getAccountInformation(buildBody("_stake_addresses", stakeAddresses, null, null, null), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<AccountInfo>> getCachedAccountInformation(List<String> stakeAddresses, Options options) throws ApiException {
        for (String address : stakeAddresses) {
            validateBech32(address);
        }
        Call<List<AccountInfo>> call = accountApi.getCachedAccountInformation(buildBody("_stake_addresses", stakeAddresses, null, null, null), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<UTxO>> getAccountUTxOs(List<String> stakeAddresses, boolean extended, Options options) throws ApiException {
        for (String stakeAddress : stakeAddresses) {
            validateBech32(stakeAddress);
        }
        Call<List<UTxO>> call = accountApi.getAccountUTxOs(buildBodyUTxOs(stakeAddresses, extended), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<AccountTx>> getAccountTxs(String stakeAddress, Integer afterBlockHeight, Options options) throws ApiException {
        validateBech32(stakeAddress);
        if (afterBlockHeight == null) {
            afterBlockHeight = 0;
        }
        if (afterBlockHeight < 0) {
            throw new ApiException("Non Positive \"afterBlockHeight\" Value");
        }
        Call<List<AccountTx>> call = accountApi.getAccountTxs(stakeAddress, afterBlockHeight, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<AccountRewards>> getAccountRewards(List<String> addressList, Integer epochNo, Options options) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        if (epochNo != null) {
            validateEpoch(epochNo);
        }
        Call<List<AccountRewards>> call = accountApi.getAccountRewards(buildBody("_stake_addresses", addressList, epochNo, null, null), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<AccountUpdates>> getAccountUpdates(List<String> addressList, Options options) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        Call<List<AccountUpdates>> call = accountApi.getAccountUpdates(buildBody("_stake_addresses", addressList, null, null, null), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<AccountAddress>> getAccountAddresses(List<String> addressList, boolean firstOnly, boolean empty, Options options) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        Call<List<AccountAddress>> call = accountApi.getAccountAddresses(buildBody("_stake_addresses", addressList, null, firstOnly, empty), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<AccountAsset>> getAccountAssets(List<String> addressList, Integer epochNo, Options options) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        if (epochNo != null) {
            validateEpoch(epochNo);
        }
        Call<List<AccountAsset>> call = accountApi.getAccountAssets(buildBody("_stake_addresses", addressList, epochNo, null, null), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<AccountHistory>> getAccountHistory(List<String> addressList, Integer epochNo, Options options) throws ApiException {
        for (String address : addressList) {
            validateBech32(address);
        }
        if (epochNo != null) {
            validateEpoch(epochNo);
        }
        Call<List<AccountHistory>> call = accountApi.getAccountHistory(buildBody("_stake_addresses", addressList, epochNo, null, null), optionsToParamMap(options));
        return processResponse(call);
    }

    private Map<String, Object> buildBody(String arrayObjString, List<String> list, Integer epochNo, Boolean firstOnly, Boolean empty) {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put(arrayObjString, list);
        if (epochNo != null) {
            bodyMap.put("_epoch_no", epochNo);
        }
        if (firstOnly != null) {
            bodyMap.put("_first_only", firstOnly);
        }
        if (empty != null) {
            bodyMap.put("_empty", empty);
        }
        return bodyMap;
    }

    private Map<String, Object> buildBodyUTxOs(List<String> stakeAddresses, boolean extended) {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("_stake_addresses", stakeAddresses);
        bodyMap.put("_extended", extended);
        return bodyMap;
    }
}
