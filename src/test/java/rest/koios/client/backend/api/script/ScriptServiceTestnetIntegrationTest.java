package rest.koios.client.backend.api.script;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.script.model.Script;
import rest.koios.client.backend.api.script.model.ScriptRedeemer;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ScriptServiceTestnetIntegrationTest {

    private ScriptService scriptService;

    @BeforeAll
    public void setup() {
        scriptService = BackendFactory.getKoiosTestnetService().getScriptService();
    }

    @Test
    void getScriptListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<Script>> scriptListResult = scriptService.getScriptList(options);
        Assertions.assertTrue(scriptListResult.isSuccessful());
        Assertions.assertNotNull(scriptListResult.getValue());
        log.info(scriptListResult.getValue().toString());
        assertEquals(10, scriptListResult.getValue().size());
    }

    @Test
    void getScriptRedeemersTest() throws ApiException {
        String scriptHash = "0cc40ebefcdd1a32dc96ec4b548075779c28f6842b487d56bf54fd29";
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
