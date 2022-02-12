package com.reina.koios.client.backend.api.transactions;

import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.transactions.model.*;
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
    void getTransactionInformationTest() throws ApiException {
        String txHash = "f144a8264acf4bdfe2e1241170969c930d64ab6b0996a4a45237b623f1dd670e";
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
        String txHash = "f144a8264acf4bdfe2e1241170969c930d64ab6b0996a4a45237b623f1dd670e";
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
        String txHash = "f144a8264acf4bdfe2e1241170969c930d64ab6b0996a4a45237b623f1dd670e";
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
        String txHash = "f144a8264acf4bdfe2e1241170969c930d64ab6b0996a4a45237b623f1dd670e";
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
