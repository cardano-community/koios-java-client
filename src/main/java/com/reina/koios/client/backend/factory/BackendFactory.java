package com.reina.koios.client.backend.factory;

import com.reina.koios.client.backend.factory.impl.BackendServiceImpl;

public class BackendFactory {

    private BackendFactory() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Get Mainnet BackendService for Koios
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosMainnetService() {
        return new BackendServiceImpl(OperationType.KOIOS_MAINNET);
    }

    /**
     * Get Testnet BackendService for Koios
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosTestnetService() {
        return new BackendServiceImpl(OperationType.KOIOS_TESTNET);
    }

    /**
     * Get Guild Network BackendService for Koios
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosGuildService() {
        return new BackendServiceImpl(OperationType.KOIOS_GUILD);
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
