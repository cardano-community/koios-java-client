package rest.koios.client.backend.api.address.api;

import rest.koios.client.backend.api.TxHash;
import rest.koios.client.backend.api.address.model.AddressInfo;
import rest.koios.client.backend.api.address.model.AssetInfo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

/**
 * Address API
 */
public interface AddressApi {

    @GET("address_info")
    Call<List<AddressInfo>> getAddressInformation(@Query("_address") String address);

    @POST("address_txs")
    Call<List<TxHash>> getAddressTransactions(@Body Map<String, Object> requestBody);

    @GET("address_assets")
    Call<List<AssetInfo>> getAddressAssets(@Query("_address") String address);

    @POST("credential_txs")
    Call<List<TxHash>> getTransactionsByPaymentCredentials(@Body Map<String, Object> requestBody);
}
