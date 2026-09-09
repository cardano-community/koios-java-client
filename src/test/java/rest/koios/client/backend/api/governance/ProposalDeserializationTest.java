package rest.koios.client.backend.api.governance;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rest.koios.client.backend.api.governance.model.Proposal;
import rest.koios.client.backend.api.governance.model.ProposalVotingSummary;
import rest.koios.client.backend.api.transactions.model.ProposalProcedure;

import java.util.List;

class ProposalDeserializationTest {

    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Test
    void proposalListWithdrawalIsAnArrayTest() throws Exception {
        String json = "[{\"proposal_id\":\"gov_action1abc\"," +
                "\"proposal_type\":\"TreasuryWithdrawals\"," +
                "\"previous_gov_action_proposal_id\":\"gov_action1prev\"," +
                "\"withdrawal\":[{\"amount\":\"11787063000000\"," +
                "\"stake_address\":\"stake1784sdxt6jjennmstphgdu7l7c2scf5d02a6cve2dgn5s2kq5u3j9v\"}]}]";

        List<Proposal> proposals = objectMapper.readValue(json, new TypeReference<>() {
        });

        Assertions.assertEquals(1, proposals.size());
        Proposal proposal = proposals.get(0);
        Assertions.assertEquals("gov_action1prev", proposal.getPreviousGovActionProposalId());
        Assertions.assertNotNull(proposal.getWithdrawal());
        Assertions.assertEquals(1, proposal.getWithdrawal().size());
        Assertions.assertEquals("11787063000000", proposal.getWithdrawal().get(0).getAmount());
        Assertions.assertEquals("stake1784sdxt6jjennmstphgdu7l7c2scf5d02a6cve2dgn5s2kq5u3j9v",
                proposal.getWithdrawal().get(0).getStakeAddress());
    }

    @Test
    void proposalProcedureWithdrawalUsesStakeAddressTest() throws Exception {
        String json = "{\"index\":0,\"type\":\"TreasuryWithdrawals\"," +
                "\"withdrawal\":[{\"amount\":\"11787063000000\"," +
                "\"stake_address\":\"stake1784sdxt6jjennmstphgdu7l7c2scf5d02a6cve2dgn5s2kq5u3j9v\"}]}";

        ProposalProcedure procedure = objectMapper.readValue(json, ProposalProcedure.class);

        Assertions.assertNotNull(procedure.getWithdrawal());
        Assertions.assertEquals(1, procedure.getWithdrawal().size());
        Assertions.assertEquals("stake1784sdxt6jjennmstphgdu7l7c2scf5d02a6cve2dgn5s2kq5u3j9v",
                procedure.getWithdrawal().get(0).getStakeAddress());
    }

    @Test
    void votingSummaryPassiveVotePowerExceedsIntRangeTest() throws Exception {
        String json = "{\"proposal_type\":\"NewCommittee\",\"epoch_no\":653," +
                "\"pool_passive_always_abstain_vote_power\":\"9868154138925825\"," +
                "\"pool_passive_always_no_confidence_vote_power\":\"48183240800265\"}";

        ProposalVotingSummary summary = objectMapper.readValue(json, ProposalVotingSummary.class);

        Assertions.assertEquals("9868154138925825", summary.getPoolPassiveAlwaysAbstainVotePower());
        Assertions.assertEquals("48183240800265", summary.getPoolPassiveAlwaysNoConfidenceVotePower());
    }
}
