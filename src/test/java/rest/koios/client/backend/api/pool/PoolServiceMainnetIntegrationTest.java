package rest.koios.client.backend.api.pool;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.pool.model.*;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Limit;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PoolServiceMainnetIntegrationTest {

    private PoolService poolService;

    @BeforeAll
    public void setup() {
        poolService = BackendFactory.getKoiosMainnetService().getPoolService();
    }

    @Test
    void getPoolListLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<Pool>> poolListResult = poolService.getPoolList(options);
        Assertions.assertTrue(poolListResult.isSuccessful());
        Assertions.assertNotNull(poolListResult.getValue());
        log.info(poolListResult.getValue().toString());
        assertEquals(10, poolListResult.getValue().size());
    }

    @Test
    void getPoolInformationTest() throws ApiException {
        String poolId = "pool100wj94uzf54vup2hdzk0afng4dhjaqggt7j434mtgm8v2gfvfgp";
        Result<List<PoolInfo>> poolInfosResult = poolService.getPoolInformation(List.of(poolId), Options.EMPTY);
        Assertions.assertTrue(poolInfosResult.isSuccessful());
        Assertions.assertNotNull(poolInfosResult.getValue());
        log.info(poolInfosResult.getValue().toString());
    }

    @Test
    void getPoolInformationBadRequestTest() {
        String poolId = "asdsa";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolInformation(List.of(poolId), Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPoolStakeSnapshotTest() throws ApiException {
        String poolBech32 = "pool155efqn9xpcf73pphkk88cmlkdwx4ulkg606tne970qswczg3asc";
        Result<List<PoolStakeSnapshot>> poolInfosResult = poolService.getPoolStakeSnapshot(poolBech32, Options.EMPTY);
        Assertions.assertTrue(poolInfosResult.isSuccessful());
        Assertions.assertNotNull(poolInfosResult.getValue());
        log.info(poolInfosResult.getValue().toString());
    }

    @Test
    void getPoolStakeSnapshotBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolStakeSnapshot(poolBech32, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPoolDelegatorsListTest() throws ApiException {
        String poolBech32 = "pool155efqn9xpcf73pphkk88cmlkdwx4ulkg606tne970qswczg3asc";
        Result<List<PoolDelegatorHistory>> poolDelegatorsResult = poolService.getPoolDelegatorsHistory(poolBech32, 180, Options.EMPTY);
        Assertions.assertTrue(poolDelegatorsResult.isSuccessful());
        Assertions.assertNotNull(poolDelegatorsResult.getValue());
        log.info(poolDelegatorsResult.getValue().toString());
    }

    @Test
    void getPoolDelegatorsListLimitTest() throws ApiException {
        String poolBech32 = "pool155efqn9xpcf73pphkk88cmlkdwx4ulkg606tne970qswczg3asc";
        Options options = Options.builder().option(Limit.of(1)).build();
        Result<List<PoolDelegator>> poolDelegatorsResult = poolService.getPoolDelegatorsList(poolBech32, options);
        Assertions.assertTrue(poolDelegatorsResult.isSuccessful());
        Assertions.assertNotNull(poolDelegatorsResult.getValue());
        log.info(poolDelegatorsResult.getValue().toString());
        assertEquals(1, poolDelegatorsResult.getValue().size());
    }

    @Test
    void getPoolDelegatorsListBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolDelegatorsHistory(poolBech32, 180, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPoolBlocksTest() throws ApiException {
        String poolBech32 = "pool155efqn9xpcf73pphkk88cmlkdwx4ulkg606tne970qswczg3asc";
        Result<List<PoolBlock>> poolBlocksResult = poolService.getPoolBlocksByEpoch(poolBech32, 180, Options.EMPTY);
        Assertions.assertTrue(poolBlocksResult.isSuccessful());
        Assertions.assertNotNull(poolBlocksResult.getValue());
        log.info(poolBlocksResult.getValue().toString());
    }

    @Test
    void getPoolBlocksLimitTest() throws ApiException {
        String poolBech32 = "pool155efqn9xpcf73pphkk88cmlkdwx4ulkg606tne970qswczg3asc";
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<PoolBlock>> poolBlocksResult = poolService.getPoolBlocks(poolBech32, options);
        Assertions.assertTrue(poolBlocksResult.isSuccessful());
        Assertions.assertNotNull(poolBlocksResult.getValue());
        log.info(poolBlocksResult.getValue().toString());
        assertEquals(10, poolBlocksResult.getValue().size());
    }

    @Test
    void getPoolBlocksBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolBlocksByEpoch(poolBech32, 180, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPoolOwnerHistoryTest() throws ApiException {
        String poolBech32 = "pool100wj94uzf54vup2hdzk0afng4dhjaqggt7j434mtgm8v2gfvfgp";
        String poolBech32_2 = "pool102s2nqtea2hf5q0s4amj0evysmfnhrn4apyyhd4azcmsclzm96m";
        String poolBech32_3 = "pool102vsulhfx8ua2j9fwl2u7gv57fhhutc3tp6juzaefgrn7ae35wm";
        Result<List<PoolOwnerHistory>> poolBlocksResult = poolService.getPoolOwnerHistory(List.of(poolBech32, poolBech32_2, poolBech32_3), Options.EMPTY);
        Assertions.assertTrue(poolBlocksResult.isSuccessful());
        Assertions.assertNotNull(poolBlocksResult.getValue());
        log.info(poolBlocksResult.getValue().toString());
    }

    @Test
    void getPoolHistoryByEpochTest() throws ApiException {
        String poolBech32 = "pool155efqn9xpcf73pphkk88cmlkdwx4ulkg606tne970qswczg3asc";
        Integer epochNo = 294;
        Result<PoolHistory> poolHistoryResult = poolService.getPoolHistoryByEpoch(poolBech32, epochNo,Options.EMPTY);
        Assertions.assertTrue(poolHistoryResult.isSuccessful());
        Assertions.assertNotNull(poolHistoryResult.getValue());
        log.info(poolHistoryResult.getValue().toString());
    }

    @Test
    void getPoolHistoryLimitTest() throws ApiException {
        String poolBech32 = "pool155efqn9xpcf73pphkk88cmlkdwx4ulkg606tne970qswczg3asc";
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<PoolHistory>> poolHistoryResult = poolService.getPoolHistory(poolBech32, options);
        Assertions.assertTrue(poolHistoryResult.isSuccessful());
        Assertions.assertNotNull(poolHistoryResult.getValue());
        log.info(poolHistoryResult.getValue().toString());
        assertEquals(10, poolHistoryResult.getValue().size());
    }

    @Test
    void getPoolHistoryBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolHistoryByEpoch(poolBech32, 294, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPoolUpdatesTest() throws ApiException {
        String poolBech32 = "pool155efqn9xpcf73pphkk88cmlkdwx4ulkg606tne970qswczg3asc";
        Result<List<PoolUpdate>> poolUpdatesResult = poolService.getPoolUpdatesByPoolBech32(poolBech32, Options.EMPTY);
        Assertions.assertTrue(poolUpdatesResult.isSuccessful());
        Assertions.assertNotNull(poolUpdatesResult.getValue());
        log.info(poolUpdatesResult.getValue().toString());
    }

    @Test
    void getPoolUpdatesLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<PoolUpdate>> poolUpdatesResult = poolService.getPoolUpdates(options);
        Assertions.assertTrue(poolUpdatesResult.isSuccessful());
        Assertions.assertNotNull(poolUpdatesResult.getValue());
        log.info(poolUpdatesResult.getValue().toString());
        assertEquals(10, poolUpdatesResult.getValue().size());
    }

    @Test
    void getPoolUpdatesBadRequestTest() {
        String poolBech32 = "123asd";
        ApiException exception = assertThrows(ApiException.class, () -> poolService.getPoolUpdatesByPoolBech32(poolBech32, Options.EMPTY));
        assertInstanceOf(ApiException.class, exception);
    }

    @Test
    void getPoolRegistrationsTest() throws ApiException {
        Integer epochNo = 320;
        Result<List<PoolStatus>> poolRegistrationsResult = poolService.getPoolRegistrations(epochNo, Options.EMPTY);
        Assertions.assertTrue(poolRegistrationsResult.isSuccessful());
        Assertions.assertNotNull(poolRegistrationsResult.getValue());
        log.info(poolRegistrationsResult.getValue().toString());
    }

    @Test
    void getPoolRetirementsTest() throws ApiException {
        Integer epochNo = 320;
        Result<List<PoolStatus>> poolRegistrationsResult = poolService.getPoolRetirements(epochNo, Options.EMPTY);
        Assertions.assertTrue(poolRegistrationsResult.isSuccessful());
        Assertions.assertNotNull(poolRegistrationsResult.getValue());
        log.info(poolRegistrationsResult.getValue().toString());
    }

    @Test
    void getPoolRelaysLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<PoolRelay>> poolRelaysResult = poolService.getPoolRelays(options);
        Assertions.assertTrue(poolRelaysResult.isSuccessful());
        Assertions.assertNotNull(poolRelaysResult.getValue());
        log.info(poolRelaysResult.getValue().toString());
        assertEquals(10, poolRelaysResult.getValue().size());
    }

    @Test
    void getPoolGroupsTest() throws ApiException {
        Result<List<PoolGroup>> poolGroupsResult = poolService.getPoolGroups(Options.EMPTY);
        Assertions.assertTrue(poolGroupsResult.isSuccessful());
        Assertions.assertNotNull(poolGroupsResult.getValue());
        log.info(poolGroupsResult.getValue().toString());
    }

    @Test
    void getPoolMetadataLimitTest() throws ApiException {
        Options options = Options.builder().option(Limit.of(10)).build();
        Result<List<PoolMetadata>> poolMetadataResult = poolService.getPoolMetadata(options);
        Assertions.assertTrue(poolMetadataResult.isSuccessful());
        Assertions.assertNotNull(poolMetadataResult.getValue());
        log.info(poolMetadataResult.getValue().toString());
        assertEquals(10, poolMetadataResult.getValue().size());
    }

    @Test
    void getPoolCalidusKeysTest() throws ApiException {
        Result<List<PoolCalidusKey>> poolCalidusKeysResult = poolService.getPoolCalidusKeys(Options.EMPTY);
        Assertions.assertTrue(poolCalidusKeysResult.isSuccessful());
        Assertions.assertNotNull(poolCalidusKeysResult.getValue());
        log.info(poolCalidusKeysResult.getValue().toString());
    }
}
