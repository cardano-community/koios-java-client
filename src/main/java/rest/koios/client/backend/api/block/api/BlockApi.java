package rest.koios.client.backend.api.block.api;

import rest.koios.client.backend.api.TxHash;
import rest.koios.client.backend.api.block.model.Block;
import rest.koios.client.backend.api.block.model.BlockInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * Block API
 */
public interface BlockApi {

    @GET("blocks")
    Call<List<Block>> getBlockList(@QueryMap Map<String, String> paramsMap);

    @GET("block_info")
    Call<List<BlockInfo>> getBlockInformation(@Query("_block_hash") String blockHash);

    @GET("block_txs")
    Call<List<TxHash>> getBlockTransactions(@Query("_block_hash") String blockHash, @QueryMap Map<String, String> paramsMap);
}
