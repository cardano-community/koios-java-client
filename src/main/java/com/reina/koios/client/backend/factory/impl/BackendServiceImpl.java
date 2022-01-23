package com.reina.koios.client.backend.factory.impl;

import com.reina.koios.client.backend.api.address.AddressService;
import com.reina.koios.client.backend.api.address.impl.AddressServiceImpl;
import com.reina.koios.client.backend.api.block.BlockService;
import com.reina.koios.client.backend.api.block.impl.BlockServiceImpl;
import com.reina.koios.client.backend.api.epoch.EpochService;
import com.reina.koios.client.backend.api.epoch.impl.EpochServiceImpl;
import com.reina.koios.client.backend.api.network.NetworkService;
import com.reina.koios.client.backend.api.network.impl.NetworkServiceImpl;
import com.reina.koios.client.backend.api.transactions.TransactionsService;
import com.reina.koios.client.backend.api.transactions.impl.TransactionsServiceImpl;
import com.reina.koios.client.backend.factory.BackendService;
import com.reina.koios.client.backend.factory.OperationType;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.resolver.DefaultAddressResolverGroup;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Data
@Slf4j
public class BackendServiceImpl implements BackendService {

    private final NetworkService networkService;
    private final EpochService epochService;
    private final BlockService blockService;
    private final TransactionsService transactionsService;
    private final AddressService addressService;

    public BackendServiceImpl(String baseUrl) {
        this(OperationType.CUSTOM_RPC, baseUrl);
    }

    public BackendServiceImpl(OperationType operationType) {
        this(operationType, operationType.getBaseUrl());
    }

    private BackendServiceImpl(OperationType operationType, String baseUrl) {
        if (operationType != OperationType.CUSTOM_RPC) {
            log.info("Koios URL: " + operationType.getBaseUrl());
        } else {
            log.info("Custom RPC URL: " + operationType.getBaseUrl());
        }
        WebClient webClient = createWebClient(baseUrl);
        this.networkService = new NetworkServiceImpl(operationType, webClient);
        this.epochService = new EpochServiceImpl(operationType, webClient);
        this.blockService = new BlockServiceImpl(operationType, webClient);
        this.transactionsService = new TransactionsServiceImpl(operationType, webClient);
        this.addressService = new AddressServiceImpl(operationType, webClient);
    }

    @SneakyThrows
    private WebClient createWebClient(String baseUrl) {
        WebClient.Builder webClientBuilder = WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer
                                .defaultCodecs()
                                .maxInMemorySize(16 * 1024 * 1024))
                        .build());
        if (baseUrl.contains("https")) {
            SslContext context = SslContextBuilder.forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    .build();
            HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(context)).resolver(DefaultAddressResolverGroup.INSTANCE);
            webClientBuilder.clientConnector(new ReactorClientHttpConnector(httpClient));
        }
        return webClientBuilder.build();
    }
}
