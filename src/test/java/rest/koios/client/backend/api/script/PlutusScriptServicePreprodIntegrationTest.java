package rest.koios.client.backend.api.script;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.script.model.DatumInfo;
import rest.koios.client.backend.api.script.model.NativeScript;
import rest.koios.client.backend.api.script.model.PlutusScript;
import rest.koios.client.backend.api.script.model.ScriptRedeemer;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlutusScriptServicePreprodIntegrationTest {

    private ScriptService scriptService;

    @BeforeAll
    public void setup() {
        scriptService = BackendFactory.getKoiosPreprodService().getScriptService();
    }

    @Test
    void getNativeScriptListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<NativeScript>> scriptListResult = scriptService.getNativeScriptList(options);
        Assertions.assertTrue(scriptListResult.isSuccessful());
        Assertions.assertNotNull(scriptListResult.getValue());
        log.info(scriptListResult.getValue().toString());
        assertEquals(10, scriptListResult.getValue().size());
    }

    @Test
    void getNativeScriptByScriptHashTest() throws ApiException {
        String scriptHash = "2f4e0f59b09f77dff4ab0664c12806fff5316f6bdf0484594439fe39";
        Result<NativeScript> scriptResult = scriptService.getNativeScript(scriptHash);
        Assertions.assertTrue(scriptResult.isSuccessful());
        Assertions.assertNotNull(scriptResult.getValue());
        log.info(scriptResult.getValue().toString());
        assertEquals(scriptHash, scriptResult.getValue().getScriptHash());
        assertEquals("12cec4f58b30677b6e21f1df0ef6e050ddf64eff9e07fcaaef59f112a621350c", scriptResult.getValue().getCreationTxHash());
    }

    @Test
    void getPlutusScriptListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<PlutusScript>> scriptListResult = scriptService.getPlutusScriptList(options);
        Assertions.assertTrue(scriptListResult.isSuccessful());
        Assertions.assertNotNull(scriptListResult.getValue());
        log.info(scriptListResult.getValue().toString());
        assertEquals(10, scriptListResult.getValue().size());
    }

    @Test
    void getScriptRedeemersTest() throws ApiException {
        String scriptHash = "2ab32ec22330adf91e42905b008a1aa84ea7af7dc2dc85592497527c";
        Result<List<ScriptRedeemer>> scriptRedeemersResult = scriptService.getScriptRedeemers(scriptHash, Options.EMPTY);
        Assertions.assertTrue(scriptRedeemersResult.isSuccessful());
        Assertions.assertNotNull(scriptRedeemersResult.getValue());
        log.info(scriptRedeemersResult.getValue().toString());
    }

    @Test
    void getScriptRedeemersBadRequestTest() {
        String scriptHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> scriptService.getScriptRedeemers(scriptHash, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getDatumInformationTest() throws ApiException {
        String hash1 = "5571e2c3549f15934a38382d1318707a86751fb70827f4cbd29b104480f1be9b";
        String hash2 = "5f7212f546d7e7308ce99b925f05538db19981f4ea3084559c0b28a363245826";
        Result<List<DatumInfo>> datumInformationResult = scriptService.getDatumInformation(List.of(hash1, hash2), Options.EMPTY);
        Assertions.assertTrue(datumInformationResult.isSuccessful());
        Assertions.assertNotNull(datumInformationResult.getValue());
        log.info(datumInformationResult.getValue().toString());
    }

    @Test
    void getDatumInformationBadRequestTest() {
        String scriptHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> scriptService.getDatumInformation(List.of(scriptHash), Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }
}
