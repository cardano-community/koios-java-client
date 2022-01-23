package com.reina.koios.client.backend.api.network.impl;

import com.reina.koios.client.backend.api.BaseService;
import com.reina.koios.client.backend.api.network.NetworkService;
import com.reina.koios.client.backend.api.network.model.Genesis;
import com.reina.koios.client.backend.api.network.model.Tip;
import com.reina.koios.client.backend.api.network.model.Totals;
import com.reina.koios.client.backend.factory.OperationType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class NetworkServiceImpl extends BaseService implements NetworkService {

    public NetworkServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public Tip[] getChainTip() {
        return (Tip[]) getWebClient().get()
                .uri(getCustomUrlSuffix() + "/tip")
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(Tip[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public Genesis[] getGenesisInfo() {
        return (Genesis[]) getWebClient().get()
                .uri("/genesis")
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(Genesis[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public Totals[] getHistoricalTokenomicStats(String epochNo) {
        return (Totals[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/totals").queryParam("_epoch_no", epochNo).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode()
                            .equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(Totals[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException()
                                .flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }
}
