package com.reina.koios.client.backend.factory;

import com.reina.koios.client.backend.factory.impl.BackendServiceImpl;

public class BackendFactory {

    private BackendFactory() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Get Mainnet BackendService for Koios (Latest Version)
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosMainnetService() {
        return getKoiosMainnetService(ApiVersion.VERSION_0);
    }

    /**
     * Get Mainnet BackendService for Koios By Version
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosMainnetService(ApiVersion apiVersion) {
        return new BackendServiceImpl(OperationType.KOIOS_MAINNET+apiVersion.getVersion());
    }

    /**
     * Get Testnet BackendService for Koios (Latest Version)
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosTestnetService() {
        return getKoiosTestnetService(ApiVersion.VERSION_0);
    }

    /**
     * Get Testnet BackendService for Koios By Version
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosTestnetService(ApiVersion apiVersion) {
        return new BackendServiceImpl(OperationType.KOIOS_TESTNET+apiVersion.getVersion());
    }

    /**
     * Get Guild Network BackendService for Koios (Latest Version)
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosGuildService() {
        return getKoiosGuildService(ApiVersion.VERSION_0);
    }

    /**
     * Get Guild Network BackendService for Koios By Version
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosGuildService(ApiVersion apiVersion) {
        return new BackendServiceImpl(OperationType.KOIOS_GUILD+apiVersion.getVersion());
    }

    /**
     * Get BackendService for Koios
     *
     * @param baseUrl base URL for Koios
     * @return {@link BackendService}
     */
    public static BackendService getCustomRPCService(String baseUrl) {
        return new BackendServiceImpl(baseUrl);
    }
}
