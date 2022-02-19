package rest.koios.client.backend.api.block.impl;

import rest.koios.client.backend.api.TxHash;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.block.BlockService;
import rest.koios.client.backend.api.block.api.BlockApi;
import rest.koios.client.backend.api.block.model.Block;
import rest.koios.client.backend.api.block.model.BlockInfo;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Block Service Implementation
 */
public class BlockServiceImpl extends BaseService implements BlockService {

    private final BlockApi blockApi;

    /**
     * Block Service Implementation Constructor
     *
     * @param baseUrl Base URL
     */
    public BlockServiceImpl(String baseUrl) {
        super(baseUrl);
        blockApi = getRetrofit().create(BlockApi.class);
    }

    @Override
    public Result<List<Block>> getBlockList(Options options) throws ApiException {
        Call<List<Block>> call = blockApi.getBlockList(options.toMap());
        try {
            Response<List<Block>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<BlockInfo>> getBlockInformation(String blockHash) throws ApiException {
        validateHexFormat(blockHash);
        Call<List<BlockInfo>> call = blockApi.getBlockInformation(blockHash);
        try {
            Response<List<BlockInfo>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<TxHash>> getBlockTransactions(String blockHash) throws ApiException {
        validateHexFormat(blockHash);
        Call<List<TxHash>> call = blockApi.getBlockTransactions(blockHash);
        try {
            Response<List<TxHash>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }
}
