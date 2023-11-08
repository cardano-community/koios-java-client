package rest.koios.client.backend.factory.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
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
    private final AccountService accountService;
    private final AddressService addressService;
    private final AssetService assetService;
    private final PoolService poolService;
    private final ScriptService scriptService;

    /**
     * Backend Service Implementation Constructor
     *
     * @param baseUrl baseUrl
     */
    public BackendServiceImpl(String baseUrl) {
        this(baseUrl, null);
    }

    /**
     * Backend Service Implementation Constructor
     *
     * @param baseUrl baseUrl
     */
    public BackendServiceImpl(String baseUrl, String apiToken) {
        log.info("Koios URL: " + baseUrl);
        this.networkService = new NetworkServiceImpl(baseUrl, apiToken);
        this.epochService = new EpochServiceImpl(baseUrl, apiToken);
        this.blockService = new BlockServiceImpl(baseUrl, apiToken);
        this.transactionsService = new TransactionsServiceImpl(baseUrl, apiToken);
        this.accountService = new AccountServiceImpl(baseUrl, apiToken);
        this.addressService = new AddressServiceImpl(baseUrl, apiToken);
        this.assetService = new AssetServiceImpl(baseUrl, apiToken);
        this.poolService = new PoolServiceImpl(baseUrl, apiToken);
        this.scriptService = new ScriptServiceImpl(baseUrl, apiToken);
    }

    /**
     * Backend Service Implementation Constructor
     *
     * @param operationType Operation Type
     * @param apiVersion    API Version
     * @param apiToken      Authorization Bearer JWT Token
     */
    public BackendServiceImpl(OperationType operationType, ApiVersion apiVersion, String apiToken) {
        this(operationType.getBaseUrl() + apiVersion.getVersion() + "/", apiToken);
    }
}
