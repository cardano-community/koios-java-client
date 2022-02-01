package com.reina.koios.client.backend.api.script;

import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.script.model.Script;
import com.reina.koios.client.backend.api.script.model.ScriptRedeemer;
import com.reina.koios.client.backend.factory.BackendFactory;
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
class ScriptServiceIntegrationTest {

    private ScriptService scriptService;

    @BeforeAll
    public void setup() {
        scriptService = BackendFactory.getKoiosTestnetService().getScriptService();
    }

    @Test
    void getScriptListTest() throws ApiException {
        Script[] scriptList = scriptService.getScriptList();
        log.info(Arrays.toString(scriptList));
        Assertions.assertNotNull(scriptList);
    }

    @Test
    void getScriptRedeemersTest() throws ApiException {
        String scriptHash = "0cc40ebefcdd1a32dc96ec4b548075779c28f6842b487d56bf54fd29";
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
