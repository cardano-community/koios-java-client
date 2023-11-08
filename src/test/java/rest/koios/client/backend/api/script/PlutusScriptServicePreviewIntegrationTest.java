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
class PlutusScriptServicePreviewIntegrationTest {

    private ScriptService scriptService;

    @BeforeAll
    public void setup() {
        scriptService = BackendFactory.getKoiosPreviewService().getScriptService();
    }

    @Test
    void getScriptInformationTest() throws ApiException {
        List<String> scriptHashes = List.of("c6d963e8892916ab8753d3c342037cd122123c4dd783a07af21f8dac","c0c671fba483641a71bb92d3a8b7c52c90bf1c01e2b83116ad7d4536");
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
        String scriptHash = "6c969320597b755454ff3653ad09725d590c570827a129aeb4385526";
        Result<NativeScript> scriptResult = scriptService.getNativeScriptByScriptHash(scriptHash);
        Assertions.assertTrue(scriptResult.isSuccessful());
        Assertions.assertNotNull(scriptResult.getValue());
        log.info(scriptResult.getValue().toString());
        assertEquals(scriptHash, scriptResult.getValue().getScriptHash());
        assertEquals("e5602443710892625b8526d2499b29d25b8f5d830eb5bb374323fdb74e17a674", scriptResult.getValue().getCreationTxHash());
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
        String scriptHash = "8d73f125395466f1d68570447e4f4b87cd633c6728f3802b2dcfca20";
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
        String scriptHash = "f758cf422ca0cbed7d9d6fad1eb5a3c70537d62e661ad450dd2a3810";
        Result<List<UTxO>> utxosResult = scriptService.getScriptUTxOs(scriptHash, false, Options.EMPTY);
        Assertions.assertTrue(utxosResult.isSuccessful());
        Assertions.assertNotNull(utxosResult.getValue());
        log.info(utxosResult.getValue().toString());
    }

    @Test
    void getDatumInformationTest() throws ApiException {
        String hash1 = "6181b3dc623cd8812caf027a3507e9b3095388a7cf3db65983e1fddd3a84c88c";
        String hash2 = "f8ae55ff89e1f5366f23e16bcaf2073252337b96031a02d79e41d653b5f0a978";
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
