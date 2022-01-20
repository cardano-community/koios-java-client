package com.reina.koios.client.api;

import com.reina.koios.client.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for AccountApi
 */
public class AccountApiTest {

    private AccountApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountApi.class);
    }


    /**
     * Account Addresses
     * <p>
     * Get all addresses associated with an account
     */
    @Test
    public void accountAddressesGetTest() {
        String _address = null;
        // Void response = api.accountAddressesGet(_address);

        // TODO: test validations
    }

    /**
     * Account Assets
     * <p>
     * Get the native asset balance of an account
     */
    @Test
    public void accountAssetsGetTest() {
        String _address = null;
        // Void response = api.accountAssetsGet(_address);

        // TODO: test validations
    }

    /**
     * Account History
     * <p>
     * Get the staking history of an account
     */
    @Test
    public void accountHistoryGetTest() {
        String _address = null;
        // AccountHistory response = api.accountHistoryGet(_address);

        // TODO: test validations
    }

    /**
     * Account Information
     * <p>
     * Get the account info of any (payment or staking) address
     */
    @Test
    public void accountInfoGetTest() {
        String _address = null;
        // Void response = api.accountInfoGet(_address);

        // TODO: test validations
    }

    /**
     * Get a list of all accounts
     */
    @Test
    public void accountListGetTest() {
        // Void response = api.accountListGet();

        // TODO: test validations
    }

    /**
     * Account Rewards
     * <p>
     * Get the full rewards history (including MIR) for a stake address, or certain epoch if specified
     */
    @Test
    public void accountRewardsGetTest() {
        String _stakeAddress = null;
        String _epochNo = null;
        // Void response = api.accountRewardsGet(_stakeAddress, _epochNo);

        // TODO: test validations
    }

    /**
     * Account Updates (History)
     * <p>
     * Get the account updates (registration, deregistration, delegation and withdrawals)
     */
    @Test
    public void accountUpdatesGetTest() {
        String _stakeAddress = null;
        // Void response = api.accountUpdatesGet(_stakeAddress);

        // TODO: test validations
    }
}
