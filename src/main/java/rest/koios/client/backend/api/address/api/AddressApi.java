package rest.koios.client.backend.api.address.api;

import rest.koios.client.backend.api.address.model.AddressOutput;
import rest.koios.client.backend.api.base.common.TxHash;
import rest.koios.client.backend.api.address.model.AddressAsset;
import rest.koios.client.backend.api.address.model.AddressInfo;
import rest.koios.client.backend.api.base.common.UTxO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * Address API
 */
public interface AddressApi {

    /**
     * Get address info
     * balance, associated stake address (if any) and UTxO set for given addresses
     *
     * @param requestBody Array of Cardano payment address(es) in bech32 format
     * @param paramsMap   Options and Filters Map
     * @return List of {@link AddressInfo}
     */
    @POST("address_info")
    Call<List<AddressInfo>> getAddressInformation(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * Get Address UTxOs
     *
     * @param requestBody Json Body containing List of Cardano payment address(es) in bech32 format
     * @param paramsMap   Query Params
     * @return List of complete UTxO information
     */
    @POST("address_utxos")
    Call<List<UTxO>> getAddressUTxOs(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * Get Address Outputs
     *
     * @param requestBody Json Body containing List of Cardano payment address(es) in bech32 format
     * @param paramsMap   Query Params
     * @return List of complete UTxO information
     */
    @POST("address_outputs")
    Call<List<AddressOutput>> getAddressOutputs(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * UTxOs from payment credentials
     * Get UTxO details for requested payment credentials
     *
     * @param requestBody Json Body containing List of Cardano payment credential(s) in hex format
     * @param paramsMap   Query Params
     * @return List of complete UTxO information
     */
    @POST("credential_utxos")
    Call<List<UTxO>> getUTxOsFromPaymentCredentials(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * Address Transactions
     * Get the transaction hash list of input address array, optionally filtering after specified block height (inclusive)
     *
     * @param requestBody Array of Cardano payment address(es) in bech32 format
     * @param paramsMap   Options and Filters Map
     * @return List of {@link TxHash}
     */
    @POST("address_txs")
    Call<List<TxHash>> getAddressTransactions(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    /**
     * Get the list of all the assets (policy, name and quantity) for given addresses
     *
     * @param requestBody Array of Cardano payment address(es) in bech32 format
     * @param paramsMap   Options and Filters Map
     * @return List of {@link AddressAsset}
     */
    @POST("address_assets")
    Call<List<AddressAsset>> getAddressAssets(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);

    @POST("credential_txs")
    Call<List<TxHash>> getTransactionsByPaymentCredentials(@Body Map<String, Object> requestBody, @QueryMap Map<String, String> paramsMap);
}
