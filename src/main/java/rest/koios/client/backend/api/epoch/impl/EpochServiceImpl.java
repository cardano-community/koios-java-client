package rest.koios.client.backend.api.epoch.impl;

import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.epoch.EpochService;
import rest.koios.client.backend.api.epoch.model.EpochInfo;
import rest.koios.client.backend.api.epoch.model.EpochParams;
import rest.koios.client.backend.factory.OperationType;
import rest.koios.client.backend.factory.options.Options;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * Epoch Service Implementation
 */
public class EpochServiceImpl extends BaseService implements EpochService {

    /**
     * Epoch Service Implementation Constructor
     *
     * @param operationType Operation Type
     * @param webClient     webClient
     */
    public EpochServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public EpochInfo[] getEpochInformation(Long epochNo) throws ApiException {
        validateEpoch(epochNo);
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
    public EpochInfo[] getEpochInformation(Options options) throws ApiException {
        try {
            return (EpochInfo[]) sendGetRequest("/epoch_info", options, EpochInfo[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public EpochParams[] getEpochParameters(Long epochNo) throws ApiException {
        validateEpoch(epochNo);
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

    @Override
    public EpochParams[] getEpochParameters(Options options) throws ApiException {
        try {
            return (EpochParams[]) sendGetRequest("/epoch_params", options, EpochParams[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
