package rest.koios.client.backend.api.block.impl;

import rest.koios.client.backend.api.TxHash;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.block.BlockService;
import rest.koios.client.backend.api.block.model.Block;
import rest.koios.client.backend.api.block.model.BlockInfo;
import rest.koios.client.backend.factory.OperationType;
import rest.koios.client.backend.factory.options.Options;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * Block Service Implementation
 */
public class BlockServiceImpl extends BaseService implements BlockService {

    /**
     * Block Service Implementation Constructor
     *
     * @param operationType Operation Type
     * @param webClient     webClient
     */
    public BlockServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public Block[] getBlockList(Options options) throws ApiException {
        try {
            return (Block[]) sendGetRequest("/blocks", options, Block[].class);
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public BlockInfo[] getBlockInformation(String blockHash) throws ApiException {
        validateHexFormat(blockHash);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/block_info")
                            .queryParam("_block_hash", blockHash).build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(BlockInfo[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public TxHash[] getBlockTransactions(String blockHash) throws ApiException {
        validateHexFormat(blockHash);
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/block_txs")
                            .queryParam("_block_hash", blockHash).build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(TxHash[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
