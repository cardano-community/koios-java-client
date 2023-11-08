package rest.koios.client.backend.api.script;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.script.model.*;
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
    void getScriptInformationTest() throws ApiException {
        List<String> scriptHashes = List.of("bd2119ee2bfb8c8d7c427e8af3c35d537534281e09e23013bca5b138","c0c671fba483641a71bb92d3a8b7c52c90bf1c01e2b83116ad7d4536");
        Result<List<ScriptInfo>> scriptInformationResult = scriptService.getScriptInformation(scriptHashes, Options.EMPTY);
        Assertions.assertTrue(scriptInformationResult.isSuccessful());
        Assertions.assertNotNull(scriptInformationResult.getValue());
        log.info(scriptInformationResult.getValue().toString());
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
        String scriptHash = "65c197d565e88a20885e535f93755682444d3c02fd44dd70883fe89e";
        Result<NativeScript> scriptResult = scriptService.getNativeScriptByScriptHash(scriptHash);
        Assertions.assertTrue(scriptResult.isSuccessful());
        Assertions.assertNotNull(scriptResult.getValue());
        log.info(scriptResult.getValue().toString());
        assertEquals(scriptHash, scriptResult.getValue().getScriptHash());
        assertEquals("4a3f86762383f1d228542d383ae7ac89cf75cf7ff84dec8148558ea92b0b92d0", scriptResult.getValue().getCreationTxHash());
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
    void getScriptUTxOsTest() throws ApiException {
        String scriptHash = "d8480dc869b94b80e81ec91b0abe307279311fe0e7001a9488f61ff8";
        Result<List<UTxO>> utxosResult = scriptService.getScriptUTxOs(scriptHash, false, Options.EMPTY);
        Assertions.assertTrue(utxosResult.isSuccessful());
        Assertions.assertNotNull(utxosResult.getValue());
        log.info(utxosResult.getValue().toString());
    }

    @Test
    void getDatumInformationTest() throws ApiException {
        String hash1 = "818ee3db3bbbd04f9f2ce21778cac3ac605802a4fcb00c8b3a58ee2dafc17d46";
        String hash2 = "45b0cfc220ceec5b7c1c62c4d4193d38e4eba48e8815729ce75f9c0ab0e4c1c0";
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
