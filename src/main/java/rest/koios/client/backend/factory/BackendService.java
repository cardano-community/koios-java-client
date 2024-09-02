package rest.koios.client.backend.factory;

import rest.koios.client.backend.api.account.AccountService;
import rest.koios.client.backend.api.address.AddressService;
import rest.koios.client.backend.api.asset.AssetService;
import rest.koios.client.backend.api.block.BlockService;
import rest.koios.client.backend.api.epoch.EpochService;
import rest.koios.client.backend.api.governance.GovernanceService;
import rest.koios.client.backend.api.network.NetworkService;
import rest.koios.client.backend.api.pool.PoolService;
import rest.koios.client.backend.api.script.ScriptService;
import rest.koios.client.backend.api.transactions.TransactionsService;

/**
 * Backend Service
 */
public interface BackendService {

    /**
     * Get Network Service
     *
     * @return {@link NetworkService}
     */
    NetworkService getNetworkService();

    /**
     * Get Epoch Service
     * @return {@link EpochService}
     */
    EpochService getEpochService();

    /**
     * Get Block Service
     * @return {@link BlockService}
     */
    BlockService getBlockService();

    /**
     * Get Transactions Service
     * @return {@link TransactionsService}
     */
    TransactionsService getTransactionsService();

    /**
     * Get Address Service
     * @return {@link AddressService}
     */
    AddressService getAddressService();

    /**
     * Get Account Service
     * @return {@link AccountService}
     */
    AccountService getAccountService();

    /**
     * Get Asset Service
     * @return {@link AssetService}
     */
    AssetService getAssetService();

    /**
     * Get Pool Service
     * @return {@link PoolService}
     */
    PoolService getPoolService();

    /**
     * Get Script Service
     * @return {@link ScriptService}
     */
    ScriptService getScriptService();

    /**
     * Get Governance Service
     * @return {@link GovernanceService}
     */
    GovernanceService getGovernanceService();
}
