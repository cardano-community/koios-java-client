package rest.koios.client.backend.api.block;

import rest.koios.client.backend.api.TxHash;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.block.model.Block;
import rest.koios.client.backend.api.block.model.BlockInfo;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

/**
 * Block Service
 */
public interface BlockService {

    /**
     * Block List
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
     * @return Result of Type List of {@link BlockInfo} of a specific block
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<BlockInfo>> getBlockInformation(String blockHash) throws ApiException;

    /**
     * Block Transactions
     * Get a list of all transactions included in a provided block
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param blockHash Block Hash in hex format (required)
     * @return Result of Type List of {@link TxHash} Included Transaction of a specific block
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<TxHash>> getBlockTransactions(String blockHash) throws ApiException;
}
