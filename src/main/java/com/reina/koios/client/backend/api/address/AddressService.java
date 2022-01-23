package com.reina.koios.client.backend.api.address;

import com.reina.koios.client.backend.api.TxHash;
import com.reina.koios.client.backend.api.address.model.AddressInfo;
import com.reina.koios.client.backend.api.address.model.AssetInfo;

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
     */
    AddressInfo[] getAddressInformation(String address);

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
     */
    TxHash[] getAddressTransactions(List<String> addressList, Integer afterBlockHeight);

    /**
     * Transactions from payment credentials
     * Get the transaction hash list of input payment credential array, optionally filtering after specified block height (inclusive)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param paymentCredentialList input payment credential list
     * @param afterBlockHeight      filtering after specified block height (inclusive)
     * @return Array of {@link TxHash} Included Transactions
     */
    TxHash[] getTransactionsByPaymentCredentials(List<String> paymentCredentialList, Integer afterBlockHeight);

    /**
     * Address Assets
     * Get the list of all the assets (policy, name and quantity) for a given address
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param address Cardano payment address in bech32 format (required)
     * @return Array of {@link AssetInfo} Included in specified address
     */
    AssetInfo[] getAddressAssets(String address);
}
