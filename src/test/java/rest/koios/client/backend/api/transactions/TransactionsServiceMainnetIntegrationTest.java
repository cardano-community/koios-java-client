package rest.koios.client.backend.api.transactions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.transactions.model.*;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TransactionsServiceMainnetIntegrationTest {

    private TransactionsService transactionsService;

    @BeforeAll
    public void setup() {
        transactionsService = BackendFactory.getKoiosMainnetService().getTransactionsService();
    }

    @Test
    void getUTxOInfoTest() throws ApiException {
        List<String> utxoRefs = List.of("f144a8264acf4bdfe2e1241170969c930d64ab6b0996a4a45237b623f1dd670e#0",
                "0b8ba3bed976fa4913f19adc9f6dd9063138db5b4dd29cecde369456b5155e94#0");
        Result<List<UTxO>> utxosResult = transactionsService.getUTxOInfo(utxoRefs, false);
        Assertions.assertTrue(utxosResult.isSuccessful());
        Assertions.assertNotNull(utxosResult.getValue());
        log.info(utxosResult.getValue().toString());
    }

    @Test
    void getTransactionInformationTest() throws ApiException {
        String txHash = "f144a8264acf4bdfe2e1241170969c930d64ab6b0996a4a45237b623f1dd670e";
        String txHash2 = "f5eb5ecd1737ee254bbe94ba6ddb295d90d3e80c138c7ac4e26497ccaf34b00f";
        Result<List<TxInfo>> transactionInformationResult = transactionsService.getTransactionInformation(List.of(txHash, txHash2), Options.EMPTY);
        Assertions.assertTrue(transactionInformationResult.isSuccessful());
        Assertions.assertNotNull(transactionInformationResult.getValue());
        log.info(transactionInformationResult.getValue().toString());
    }

    @Test
    void getTransactionInformation2Test() throws ApiException {
        String txHash = "f144a8264acf4bdfe2e1241170969c930d64ab6b0996a4a45237b623f1dd670e";
        Result<TxInfo> transactionInformationResult = transactionsService.getTransactionInformation(txHash);
        Assertions.assertTrue(transactionInformationResult.isSuccessful());
        Assertions.assertNotNull(transactionInformationResult.getValue());
        log.info(transactionInformationResult.getValue().toString());
    }

    @Test
    void getTransactionInformationBadRequestTest() {
        String txHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> transactionsService.getTransactionInformation(List.of(txHash), Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getTransactionMetadataTest() throws ApiException {
        String txHash = "0b8ba3bed976fa4913f19adc9f6dd9063138db5b4dd29cecde369456b5155e94";
        Result<List<TxMetadata>> transactionMetadataResult = transactionsService.getTransactionMetadata(List.of(txHash), Options.EMPTY);
        Assertions.assertTrue(transactionMetadataResult.isSuccessful());
        Assertions.assertNotNull(transactionMetadataResult.getValue());
        Assertions.assertNotNull(transactionMetadataResult.getValue().get(0));
        Assertions.assertNotNull(transactionMetadataResult.getValue().get(0).getMetadata());
        log.info(transactionMetadataResult.getValue().toString());
    }

    @Test
    void getTransactionMetadataBadRequestTest() {
        String txHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> transactionsService.getTransactionMetadata(List.of(txHash), Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getTransactionMetadataLabelsLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<TxMetadataLabels>> transactionMetadataLabelsResult = transactionsService.getTransactionMetadataLabels(options);
        Assertions.assertTrue(transactionMetadataLabelsResult.isSuccessful());
        log.info(transactionMetadataLabelsResult.getValue().toString());
        Assertions.assertNotNull(transactionMetadataLabelsResult.getValue());
        assertEquals(10, transactionMetadataLabelsResult.getValue().size());
    }

    @Test
    void submitTxBadRequestTest() throws ApiException {
        Result<String> txIdResult = transactionsService.submitTx(new byte[0]);
        Assertions.assertFalse(txIdResult.isSuccessful());
        Assertions.assertEquals(400, txIdResult.getCode());
    }

    @Test
    void getTransactionStatusTest() throws ApiException {
        String txHash = "f144a8264acf4bdfe2e1241170969c930d64ab6b0996a4a45237b623f1dd670e";
        Result<List<TxStatus>> transactionStatusResult = transactionsService.getTransactionStatus(List.of(txHash), Options.EMPTY);
        Assertions.assertTrue(transactionStatusResult.isSuccessful());
        Assertions.assertNotNull(transactionStatusResult.getValue());
        log.info(transactionStatusResult.getValue().toString());
    }

    @Test
    void getTransactionStatusBadRequestTest() {
        String txHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> transactionsService.getTransactionMetadata(List.of(txHash), Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }
}
