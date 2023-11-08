package rest.koios.client.backend.api.transactions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.transactions.model.*;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TransactionsServicePreviewIntegrationTest {

    private TransactionsService transactionsService;

    @BeforeAll
    public void setup() {
        transactionsService = BackendFactory.getKoiosPreviewService().getTransactionsService();
    }

    @Test
    void getTransactionInformationTest() throws ApiException {
        String txHash = "7395c56ce76d7e6e1155ba71cc2a9dc9b37d58d162dbc1eb9fb35267bb76054d";
        String txHash2 = "6ad56edea7cad7b61236c9f054cb402146c2d901e7b7901e4ae4a75cccf20aed";
        String txHash3 = "5011f52c08416a3728c4b7d41401bcf22e4c6b6d68c8b099e3d3bf710bd0a2e9";
        String txHash4 = "8071a8b0793c2a8b2416e01d524ffd847eae5ac845a520065268e16114f58a4e";
        Result<List<TxInfo>> transactionInformationResult = transactionsService.getTransactionInformation(List.of(txHash, txHash2, txHash3, txHash4), Options.EMPTY);
        Assertions.assertTrue(transactionInformationResult.isSuccessful());
        Assertions.assertNotNull(transactionInformationResult.getValue());
        log.info(transactionInformationResult.getValue().toString());
    }

    @Test
    void getTransactionInformation2Test() throws ApiException {
        String txHash = "7395c56ce76d7e6e1155ba71cc2a9dc9b37d58d162dbc1eb9fb35267bb76054d";
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
        String txHash = "7395c56ce76d7e6e1155ba71cc2a9dc9b37d58d162dbc1eb9fb35267bb76054d";
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
        String txHash = "7395c56ce76d7e6e1155ba71cc2a9dc9b37d58d162dbc1eb9fb35267bb76054d";
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
