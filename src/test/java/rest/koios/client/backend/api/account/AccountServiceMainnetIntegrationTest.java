package rest.koios.client.backend.api.account;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.account.model.*;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountServiceMainnetIntegrationTest {

    private rest.koios.client.backend.api.account.AccountService accountService;

    @BeforeAll
    public void setup() {
        accountService = BackendFactory.getKoiosMainnetService().getAccountService();
    }

    @Test
    void getAccountListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<StakeAddress>> stakeAddressesResult = accountService.getAccountList(options);
        Assertions.assertTrue(stakeAddressesResult.isSuccessful());
        log.info(stakeAddressesResult.getValue().toString());
        Assertions.assertNotNull(stakeAddressesResult.getValue());
        assertEquals(10, stakeAddressesResult.getValue().size());
    }

    @Test
    void getAccountInformationTest() throws ApiException {
        String address = "stake1u8yxtugdv63wxafy9d00nuz6hjyyp4qnggvc9a3vxh8yl0ckml2uz";
        Result<AccountInfo> accountInformationResult = accountService.getAccountInformation(address);
        Assertions.assertTrue(accountInformationResult.isSuccessful());
        Assertions.assertNotNull(accountInformationResult.getValue());
        log.info(accountInformationResult.getValue().toString());
    }

    @Test
    void getAccountInformationBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountInformation(address));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAccountRewardsTest() throws ApiException {
        int epochNo = 294;
        String stakeAddress = "stake1u8yxtugdv63wxafy9d00nuz6hjyyp4qnggvc9a3vxh8yl0ckml2uz";
        Result<AccountRewards> accountRewardsResult = accountService.getAccountRewardsByEpoch(stakeAddress, epochNo);
        Assertions.assertTrue(accountRewardsResult.isSuccessful());
        Assertions.assertNotNull(accountRewardsResult.getValue());
        assertEquals(epochNo, accountRewardsResult.getValue().getEarnedEpoch());
        log.info(accountRewardsResult.getValue().toString());
    }

    @Test
    void getAccountRewardsLimitTest() throws ApiException {
        String stakeAddress = "stake1u8yxtugdv63wxafy9d00nuz6hjyyp4qnggvc9a3vxh8yl0ckml2uz";
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<AccountRewards>> accountRewardsResult = accountService.getAccountRewards(stakeAddress, options);
        Assertions.assertTrue(accountRewardsResult.isSuccessful());
        Assertions.assertNotNull(accountRewardsResult.getValue());
        log.info(accountRewardsResult.getValue().toString());
        Assertions.assertEquals(10, accountRewardsResult.getValue().size());
    }

    @Test
    void getAccountRewardsBadRequestTest() {
        String stakeAddress = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountRewardsByEpoch(stakeAddress, 294));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAccountUpdatesTest() throws ApiException {
        String stakeAddress = "stake1u8yxtugdv63wxafy9d00nuz6hjyyp4qnggvc9a3vxh8yl0ckml2uz";
        Result<List<AccountUpdates>> accountUpdatesResult = accountService.getAccountUpdates(stakeAddress, null);
        Assertions.assertTrue(accountUpdatesResult.isSuccessful());
        Assertions.assertNotNull(accountUpdatesResult.getValue());
        log.info(accountUpdatesResult.getValue().toString());
    }

    @Test
    void getAccountUpdatesBadRequestTest() {
        String stakeAddress = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountUpdates(stakeAddress, null));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAccountAddressesTest() throws ApiException {
        String address = "stake1u8yxtugdv63wxafy9d00nuz6hjyyp4qnggvc9a3vxh8yl0ckml2uz";
        Result<List<AccountAddress>> accountAddressesResult = accountService.getAccountAddresses(address, null);
        Assertions.assertTrue(accountAddressesResult.isSuccessful());
        Assertions.assertNotNull(accountAddressesResult.getValue());
        log.info(accountAddressesResult.getValue().toString());
    }

    @Test
    void getAccountAddressesBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountAddresses(address, null));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAccountAssetsTest() throws ApiException {
        String address = "stake1u8yxtugdv63wxafy9d00nuz6hjyyp4qnggvc9a3vxh8yl0ckml2uz";
        Result<List<AccountAsset>> accountAssetsResult = accountService.getAccountAssets(address, null);
        Assertions.assertTrue(accountAssetsResult.isSuccessful());
        Assertions.assertNotNull(accountAssetsResult.getValue());
        log.info(accountAssetsResult.getValue().toString());
    }

    @Test
    void getAccountAssetsBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountAssets(address, null));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getAccountHistoryTest() throws ApiException {
        String address = "stake1u8yxtugdv63wxafy9d00nuz6hjyyp4qnggvc9a3vxh8yl0ckml2uz";
        Result<List<AccountHistory>> accountHistoryResult = accountService.getAccountHistory(address, null);
        Assertions.assertTrue(accountHistoryResult.isSuccessful());
        Assertions.assertNotNull(accountHistoryResult.getValue());
        log.info(accountHistoryResult.getValue().toString());
    }

    @Test
    void getAccountHistoryBadRequestTest() {
        String address = "a123sd";
        ApiException exception = assertThrows(ApiException.class, () -> accountService.getAccountHistory(address, null));
        assertInstanceOf(ApiException.class, exception);
    }
}
