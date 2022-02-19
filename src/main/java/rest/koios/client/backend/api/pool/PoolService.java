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
     * Pool List
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
     * Pool Information
     * Current pool statuses and details for a specified list of pool ids
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolIds List of Cardano pool IDs (bech32 format)
     * @return Result of Type List of {@link PoolInfo}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolInfo>> getPoolInformation(List<String> poolIds) throws ApiException;

    /**
     * Pool Delegators List
     * Return information about delegators by a given pool and optional epoch (current if omitted)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param epochNo    Epoch Number to fetch details for
     * @return Result of Type List of {@link PoolDelegator}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolDelegator>> getPoolDelegatorsList(String poolBech32, Long epochNo) throws ApiException;

    /**
     * Pool Delegators List
     * Return information about delegators by a given pool and optional epoch (current if omitted)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolDelegator}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolDelegator>> getPoolDelegatorsList(String poolBech32, Options options) throws ApiException;

    /**
     * Pool Blocks
     * Return information about blocks minted by a given pool in current epoch (or _epoch_no if provided)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param epochNo    Epoch Number to fetch details for
     * @return Result of Type List of {@link PoolBlock}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolBlock>> getPoolBlocks(String poolBech32, Long epochNo) throws ApiException;

    /**
     * Pool Blocks
     * Return information about blocks minted by a given pool in current epoch (or _epoch_no if provided)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PoolBlock}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolBlock>> getPoolBlocks(String poolBech32, Options options) throws ApiException;

    /**
     * Pool Updates (History)
     * Return all pool updates for all pools or only updates for specific pool if specified
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format
     * @return Result of Type List of {@link PoolUpdate}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolUpdate>> getPoolUpdates(String poolBech32) throws ApiException;

    /**
     * Pool Updates (History)
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
     * Pool Relays
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
     * Pool Metadata
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
}
