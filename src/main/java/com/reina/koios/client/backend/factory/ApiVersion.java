package com.reina.koios.client.backend.factory;

import lombok.Getter;

@Getter
public enum ApiVersion {

    VERSION_0("v0");

    private final String version;

    ApiVersion(String version) {
        this.version = version;
    }
}
