package rest.koios.client.backend.api.block.impl;

import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.block.api.BlockApi;
import rest.koios.client.backend.api.block.BlockService;
import rest.koios.client.backend.api.block.model.Block;
import rest.koios.client.backend.api.block.model.BlockInfo;
import rest.koios.client.backend.api.block.model.BlockTxHash;
import rest.koios.client.backend.api.transactions.model.TxInfo;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.*;

/**
 * Block Service Implementation
 */
public class BlockServiceImpl extends BaseService implements BlockService {

    private final BlockApi blockApi;

    /**
     * Block Service Implementation Constructor
     *
     * @param baseUrl Base Url
     * @param apiToken Authorization Bearer JWT Token
     */
    public BlockServiceImpl(String baseUrl, String apiToken) {
        super(baseUrl, apiToken);
        blockApi = getRetrofit().create(BlockApi.class);
    }

    @Override
    public Result<Block> getLatestBlock() throws ApiException {
        Options options = Options.builder().option(Limit.of(1)).build();
        Call<List<Block>> call = blockApi.getBlockList(optionsToParamMap(options));
        try {
            Response<List<Block>> response = (Response) execute(call);
            return processResponseGetOne(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<Block>> getBlockList(Options options) throws ApiException {
        Call<List<Block>> call = blockApi.getBlockList(optionsToParamMap(options));
        try {
            Response<List<Block>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<BlockInfo> getBlockInformation(String blockHash) throws ApiException {
        validateHexFormat(blockHash);
        Call<List<BlockInfo>> call = blockApi.getBlockInformation(buildBody(List.of(blockHash)), Collections.emptyMap());
        try {
            Response<List<BlockInfo>> response = (Response) execute(call);
            return processResponseGetOne(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<BlockInfo>> getBlocksInformation(List<String> blockHashes, Options options) throws ApiException {
        for (String blockHash : blockHashes) {
            validateHexFormat(blockHash);
        }
        Call<List<BlockInfo>> call = blockApi.getBlockInformation(buildBody(blockHashes), optionsToParamMap(options));
        try {
            Response<List<BlockInfo>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<BlockTxHash>> getBlockTransactions(List<String> blockHashes, Options options) throws ApiException {
        for (String blockHash : blockHashes) {
            validateHexFormat(blockHash);
        }
        Call<List<BlockTxHash>> call = blockApi.getBlockTransactions(buildBody(blockHashes), optionsToParamMap(options));
        try {
            Response<List<BlockTxHash>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<TxInfo>> getBlockTransactionsInfo(List<String> blockHashes, Boolean inputs, Boolean metadata, Boolean assets, Boolean withdrawals, Boolean certs, Boolean scripts, Options options) throws ApiException {
        for (String blockHash : blockHashes) {
            validateHexFormat(blockHash);
        }
        Call<List<TxInfo>> call = blockApi.getBlockTransactionsInfo(buildBodyBlockTxInfo(blockHashes, inputs, metadata, assets, withdrawals, certs, scripts), optionsToParamMap(options));
        try {
            Response<List<TxInfo>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    private Map<String, Object> buildBodyBlockTxInfo(List<String> blockHashes, Boolean inputs, Boolean metadata, Boolean assets, Boolean withdrawals, Boolean certs, Boolean scripts) {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("_block_hashes", blockHashes);
        bodyMap.put("_inputs", Optional.ofNullable(inputs).orElse(false));
        bodyMap.put("_metadata", Optional.ofNullable(metadata).orElse(false));
        bodyMap.put("_assets", Optional.ofNullable(assets).orElse(false));
        bodyMap.put("_withdrawals", Optional.ofNullable(withdrawals).orElse(false));
        bodyMap.put("_certs", Optional.ofNullable(certs).orElse(false));
        bodyMap.put("_scripts", Optional.ofNullable(scripts).orElse(false));
        return bodyMap;
    }

    private Map<String, Object> buildBody(List<String> blockHashes) {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("_block_hashes", blockHashes);
        return bodyMap;
    }
}
