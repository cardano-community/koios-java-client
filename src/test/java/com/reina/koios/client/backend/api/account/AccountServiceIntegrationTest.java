package com.reina.koios.client.backend.api.account;

import com.reina.koios.client.backend.api.account.model.*;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.factory.BackendFactory;
import com.reina.koios.client.backend.factory.options.Limit;
import com.reina.koios.client.backend.factory.options.Options;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountServiceIntegrationTest {

    private AccountService accountService;

    @BeforeAll
    public void setup() {
        accountService = BackendFactory.getKoiosTestnetService().getAccountService();
    }

    @Test
    void getAccountListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        StakeAddress[] stakeAddresses = accountService.getAccountList(options);
        log.info(Arrays.toString(stakeAddresses));
        Assertions.assertNotNull(stakeAddresses);
        Assertions.assertEquals(10, stakeAddresses.length);
    }

    @Test
    void getAccountInformationTest() throws ApiException {
        String address = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        AccountInfo[] accountInformation = accountService.getAccountInformation(address);
        log.info(Arrays.toString(accountInformation));
        Assertions.assertNotNull(accountInformation);
    }

    @Test
    void getAccountInformationBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountInformation(address));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAccountRewardsTest() throws ApiException {
        String stakeAddress = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        AccountRewards[] accountRewards = accountService.getAccountRewards(stakeAddress, 180L);
        log.info(Arrays.toString(accountRewards));
        Assertions.assertNotNull(accountRewards);
    }

    @Test
    void getAccountRewardsLimitTest() throws ApiException {
        String stakeAddress = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        Options options = Options.builder().option(Limit.of(10)).build();
        AccountRewards[] accountRewards = accountService.getAccountRewards(stakeAddress, options);
        log.info(Arrays.toString(accountRewards));
        Assertions.assertNotNull(accountRewards);
        Assertions.assertEquals(10, accountRewards.length);
    }

    @Test
    void getAccountRewardsBadRequestTest() {
        String stakeAddress = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountRewards(stakeAddress, 180L));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAccountUpdatesTest() throws ApiException {
        String stakeAddress = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        AccountUpdates[] accountUpdates = accountService.getAccountUpdates(stakeAddress);
        log.info(Arrays.toString(accountUpdates));
        Assertions.assertNotNull(accountUpdates);
    }

    @Test
    void getAccountUpdatesBadRequestTest() {
        String stakeAddress = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountUpdates(stakeAddress));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAccountAddressesTest() throws ApiException {
        String address = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        AccountAddress[] accountAddresses = accountService.getAccountAddresses(address);
        log.info(Arrays.toString(accountAddresses));
        Assertions.assertNotNull(accountAddresses);
    }

    @Test
    void getAccountAddressesBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountAddresses(address));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAccountAssetsTest() throws ApiException {
        String address = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        AccountAsset[] accountAddresses = accountService.getAccountAssets(address);
        log.info(Arrays.toString(accountAddresses));
        Assertions.assertNotNull(accountAddresses);
    }

    @Test
    void getAccountAssetsBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountAssets(address));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void getAccountHistoryTest() throws ApiException {
        String address = "stake_test1uq02x8kk9kcee2uhlw69srl78s2rdu83z6tgjcxceufd7asvp5p2z";
        AccountHistory[] accountHistory = accountService.getAccountHistory(address);
        log.info(Arrays.toString(accountHistory));
        Assertions.assertNotNull(accountHistory);
    }

    @Test
    void getAccountHistoryBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountHistory(address));
        assertInstanceOf(ApiException.class, exception);
        assertEquals(exception.getCode(), HttpStatus.BAD_REQUEST.value());
    }
}
