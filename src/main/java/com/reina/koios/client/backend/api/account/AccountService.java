package com.reina.koios.client.backend.api.account;

import com.reina.koios.client.backend.api.account.model.*;

public interface AccountService {

    /**
     * Get a list of all accounts
     *
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @return Array of {@link StakeAddress}
     */
    StakeAddress[] getAccountList();

    /**
     * Account Information
     * Get the account info of any (payment or staking) address
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param address Cardano payment or staking address in bech32 format (required)
     * @return Array of {@link AccountInfo} per the specified payment or staking address
     */
    AccountInfo[] getAccountInformation(String address);

    /**
     * Account Rewards per Epoch
     * Get the full rewards history (including MIR) for a stake address, or certain epoch if specified
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param stakeAddress Cardano staking address (reward account) in bech32 format (required)
     * @param epochNo      Filter for earned rewards Epoch Number (optional)
     * @return Array of {@link AccountRewards}
     */
    AccountRewards[] getAccountRewards(String stakeAddress, Long epochNo);

    /**
     * Account Updates (History)
     * Get the account updates (registration, deregistration, delegation and withdrawals)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param stakeAddress Cardano staking address (reward account) in bech32 format (required)
     * @return Array of {@link AccountUpdates}
     */
    AccountUpdates[] getAccountUpdates(String stakeAddress);

    /**
     * Account Addresses
     * Get all addresses associated with an account
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param address Cardano payment or staking address in bech32 format (required)
     * @return Array of {@link AccountAddress}
     */
    AccountAddress[] getAccountAddresses(String address);

    /**
     * Account Assets
     * Get the native asset balance of an account
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param address Cardano payment or staking address in bech32 format (required)
     * @return Array of {@link AccountAsset}
     */
    AccountAsset[] getAccountAssets(String address);

    /**
     * Account History
     * Get the staking history of an account
     * <p><b>200</b> - Array of active stake values per epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     * @param address Cardano payment or staking address in bech32 format (required)
     * @return Array of {@link AccountHistory} active stake values per epoch
     */
    AccountHistory[] getAccountHistory(String address);
}
