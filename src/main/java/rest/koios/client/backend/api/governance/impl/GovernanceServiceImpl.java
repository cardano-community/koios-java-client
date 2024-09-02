package rest.koios.client.backend.api.governance.impl;

import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.governance.GovernanceService;
import rest.koios.client.backend.api.governance.api.GovernanceApi;
import rest.koios.client.backend.api.governance.model.*;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Governance Service Implementation
 */
public class GovernanceServiceImpl extends BaseService implements GovernanceService {

    private final GovernanceApi governanceApi;

    /**
     * Governance Service Implementation Constructor
     *
     * @param baseUrl  Base Url
     * @param apiToken Authorization Bearer JWT Token
     */
    public GovernanceServiceImpl(String baseUrl, String apiToken) {
        super(baseUrl, apiToken);
        governanceApi = getRetrofit().create(GovernanceApi.class);
    }

    @Override
    public Result<List<DRepEpochSummary>> getDRepsEpochSummary(Integer epochNo, Options options) throws ApiException {
        Call<List<DRepEpochSummary>> call = governanceApi.getDRepsEpochSummary(epochNo, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<DRep>> getDRepsList(Options options) throws ApiException {
        Call<List<DRep>> call = governanceApi.getDRepsList(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<DRepInfo>> getDRepsInfo(List<String> drepIds, Options options) throws ApiException {
        Call<List<DRepInfo>> call = governanceApi.getDRepsInfo(buildBody(drepIds), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<DRepMetadata>> getDRepsMetadata(List<String> drepIds, Options options) throws ApiException {
        Call<List<DRepMetadata>> call = governanceApi.getDRepsMetadata(buildBody(drepIds), optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<DRepUpdate>> getDRepsUpdates(String drepId, Options options) throws ApiException {
        Call<List<DRepUpdate>> call = governanceApi.getDRepsUpdates(drepId, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<DRepVote>> getDRepsVotes(String drepId, Options options) throws ApiException {
        Call<List<DRepVote>> call = governanceApi.getDRepsVotes(drepId, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<DRepDelegator>> getDRepsDelegators(String drepId, Options options) throws ApiException {
        Call<List<DRepDelegator>> call = governanceApi.getDRepsDelegators(drepId, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<CommitteeInfo>> getCommitteeInformation(Options options) throws ApiException {
        Call<List<CommitteeInfo>> call = governanceApi.getCommitteeInformation(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<CommitteeVote>> getCommitteeVotes(String ccHotId, Options options) throws ApiException {
        Call<List<CommitteeVote>> call = governanceApi.getCommitteeVotes(ccHotId, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<Proposal>> getProposalList(Options options) throws ApiException {
        Call<List<Proposal>> call = governanceApi.getProposalList(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<Proposal>> getVoterProposals(String voterId, Options options) throws ApiException {
        Call<List<Proposal>> call = governanceApi.getVoterProposal(voterId, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<ProposalVotingSummary>> getProposalVotingSummary(String proposalId, Options options) throws ApiException {
        Call<List<ProposalVotingSummary>> call = governanceApi.getProposalVotingSummary(proposalId, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<ProposalVote>> getProposalVotes(String proposalId, Options options) throws ApiException {
        Call<List<ProposalVote>> call = governanceApi.getProposalVotes(proposalId, optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<PoolVote>> getPoolVotes(String poolBech32, Options options) throws ApiException {
        Call<List<PoolVote>> call = governanceApi.getPoolVotes(poolBech32, optionsToParamMap(options));
        return processResponse(call);
    }

    private Map<String, Object> buildBody(List<String> txHashes) {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("_drep_ids", txHashes);
        return bodyMap;
    }
}
