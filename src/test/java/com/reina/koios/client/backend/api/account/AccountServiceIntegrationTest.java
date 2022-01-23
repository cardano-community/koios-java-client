package com.reina.koios.client.backend.api.account;

import com.reina.koios.client.backend.api.account.model.*;
import com.reina.koios.client.backend.factory.BackendFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountServiceIntegrationTest {

    private AccountService accountService;

    @BeforeAll
    public void setup() {
        accountService = BackendFactory.getKoiosTestnetService().getAccountService();
    }

    @Test
    void getAccountListTest() {
        StakeAddress[] stakeAddresses = accountService.getAccountList();
        log.info(Arrays.toString(stakeAddresses));
        Assertions.assertNotNull(stakeAddresses);
    }

    @Test
    void getAccountInformationTest() {
        String address = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        AccountInfo[] accountInformation = accountService.getAccountInformation(address);
        log.info(Arrays.toString(accountInformation));
        Assertions.assertNotNull(accountInformation);
    }

    @Test
    void getAccountRewardsTest() {
        String stakeAddress = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        AccountRewards[] accountRewards = accountService.getAccountRewards(stakeAddress,180L);
        log.info(Arrays.toString(accountRewards));
        Assertions.assertNotNull(accountRewards);

        accountRewards = accountService.getAccountRewards(stakeAddress,null);
        log.info(Arrays.toString(accountRewards));
        Assertions.assertNotNull(accountRewards);
    }

    @Test
    void getAccountUpdatesTest() {
        String stakeAddress = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        AccountUpdates[] accountUpdates = accountService.getAccountUpdates(stakeAddress);
        log.info(Arrays.toString(accountUpdates));
        Assertions.assertNotNull(accountUpdates);
    }

    @Test
    void getAccountAddressesTest() {
        String address = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        AccountAddress[] accountAddresses = accountService.getAccountAddresses(address);
        log.info(Arrays.toString(accountAddresses));
        Assertions.assertNotNull(accountAddresses);
    }

    @Test
    void getAccountAssetsTest() {
        String address = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        AccountAsset[] accountAddresses = accountService.getAccountAssets(address);
        log.info(Arrays.toString(accountAddresses));
        Assertions.assertNotNull(accountAddresses);
    }

    @Test
    void getAccountHistoryTest() {
        String address = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        AccountHistory[] accountHistory = accountService.getAccountHistory(address);
        log.info(Arrays.toString(accountHistory));
        Assertions.assertNotNull(accountHistory);
    }
}
