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
        return getKoiosMainnetService(null);
    }

    /**
     * Get Mainnet BackendService for Koios (Latest Version)
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosMainnetService(String apiToken) {
        return getKoiosMainnetService(ApiVersion.VERSION_1, apiToken);
    }

    /**
     * Get Mainnet BackendService for Koios By Version
     *
     * @param apiVersion API Version
     * @param apiToken   Authorization Bearer JWT Token
     * @return {@link BackendService}
     */
    public static BackendService getKoiosMainnetService(ApiVersion apiVersion, String apiToken) {
        return new BackendServiceImpl(OperationType.KOIOS_MAINNET, apiVersion, apiToken);
    }

    /**
     * Get Guild Network BackendService for Koios (Latest Version)
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosGuildService() {
        return getKoiosGuildService(ApiVersion.VERSION_1, null);
    }

    /**
     * Get Guild Network BackendService for Koios (Latest Version)
     *
     * @param apiToken Authorization Bearer JWT Token
     * @return {@link BackendService}
     */
    public static BackendService getKoiosGuildService(String apiToken) {
        return getKoiosGuildService(ApiVersion.VERSION_1, apiToken);
    }

    /**
     * Get Guild Network BackendService for Koios By Version
     *
     * @param apiVersion API Version
     * @return {@link BackendService}
     */
    public static BackendService getKoiosGuildService(ApiVersion apiVersion, String apiToken) {
        return new BackendServiceImpl(OperationType.KOIOS_GUILD, apiVersion, apiToken);
    }

    /**
     * Get Preview Network BackendService for Koios (Latest Version)
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosPreviewService() {
        return getKoiosPreviewService(null);
    }

    /**
     * Get Preview Network BackendService for Koios (Latest Version)
     *
     * @param apiToken Authorization Bearer JWT Token
     * @return {@link BackendService}
     */
    public static BackendService getKoiosPreviewService(String apiToken) {
        return getKoiosPreviewService(ApiVersion.VERSION_1, apiToken);
    }

    /**
     * Get Preview Network BackendService for Koios By Version
     *
     * @param apiVersion API Version
     * @param apiToken   Authorization Bearer JWT Token
     * @return {@link BackendService}
     */
    public static BackendService getKoiosPreviewService(ApiVersion apiVersion, String apiToken) {
        return new BackendServiceImpl(OperationType.KOIOS_PREVIEW, apiVersion, apiToken);
    }

    /**
     * Get Preprod Network BackendService for Koios (Latest Version)
     *
     * @return {@link BackendService}
     */
    public static BackendService getKoiosPreprodService() {
        return getKoiosPreprodService(null);
    }

    /**
     * Get Preprod Network BackendService for Koios (Latest Version)
     *
     * @param apiToken Authorization Bearer JWT Token
     * @return {@link BackendService}
     */
    public static BackendService getKoiosPreprodService(String apiToken) {
        return getKoiosPreprodService(ApiVersion.VERSION_1, apiToken);
    }

    /**
     * Get Preprod Network BackendService for Koios By Version
     *
     * @param apiVersion API Version
     * @param apiToken   Authorization Bearer JWT Token
     * @return {@link BackendService}
     */
    public static BackendService getKoiosPreprodService(ApiVersion apiVersion, String apiToken) {
        return new BackendServiceImpl(OperationType.KOIOS_PREPROD, apiVersion, apiToken);
    }

    /**
     * Get BackendService for Koios
     *
     * @param baseUrl base URL for Koios
     * @return {@link BackendService}
     */
    public static BackendService getCustomRPCService(String baseUrl) {
        return getCustomRPCService(baseUrl, null);
    }

    /**
     * Get BackendService for Koios
     *
     * @param baseUrl  base URL for Koios
     * @param apiToken Authorization Bearer JWT Token
     * @return {@link BackendService}
     */
    public static BackendService getCustomRPCService(String baseUrl, String apiToken) {
        return new BackendServiceImpl(baseUrl, apiToken);
    }
}
