package rest.koios.client.backend.factory;

import lombok.Getter;

/**
 * API Version
 */
@Getter
public enum ApiVersion {

    /**
     * Version 0
     */
    VERSION_0("v0");

    private final String version;

    ApiVersion(String version) {
        this.version = version;
    }
}
