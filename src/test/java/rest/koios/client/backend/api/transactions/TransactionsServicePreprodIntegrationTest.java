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
class TransactionsServicePreprodIntegrationTest {

    private TransactionsService transactionsService;

    @BeforeAll
    public void setup() {
        transactionsService = BackendFactory.getKoiosPreprodService().getTransactionsService();
    }

    @Test
    void getTransactionInformationTest() throws ApiException {
        String txHash = "b241c8c466c64ca7f7e33a3c4a0df5ce079a719b1c6a3b2dfe72780192235417";
        String txHash2 = "d22da668941e5898c925ddc7855806a625f051add869f503fe7a3b26a8e534ca";
        String txHash3 = "b003b29239ef68a897b6d0e0125589b22f46d621762684ef36c82cf1e20fa4a0";
        String txHash4 = "b8e6474c05b2de4b72e2938dad1a4da18689fee451a6c24b0ef28716c1a20969";
        Result<List<TxInfo>> transactionInformationResult = transactionsService.getTransactionInformation(List.of(txHash, txHash2, txHash3, txHash4), Options.EMPTY);
        Assertions.assertTrue(transactionInformationResult.isSuccessful());
        Assertions.assertNotNull(transactionInformationResult.getValue());
        log.info(transactionInformationResult.getValue().toString());
    }

    @Test
    void getTransactionInformation2Test() throws ApiException {
        String txHash = "b241c8c466c64ca7f7e33a3c4a0df5ce079a719b1c6a3b2dfe72780192235417";
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
        String txHash = "928613735664d63c27003fb9e517f956c838d19f641238c92a6e1a3a3361255c";
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
        String txHash = "b241c8c466c64ca7f7e33a3c4a0df5ce079a719b1c6a3b2dfe72780192235417";
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
