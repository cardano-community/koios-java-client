package com.reina.koios.client.backend.api.pool;

import com.reina.koios.client.backend.api.pool.model.*;

public interface PoolService {

    /**
     * Pool List
     * A list of all currently registered/retiring (not retired) pools
     * <p><b>200</b> - Array of pool IDs and tickers
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @return Array of {@link Pool} IDs and tickers
     */
    Pool[] getPoolList();

    /**
     * Pool Information
     * Current pool status and details for specified pool id
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @return Array of {@link PoolInfo}
     */
    PoolInfo[] getPoolInformation(String poolBech32);

    /**
     * Pool Delegators List
     * Return information about delegators by a given pool and optional epoch (current if omitted)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param epochNo    Epoch Number to fetch details for (optional)
     */
    PoolDelegator[] getPoolDelegatorsList(String poolBech32, Long epochNo);

    /**
     * Pool Blocks
     * Return information about blocks minted by a given pool in current epoch (or _epoch_no if provided)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (required)
     * @param epochNo    Epoch Number to fetch details for (optional)
     */
    PoolBlock[] getPoolBlocks(String poolBech32, Long epochNo);

    /**
     * Pool Updates (History)
     * Return all pool updates for all pools or only updates for specific pool if specified
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param poolBech32 Pool ID in bech32 format (optional) (optional)
     */
    PoolUpdate[] getPoolUpdates(String poolBech32);

    /**
     * Pool Relays
     * A list of registered relays for all currently registered/retiring (not retired) pools
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     */
    PoolRelay[] getPoolRelays();

    /**
     * Pool Metadata
     * Metadata(on &amp; off-chain) for all currently registered/retiring (not retired) pools
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     */
    PoolMetadata[] getPoolMetadata();
}
