package rest.koios.client.backend.api.account.impl;

import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import rest.koios.client.backend.api.account.AccountService;
import rest.koios.client.backend.api.account.model.*;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.OperationType;
import rest.koios.client.backend.factory.options.Options;

/**
 * Account Service Implementation
 */
public class AccountServiceImpl extends BaseService implements AccountService {

    /**
     * Account Service Implementation Constructor
     *
     * @param operationType Operation Type
     * @param webClient     webClient
     */
    public AccountServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public StakeAddress[] getAccountList(Options options) throws ApiException {
        try {
            return (StakeAddress[]) sendGetRequest("/account_list", options, StakeAddress[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AccountInfo[] getAccountInformation(String address) throws ApiException {
        validateBech32(address);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_info")
                            .queryParam("_address", address).build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(AccountInfo[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AccountRewards[] getAccountRewards(String stakeAddress, Long epochNo) throws ApiException {
        validateBech32(stakeAddress);
        validateEpoch(epochNo);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_rewards")
                            .queryParam("_stake_address", stakeAddress)
                            .queryParam("_epoch_no", epochNo)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(AccountRewards[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AccountRewards[] getAccountRewards(String stakeAddress, Options options) throws ApiException {
        try {
            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add("_stake_address", stakeAddress);
            return (AccountRewards[]) sendGetRequest("/account_rewards", multiValueMap, options, AccountRewards[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AccountUpdates[] getAccountUpdates(String stakeAddress) throws ApiException {
        validateBech32(stakeAddress);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_updates")
                            .queryParam("_stake_address", stakeAddress)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(AccountUpdates[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AccountAddress[] getAccountAddresses(String address) throws ApiException {
        validateBech32(address);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_addresses")
                            .queryParam("_address", address)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(AccountAddress[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AccountAsset[] getAccountAssets(String address) throws ApiException {
        validateBech32(address);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_assets")
                            .queryParam("_address", address)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(AccountAsset[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AccountHistory[] getAccountHistory(String address) throws ApiException {
        validateBech32(address);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_history")
                            .queryParam("_address", address)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(AccountHistory[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
