package com.reina.koios.client.backend.api.transactions.impl;

import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.transactions.TransactionsService;
import com.reina.koios.client.backend.api.transactions.model.*;
import com.reina.koios.client.backend.factory.OperationType;
import com.reina.koios.client.backend.factory.options.Options;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

public class TransactionsServiceImpl extends BaseService implements TransactionsService {

    public TransactionsServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public TxInfo[] getTransactionInformation(List<String> txHashes) throws ApiException {
        for (String tx : txHashes) {
            validateHexFormat(tx);
        }
        try {
            return getWebClient().post()
                    .uri(getCustomUrlSuffix() + "/tx_info")
                    .accept(MediaType.APPLICATION_JSON)
                    .bodyValue(buildBody(txHashes))
                    .retrieve()
                    .bodyToMono(TxInfo[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public TxUtxo[] getTransactionUTxOs(List<String> txHashes) throws ApiException {
        for (String tx : txHashes) {
            validateHexFormat(tx);
        }
        try {
            return getWebClient().post()
                    .uri(getCustomUrlSuffix() + "/tx_utxos")
                    .accept(MediaType.APPLICATION_JSON)
                    .bodyValue(buildBody(txHashes))
                    .retrieve()
                    .bodyToMono(TxUtxo[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public TxMetadata[] getTransactionMetadata(List<String> txHashes) throws ApiException {
        for (String tx : txHashes) {
            validateHexFormat(tx);
        }
        try {
            return getWebClient().post()
                    .uri(getCustomUrlSuffix() + "/tx_metadata")
                    .accept(MediaType.APPLICATION_JSON)
                    .bodyValue(buildBody(txHashes))
                    .retrieve()
                    .bodyToMono(TxMetadata[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public TxMetadataLabels[] getTransactionMetadataLabels(Options options) throws ApiException {
        try {
            return (TxMetadataLabels[]) sendGetRequest("/tx_metalabels", options, TxMetadataLabels[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public String submitTx(byte[] cborData) throws ApiException {
        try {
            return getWebClient().post()
                    .uri(getCustomUrlSuffix() + "/submittx")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_CBOR)
                    .bodyValue(cborData)
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public TxStatus[] getTransactionStatus(List<String> txHashes) throws ApiException {
        for (String tx : txHashes) {
            validateHexFormat(tx);
        }
        try {
            return getWebClient().post()
                    .uri(getCustomUrlSuffix() + "/tx_status")
                    .accept(MediaType.APPLICATION_JSON)
                    .bodyValue(buildBody(txHashes))
                    .retrieve()
                    .bodyToMono(TxStatus[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    private String buildBody(List<String> txHashes) {
        if (txHashes == null || txHashes.isEmpty()) {
            return null;
        }
        StringBuilder jsonBodyValue = new StringBuilder("{\"_tx_hashes\":[");
        for (int i = 0; i < txHashes.size(); i++) {
            jsonBodyValue.append("\"").append(txHashes.get(i)).append("\"");
            if (i < txHashes.size() - 1) {
                jsonBodyValue.append(",");
            }
        }
        jsonBodyValue.append("]}");
        return jsonBodyValue.toString();
    }
}
