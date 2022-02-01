package com.reina.koios.client.backend.api.transactions;

import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.transactions.model.*;
import com.reina.koios.client.backend.factory.BackendFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TransactionsServiceIntegrationTest {

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
    void getTransactionUTxOsTest() throws ApiException {
        String txHash = "6b2623d83581cdc387f104fd3619a8a613bd3b07c2bc8919246ece80d924e370";
        TxUtxo[] transactionUTxOs = transactionsService.getTransactionUTxOs(List.of(txHash));
        log.info(Arrays.toString(transactionUTxOs));
        Assertions.assertNotNull(transactionUTxOs);
        Assertions.assertEquals(txHash, transactionUTxOs[0].getTxHash());
    }

    @Test
    void getTransactionMetadataTest() throws ApiException {
        String txHash = "6b2623d83581cdc387f104fd3619a8a613bd3b07c2bc8919246ece80d924e370";
        TxMetadata[] transactionMetadata = transactionsService.getTransactionMetadata(List.of(txHash));
        log.info(Arrays.toString(transactionMetadata));
        Assertions.assertNotNull(transactionMetadata);
    }

    @Test
    void getTransactionMetadataLabelsTest() throws ApiException {
        TxMetadataLabels[] transactionMetadataLabels = transactionsService.getTransactionMetadataLabels();
        log.info(Arrays.toString(transactionMetadataLabels));
        Assertions.assertNotNull(transactionMetadataLabels);
    }

//    @Test
    void getTransactionStatusTest() throws ApiException {
        String txHash = "6b2623d83581cdc387f104fd3619a8a613bd3b07c2bc8919246ece80d924e370";
        TxStatus[] transactionStatus = transactionsService.getTransactionStatus(List.of(txHash));
        log.info(Arrays.toString(transactionStatus));
        Assertions.assertNotNull(transactionStatus);
        Assertions.assertEquals(txHash, transactionStatus[0].getTxHash());
    }
}
