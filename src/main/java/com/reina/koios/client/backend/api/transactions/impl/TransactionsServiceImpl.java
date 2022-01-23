package com.reina.koios.client.backend.api.transactions.impl;

import com.reina.koios.client.backend.api.BaseService;
import com.reina.koios.client.backend.api.transactions.TransactionsService;
import com.reina.koios.client.backend.api.transactions.model.*;
import com.reina.koios.client.backend.factory.OperationType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

public class TransactionsServiceImpl extends BaseService implements TransactionsService {

    public TransactionsServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType,webClient);
    }

    @Override
    public TxInfo[] getTransactionInformation(List<String> txHashes) {
        return (TxInfo[]) getWebClient().post()
                .uri(getCustomUrlSuffix()+"/tx_info")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(buildBody(txHashes))
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(TxInfo[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public TxUtxo[] getTransactionUTxOs(List<String> txHashes) {
        return (TxUtxo[]) getWebClient().post()
                .uri(getCustomUrlSuffix()+"/tx_info")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(buildBody(txHashes))
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(TxUtxo[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public TxMetadata[] getTransactionMetadata(List<String> txHashes) {
        return (TxMetadata[]) getWebClient().post()
                .uri(getCustomUrlSuffix()+"/tx_metadata")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(buildBody(txHashes))
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(TxMetadata[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public TxMetadataLabels[] getTransactionMetadataLabels() {
        return (TxMetadataLabels[]) getWebClient().get()
                .uri("/tx_metalabels")
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(TxMetadataLabels[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public TxStatus[] getTransactionStatus(List<String> txHashes) {
        return (TxStatus[]) getWebClient().post()
                .uri(getCustomUrlSuffix()+"/tx_metadata")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(buildBody(txHashes))
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(TxStatus[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    private String buildBody(List<String> txHashes) {
        StringBuilder jsonBodyValue = new StringBuilder("{\"_tx_hashes\":[");
        for (int i = 0 ; i < txHashes.size() ; i++) {
            jsonBodyValue.append("\"").append(txHashes.get(i)).append("\"");
            if (i+1 < txHashes.size()) {
                jsonBodyValue.append(",");
            }
        }
        jsonBodyValue.append("]}");
        return jsonBodyValue.toString();
    }


}
