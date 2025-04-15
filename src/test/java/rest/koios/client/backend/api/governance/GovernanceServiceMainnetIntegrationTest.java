package rest.koios.client.backend.api.governance;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.governance.model.*;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.backend.factory.options.filters.Filter;
import rest.koios.client.backend.factory.options.filters.FilterType;

import java.util.List;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GovernanceServiceMainnetIntegrationTest {

    private GovernanceService governanceService;

    @BeforeAll
    public void setup() {
        governanceService = BackendFactory.getKoiosMainnetService().getGovernanceService();
    }

    @Test
    void getDRepsEpochSummaryTest() throws ApiException {
        Integer epochNo = 320;
        Result<List<DRepEpochSummary>> result = governanceService.getDRepsEpochSummary(epochNo, Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getDRepsListTest() throws ApiException {
        Result<List<DRep>> result = governanceService.getDRepsList(Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getDRepsInfoTest() throws ApiException {
        List<String> drepIds = List.of("drep17l6sywnwqu9aedd6aumev42w39ln5zfl9nw7j4ak6u8swyrwvz3", "drep1s9q5uyddsvza4uk2n9wswy90n8wx9d2jmrq4zgcvlyv055007av");
        Result<List<DRepInfo>> result = governanceService.getDRepsInfo(drepIds, Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getDRepsMetadataTest() throws ApiException {
        List<String> drepIds = List.of("drep1y2ltat8kjqrmnff3lkkpxy0j5tn66d3m0gy64dc92asft5g6dl9ws", "drep1s9q5uyddsvza4uk2n9wswy90n8wx9d2jmrq4zgcvlyv055007av");
        Result<List<DRepMetadata>> result = governanceService.getDRepsMetadata(drepIds, Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getDRepsUpdatesTest() throws ApiException {
        String drepId = "drep17l6sywnwqu9aedd6aumev42w39ln5zfl9nw7j4ak6u8swyrwvz3";
        Result<List<DRepUpdate>> result = governanceService.getDRepsUpdates(drepId, Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getDRepsVotingPowerTest() throws ApiException {
        int epochNo = 320;
        String drepId = "drep17l6sywnwqu9aedd6aumev42w39ln5zfl9nw7j4ak6u8swyrwvz3";
        Result<List<DRepVotingPowerHistory>> result = governanceService.getDRepsVotingPowerHistory(drepId, epochNo, Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getDRepsVotesTest() throws ApiException {
        String drepId = "drep17l6sywnwqu9aedd6aumev42w39ln5zfl9nw7j4ak6u8swyrwvz3";
        Result<List<Vote>> result = governanceService.getVoteList(Options.builder().option(Filter.of("voter_id", FilterType.EQ, drepId)).build());
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getDRepsDelegatorsTest() throws ApiException {
        String drepId = "drep17l6sywnwqu9aedd6aumev42w39ln5zfl9nw7j4ak6u8swyrwvz3";
        Result<List<DRepDelegator>> result = governanceService.getDRepsDelegators(drepId, Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getCommitteeInformationTest() throws ApiException {
        Result<List<CommitteeInfo>> result = governanceService.getCommitteeInformation(Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getCommitteeVotesTest() throws ApiException {
        String ccHotId = "cc_hot1qgqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqvcdjk7";
        Result<List<CommitteeVote>> result = governanceService.getCommitteeVotes(ccHotId, Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getProposalListTest() throws ApiException {
        Result<List<Proposal>> result = governanceService.getProposalList(Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getVoterProposalsTest() throws ApiException {
        String voterId = "drep17l6sywnwqu9aedd6aumev42w39ln5zfl9nw7j4ak6u8swyrwvz3";
        Result<List<Proposal>> result = governanceService.getVoterProposals(voterId, Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getProposalVotingSummaryTest() throws ApiException {
        String proposalId = "gov_action1qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqpzklpgpf";
        Result<List<ProposalVotingSummary>> result = governanceService.getProposalVotingSummary(proposalId, Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getProposalVotesTest() throws ApiException {
        String proposalId = "gov_action1qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqpzklpgpf";
        Result<List<ProposalVote>> result = governanceService.getProposalVotes(proposalId, Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getPoolsVotingPowerHistoryTest() throws ApiException {
        int epochNo = 320;
        String poolBech32 = "pool155efqn9xpcf73pphkk88cmlkdwx4ulkg606tne970qswczg3asc";
        Result<List<PoolsVotingPowerHistory>> result = governanceService.getPoolsVotingPowerHistory(poolBech32, epochNo, Options.EMPTY);
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }

    @Test
    void getPoolVotesTest() throws ApiException {
        String poolBech32 = "pool155efqn9xpcf73pphkk88cmlkdwx4ulkg606tne970qswczg3asc";
        Result<List<Vote>> result = governanceService.getVoteList(Options.builder().option(Filter.of("voter_id", FilterType.EQ, poolBech32)).build());
        Assertions.assertTrue(result.isSuccessful());
        Assertions.assertNotNull(result.getValue());
        log.info(result.getValue().toString());
    }
}
