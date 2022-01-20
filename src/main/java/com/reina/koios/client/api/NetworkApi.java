package com.reina.koios.client.api;

import com.reina.koios.client.model.Genesis;
import com.reina.koios.client.model.Tip;
import com.reina.koios.client.model.Totals;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkApi {
    /**
     * Get Genesis info
     * Get the Genesis parameters used to start specific era on chain
     *
     * @return Call&lt;Genesis&gt;
     */
    @GET("genesis")
    Call<Genesis> genesisGet();


    /**
     * Query Chain Tip
     * Get the tip info about the latest block seen by chain
     *
     * @return Call&lt;Tip&gt;
     */
    @GET("tip")
    Call<Tip> tipGet();


    /**
     * Get historical tokenomic stats
     * Get the circulating utxo, treasury, rewards, supply and reserves in lovelace for specified epoch, all epochs if empty
     *
     * @param _epochNo Epoch Number to fetch details for (optional)
     * @return Call&lt;Totals&gt;
     */
    @GET("totals")
    Call<Totals> totalsGet(@Query("_epoch_no") String _epochNo);
}
