package rest.koios.client.backend.api.governance;

import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.governance.model.*;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

/**
 * Governance Service
 */
public interface GovernanceService {

    /**
     * DReps Epoch Summary
     * Summary of voting power and DRep count for each epoch
     *
     * @param epochNo   Epoch Number to fetch details for
     * @param options   Filtering Options (optional)
     * @return Summary of voting power and DRep count for each epoch
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<DRepEpochSummary>> getDRepsEpochSummary(Integer epochNo, Options options) throws ApiException;

    /**
     * DReps List
     * List of all active delegated representatives (DReps)
     *
     * @param options   Filtering Options (optional)
     * @return List of all active delegated representatives (DReps)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<DRep>> getDRepsList(Options options) throws ApiException;

    /**
     * DReps Info
     * Get detailed information about requested delegated representatives (DReps)
     *
     * @param drepIds   List of DRep Ids
     * @param options   Filtering Options (optional)
     * @return Detailed information about requested delegated representatives (DReps)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<DRepInfo>> getDRepsInfo(List<String> drepIds, Options options) throws ApiException;

    /**
     * DReps Metadata
     * List metadata for requested delegated representatives (DReps)
     *
     * @param drepIds   List of DRep Ids
     * @param options   Filtering Options (optional)
     * @return Metadata for requested delegated representatives (DReps)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<DRepMetadata>> getDRepsMetadata(List<String> drepIds, Options options) throws ApiException;

    /**
     * DReps Updates
     * List of updates for requested (or all) delegated representatives (DReps)
     *
     * @param drepId   DRep ID in bech32 format
     * @param options  Filtering Options (optional)
     * @return List of updates for requested (or all) delegated representatives (DReps)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<DRepUpdate>> getDRepsUpdates(String drepId, Options options) throws ApiException;

    /**
     * DReps Voting Power History
     * History of DReps voting power against each (or requested) epoch
     *
     * @param drepId   DRep ID in bech32 format
     * @param epochNo  Epoch Number to fetch details for
     * @param options  Filtering Options (optional)
     * @return History of DReps voting power against each (or requested) epoch
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<DRepVotingPowerHistory>> getDRepsVotingPowerHistory(String drepId, Integer epochNo, Options options) throws ApiException;

    /**
     * DReps Votes
     * List of all votes cast by requested delegated representative (DRep)
     *
     * @param drepId   DRep ID in bech32 format
     * @param options  Filtering Options (optional)
     * @return List of all votes cast by requested delegated representative (DRep)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    @Deprecated
    Result<List<DRepVote>> getDRepsVotes(String drepId, Options options) throws ApiException;

    /**
     * DReps Delegators
     * List of all delegators to requested delegated representative (DRep)
     *
     * @param drepId   DRep ID in bech32 format
     * @param options  Filtering Options (optional)
     * @return List of all delegators to requested delegated representative (DRep)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<DRepDelegator>> getDRepsDelegators(String drepId, Options options) throws ApiException;

    /**
     * Committee Information
     * Information about active committee and its members
     *
     * @param options   Filtering Options (optional)
     * @return Current governance committee information
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<CommitteeInfo>> getCommitteeInformation(Options options) throws ApiException;

    /**
     * Committee Votes
     * List of all votes cast by a given committee member or collective
     *
     * @param ccHotId  Committee member hot key ID in Bech32 format (CIP-5 | CIP-129)
     * @param options  Filtering Options (optional)
     * @return List of all votes cast by a given committee member or collective
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<CommitteeVote>> getCommitteeVotes(String ccHotId, Options options) throws ApiException;

    /**
     * Proposals List
     * List of all governance proposals
     *
     * @param options   Filtering Options (optional)
     * @return List of all governance action proposals
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<Proposal>> getProposalList(Options options) throws ApiException;

    /**
     * Voter's Proposal List
     * List of all governance proposals for specified DRep, SPO or Committee credential
     *
     * @param voterId   Voter ID (DRep, SPO, Committee Member) in Bech32 format (CIP-5 | CIP-129) (optional)
     * @param options   Filtering Options (optional)
     * @return List of all governance action proposals for the specified voter
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<Proposal>> getVoterProposals(String voterId, Options options) throws ApiException;

    /**
     * Proposal Voting Summary
     * Summary of votes for a given proposal
     *
     * @param proposalId Government proposal ID in CIP-129 Bech32 format
     * @param options    Filtering Options (optional)
     * @return Summary of votes for the given proposal
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<ProposalVotingSummary>> getProposalVotingSummary(String proposalId, Options options) throws ApiException;

    /**
     * Proposal Votes
     * List of all votes cast on a specified governance action
     *
     * @param proposalId Government proposal ID in CIP-129 Bech32 format
     * @param options    Filtering Options (optional)
     * @return List of all votes cast on the specified governance action
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<ProposalVote>> getProposalVotes(String proposalId, Options options) throws ApiException;

    /**
     * Vote List
     * List of all votes posted on-chain
     *
     * @param options Filtering Options (optional)
     * @return List of all votes posted on-chain
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<Vote>> getVoteList(Options options) throws ApiException;

    /**
     * Pool's Voting Power History
     * History of Pool voting power against each (or requested) epoch
     *
     * @param poolBech32 Pool ID in bech32 format
     * @param epochNo    Epoch Number to fetch details for
     * @param options    Filtering Options (optional)
     * @return List of all votes cast by the requested pool
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PoolsVotingPowerHistory>> getPoolsVotingPowerHistory(String poolBech32, Integer epochNo, Options options) throws ApiException;

    /**
     * Pool Votes
     * List of all votes cast by a pool
     *
     * @param poolBech32 Pool ID in bech32 format
     * @param options    Filtering Options (optional)
     * @return List of all votes cast by the requested pool
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    @Deprecated
    Result<List<PoolVote>> getPoolVotes(String poolBech32, Options options) throws ApiException;
}
