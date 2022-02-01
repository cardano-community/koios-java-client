package com.reina.koios.client.backend.factory;

import lombok.Getter;

@Getter
public enum OperationType {

    KOIOS_MAINNET("https://api.koios.rest/api/"),
    KOIOS_TESTNET("https://testnet.koios.rest/api/"),
    KOIOS_GUILD("https://guild.koios.rest/api/"),
    CUSTOM_RPC();

    private final String baseUrl;

    OperationType() {
        baseUrl = null;
    }

    OperationType(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
