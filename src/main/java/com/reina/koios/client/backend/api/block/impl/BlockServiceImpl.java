package com.reina.koios.client.backend.api.block.impl;

import com.reina.koios.client.backend.api.TxHash;
import com.reina.koios.client.backend.api.base.BaseService;
import com.reina.koios.client.backend.api.block.BlockService;
import com.reina.koios.client.backend.api.block.model.Block;
import com.reina.koios.client.backend.api.block.model.BlockInfo;
import com.reina.koios.client.backend.factory.OperationType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class BlockServiceImpl extends BaseService implements BlockService {

    public BlockServiceImpl(OperationType operationType, WebClient webClient) {
        super(operationType, webClient);
    }

    @Override
    public Block[] getBlockList() {
        return (Block[]) getWebClient().get()
                .uri("/blocks")
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(Block[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public BlockInfo[] getBlockInformation(String blockHash) {
        return (BlockInfo[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/block_info").queryParam("_block_hash", blockHash).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(BlockInfo[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }

    @Override
    public TxHash[] getBlockTransactions(String blockHash) {
        return (TxHash[]) getWebClient().get()
                .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + "/block_txs").queryParam("_block_hash", blockHash).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        return clientResponse.bodyToMono(TxHash[].class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                }).timeout(getTimeoutDuration())
                .block();
    }
}
