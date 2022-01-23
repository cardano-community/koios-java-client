package com.reina.koios.client.backend.api.transactions;

import com.reina.koios.client.backend.api.transactions.model.*;

import java.util.List;

public interface TransactionsService {

    /**
     * Transaction Information
     * Get detailed information about transaction(s)
     * <p><b>200</b> - Array of detailed information about transaction(s)
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param txHashes (optional)
     * @return Array of {@link TxInfo} detailed information about transaction(s)
     */
    TxInfo[] getTransactionInformation(List<String> txHashes);

    /**
     * Transaction UTxOs
     * Get UTxO set (inputs/outputs) of transactions.
     * <p><b>200</b> - Array of inputs and outputs for given transaction(s)
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param txHashes (optional)
     * @return Array of {@link TxUtxo} inputs and outputs for given transaction(s)
     */
    TxUtxo[] getTransactionUTxOs(List<String> txHashes);

    /**
     * Transaction Metadata
     * Get metadata information (if any) for given transaction(s)
     * <p><b>200</b> - Array of metadata information present in each of the transactions queried
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param txHashes (optional)
     * @return Array of {@link TxMetadata} information present in each of the transactions queried
     */
    TxMetadata[] getTransactionMetadata(List<String> txHashes);

    /**
     * Transaction Metadata Labels
     * Get a list of all transaction metalabels
     * <p><b>200</b> - Array of known metadata labels
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @return Array of known {@link TxMetadataLabels}
     */
    TxMetadataLabels[] getTransactionMetadataLabels();

    /**
     * Transaction Status (Block Confirmations)
     * Get the number of block confirmations for a given transaction hash list
     * <p><b>200</b> - Array of transaction confirmation counts
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param txHashes (optional)
     * @return Array of transaction confirmation counts {@link TxStatus}
     */
    TxStatus[] getTransactionStatus(List<String> txHashes);
}
