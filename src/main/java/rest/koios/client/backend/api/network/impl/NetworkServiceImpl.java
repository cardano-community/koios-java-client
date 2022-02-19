package rest.koios.client.backend.api.network.impl;

import rest.koios.client.backend.api.base.BaseService;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.network.NetworkService;
import rest.koios.client.backend.api.network.api.NetworkApi;
import rest.koios.client.backend.api.network.model.Genesis;
import rest.koios.client.backend.api.network.model.Tip;
import rest.koios.client.backend.api.network.model.Totals;
import rest.koios.client.backend.factory.options.Options;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Network Service Implementation
 */
public class NetworkServiceImpl extends BaseService implements NetworkService {

    private final NetworkApi networkApi;

    /**
     * Network Service Implementation Constructor
     *
     * @param baseUrl Base URL
     */
    public NetworkServiceImpl(String baseUrl) {
        super(baseUrl);
        networkApi = getRetrofit().create(NetworkApi.class);
    }

    @Override
    public Result<List<Tip>> getChainTip() throws ApiException {
        Call<List<Tip>> call = networkApi.getChainTip();
        try {
            Response<List<Tip>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<Genesis>> getGenesisInfo() throws ApiException {
        Call<List<Genesis>> call = networkApi.getGenesisInfo();
        try {
            Response<List<Genesis>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<Totals>> getHistoricalTokenomicStats(Long epochNo) throws ApiException {
        validateEpoch(epochNo);
        Call<List<Totals>> call = networkApi.getHistoricalTokenomicStats(epochNo);
        try {
            Response<List<Totals>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    @Override
    public Result<List<Totals>> getHistoricalTokenomicStats(Options options) throws ApiException {
        Call<List<Totals>> call = networkApi.getHistoricalTokenomicStats(options.toMap());
        try {
            Response<List<Totals>> response = (Response) execute(call);
            return processResponse(response);
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }
}
