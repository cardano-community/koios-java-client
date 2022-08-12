package rest.koios.client.backend.api.transactions.api;

import okhttp3.RequestBody;
import rest.koios.client.backend.api.transactions.model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Transaction API
 */
public interface TransactionApi {

    @POST("tx_info")
    Call<List<TxInfo>> getTransactionInformation(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    @POST("tx_utxos")
    Call<List<TxUtxo>> getTransactionUTxOs(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    @POST("tx_metadata")
    Call<List<TxMetadata>> getTransactionMetadata(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    @GET("tx_metalabels")
    Call<List<TxMetadataLabels>> getTransactionMetadataLabels(@QueryMap Map<String, String> paramsMap);

    /**
     * Submit Tx
     * @param requestBody body
     * @return Tx Id
     */
    @Headers("Content-Type: application/cbor")
    @POST("submittx")
    Call<String> submitTx(@Body RequestBody requestBody);

    /**
     * getTransactionStatus
     * @param requestBody body
     * @param paramsMap request params
     * @return List of Tx Statuses
     */
    @POST("tx_status")
    Call<List<TxStatus>> getTransactionStatus(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);
}
