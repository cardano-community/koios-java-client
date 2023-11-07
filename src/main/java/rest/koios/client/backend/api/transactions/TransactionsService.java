package rest.koios.client.backend.api.transactions;

import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.transactions.model.*;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

/**
 * Transaction Service
 */
public interface TransactionsService {

    /**
     * UTxO Info
     * Get UTxO set for requested UTxO references
     * <p><b>200</b> - List of UTxO details
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param utxoRefs List of Cardano utxo references in the form "hash#index"
     * @return Result of Type List of {@link TxInfo} detailed information about transaction(s)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<UTxO>> getUTxOInfo(List<String> utxoRefs, boolean extended) throws ApiException;


    /**
     * Transaction Information for Specific Transaction
     * Get detailed information about transaction
     * <p><b>200</b> - detailed information about a transaction
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param txHash Cardano Transaction hash
     * @return Result of Type List of {@link TxInfo} detailed information about transaction(s)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<TxInfo> getTransactionInformation(String txHash) throws ApiException;

    /**
     * Transaction Information
     * Get detailed information about transaction(s)
     * <p><b>200</b> - Array of detailed information about transaction(s)
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param txHashes List of Cardano Transaction hashes
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link TxInfo} detailed information about transaction(s)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<TxInfo>> getTransactionInformation(List<String> txHashes, Options options) throws ApiException;

    /**
     * Transaction Metadata
     * Get metadata information (if any) for given transaction(s)
     * <p><b>200</b> - Array of metadata information present in each of the transactions queried
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param txHashes List of Cardano Transaction hashes
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link TxMetadata} information present in each of the transactions queried
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<TxMetadata>> getTransactionMetadata(List<String> txHashes, Options options) throws ApiException;

    /**
     * Transaction Metadata Labels with Filtering, Pagination, Ordering Options
     * Get a list of all transaction metadata labels
     * <p><b>200</b> - Array of known metadata labels
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of known {@link TxMetadataLabels}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<TxMetadataLabels>> getTransactionMetadataLabels(Options options) throws ApiException;

    /**
     * Submit Transaction
     * Submit an already serialized transaction to the network.
     * <p><b>202</b> - OK
     * <p><b>400</b> - An error occurred while submitting transaction.
     *
     * @param cborData (optional)
     * @return Result of Transaction Id (Hex String)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<String> submitTx(byte[] cborData) throws ApiException;

    /**
     * Transaction Status (Block Confirmations)
     * Get the number of block confirmations for a given transaction hash list
     * <p><b>200</b> - Array of transaction confirmation counts
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param txHashes List of Cardano Transaction hashes
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of transaction confirmation counts {@link TxStatus}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<TxStatus>> getTransactionStatus(List<String> txHashes, Options options) throws ApiException;
}
