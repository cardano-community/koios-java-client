package com.reina.koios.client.backend.api.script;

import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.script.model.Script;
import com.reina.koios.client.backend.api.script.model.ScriptRedeemer;
import com.reina.koios.client.backend.factory.BackendFactory;
import com.reina.koios.client.backend.factory.options.Limit;
import com.reina.koios.client.backend.factory.options.Options;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ScriptServiceMainnetIntegrationTest {

    private ScriptService scriptService;

    @BeforeAll
    public void setup() {
        scriptService = BackendFactory.getKoiosMainnetService().getScriptService();
    }

    @Test
    void getScriptListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Script[] scriptList = scriptService.getScriptList(options);
        log.info(Arrays.toString(scriptList));
        Assertions.assertNotNull(scriptList);
        Assertions.assertEquals(10, scriptList.length);
    }

    @Test
    void getScriptRedeemersTest() throws ApiException {
        String scriptHash = "d8480dc869b94b80e81ec91b0abe307279311fe0e7001a9488f61ff8";
        ScriptRedeemer[] scriptRedeemers = scriptService.getScriptRedeemers(scriptHash);
        log.info(Arrays.toString(scriptRedeemers));
        Assertions.assertNotNull(scriptRedeemers);
    }

    @Test
    void getScriptRedeemersBadRequestTest() {
        String scriptHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> scriptService.getScriptRedeemers(scriptHash));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }
}
