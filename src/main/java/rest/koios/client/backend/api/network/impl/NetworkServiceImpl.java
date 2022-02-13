package rest.koios.client.backend.api.network.impl;

import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.network.NetworkService;
import rest.koios.client.backend.api.network.model.Genesis;
import rest.koios.client.backend.api.network.model.Tip;
import rest.koios.client.backend.api.network.model.Totals;
import rest.koios.client.backend.factory.OperationType;
import rest.koios.client.backend.factory.options.Options;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * Network Service Implementation
 */
public class NetworkServiceImpl extends BaseService implements NetworkService {

    /**
     * Network Service Implementation Constructor
     *
     * @param operationType Operation Type
     * @param webClient     webClient
     */
    public NetworkServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public Tip[] getChainTip() throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/tip").build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Tip[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public Genesis[] getGenesisInfo() throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/genesis").build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Genesis[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public Totals[] getHistoricalTokenomicStats(Long epochNo) throws ApiException {
        validateEpoch(epochNo);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/totals")
                            .queryParam("_epoch_no", epochNo)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Totals[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public Totals[] getHistoricalTokenomicStats(Options options) throws ApiException {
        try {
            return (Totals[]) sendGetRequest("/totals", options, Totals[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
