package rest.koios.client.backend.api.network.impl;

import com.fasterxml.jackson.databind.JsonNode;
import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.network.NetworkService;
import rest.koios.client.backend.api.network.api.NetworkApi;
import rest.koios.client.backend.api.network.model.*;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;

import java.util.List;

/**
 * Network Service Implementation
 */
public class NetworkServiceImpl extends BaseService implements NetworkService {

    private final NetworkApi networkApi;

    /**
     * Network Service Implementation Constructor
     *
     * @param baseUrl  Base Url
     * @param apiToken Authorization Bearer JWT Token
     */
    public NetworkServiceImpl(String baseUrl, String apiToken) {
        super(baseUrl, apiToken);
        networkApi = getRetrofit().create(NetworkApi.class);
    }

    @Override
    public Result<Tip> getChainTip() throws ApiException {
        Call<List<Tip>> call = networkApi.getChainTip();
        return processResponseGetOne(call);
    }

    @Override
    public Result<Genesis> getGenesisInfo() throws ApiException {
        Call<List<Genesis>> call = networkApi.getGenesisInfo();
        return processResponseGetOne(call);
    }

    @Override
    public Result<Totals> getHistoricalTokenomicStatsByEpoch(Integer epochNo) throws ApiException {
        validateEpoch(epochNo);
        Call<List<Totals>> call = networkApi.getHistoricalTokenomicStatsByEpoch(epochNo);
        return processResponseGetOne(call);
    }

    @Override
    public Result<List<Totals>> getHistoricalTokenomicStats(Options options) throws ApiException {
        Call<List<Totals>> call = networkApi.getHistoricalTokenomicStats(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<ParamUpdateProposal>> getParamUpdateProposals(Options options) throws ApiException {
        Call<List<ParamUpdateProposal>> call = networkApi.getParamUpdateProposals(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<JsonNode> getCliProtocolParameters(Options options) throws ApiException {
        Call<JsonNode> call = networkApi.getCliProtocolParameters(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<Withdrawal>> getReserveWithdrawals(Options options) throws ApiException {
        Call<List<Withdrawal>> call = networkApi.getReserveWithdrawals(optionsToParamMap(options));
        return processResponse(call);
    }

    @Override
    public Result<List<Withdrawal>> getTreasuryWithdrawals(Options options) throws ApiException {
        Call<List<Withdrawal>> call = networkApi.getTreasuryWithdrawals(optionsToParamMap(options));
        return processResponse(call);
    }
}
