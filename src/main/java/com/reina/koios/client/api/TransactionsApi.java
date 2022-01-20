package com.reina.koios.client.api;

import com.reina.koios.client.model.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TransactionsApi {
    /**
     * Transaction Information
     * Get detailed information about transaction(s)
     *
     * @param body (optional)
     * @return Call&lt;TxInfo&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("tx_info")
    Call<TxInfo> txInfoPost(
            @Body Object body
    );

    /**
     * Transaction Metadata
     * Get metadata information (if any) for given transaction(s)
     *
     * @param body (optional)
     * @return Call&lt;TxMetadata&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("tx_metadata")
    Call<TxMetadata> txMetadataPost(
            @Body Object body
    );

    /**
     * Transaction Metadata Labels
     * Get a list of all transaction metalabels
     *
     * @return Call&lt;TxMetalabels&gt;
     */
    @GET("tx_metalabels")
    Call<TxMetalabels> txMetalabelsGet();


    /**
     * Transaction Status (Block Confirmations)
     * Get the number of block confirmations for a given transaction hash list
     *
     * @param body (optional)
     * @return Call&lt;TxStatus&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("tx_status")
    Call<TxStatus> txStatusPost(
            @Body Object body
    );

    /**
     * Transaction UTxOs
     * Get UTxO set (inputs/outputs) of transactions.
     *
     * @param body (optional)
     * @return Call&lt;TxUtxos&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("tx_utxos")
    Call<TxUtxos> txUtxosPost(
            @Body Object body
    );

}
