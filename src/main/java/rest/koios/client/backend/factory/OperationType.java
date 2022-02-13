package rest.koios.client.backend.factory;

import lombok.Getter;

/**
 * Operation Type
 */
@Getter
public enum OperationType {

    /**
     * Mainnet
     */
    KOIOS_MAINNET("https://api.koios.rest/api/"),
    /**
     * Testnet
     */
    KOIOS_TESTNET("https://testnet.koios.rest/api/"),
    /**
     * Guildnet
     */
    KOIOS_GUILD("https://guild.koios.rest/api/"),
    /**
     * Custom
     */
    CUSTOM_RPC();

    private final String baseUrl;

    OperationType() {
        baseUrl = null;
    }

    OperationType(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
