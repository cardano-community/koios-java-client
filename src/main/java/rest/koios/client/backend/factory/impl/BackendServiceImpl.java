package rest.koios.client.backend.factory.impl;

import rest.koios.client.backend.api.account.AccountService;
import rest.koios.client.backend.api.account.impl.AccountServiceImpl;
import rest.koios.client.backend.api.address.AddressService;
import rest.koios.client.backend.api.address.impl.AddressServiceImpl;
import rest.koios.client.backend.api.asset.AssetService;
import rest.koios.client.backend.api.asset.impl.AssetServiceImpl;
import rest.koios.client.backend.api.block.BlockService;
import rest.koios.client.backend.api.block.impl.BlockServiceImpl;
import rest.koios.client.backend.api.epoch.EpochService;
import rest.koios.client.backend.api.epoch.impl.EpochServiceImpl;
import rest.koios.client.backend.api.network.NetworkService;
import rest.koios.client.backend.api.network.impl.NetworkServiceImpl;
import rest.koios.client.backend.api.pool.PoolService;
import rest.koios.client.backend.api.pool.impl.PoolServiceImpl;
import rest.koios.client.backend.api.script.ScriptService;
import rest.koios.client.backend.api.script.impl.ScriptServiceImpl;
import rest.koios.client.backend.api.transactions.TransactionsService;
import rest.koios.client.backend.api.transactions.impl.TransactionsServiceImpl;
import rest.koios.client.backend.factory.ApiVersion;
import rest.koios.client.backend.factory.BackendService;
import rest.koios.client.backend.factory.OperationType;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.resolver.DefaultAddressResolverGroup;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

/**
 * Backend Service Implementation
 */
@Getter
@Setter
@Slf4j
public class BackendServiceImpl implements BackendService {

    private final NetworkService networkService;
    private final EpochService epochService;
    private final BlockService blockService;
    private final TransactionsService transactionsService;
    private final AddressService addressService;
    private final AccountService accountService;
    private final AssetService assetService;
    private final PoolService poolService;
    private final ScriptService scriptService;

    /**
     * Backend Service Implementation Constructor
     *
     * @param baseUrl baseUrl
     */
    public BackendServiceImpl(String baseUrl) {
        this(OperationType.CUSTOM_RPC, baseUrl);
    }

    /**
     * Backend Service Implementation Constructor
     *
     * @param operationType Operation Type
     * @param apiVersion    API Version
     */
    public BackendServiceImpl(OperationType operationType, ApiVersion apiVersion) {
        this(operationType, operationType.getBaseUrl() + apiVersion.getVersion());
    }

    /**
     * Backend Service Implementation Constructor
     *
     * @param operationType Operation Type
     * @param baseUrl       baseUrl
     */
    private BackendServiceImpl(OperationType operationType, String baseUrl) {
        if (operationType != OperationType.CUSTOM_RPC) {
            log.info("Koios URL: " + operationType.getBaseUrl());
        } else {
            log.info("Custom RPC URL: " + baseUrl);
        }
        WebClient webClient = createWebClient(baseUrl);
        this.networkService = new NetworkServiceImpl(operationType, webClient);
        this.epochService = new EpochServiceImpl(operationType, webClient);
        this.blockService = new BlockServiceImpl(operationType, webClient);
        this.transactionsService = new TransactionsServiceImpl(operationType, webClient);
        this.addressService = new AddressServiceImpl(operationType, webClient);
        this.accountService = new AccountServiceImpl(operationType, webClient);
        this.assetService = new AssetServiceImpl(operationType, webClient);
        this.poolService = new PoolServiceImpl(operationType, webClient);
        this.scriptService = new ScriptServiceImpl(operationType, webClient);
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
