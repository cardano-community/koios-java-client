package rest.koios.client.backend.api.account;

import rest.koios.client.backend.api.account.model.*;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

/**
 * Account Service
 */
public interface AccountService {

    /**
     * Get a list of all accounts with Filtering, Pagination, Ordering Options
     *
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link StakeAddress}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<StakeAddress>> getAccountList(Options options) throws ApiException;

    /**
     * Account Information
     * Get the account information for given stake addresses (accounts)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param stakeAddresses List of Cardano stake address(es) in bech32 format (required)
     * @param options        Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountInfo} per the specified payment or staking address
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountInfo>> getAccountInformation(List<String> stakeAddresses, Options options) throws ApiException;

    /**
     * Account Information (Cached)
     * Get the cached account information for given stake addresses (accounts)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param stakeAddresses List of Cardano stake address(es) in bech32 format (required)
     * @param options        Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountInfo} per the specified payment or staking address
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountInfo>> getCachedAccountInformation(List<String> stakeAddresses, Options options) throws ApiException;

    /**
     * Account UTxOs
     * Get a list of all UTxOs for a given stake address (account)s
     * <p><b>200</b> - List of account UTxOs associated with stake address
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param stakeAddresses List of Cardano stake address(es) in bech32 format
     * @param extended       Controls whether or not certain optional fields supported by a given endpoint are populated as a part of the call
     * @param options        Filtering and Pagination options (optional)
     * @return Result of Type List of {@link UTxO} associated with stake address
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<UTxO>> getAccountUTxOs(List<String> stakeAddresses, boolean extended, Options options) throws ApiException;

    /**
     * Account Txs
     * Get a list of all Txs for a given stake address (account)
     * <p><b>200</b> - List of Txs associated with stake address (account)
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param stakeAddress     Cardano staking address (reward account) in bech32 format
     * @param afterBlockHeight Block height for specifying time delta
     * @param options          Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountTx} associated with stake address (account)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountTx>> getAccountTxs(String stakeAddress, Integer afterBlockHeight, Options options) throws ApiException;

    /**
     * Account Rewards
     * Get the full rewards history (including MIR) for given stake addresses (accounts)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param addressList Array of Cardano stake address(es) in bech32 format
     * @param epochNo     Only fetch information for a specific epoch (optional)
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountRewards}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountRewards>> getAccountRewards(List<String> addressList, Integer epochNo, Options options) throws ApiException;

    /**
     * Account Updates (History)
     * Get the account updates (registration, deregistration, delegation and withdrawals)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param addressList Array of Cardano stake address(es) in bech32 format (required)
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountUpdates}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountUpdates>> getAccountUpdates(List<String> addressList, Options options) throws ApiException;

    /**
     * Account Addresses
     * Get all addresses associated with given staking accounts
     * <p><b>200</b> - List of payment addresses
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param addressList Array of Cardano stake address(es) in bech32 format (required)
     * @param firstOnly   Only return the first result
     * @param empty       Include zero quantity entries
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountAddress}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountAddress>> getAccountAddresses(List<String> addressList, boolean firstOnly, boolean empty, Options options) throws ApiException;

    /**
     * Account Assets
     * Get the native asset balance of given accounts
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param addressList Array of Cardano stake address(es) in bech32 format (required)
     * @param epochNo     Only fetch information for a specific epoch (optional)
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountAsset}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountAsset>> getAccountAssets(List<String> addressList, Integer epochNo, Options options) throws ApiException;

    /**
     * Account History
     * Get the staking history of given stake addresses (accounts)
     * <p><b>200</b> - Array of active stake values per epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param addressList Array of Cardano stake address(es) in bech32 format
     * @param epochNo     Only fetch information for a specific epoch (optional)
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountHistory} active stake values per epoch
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountHistory>> getAccountHistory(List<String> addressList, Integer epochNo, Options options) throws ApiException;
}
