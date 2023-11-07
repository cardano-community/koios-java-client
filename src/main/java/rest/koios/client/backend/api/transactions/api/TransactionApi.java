package rest.koios.client.backend.api.transactions.api;

import okhttp3.RequestBody;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.transactions.model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Transaction API
 */
public interface TransactionApi {

    /**
     * Get UTxO set for requested UTxO references
     *
     * @param requestBody Json Body containing Array of Cardano utxo references in the form "hash#index"
     * @param paramsMap   Filtering Options Query Parameters
     * @return detailed information about transaction(s)
     */
    @POST("utxo_info")
    Call<List<UTxO>> getUTxOInfo(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * Get Transaction Information
     *
     * @param requestBody Json Body containing Array of Cardano Transaction hashes
     * @param paramsMap   Filtering Options Query Parameters
     * @return detailed information about transaction(s)
     */
    @POST("tx_info")
    Call<List<TxInfo>> getTransactionInformation(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * Get Transaction Metadata
     *
     * @param requestBody Json Body containing Array of Cardano Transaction hashes
     * @param paramsMap   Filtering Options Query Parameters
     * @return Metadata information (if any) for given transaction(s)
     */
    @POST("tx_metadata")
    Call<List<TxMetadata>> getTransactionMetadata(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * Get Transaction Metadata Labels
     *
     * @param paramsMap Filtering Options Query Parameters
     * @return list of all transaction metalabels
     */
    @GET("tx_metalabels")
    Call<List<TxMetadataLabels>> getTransactionMetadataLabels(@QueryMap Map<String, String> paramsMap);

    /**
     * Submit Tx
     *
     * @param requestBody body
     * @return Tx Id
     */
    @Headers("Content-Type: application/cbor")
    @POST("submittx")
    Call<String> submitTx(@Body RequestBody requestBody);

    /**
     * getTransactionStatus
     *
     * @param requestBody body
     * @param paramsMap   request params
     * @return List of Tx Statuses
     */
    @POST("tx_status")
    Call<List<TxStatus>> getTransactionStatus(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);
}
