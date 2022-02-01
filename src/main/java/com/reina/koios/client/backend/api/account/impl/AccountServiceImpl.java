package com.reina.koios.client.backend.api.account.impl;

import com.reina.koios.client.backend.api.account.AccountService;
import com.reina.koios.client.backend.api.account.model.*;
import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.factory.OperationType;
import com.reina.koios.client.utils.Bech32Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class AccountServiceImpl extends BaseService implements AccountService {

    public AccountServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public StakeAddress[] getAccountList() throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_list").build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(StakeAddress[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AccountInfo[] getAccountInformation(String address) throws ApiException {
        if (!Bech32Util.isValid(address)) {
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
        }
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
        if (!Bech32Util.isValid(stakeAddress)) {
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
        }
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
    public AccountUpdates[] getAccountUpdates(String stakeAddress) throws ApiException {
        if (!Bech32Util.isValid(stakeAddress)) {
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
        }
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
        if (!Bech32Util.isValid(address)) {
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
        }
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
        if (!Bech32Util.isValid(address)) {
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
        }
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
        if (!Bech32Util.isValid(address)) {
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
        }
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
