package rest.koios.client.backend.api.script;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
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
class PlutusScriptServiceMainnetIntegrationTest {

    private ScriptService scriptService;

    @BeforeAll
    public void setup() {
        scriptService = BackendFactory.getKoiosMainnetService().getScriptService();
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
        String scriptHash = "d8480dc869b94b80e81ec91b0abe307279311fe0e7001a9488f61ff8";
        Result<List<ScriptRedeemer>> scriptRedeemersResult = scriptService.getScriptRedeemers(scriptHash, null);
        Assertions.assertTrue(scriptRedeemersResult.isSuccessful());
        Assertions.assertNotNull(scriptRedeemersResult.getValue());
        log.info(scriptRedeemersResult.getValue().toString());
    }

    @Test
    void getScriptRedeemersBadRequestTest() {
        String scriptHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> scriptService.getScriptRedeemers(scriptHash, null));
        assertInstanceOf(ApiException.class, exception);
    }
}
