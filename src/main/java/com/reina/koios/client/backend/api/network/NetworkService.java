package com.reina.koios.client.backend.api.network;

import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.api.network.model.Genesis;
import com.reina.koios.client.backend.api.network.model.Tip;
import com.reina.koios.client.backend.api.network.model.Totals;

public interface NetworkService {

    /**
     * Query Chain Tip
     * Get the tip info about the latest block seen by chain
     * <p><b>200</b> - Array of block summary (limit+paginated)
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @return Array of {@link Tip} block summary (limit+paginated)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Tip[] getChainTip() throws ApiException;

    /**
     * Get Genesis info
     * Get the Genesis parameters used to start specific era on chain
     * <p><b>200</b> - Array of genesis parameters used to start each era on chain
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @return Array of {@link Genesis} parameters used to start each era on chain
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Genesis[] getGenesisInfo() throws ApiException;

    /**
     * Get historical tokenomic stats
     * Get the circulating utxo, treasury, rewards, supply and reserves in lovelace for specified epoch, all epochs if empty
     * <p><b>200</b> - Array of supply/reserves/utxo/fees/treasury stats
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param epochNo Epoch Number to fetch details for (optional)
     * @return Array of {@link Totals} with supply/reserves/utxo/fees/treasury stats
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Totals[] getHistoricalTokenomicStats(Long epochNo) throws ApiException;
}
