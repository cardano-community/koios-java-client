package com.reina.koios.client.backend.api.epoch.impl;

import com.reina.koios.client.backend.api.BaseService;
import com.reina.koios.client.backend.api.epoch.EpochService;
import com.reina.koios.client.backend.api.epoch.model.EpochInfo;
import com.reina.koios.client.backend.api.epoch.model.EpochParams;
import com.reina.koios.client.backend.factory.OperationType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class EpochServiceImpl extends BaseService implements EpochService {

    public EpochServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public EpochInfo[] getEpochInformation(String epochNo) {
        return (EpochInfo[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/epoch_info").queryParam("_epoch_no", epochNo).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(EpochInfo[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public EpochParams[] getEpochParameters(String epochNo) {
        return (EpochParams[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/epoch_params").queryParam("_epoch_no", epochNo).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(EpochParams[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }
}
