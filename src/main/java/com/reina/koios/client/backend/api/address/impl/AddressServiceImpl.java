package com.reina.koios.client.backend.api.address.impl;

import com.reina.koios.client.backend.api.TxHash;
import com.reina.koios.client.backend.api.address.AddressService;
import com.reina.koios.client.backend.api.address.model.AddressInfo;
import com.reina.koios.client.backend.api.address.model.AssetInfo;
import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.factory.OperationType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

public class AddressServiceImpl extends BaseService implements AddressService {

    public AddressServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public AddressInfo[] getAddressInformation(String address) {
        return (AddressInfo[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/address_info").queryParam("_address", address).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(AddressInfo[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public TxHash[] getAddressTransactions(List<String> addressList, Integer afterBlockHeight) {
        return (TxHash[]) getWebClient().post()
                .uri(getCustomUrlSuffix() + "/address_txs")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(buildBody("_addresses",addressList, afterBlockHeight))
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(TxHash[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public TxHash[] getTransactionsByPaymentCredentials(List<String> paymentCredentialList, Integer afterBlockHeight) {
        return (TxHash[]) getWebClient().post()
                .uri(getCustomUrlSuffix() + "/credential_txs")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(buildBody("_payment_credentials",paymentCredentialList, afterBlockHeight))
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(TxHash[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public AssetInfo[] getAddressAssets(String address) {
        return (AssetInfo[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/address_assets").queryParam("_address", address).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(AssetInfo[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    private String buildBody(String arrayObjString, List<String> list, Integer afterBlockHeight) {
        StringBuilder jsonBodyValue = new StringBuilder("{\"").append(arrayObjString).append("\":[");
        for (int i = 0; i < list.size(); i++) {
            jsonBodyValue.append("\"").append(list.get(i)).append("\"");
            if (i + 1 < list.size()) {
                jsonBodyValue.append(",");
            }
        }
        jsonBodyValue.append("]");
        if (afterBlockHeight != null) {
            jsonBodyValue.append(",\"_after_block_height\":").append(afterBlockHeight);
        }
        jsonBodyValue.append("}");
        return jsonBodyValue.toString();
    }
}
