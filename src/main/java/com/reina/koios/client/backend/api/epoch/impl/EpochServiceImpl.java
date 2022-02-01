package com.reina.koios.client.backend.api.epoch.impl;

import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.epoch.EpochService;
import com.reina.koios.client.backend.api.epoch.model.EpochInfo;
import com.reina.koios.client.backend.api.epoch.model.EpochParams;
import com.reina.koios.client.backend.factory.OperationType;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class EpochServiceImpl extends BaseService implements EpochService {

    public EpochServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public EpochInfo[] getEpochInformation(String epochNo) throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/epoch_info")
                            .queryParam("_epoch_no", epochNo)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(EpochInfo[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public EpochParams[] getEpochParameters(String epochNo) throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/epoch_params")
                            .queryParam("_epoch_no", epochNo)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(EpochParams[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
