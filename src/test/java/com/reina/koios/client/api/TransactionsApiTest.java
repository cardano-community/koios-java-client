package com.reina.koios.client.api;

import com.reina.koios.client.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for TransactionsApi
 */
public class TransactionsApiTest {

    private TransactionsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TransactionsApi.class);
    }


    /**
     * Transaction Information
     * <p>
     * Get detailed information about transaction(s)
     */
    @Test
    public void txInfoPostTest() {
        Object body = null;
        // TxInfo response = api.txInfoPost(body);

        // TODO: test validations
    }

    /**
     * Transaction Metadata
     * <p>
     * Get metadata information (if any) for given transaction(s)
     */
    @Test
    public void txMetadataPostTest() {
        Object body = null;
        // TxMetadata response = api.txMetadataPost(body);

        // TODO: test validations
    }

    /**
     * Transaction Metadata Labels
     * <p>
     * Get a list of all transaction metalabels
     */
    @Test
    public void txMetalabelsGetTest() {
        // TxMetalabels response = api.txMetalabelsGet();

        // TODO: test validations
    }

    /**
     * Transaction Status (Block Confirmations)
     * <p>
     * Get the number of block confirmations for a given transaction hash list
     */
    @Test
    public void txStatusPostTest() {
        Object body = null;
        // TxStatus response = api.txStatusPost(body);

        // TODO: test validations
    }

    /**
     * Transaction UTxOs
     * <p>
     * Get UTxO set (inputs/outputs) of transactions.
     */
    @Test
    public void txUtxosPostTest() {
        Object body = null;
        // TxUtxos response = api.txUtxosPost(body);

        // TODO: test validations
    }
}
