package rest.koios.client.backend.factory;

import org.junit.jupiter.api.Test;
import rest.koios.client.backend.api.base.BaseService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class BackendFactoryTest {

    private static String baseUrlOf(BackendService service) {
        return ((BaseService) service.getNetworkService()).getRetrofit().baseUrl().toString();
    }

    @Test
    void mainnetPointsAtMainnetTest() {
        assertEquals("https://api.koios.rest/api/v1/", baseUrlOf(BackendFactory.getKoiosMainnetService()));
        assertEquals("https://api.koios.rest/api/v1/", baseUrlOf(BackendFactory.getKoiosMainnetService("token")));
        assertEquals("https://api.koios.rest/api/v1/",
                baseUrlOf(BackendFactory.getKoiosMainnetService(ApiVersion.VERSION_1, "token")));
    }

    @Test
    void eachNetworkGetsItsOwnHostTest() {
        assertEquals("https://guild.koios.rest/api/v1/", baseUrlOf(BackendFactory.getKoiosGuildService()));
        assertEquals("https://preview.koios.rest/api/v1/", baseUrlOf(BackendFactory.getKoiosPreviewService()));
        assertEquals("https://preprod.koios.rest/api/v1/", baseUrlOf(BackendFactory.getKoiosPreprodService()));
    }

    @Test
    void tokenOverloadsResolveToTheSameHostTest() {
        assertEquals(baseUrlOf(BackendFactory.getKoiosGuildService()),
                baseUrlOf(BackendFactory.getKoiosGuildService("token")));
        assertEquals(baseUrlOf(BackendFactory.getKoiosPreviewService()),
                baseUrlOf(BackendFactory.getKoiosPreviewService(ApiVersion.VERSION_1, "token")));
        assertEquals(baseUrlOf(BackendFactory.getKoiosPreprodService()),
                baseUrlOf(BackendFactory.getKoiosPreprodService("token")));
    }

    @Test
    void customRpcUsesTheGivenUrlTest() {
        String url = "http://localhost:8080/api/v1/";
        assertEquals(url, baseUrlOf(BackendFactory.getCustomRPCService(url)));
        assertEquals(url, baseUrlOf(BackendFactory.getCustomRPCService(url, "token")));
    }

    @Test
    void everyServiceIsWiredTest() {
        BackendService service = BackendFactory.getKoiosMainnetService();
        assertNotNull(service.getNetworkService());
        assertNotNull(service.getEpochService());
        assertNotNull(service.getBlockService());
        assertNotNull(service.getTransactionsService());
        assertNotNull(service.getAccountService());
        assertNotNull(service.getAddressService());
        assertNotNull(service.getAssetService());
        assertNotNull(service.getPoolService());
        assertNotNull(service.getScriptService());
        assertNotNull(service.getGovernanceService());
    }

    @Test
    void apiVersionCarriesItsPathSegmentTest() {
        assertEquals("v1", ApiVersion.VERSION_1.getVersion());
        assertEquals(1, ApiVersion.values().length);
    }

    @Test
    void operationTypesCarryTheirUrlsTest() {
        assertEquals("https://api.koios.rest/api/", OperationType.KOIOS_MAINNET.getBaseUrl());
        assertEquals("https://guild.koios.rest/api/", OperationType.KOIOS_GUILD.getBaseUrl());
        assertEquals("https://preview.koios.rest/api/", OperationType.KOIOS_PREVIEW.getBaseUrl());
        assertEquals("https://preprod.koios.rest/api/", OperationType.KOIOS_PREPROD.getBaseUrl());
    }

    @Test
    void factoryIsNotInstantiableTest() throws NoSuchMethodException {
        Constructor<BackendFactory> constructor = BackendFactory.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        InvocationTargetException thrown =
                assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertInstanceOf(IllegalStateException.class, thrown.getCause());
    }
}
