package rest.koios.client.backend.api.address;

import rest.koios.client.backend.api.base.common.TxHash;
import rest.koios.client.backend.api.address.model.AddressAsset;
import rest.koios.client.backend.api.address.model.AddressInfo;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.backend.factory.options.SortType;

import java.util.List;

/**
 * Address Service
 */
public interface AddressService {

    /**
     * Address Information
     * Get address info - balance, associated stake address (if any) and UTXO set Sorted by a Descending Order
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param address Cardano payment address in bech32 format (required)
     * @return Result of Type List of {@link AddressInfo} with Balance, Stake Address, UTxO set associated with the specified address.
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<AddressInfo> getAddressInformation(String address) throws ApiException;

    /**
     * Address Information
     * Get address info - balance, associated stake address (if any) and UTXO set
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param addressList  Array of Cardano payment address(es) in bech32 format
     * @param utxoSortType UTxO sort Parameter by Block Height. DESC or ASC.
     * @param options      Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AddressInfo} with Balance, Stake Address, UTxO set associated with the specified address.
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AddressInfo>> getAddressInformation(List<String> addressList, SortType utxoSortType, Options options) throws ApiException;

    /**
     * Address UTXOs
     * Get UTxO set for given addresses
     * <p><b>200</b> - List of address UTxOs
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param addresses List of Cardano payment address(es) in bech32 format
     * @param extended  Controls whether or not certain optional fields supported by a given endpoint are populated as a part of the call
     * @param options   Filtering and Pagination options (optional)
     * @return Result of Type List of address {@link UTxO}s.
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<UTxO>> getAddressUTxOs(List<String> addresses, boolean extended, Options options) throws ApiException;

    /**
     * UTxOs from payment credentials
     * Get UTxO details for requested payment credentials
     * <p><b>200</b> - List of address UTxOs
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param paymentCredentials List of Cardano payment credential(s) in hex format
     * @param extended           Controls whether or not certain optional fields supported by a given endpoint are populated as a part of the call
     * @param options            Filtering and Pagination options (optional)
     * @return Result of Type List of address {@link UTxO}s.
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<UTxO>> getUTxOsFromPaymentCredentials(List<String> paymentCredentials, boolean extended, Options options) throws ApiException;

    /**
     * Address Transactions with Filtering, Pagination, Ordering Options
     * Get the transaction hash list of input address array
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param addressList input address list
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link TxHash} Included Transactions
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<TxHash>> getAddressTransactions(List<String> addressList, Options options) throws ApiException;

    /**
     * Address Transactions After Block Height with Filtering, Pagination, Ordering Options
     * Get the transaction hash list of input address array, optionally filtering after specified block height (inclusive)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param addressList      input address list
     * @param afterBlockHeight filtering after specified block height (inclusive)
     * @param options          Filtering and Pagination options (optional)
     * @return Result of Type List of {@link TxHash} Included Transactions
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<TxHash>> getAddressTransactions(List<String> addressList, Integer afterBlockHeight, Options options) throws ApiException;

    /**
     * Address Assets with Filtering, Pagination, Ordering Options
     * Get the list of all the assets (policy, name and quantity) for a given address
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param addressList Array of Cardano payment address(es) in bech32 format
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AddressAsset} Included in specified address
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AddressAsset>> getAddressAssets(List<String> addressList, Options options) throws ApiException;

    /**
     * Transactions from payment credentials with Filtering, Pagination, Ordering Options
     * Get the transaction hash list of input payment credential array, optionally filtering after specified block height (inclusive)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param paymentCredentialsList List of Cardano payment credential(s) in hex format
     * @param options                Filtering and Pagination options (optional)
     * @return Result of Type List of {@link TxHash} Included Transactions
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<TxHash>> getTransactionsByPaymentCredentials(List<String> paymentCredentialsList, Options options) throws ApiException;

    /**
     * Transactions from payment credentials with Filtering, Pagination, Ordering Options
     * Get the transaction hash list of input payment credential array, optionally filtering after specified block height (inclusive)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param paymentCredentialsList List of Cardano payment credential(s) in hex format
     * @param afterBlockHeight       Only fetch information after specific block height
     * @param options                Filtering and Pagination options (optional)
     * @return Result of Type List of {@link TxHash} Included Transactions
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<TxHash>> getTransactionsByPaymentCredentials(List<String> paymentCredentialsList, Integer afterBlockHeight, Options options) throws ApiException;
}
