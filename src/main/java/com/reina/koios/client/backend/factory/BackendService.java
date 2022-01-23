package com.reina.koios.client.backend.factory;

import com.reina.koios.client.backend.api.block.BlockService;
import com.reina.koios.client.backend.api.epoch.EpochService;
import com.reina.koios.client.backend.api.network.NetworkService;
import com.reina.koios.client.backend.api.transactions.TransactionsService;

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

//    /**
//     * Get Address Service
//     * @return {@link AddressService}
//     */
//    AddressService getAddressService();
//
//    /**
//     * Get Account Service
//     * @return {@link AccountService}
//     */
//    AccountService getAccountService();
//
//    /**
//     * Get Asset Service
//     * @return {@link AssetService}
//     */
//    AssetService getAssetService();
//
//    /**
//     * Get Pool Service
//     * @return {@link PoolService}
//     */
//    PoolService getPoolService();
//
//    /**
//     * Get Script Service
//     * @return {@link ScriptService}
//     */
//    ScriptService getScriptService();
}
