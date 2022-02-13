package rest.koios.client.backend.api.transactions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.transactions.model.*;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;

import java.util.Arrays;
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
        TxInfo[] transactionInformation = transactionsService.getTransactionInformation(List.of(txHash));
        log.info(Arrays.toString(transactionInformation));
        Assertions.assertNotNull(transactionInformation);
        Assertions.assertEquals(txHash, transactionInformation[0].getTxHash());
    }

    @Test
    void getTransactionInformationBadRequestTest() {
        String txHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> transactionsService.getTransactionInformation(List.of(txHash)));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getTransactionUTxOsTest() throws ApiException {
        String txHash = "6b2623d83581cdc387f104fd3619a8a613bd3b07c2bc8919246ece80d924e370";
        TxUtxo[] transactionUTxOs = transactionsService.getTransactionUTxOs(List.of(txHash));
        log.info(Arrays.toString(transactionUTxOs));
        Assertions.assertNotNull(transactionUTxOs);
        Assertions.assertEquals(txHash, transactionUTxOs[0].getTxHash());
    }

    @Test
    void getTransactionUTxOsBadRequestTest() {
        String txHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> transactionsService.getTransactionUTxOs(List.of(txHash)));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getTransactionMetadataTest() throws ApiException {
        String txHash = "6b2623d83581cdc387f104fd3619a8a613bd3b07c2bc8919246ece80d924e370";
        TxMetadata[] transactionMetadata = transactionsService.getTransactionMetadata(List.of(txHash));
        log.info(Arrays.toString(transactionMetadata));
        Assertions.assertNotNull(transactionMetadata);
    }

    @Test
    void getTransactionMetadataBadRequestTest() {
        String txHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> transactionsService.getTransactionMetadata(List.of(txHash)));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getTransactionMetadataLabelsLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        TxMetadataLabels[] transactionMetadataLabels = transactionsService.getTransactionMetadataLabels(options);
        log.info(Arrays.toString(transactionMetadataLabels));
        Assertions.assertNotNull(transactionMetadataLabels);
        Assertions.assertEquals(10,transactionMetadataLabels.length);
    }

    @Test
    void submitTxBadRequestTest() {
        ApiException exception = assertThrows(ApiException.class, () -> transactionsService.submitTx(new byte[0]));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getTransactionStatusTest() throws ApiException {
        String txHash = "6b2623d83581cdc387f104fd3619a8a613bd3b07c2bc8919246ece80d924e370";
        TxStatus[] transactionStatus = transactionsService.getTransactionStatus(List.of(txHash));
        log.info(Arrays.toString(transactionStatus));
        Assertions.assertNotNull(transactionStatus);
        Assertions.assertEquals(txHash, transactionStatus[0].getTxHash());
    }

    @Test
    void getTransactionStatusBadRequestTest() {
        String txHash = "test";
        ApiException exception = assertThrows(ApiException.class, () -> transactionsService.getTransactionMetadata(List.of(txHash)));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }
}
