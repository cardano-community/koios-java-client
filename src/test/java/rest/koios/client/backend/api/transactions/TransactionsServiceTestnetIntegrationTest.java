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
class TransactionsServiceTestnetIntegrationTest {

    private TransactionsService transactionsService;

    @BeforeAll
    public void setup() {
        transactionsService = BackendFactory.getKoiosTestnetService().getTransactionsService();
    }

    @Test
    void getTransactionInformationTest() throws ApiException {
        String txHash = "6b2623d83581cdc387f104fd3619a8a613bd3b07c2bc8919246ece80d924e370";
        Result<List<TxInfo>> transactionInformationResult = transactionsService.getTransactionInformation(List.of(txHash));
        Assertions.assertTrue(transactionInformationResult.isSuccessful());
        Assertions.assertNotNull(transactionInformationResult.getValue());
        log.info(transactionInformationResult.getValue().toString());
    }

    @Test
    void getTransactionInformationBadRequestTest() {
        String txHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> transactionsService.getTransactionInformation(List.of(txHash)));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getTransactionUTxOsTest() throws ApiException {
        String txHash = "6b2623d83581cdc387f104fd3619a8a613bd3b07c2bc8919246ece80d924e370";
        Result<List<TxUtxo>> transactionUTxOsResult = transactionsService.getTransactionUTxOs(List.of(txHash));
        Assertions.assertTrue(transactionUTxOsResult.isSuccessful());
        Assertions.assertNotNull(transactionUTxOsResult.getValue());
        log.info(transactionUTxOsResult.getValue().toString());
    }

    @Test
    void getTransactionUTxOsBadRequestTest() {
        String txHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> transactionsService.getTransactionUTxOs(List.of(txHash)));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getTransactionMetadataTest() throws ApiException {
        String txHash = "6b2623d83581cdc387f104fd3619a8a613bd3b07c2bc8919246ece80d924e370";
        Result<List<TxMetadata>> transactionMetadataResult = transactionsService.getTransactionMetadata(List.of(txHash));
        Assertions.assertTrue(transactionMetadataResult.isSuccessful());
        Assertions.assertNotNull(transactionMetadataResult.getValue());
        log.info(transactionMetadataResult.getValue().toString());
    }

    @Test
    void getTransactionMetadataBadRequestTest() {
        String txHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> transactionsService.getTransactionMetadata(List.of(txHash)));
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
        String txHash = "6b2623d83581cdc387f104fd3619a8a613bd3b07c2bc8919246ece80d924e370";
        Result<List<TxStatus>> transactionStatusResult = transactionsService.getTransactionStatus(List.of(txHash));
        Assertions.assertTrue(transactionStatusResult.isSuccessful());
        Assertions.assertNotNull(transactionStatusResult.getValue());
        log.info(transactionStatusResult.getValue().toString());
    }

    @Test
    void getTransactionStatusBadRequestTest() {
        String txHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> transactionsService.getTransactionMetadata(List.of(txHash)));
        assertInstanceOf(ApiException.class, exception);
    }
}
