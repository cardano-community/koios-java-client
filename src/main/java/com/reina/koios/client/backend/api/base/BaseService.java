package com.reina.koios.client.backend.api.base;

import com.reina.koios.client.backend.factory.OperationType;
import lombok.Data;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Data
public class BaseService {

    private final WebClient webClient;
    private final String customUrlSuffix;
    private final Duration timeoutDuration = Duration.ofSeconds(20);

    public BaseService(OperationType operationType, WebClient webClient) {
        this.webClient = webClient;
        if (operationType == OperationType.CUSTOM_RPC) {
            customUrlSuffix = "/rpc";
        } else {
            customUrlSuffix = "";
        }
    }
}
