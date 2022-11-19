package rest.koios.client.backend.factory;

import rest.koios.client.backend.factory.impl.BackendServiceImpl;

/**
 * Backend Factory
 */
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
     * @param apiVersion API Version
     * @return {@link BackendService}
     */
    public static BackendService getKoiosMainnetService(ApiVersion apiVersion) {
        return new BackendServiceImpl(OperationType.KOIOS_MAINNET, apiVersion);
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
     * @param apiVersion API Version
     * @return {@link BackendService}
     */
    public static BackendService getKoiosTestnetService(ApiVersion apiVersion) {
        return new BackendServiceImpl(OperationType.KOIOS_TESTNET, apiVersion);
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
     * @param apiVersion API Version
     * @return {@link BackendService}
     */
    public static BackendService getKoiosGuildService(ApiVersion apiVersion) {
        return new BackendServiceImpl(OperationType.KOIOS_GUILD, apiVersion);
    }

    /**
     * Get Preview Network BackendService for Koios (Latest Version)
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosPreviewService() {
        return getKoiosPreviewService(ApiVersion.VERSION_0);
    }

    /**
     * Get Preview Network BackendService for Koios By Version
     *
     * @param apiVersion API Version
     * @return {@link BackendService}
     */
    public static BackendService getKoiosPreviewService(ApiVersion apiVersion) {
        return new BackendServiceImpl(OperationType.KOIOS_PREVIEW, apiVersion);
    }

    /**
     * Get Preprod Network BackendService for Koios (Latest Version)
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosPreprodService() {
        return getKoiosPreprodService(ApiVersion.VERSION_0);
    }

    /**
     * Get Preprod Network BackendService for Koios By Version
     *
     * @param apiVersion API Version
     * @return {@link BackendService}
     */
    public static BackendService getKoiosPreprodService(ApiVersion apiVersion) {
        return new BackendServiceImpl(OperationType.KOIOS_PREPROD, apiVersion);
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
