package rest.koios.client.backend.api.pool;

import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.pool.model.*;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

/**
 * Pool Service
 */
public interface PoolService {

    /**
     * Pool List with Filtering, Pagination, Ordering Options
     * A list of all currently registered/retiring (not retired) pools
     * <p><b>200</b> - Array of pool IDs and tickers
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link Pool} IDs and tickers
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<Pool>> getPoolList(Options options) throws ApiException;

    /**
     * Pool Information with Filtering, Pagination, Ordering Options
     * Current pool statuses and details for a specified list of pool ids
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolIds List of Cardano pool IDs (bech32 format)
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolInfo}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolInfo>> getPoolInformation(List<String> poolIds, Options options) throws ApiException;

    /**
     * Pool Stake Snapshot with Filtering, Pagination, Ordering Options
     * Returns Mark, Set and Go stake snapshots for the selected pool, useful for leaderlog calculation
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param options    Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolStakeSnapshot}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolStakeSnapshot>> getPoolStakeSnapshot(String poolBech32, Options options) throws ApiException;

    /**
     * Pool Delegators List for Current Epoch with Filtering, Pagination, Ordering Options
     * Return information about delegators by a given pool
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param options    Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolDelegator}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolDelegator>> getPoolDelegatorsList(String poolBech32, Options options) throws ApiException;

    /**
     * Pool Delegators History
     * Return information about active delegators (incl. history) for a given pool and epoch number - current epoch if not provided.
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param epochNo    Epoch Number to fetch details for (optional)
     * @param options    Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolDelegatorHistory}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolDelegatorHistory>> getPoolDelegatorsHistory(String poolBech32, Integer epochNo, Options options) throws ApiException;

    /**
     * Pool Blocks by Epoch with Filtering, Pagination, Ordering Options
     * Return information about blocks minted by a given pool in a specific epoch
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param epochNo    Epoch Number to fetch details for (required)
     * @param options    Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolBlock}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolBlock>> getPoolBlocksByEpoch(String poolBech32, Integer epochNo, Options options) throws ApiException;

    /**
     * Pool Blocks with Filtering, Pagination, Ordering Options
     * Return information about blocks minted by a given pool in current epoch
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param options    Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolBlock}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolBlock>> getPoolBlocks(String poolBech32, Options options) throws ApiException;

    /**
     * Pool Stake, Block and Reward History by Epoch with Filtering, Pagination, Ordering Options
     * Return information about pool stake, block and reward history in a given epoch _epoch_no (or all epochs that pool existed for, in descending order if no _epoch_no was provided)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param epochNo    Epoch Number to fetch details for (required)
     * @param options    Filtering and Pagination options (optional)
     * @return Result of {@link PoolHistory}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<PoolHistory> getPoolHistoryByEpoch(String poolBech32, Integer epochNo, Options options) throws ApiException;

    /**
     * Pool Stake, Block and Reward History with Filtering, Pagination, Ordering Options
     * Return information about pool stake, block and reward history in a given epoch _epoch_no (or all epochs that pool existed for, in descending order if no _epoch_no was provided)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param options    Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolHistory}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolHistory>> getPoolHistory(String poolBech32, Options options) throws ApiException;

    /**
     * Pool Updates (History) for specific pool with Filtering, Pagination, Ordering Options
     * Return all pool updates for specified pool
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format
     * @param options    Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolUpdate}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolUpdate>> getPoolUpdatesByPoolBech32(String poolBech32, Options options) throws ApiException;

    /**
     * Pool Updates (History) with Filtering, Pagination, Ordering Options
     * Return all pool updates for all pools or only updates for specific pool if specified
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolUpdate}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolUpdate>> getPoolUpdates(Options options) throws ApiException;

    /**
     * Pool Relays with Filtering, Pagination, Ordering Options
     * A list of registered relays for all currently registered/retiring (not retired) pools
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolRelay}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolRelay>> getPoolRelays(Options options) throws ApiException;

    /**
     * Pool Metadata with Filtering, Pagination, Ordering Options
     * Metadata(on &amp; off-chain) for all currently registered/retiring (not retired) pools
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolMetadata}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolMetadata>> getPoolMetadata(Options options) throws ApiException;

    /**
     * Pool Metadata by Pool Ids with Filtering, Pagination, Ordering Options
     * Metadata(on &amp; off-chain) for all currently registered/retiring (not retired) pools
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolIds Pool Bech32 Ids List (optional)
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolMetadata}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolMetadata>> getPoolMetadata(List<String> poolIds, Options options) throws ApiException;
}
