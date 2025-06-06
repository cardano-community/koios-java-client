package rest.koios.client.backend.api.block;

import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.block.model.Block;
import rest.koios.client.backend.api.block.model.BlockInfo;
import rest.koios.client.backend.api.block.model.BlockTxCbor;
import rest.koios.client.backend.api.block.model.BlockTxHash;
import rest.koios.client.backend.api.transactions.model.TxInfo;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

/**
 * Block Service
 */
public interface BlockService {

    /**
     * Latest Block
     * Get summarised details about the latest block
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @return Result of detailed summary of latest {@link Block}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<Block> getLatestBlock() throws ApiException;

    /**
     * Block List with Filtering, Pagination, Ordering Options
     * Get summarised details about all blocks (paginated - latest first)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of detailed summary of every {@link Block}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<Block>> getBlockList(Options options) throws ApiException;

    /**
     * Block Information
     * Get detailed information about a specific block
     * <p><b>200</b> - Array of detailed information of a specific block
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param blockHash Block Hash in hex format (required)
     * @return Result of {@link BlockInfo} of a specific block
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<BlockInfo> getBlockInformation(String blockHash) throws ApiException;

    /**
     * Block Information with Filtering, Pagination, Ordering Options
     * Get detailed information about specific block hashes
     * <p><b>200</b> - Array of detailed information of a specific block
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param blockHashes List of Block Hashes in hex format (required)
     * @param options Filtering and Pagination options (optional)
     * @return Result of {@link BlockInfo} of a specific block
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<BlockInfo>> getBlocksInformation(List<String> blockHashes, Options options) throws ApiException;

    /**
     * Block Transactions with Filtering, Pagination, Ordering Options
     * Get a list of all transactions included in provided blocks
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param blockHashes List of Block Hashes in hex format (required)
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link BlockTxHash} Included Transaction of a specific block
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<BlockTxHash>> getBlockTransactions(List<String> blockHashes, Options options) throws ApiException;

    /**
     * Block Transactions (Raw CBOR)
     * Get raw CBOR data for all transaction(s) within requested blocks
     *
     * @param blockHashes List of Block Hashes in hex format (required)
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link BlockTxCbor} Included Transaction of a specific block
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<BlockTxCbor>> getBlockTransactionsCbor(List<String> blockHashes, Options options) throws ApiException;

    /**
     * Block Transactions (Detailed Info)
     * Get detailed information about transaction(s) for requested blocks
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param blockHashes List of Block Hashes in hex format (required)
     * @param inputs Controls whether to include transaction inputs in the result
     * @param metadata Controls whether to include transaction metadata in the result
     * @param assets Controls whether to include assets involved within transaction the result
     * @param withdrawals Controls whether to include any stake account reward withdrawals in the
     * @param certs Controls whether to include transaction certificates in the result
     * @param scripts Controls whether to include any details regarding collateral/reference/datum/script objects in the result
     * @param byteCode Controls whether to include bytecode for associated reference/plutus scripts
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link TxInfo} Included Transactions of a specific block
     * @throws ApiException if an error occurs while attempting to invoke the API
     *
     */
    @Deprecated
    Result<List<TxInfo>> getBlockTransactionsInfo(List<String> blockHashes, Boolean inputs, Boolean metadata, Boolean assets,
                                                 Boolean withdrawals, Boolean certs, Boolean scripts, Boolean byteCode, Options options) throws ApiException;
}
