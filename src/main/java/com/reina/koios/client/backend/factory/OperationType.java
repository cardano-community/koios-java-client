package com.reina.koios.client.backend.factory;

import lombok.Getter;

@Getter
public enum OperationType {

    KOIOS_MAINNET("https://api.koios.rest/api/v0"),
    KOIOS_TESTNET("https://testnet.koios.rest/api/v0"),
    KOIOS_GUILD("https://guild.koios.rest/api/v0"),
    CUSTOM_RPC();

    private final String baseUrl;

    OperationType() {
        baseUrl = null;
    }

    OperationType(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
