package rest.koios.client.backend.api.account;

import rest.koios.client.backend.api.account.model.*;
import rest.koios.client.backend.api.base.Result;
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
     * Get the account info of any (payment or staking) address
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param address Cardano payment or staking address in bech32 format (required)
     * @return Result of Type List of {@link AccountInfo} per the specified payment or staking address
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<AccountInfo> getAccountInformation(String address) throws ApiException;

    /**
     * Account Rewards By Epoch
     * Get the full rewards history (including MIR) for a stake address, or certain epoch if specified
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param stakeAddress Cardano staking address (reward account) in bech32 format (required)
     * @param epochNo      Filter for earned rewards Epoch Number (optional)
     * @return Result of {@link AccountRewards}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<AccountRewards> getAccountRewardsByEpoch(String stakeAddress, Long epochNo) throws ApiException;

    /**
     * Account Rewards with Filtering, Pagination, Ordering Options
     * Get the full rewards history (including MIR) for a stake address, or certain epoch if specified
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param stakeAddress Cardano staking address (reward account) in bech32 format (required)
     * @param options      Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountRewards}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountRewards>> getAccountRewards(String stakeAddress, Options options) throws ApiException;

    /**
     * Account Updates (History) with Filtering, Pagination, Ordering Options
     * Get the account updates (registration, deregistration, delegation and withdrawals)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param stakeAddress Cardano staking address (reward account) in bech32 format (required)
     * @param options      Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountUpdates}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountUpdates>> getAccountUpdates(String stakeAddress, Options options) throws ApiException;

    /**
     * Account Addresses with Filtering, Pagination, Ordering Options
     * Get all addresses associated with an account
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param address Cardano payment or staking address in bech32 format (required)
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountAddress}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountAddress>> getAccountAddresses(String address, Options options) throws ApiException;

    /**
     * Account Assets with Filtering, Pagination, Ordering Options
     * Get the native asset balance of an account
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param address Cardano payment or staking address in bech32 format (required)
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountAsset}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountAsset>> getAccountAssets(String address, Options options) throws ApiException;

    /**
     * Account History with Filtering, Pagination, Ordering Options
     * Get the staking history of an account
     * <p><b>200</b> - Array of active stake values per epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param address Cardano payment or staking address in bech32 format (required)
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AccountHistory} active stake values per epoch
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AccountHistory>> getAccountHistory(String address, Options options) throws ApiException;
}
