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
import java.util.List;

/**
 * Account Service Implementation
 */
public class AccountServiceImpl extends BaseService implements AccountService {

    private final AccountApi accountApi;

    /**
     * Account Service Implementation Constructor
     *
     * @param baseUrl Base URL
     */
    public AccountServiceImpl(String baseUrl) {
        super(baseUrl);
        accountApi = getRetrofit().create(AccountApi.class);
    }

    @Override
    public Result<List<StakeAddress>> getAccountList(Options options) throws ApiException {
        Call<List<StakeAddress>> call = accountApi.getAccountList(options.toMap());
        try {
            Response<List<StakeAddress>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AccountInfo>> getAccountInformation(String address) throws ApiException {
        validateBech32(address);
        Call<List<AccountInfo>> call = accountApi.getAccountInformation(address);
        try {
            Response<List<AccountInfo>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AccountRewards>> getAccountRewards(String stakeAddress, Long epochNo) throws ApiException {
        validateBech32(stakeAddress);
        validateEpoch(epochNo);
        Call<List<AccountRewards>> call = accountApi.getAccountRewards(stakeAddress, epochNo);
        try {
            Response<List<AccountRewards>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AccountRewards>> getAccountRewards(String stakeAddress, Options options) throws ApiException {
        validateBech32(stakeAddress);
        Call<List<AccountRewards>> call = accountApi.getAccountRewards(stakeAddress, options.toMap());
        try {
            Response<List<AccountRewards>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AccountUpdates>> getAccountUpdates(String stakeAddress) throws ApiException {
        validateBech32(stakeAddress);
        Call<List<AccountUpdates>> call = accountApi.getAccountUpdates(stakeAddress);
        try {
            Response<List<AccountUpdates>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AccountAddress>> getAccountAddresses(String address) throws ApiException {
        validateBech32(address);
        Call<List<AccountAddress>> call = accountApi.getAccountAddresses(address);
        try {
            Response<List<AccountAddress>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AccountAsset>> getAccountAssets(String address) throws ApiException {
        validateBech32(address);
        Call<List<AccountAsset>> call = accountApi.getAccountAssets(address);
        try {
            Response<List<AccountAsset>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<AccountHistory>> getAccountHistory(String address) throws ApiException {
        validateBech32(address);
        Call<List<AccountHistory>> call = accountApi.getAccountHistory(address);
        try {
            Response<List<AccountHistory>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }
}
