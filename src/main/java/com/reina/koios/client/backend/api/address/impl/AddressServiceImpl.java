package com.reina.koios.client.backend.api.address.impl;

import com.reina.koios.client.backend.api.TxHash;
import com.reina.koios.client.backend.api.address.AddressService;
import com.reina.koios.client.backend.api.address.model.AddressInfo;
import com.reina.koios.client.backend.api.address.model.AssetInfo;
import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.factory.OperationType;
import com.reina.koios.client.utils.Bech32Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

public class AddressServiceImpl extends BaseService implements AddressService {

    public AddressServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public AddressInfo[] getAddressInformation(String address) throws ApiException {
        if (!Bech32Util.isValid(address)) {
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
        }
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/address_info")
                            .queryParam("_address", address)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(AddressInfo[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public TxHash[] getAddressTransactions(List<String> addressList, Integer afterBlockHeight) throws ApiException {
        if (afterBlockHeight<0) {
            throw new ApiException("Non Positive \"afterBlockHeight\" Value", HttpStatus.BAD_REQUEST);
        }
        for (String address : addressList) {
            if (!Bech32Util.isValid(address)) {
                throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
            }
        }
        try {
            return getWebClient().post()
                    .uri(getCustomUrlSuffix() + "/address_txs")
                    .accept(MediaType.APPLICATION_JSON)
                    .bodyValue(buildBody("_addresses", addressList, afterBlockHeight))
                    .retrieve()
                    .bodyToMono(TxHash[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public TxHash[] getTransactionsByPaymentCredentials(List<String> paymentCredentialsList, Integer afterBlockHeight) throws ApiException {
        if (afterBlockHeight<0) {
            throw new ApiException("Non Positive \"afterBlockHeight\" Value", HttpStatus.BAD_REQUEST);
        }
        for (String paymentCredentials : paymentCredentialsList) {
            if (!paymentCredentials.matches("^[0-9a-fA-F]+$")) {
                throw new ApiException("Invalid Hexadecimal String Format", HttpStatus.BAD_REQUEST);
            }
        }
        try {
            return getWebClient().post()
                    .uri(getCustomUrlSuffix() + "/credential_txs")
                    .accept(MediaType.APPLICATION_JSON)
                    .bodyValue(buildBody("_payment_credentials", paymentCredentialsList, afterBlockHeight))
                    .retrieve()
                    .bodyToMono(TxHash[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public AssetInfo[] getAddressAssets(String address) throws ApiException {
        if (!Bech32Util.isValid(address)) {
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
        }
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/address_assets")
                            .queryParam("_address", address)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(AssetInfo[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
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
