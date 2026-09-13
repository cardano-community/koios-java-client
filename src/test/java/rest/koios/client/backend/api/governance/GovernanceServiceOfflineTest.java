package rest.koios.client.backend.api.governance;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.BackendFactory;
import rest.koios.client.backend.factory.options.Options;

import java.io.IOException;

/**
 * Exercises {@link GovernanceService} against a local {@link MockWebServer}.
 * <p>
 * Governance only had a mainnet integration suite, which the coverage job excludes and which
 * cannot assert request shape. These run offline, so they are deterministic and check that each
 * call reaches the endpoint it should with the parameters it should.
 */
class GovernanceServiceOfflineTest {

    private MockWebServer server;
    private GovernanceService governanceService;

    @BeforeEach
    void setup() throws IOException {
        server = new MockWebServer();
        server.start();
        governanceService = BackendFactory
                .getCustomRPCService(server.url("/api/v1/").toString()).getGovernanceService();
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    private void enqueueEmptyArray() {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("[]"));
    }

    private RecordedRequest take() throws InterruptedException {
        return server.takeRequest();
    }

    @Test
    void everyEndpointIsReachedTest() throws ApiException, InterruptedException {
        for (int i = 0; i < 15; i++) {
            enqueueEmptyArray();
        }

        governanceService.getDRepsEpochSummary(500, Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/drep_epoch_summary"));

        governanceService.getDRepsList(Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/drep_list"));

        governanceService.getDRepsUpdates("drep1abc", Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/drep_updates"));

        governanceService.getDRepsVotingPowerHistory("drep1abc", null, Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/drep_voting_power_history"));

        governanceService.getDRepsVotes("drep1abc", Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/drep_votes"));

        governanceService.getDRepsDelegators("drep1abc", Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/drep_delegators"));

        governanceService.getCommitteeInformation(Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/committee_info"));

        governanceService.getCommitteeVotes("cc_hot1abc", Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/committee_votes"));

        governanceService.getProposalList(Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/proposal_list"));

        governanceService.getVoterProposals("drep1abc", Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/voter_proposal_list"));

        governanceService.getProposalVotingSummary("gov_action1abc", Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/proposal_voting_summary"));

        governanceService.getProposalVotes("gov_action1abc", Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/proposal_votes"));

        governanceService.getVoteList(Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/vote_list"));

        governanceService.getPoolsVotingPowerHistory("pool1abc", null, Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/pool_voting_power_history"));

        governanceService.getPoolVotes("pool1abc", Options.EMPTY);
        Assertions.assertTrue(take().getPath().startsWith("/api/v1/pool_votes"));

        Assertions.assertEquals(15, server.getRequestCount());
    }

    @Test
    void drepsInfoAndMetadataPostTheIdsTest() throws ApiException, InterruptedException {
        enqueueEmptyArray();
        governanceService.getDRepsInfo(java.util.Arrays.asList("drep1abc", "drep1def"), Options.EMPTY);
        RecordedRequest info = take();
        Assertions.assertEquals("POST", info.getMethod());
        Assertions.assertTrue(info.getPath().startsWith("/api/v1/drep_info"));
        Assertions.assertTrue(info.getBody().readUtf8().contains("drep1abc"));

        enqueueEmptyArray();
        governanceService.getDRepsMetadata(java.util.Collections.singletonList("drep1abc"), Options.EMPTY);
        RecordedRequest metadata = take();
        Assertions.assertEquals("POST", metadata.getMethod());
        Assertions.assertTrue(metadata.getPath().startsWith("/api/v1/drep_metadata"));
    }

    @Test
    void epochFilterIsAppliedWhenGivenTest() throws ApiException, InterruptedException {
        enqueueEmptyArray();
        governanceService.getDRepsVotingPowerHistory("drep1abc", 500, Options.EMPTY);
        String path = take().getPath();
        Assertions.assertTrue(path.contains("epoch_no"), path);
        Assertions.assertTrue(path.contains("500"), path);

        enqueueEmptyArray();
        governanceService.getPoolsVotingPowerHistory("pool1abc", 500, Options.EMPTY);
        String poolPath = take().getPath();
        Assertions.assertTrue(poolPath.contains("epoch_no"), poolPath);
    }

    @Test
    void nullOptionsAreHandledTest() throws ApiException, InterruptedException {
        enqueueEmptyArray();
        governanceService.getDRepsVotingPowerHistory("drep1abc", 500, null);
        Assertions.assertTrue(take().getPath().contains("epoch_no"));

        enqueueEmptyArray();
        governanceService.getPoolsVotingPowerHistory("pool1abc", 500, null);
        Assertions.assertTrue(take().getPath().contains("epoch_no"));
    }

    @Test
    void invalidEpochIsRejectedBeforeSendingTest() {
        Assertions.assertThrows(ApiException.class,
                () -> governanceService.getDRepsVotingPowerHistory("drep1abc", -1, Options.EMPTY));
        Assertions.assertThrows(ApiException.class,
                () -> governanceService.getPoolsVotingPowerHistory("pool1abc", -1, Options.EMPTY));
        Assertions.assertEquals(0, server.getRequestCount(), "nothing should have been sent");
    }
}
