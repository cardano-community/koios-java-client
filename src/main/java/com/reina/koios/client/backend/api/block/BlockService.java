package com.reina.koios.client.backend.api.block;

import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.block.model.Block;
import com.reina.koios.client.backend.api.block.model.BlockInfo;
import com.reina.koios.client.backend.api.TxHash;

public interface BlockService {

    /**
     * Block List
     * Get summarised details about all blocks (paginated - latest first)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @return Array of detailed summary of every {@link Block}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Block[] getBlockList() throws ApiException;

    /**
     * Block Information
     * Get detailed information about a specific block
     * <p><b>200</b> - Array of detailed information of a specific block
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param blockHash Block Hash in hex format (required)
     * @return Array of {@link BlockInfo} of a specific block
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    BlockInfo[] getBlockInformation(String blockHash) throws ApiException;

    /**
     * Block Transactions
     * Get a list of all transactions included in a provided block
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param blockHash Block Hash in hex format (required)
     * @return Array of {@link TxHash} Included Transaction of a specific block
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    TxHash[] getBlockTransactions(String blockHash) throws ApiException;
}
