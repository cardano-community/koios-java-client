package com.reina.koios.client.backend.api.block.impl;

import com.reina.koios.client.backend.api.TxHash;
import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.block.BlockService;
import com.reina.koios.client.backend.api.block.model.Block;
import com.reina.koios.client.backend.api.block.model.BlockInfo;
import com.reina.koios.client.backend.factory.OperationType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class BlockServiceImpl extends BaseService implements BlockService {

    public BlockServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public Block[] getBlockList() throws ApiException {
        try {
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/blocks").build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Block[].class)
                    .timeout(getTimeoutDuration())
                    .block();
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public BlockInfo[] getBlockInformation(String blockHash) throws ApiException {
        if (!blockHash.matches("^[0-9a-fA-F]+$")) {
            throw new ApiException("Invalid Hexadecimal String Format", HttpStatus.BAD_REQUEST);
        }
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
        if (!blockHash.matches("^[0-9a-fA-F]+$")) {
            throw new ApiException("Invalid Hexadecimal String Format", HttpStatus.BAD_REQUEST);
        }
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
