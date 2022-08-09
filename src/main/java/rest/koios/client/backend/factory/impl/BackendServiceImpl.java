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
import rest.koios.client.backend.api.base.BaseService;
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
        log.info("Koios URL: " + baseUrl);
        BaseService baseService = new BaseService(baseUrl);
        this.networkService = new NetworkServiceImpl(baseService);
        this.epochService = new EpochServiceImpl(baseService);
        this.blockService = new BlockServiceImpl(baseService);
        this.transactionsService = new TransactionsServiceImpl(baseService);
        this.addressService = new AddressServiceImpl(baseService);
        this.accountService = new AccountServiceImpl(baseService);
        this.assetService = new AssetServiceImpl(baseService);
        this.poolService = new PoolServiceImpl(baseService);
        this.scriptService = new ScriptServiceImpl(baseService);
    }

    /**
     * Backend Service Implementation Constructor
     *
     * @param operationType Operation Type
     */
    private BackendServiceImpl(OperationType operationType) {
        this(operationType, ApiVersion.VERSION_0);
    }

    /**
     * Backend Service Implementation Constructor
     *
     * @param operationType Operation Type
     * @param apiVersion    API Version
     */
    public BackendServiceImpl(OperationType operationType, ApiVersion apiVersion) {
        this(operationType.getBaseUrl()+apiVersion.getVersion()+"/");
    }
}
