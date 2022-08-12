package rest.koios.client.backend.api.network;

import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.network.model.Genesis;
import rest.koios.client.backend.api.network.model.Tip;
import rest.koios.client.backend.api.network.model.Totals;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

/**
 * Network Service
 */
public interface NetworkService {

    /**
     * Query Chain Tip
     * Get the tip info about the latest block seen by chain
     * <p><b>200</b> - Array of block summary (limit+paginated)
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @return Result of {@link Tip} block summary
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<Tip> getChainTip() throws ApiException;

    /**
     * Get Genesis info
     * Get the Genesis parameters used to start specific era on chain
     * <p><b>200</b> - Array of genesis parameters used to start each era on chain
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @return Result of {@link Genesis} parameters used to start each era on chain
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<Genesis> getGenesisInfo() throws ApiException;

    /**
     * Get historical tokenomic stats By Epoch
     * Get the circulating utxo, treasury, rewards, supply and reserves in lovelace for specified epoch, all epochs if empty
     * <p><b>200</b> - Array of supply/reserves/utxo/fees/treasury stats
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param epochNo Epoch Number to fetch details for (optional)
     * @return Result of {@link Totals} with supply/reserves/utxo/fees/treasury stats
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<Totals> getHistoricalTokenomicStatsByEpoch(Integer epochNo) throws ApiException;

    /**
     * Get historical tokenomic stats with Filtering, Pagination, Ordering Options
     * Get the circulating utxo, treasury, rewards, supply and reserves in lovelace for specified epoch, all epochs if empty
     * <p><b>200</b> - Array of supply/reserves/utxo/fees/treasury stats
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link Totals} with supply/reserves/utxo/fees/treasury stats
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<Totals>> getHistoricalTokenomicStats(Options options) throws ApiException;
}
