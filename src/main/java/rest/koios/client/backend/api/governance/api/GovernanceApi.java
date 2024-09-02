package rest.koios.client.backend.api.governance.api;

import rest.koios.client.backend.api.governance.model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Governance API
 */
public interface GovernanceApi {

    /**
     * DReps Epoch Summary
     * Summary of voting power and DRep count for each epoch
     *
     * @param epochNo   Epoch Number to fetch details for
     * @param paramsMap Filtering Options Query Parameters
     * @return Summary of voting power and DRep count for each epoch
     */
    @GET("drep_epoch_summary")
    Call<List<DRepEpochSummary>> getDRepsEpochSummary(@Query("_epoch_no") Integer epochNo, @QueryMap Map<String, String> paramsMap);

    /**
     * DReps List
     * List of all active delegated representatives (DReps)
     *
     * @param paramsMap Filtering Options Query Parameters
     * @return List of all active delegated representatives (DReps)
     */
    @GET("drep_list")
    Call<List<DRep>> getDRepsList(@QueryMap Map<String, String> paramsMap);

    /**
     * DReps Info
     * Get detailed information about requested delegated representatives (DReps)
     *
     * @param requestBody Array of DRep Ids
     * @param paramsMap   Filtering Options Query Parameters
     * @return Get detailed information about requested delegated representatives (DReps)
     */
    @POST("drep_info")
    Call<List<DRepInfo>> getDRepsInfo(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * DReps Metadata
     * List metadata for requested delegated representatives (DReps)
     *
     * @param requestBody Array of DRep Ids
     * @param paramsMap   Filtering Options Query Parameters
     * @return List metadata for requested delegated representatives (DReps)
     */
    @POST("drep_metadata")
    Call<List<DRepMetadata>> getDRepsMetadata(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * DReps Updates
     * List of updates for requested (or all) delegated representatives (DReps)
     *
     * @param drepId    DRep ID in bech32 format
     * @param paramsMap Filtering Options Query Parameters
     * @return List of updates for requested (or all) delegated representatives (DReps)
     */
    @GET("drep_updates")
    Call<List<DRepUpdate>> getDRepsUpdates(@Query("_drep_id") String drepId, @QueryMap Map<String, String> paramsMap);

    /**
     * DReps Votes
     * List of all votes casted by requested delegated representative (DRep)
     *
     * @param drepId    DRep ID in bech32 format
     * @param paramsMap Filtering Options Query Parameters
     * @return List of all votes casted by requested delegated representative (DRep)
     */
    @GET("drep_votes")
    Call<List<DRepVote>> getDRepsVotes(@Query("_drep_id") String drepId, @QueryMap Map<String, String> paramsMap);

    /**
     * DReps Delegators
     * List of all delegators to requested delegated representative (DRep).
     *
     * @param drepId    DRep ID in bech32 format
     * @param paramsMap Filtering Options Query Parameters
     * @return List of all delegators to requested delegated representative (DRep).
     */
    @GET("drep_delegators")
    Call<List<DRepDelegator>> getDRepsDelegators(@Query("_drep_id") String drepId, @QueryMap Map<String, String> paramsMap);

    /**
     * Committee Information
     * Information about active committee and its members
     *
     * @param paramsMap Filtering Options Query Parameters
     * @return Current governance committee
     */
    @GET("committee_info")
    Call<List<CommitteeInfo>> getCommitteeInformation(@QueryMap Map<String, String> paramsMap);

    /**
     * Committee Votes
     * List of all votes casted by given committee member or collective
     *
     * @param ccHotId   Committee member hot key ID in Bech32 format (CIP-5 | CIP-129)
     * @param paramsMap Filtering Options Query Parameters
     * @return List of all votes casted by requested delegated representative (DRep)
     */
    @GET("committee_votes")
    Call<List<CommitteeVote>> getCommitteeVotes(@Query("_cc_hot_id") String ccHotId, @QueryMap Map<String, String> paramsMap);

    /**
     * Proposals List
     * List of all governance proposals
     *
     * @param paramsMap Filtering Options Query Parameters
     * @return List of all governance action proposals
     */
    @GET("proposal_list")
    Call<List<Proposal>> getProposalList(@QueryMap Map<String, String> paramsMap);

    /**
     * Voter's Proposal List
     * List of all governance proposals for specified DRep, SPO or Committee credential
     *
     * @param voterId   Voter ID (Drep, SPO, Committee Member) in Bech32 format (CIP-5 | CIP-129)
     * @param paramsMap Filtering Options Query Parameters
     * @return List of all governance action proposals
     */
    @GET("voter_proposal_list")
    Call<List<Proposal>> getVoterProposal(@Query("_voter_id") String voterId, @QueryMap Map<String, String> paramsMap);

    /**
     * Proposal Voting Summary
     * Summary of votes for given proposal
     *
     * @param proposalId Government proposal ID in CIP-129 Bech32 format
     * @param paramsMap  Filtering Options Query Parameters
     * @return Summary of votes for given proposal
     */
    @GET("proposal_voting_summary")
    Call<List<ProposalVotingSummary>> getProposalVotingSummary(@Query("_proposal_id") String proposalId, @QueryMap Map<String, String> paramsMap);

    /**
     * Proposal Votes
     * List of all votes cast on specified governance action
     *
     * @param proposalId Government proposal ID in CIP-129 Bech32 format
     * @param paramsMap  Filtering Options Query Parameters
     * @return List of all votes cast on specified governance action
     */
    @GET("proposal_votes")
    Call<List<ProposalVote>> getProposalVotes(@Query("_proposal_id") String proposalId, @QueryMap Map<String, String> paramsMap);

    /**
     * Pool Votes
     * List of all votes casted by a pool
     *
     * @param poolBech32 Pool ID in bech32 format
     * @param paramsMap  Filtering Options Query Parameters
     * @return List of all votes casted by requested pool
     */
    @GET("pool_votes")
    Call<List<PoolVote>> getPoolVotes(@Query("_pool_bech32") String poolBech32, @QueryMap Map<String, String> paramsMap);
}
