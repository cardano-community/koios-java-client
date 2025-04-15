package rest.koios.client.backend.api.network.api;

import com.fasterxml.jackson.databind.JsonNode;
import rest.koios.client.backend.api.network.model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * Network API
 */
public interface NetworkApi {

    @GET("tip")
    Call<List<Tip>> getChainTip();

    @GET("genesis")
    Call<List<Genesis>> getGenesisInfo();

    @GET("totals")
    Call<List<Totals>> getHistoricalTokenomicStatsByEpoch(@Query("_epoch_no") Integer epochNo);

    @GET("totals")
    Call<List<Totals>> getHistoricalTokenomicStats(@QueryMap Map<String, String> paramsMap);

    @GET("param_updates")
    Call<List<ParamUpdateProposal>> getParamUpdateProposals(@QueryMap Map<String, String> paramsMap);

    @GET("cli_protocol_params")
    Call<JsonNode> getCliProtocolParameters(@QueryMap Map<String, String> paramsMap);

    @GET("reserve_withdrawals")
    Call<List<Withdrawal>> getReserveWithdrawals(@QueryMap Map<String, String> paramsMap);

    @GET("treasury_withdrawals")
    Call<List<Withdrawal>> getTreasuryWithdrawals(@QueryMap Map<String, String> paramsMap);
}
