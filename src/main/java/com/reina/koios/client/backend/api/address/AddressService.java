package com.reina.koios.client.backend.api.address;

import com.reina.koios.client.backend.api.TxHash;
import com.reina.koios.client.backend.api.address.model.AddressInfo;
import com.reina.koios.client.backend.api.address.model.AssetInfo;
import com.reina.koios.client.backend.api.base.exception.ApiException;

import java.util.List;

public interface AddressService {

    /**
     * Address Information
     * Get address info - balance, associated stake address (if any) and UTXO set
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param address Cardano payment address in bech32 format (required)
     * @return Array of {@link AddressInfo} with Balance, Stake Address, UTxO set associated with the specified address.
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    AddressInfo[] getAddressInformation(String address) throws ApiException;

    /**
     * Address Transactions
     * Get the transaction hash list of input address array, optionally filtering after specified block height (inclusive)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param addressList      input address list
     * @param afterBlockHeight filtering after specified block height (inclusive)
     * @return Array of {@link TxHash} Included Transactions
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    TxHash[] getAddressTransactions(List<String> addressList, Integer afterBlockHeight) throws ApiException;

    /**
     * Address Assets
     * Get the list of all the assets (policy, name and quantity) for a given address
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param address Cardano payment address in bech32 format (required)
     * @return Array of {@link AssetInfo} Included in specified address
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    AssetInfo[] getAddressAssets(String address) throws ApiException;

    /**
     * Transactions from payment credentials
     * Get the transaction hash list of input payment credential array, optionally filtering after specified block height (inclusive)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param paymentCredentialsList List of Cardano payment credential(s) in hex format
     * @param afterBlockHeight       Only fetch information after specific block height
     * @return Array of {@link TxHash} Included Transactions
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    TxHash[] getTransactionsByPaymentCredentials(List<String> paymentCredentialsList, Integer afterBlockHeight) throws ApiException;
}
