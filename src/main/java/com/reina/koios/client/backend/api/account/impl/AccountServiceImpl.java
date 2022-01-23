package com.reina.koios.client.backend.api.account.impl;

import com.reina.koios.client.backend.api.account.AccountService;
import com.reina.koios.client.backend.api.account.model.*;
import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.factory.OperationType;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class AccountServiceImpl extends BaseService implements AccountService {

    public AccountServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public StakeAddress[] getAccountList() {
        return (StakeAddress[]) getWebClient().get()
                .uri("/account_list")
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(StakeAddress[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public AccountInfo[] getAccountInformation(String address) {
        return (AccountInfo[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_info").queryParam("_address", address).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(AccountInfo[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    @SneakyThrows
    public AccountRewards[] getAccountRewards(String stakeAddress, Long epochNo) {
        return (AccountRewards[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_rewards")
                        .queryParam("_stake_address", stakeAddress)
                        .queryParam("_epoch_no", epochNo)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(AccountRewards[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public AccountUpdates[] getAccountUpdates(String stakeAddress) {
        return (AccountUpdates[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_updates").queryParam("_stake_address", stakeAddress).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(AccountUpdates[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public AccountAddress[] getAccountAddresses(String address) {
        return (AccountAddress[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_addresses").queryParam("_address", address).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(AccountAddress[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public AccountAsset[] getAccountAssets(String address) {
        return (AccountAsset[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_assets").queryParam("_address", address).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(AccountAsset[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public AccountHistory[] getAccountHistory(String address) {
        return (AccountHistory[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/account_history").queryParam("_address", address).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(AccountHistory[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }
}
