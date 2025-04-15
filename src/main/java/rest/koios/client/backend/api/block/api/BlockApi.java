package rest.koios.client.backend.api.block.api;

import rest.koios.client.backend.api.block.model.Block;
import rest.koios.client.backend.api.block.model.BlockInfo;
import rest.koios.client.backend.api.block.model.BlockTxCbor;
import rest.koios.client.backend.api.block.model.BlockTxHash;
import rest.koios.client.backend.api.transactions.model.TxInfo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * Block API
 */
public interface BlockApi {

    /**
     * Get summarised details about all blocks (paginated - latest first)
     *
     * @param paramsMap Options and Filters Map
     * @return List of {@link Block}
     */
    @GET("blocks")
    Call<List<Block>> getBlockList(@QueryMap Map<String, String> paramsMap);

    /**
     * Get detailed information about a specific block
     *
     * @param requestBody Array of Block Hash IDs
     * @param paramsMap   Options and Filters Map
     * @return List of {@link BlockInfo}
     */
    @POST("block_info")
    Call<List<BlockInfo>> getBlockInformation(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * Get a list of all transactions included in provided blocks
     *
     * @param requestBody Array of Block Hash IDs
     * @param paramsMap   Options and Filters Map
     * @return List of {@link BlockTxHash}
     */
    @POST("block_txs")
    Call<List<BlockTxHash>> getBlockTransactions(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * Get raw CBOR data for all transaction(s) within requested blocks
     *
     * @param requestBody Array of Block Hash IDs
     * @param paramsMap   Options and Filters Map
     * @return List of {@link BlockTxCbor}
     */
    @POST("block_tx_cbor")
    Call<List<BlockTxCbor>> getBlockTransactionsCbor(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * Get a list of all transactions included in provided blocks
     *
     * @param requestBody Array of Block Hash IDs
     * @param paramsMap   Options and Filters Map
     * @return List of {@link BlockTxHash}
     */
    @POST("block_tx_info")
    @Deprecated
    Call<List<TxInfo>> getBlockTransactionsInfo(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);
}
