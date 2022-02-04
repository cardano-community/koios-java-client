package com.reina.koios.client.backend.api.script.impl;

import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.script.ScriptService;
import com.reina.koios.client.backend.api.script.model.Script;
import com.reina.koios.client.backend.api.script.model.ScriptRedeemer;
import com.reina.koios.client.backend.factory.OperationType;
import com.reina.koios.client.backend.factory.options.Options;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class ScriptServiceImpl extends BaseService implements ScriptService {

    public ScriptServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public Script[] getScriptList(Options options) throws ApiException {
        try {
            return (Script[]) sendGetRequest("/script_list", options, Script[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public ScriptRedeemer[] getScriptRedeemers(String scriptHash) throws ApiException {
        validateHexFormat(scriptHash);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/script_redeemers")
                            .queryParam("_script_hash", scriptHash)
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(ScriptRedeemer[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
