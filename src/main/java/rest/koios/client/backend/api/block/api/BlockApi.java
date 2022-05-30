package rest.koios.client.backend.api.block.api;

import rest.koios.client.backend.api.block.model.Block;
import rest.koios.client.backend.api.block.model.BlockInfo;
import rest.koios.client.backend.api.block.model.BlockTxHash;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Block API
 */
public interface BlockApi {

    @GET("blocks")
    Call<List<Block>> getBlockList(@QueryMap Map<String, String> paramsMap);

    @POST("block_info")
    Call<List<BlockInfo>> getBlockInformation(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    @GET("block_txs")
    Call<List<BlockTxHash>> getBlockTransactions(@Query("_block_hash") String blockHash, @QueryMap Map<String, String> paramsMap);
}
