package rest.koios.client.backend.factory;

import lombok.Getter;

/**
 * API Version
 */
@Getter
public enum ApiVersion {

    /**
     * Version 1
     */
    VERSION_1("v1");

    private final String version;

    ApiVersion(String version) {
        this.version = version;
    }
}
