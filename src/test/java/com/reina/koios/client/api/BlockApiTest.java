package com.reina.koios.client.api;

import com.reina.koios.client.ApiClient;
import org.junit.Before;
import org.junit.Test;


/**
 * API tests for BlockApi
 */
public class BlockApiTest {

    private BlockApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(BlockApi.class);
    }


    /**
     * Block Information
     * <p>
     * Get detailed information about a specific block
     */
    @Test
    public void blockInfoGetTest() {
        String _blockHash = null;
        // Void response = api.blockInfoGet(_blockHash);

        // TODO: test validations
    }

    /**
     * Block Transactions
     * <p>
     * Get a list of all transactions included in a provided block
     */
    @Test
    public void blockTxsGetTest() {
        String _blockHash = null;
        // Void response = api.blockTxsGet(_blockHash);

        // TODO: test validations
    }

    /**
     * Block List
     * <p>
     * Get summarised details about all blocks (paginated - latest first)
     */
    @Test
    public void blocksGetTest() {
        // Void response = api.blocksGet();

        // TODO: test validations
    }
}
