package rest.koios.client.backend.api.asset;

import rest.koios.client.backend.api.asset.model.*;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.common.TxHash;
import rest.koios.client.backend.api.base.common.UTxO;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.utils.Tuple;

import java.util.List;

/**
 * Asset Service
 */
public interface AssetService {

    /**
     * Asset List with Filtering, Pagination, Ordering Options
     * Get the list of all native assets (paginated)
     * <p><b>200</b> - Array of policy IDs and asset names
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link Asset} - policy IDs and asset names
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<Asset>> getAssetList(Options options) throws ApiException;

    /**
     * Asset Token Registry
     * Get a list of assets registered via token registry on github
     * <p><b>200</b> - Array of token registry information for each asset
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Array of token registry information for each asset
     */
    Result<List<AssetTokenRegistry>> getAssetTokenRegistry(Options options) throws ApiException;

    /**
     * Assets Addresses with Filtering, Pagination, Ordering Options
     * Get a list of all addresses for a given asset
     * <p><b>200</b> - List of payment addresses holding the given token (including balances)
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName   Asset Name in hexadecimal format (hex), empty asset name returns royalties
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AssetAddress} holding the given token (including balances)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AssetAddress>> getAssetsAddresses(String assetPolicy, String assetName, Options options) throws ApiException;

    /**
     * NFT Address
     * Get the address where specified NFT currently reside on.
     * <p><b>200</b> - Payment addresses currently holding the given NFT
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName   Asset Name in hexadecimal format (hex) (optional)
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PaymentAddress} holding the given token
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PaymentAddress>> getNFTAddress(String assetPolicy, String assetName, Options options) throws ApiException;

    /**
     * Policy Asset Address List
     * Get the list of addresses with quantity for each asset on the given policy
     * <p><b>200</b> - Payment addresses currently holding the given NFT
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AssetAddress} for the given policy (including balances)
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AssetAddress>> getPolicyAssetAddressList(String assetPolicy, Options options) throws ApiException;

    /**
     * Asset Information
     * Get the information of an asset incl first minting &amp; token registry metadata
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName   Asset Name in hexadecimal format (hex) (required)
     * @return Result of Type List of {@link AssetInformation}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<AssetInformation> getAssetInformation(String assetPolicy, String assetName) throws ApiException;

    /**
     * Asset Information (Bulk)
     * Get the information of a list of assets including first minting &amp; token registry metadata
     * <p><b>200</b> - List of detailed asset information
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetList List of Tuple of policy ID and asset names (hex)
     * @param options   Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AssetInformation}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AssetInformation>> getAssetInformationBulk(List<Tuple<String, String>> assetList, Options options) throws ApiException;

    /**
     * Asset UTxOs
     * Get the UTXO information of a list of assets
     * <p><b>200</b> - List of UTxOs for given asset list
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetList List of Tuple of policy ID and asset names (hex)
     * @param extended  Controls whether or not certain optional fields supported by a given endpoint are populated as a part of the call
     * @param options   Filtering and Pagination options (optional)
     * @return Result of Type List of {@link UTxO} for given asset list
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<UTxO>> getAssetUTxOs(List<Tuple<String, String>> assetList, Boolean extended, Options options) throws ApiException;

    /**
     * Asset History with Filtering, Pagination, Ordering Options
     * Get the mint/burn history of an asset
     * <p><b>200</b> - Array of asset mint/burn history
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName   Asset Name in hexadecimal format (hex) (required)
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AssetHistory}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AssetHistory>> getAssetHistory(String assetPolicy, String assetName, Options options) throws ApiException;

    /**
     * Policy Asset Information
     * Get the information for all assets under the same policy
     * <p><b>200</b> - List of detailed information of assets under the same policy
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PolicyAssetInfo}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PolicyAssetInfo>> getPolicyAssetInformation(String assetPolicy, Options options) throws ApiException;

    /**
     * Policy Asset Mints
     * Get a list of mint information for assets under requested policies
     * <p><b>200</b> - List of mint or burn count details for all assets minted under a policy
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PolicyAssetMint}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PolicyAssetMint>> getPolicyAssetMints(String assetPolicy, Options options) throws ApiException;

    /**
     * Policy Asset List
     * Get the list of asset under the given policy (including balances)
     * <p><b>200</b> - List of detailed information of assets under the same policy
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link PolicyAsset}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<PolicyAsset>> getPolicyAssetList(String assetPolicy, Options options) throws ApiException;

    /**
     * Asset Summary
     * Get the summary of an asset (total transactions exclude minting/total wallets include only wallets with asset balance)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName   Asset Name in hexadecimal format (hex) (required)
     * @return Result of Type List of {@link AssetSummary}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<AssetSummary> getAssetSummary(String assetPolicy, String assetName) throws ApiException;

    /**
     * Asset Transactions with Filtering, Pagination, Ordering Options
     * Get the list of all asset transaction hashes (newest first)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName   Asset Name in hexadecimal format (hex) (required)
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link TxHash}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<TxHash>> getAssetTransactions(String assetPolicy, String assetName, Options options) throws ApiException;

    /**
     * Asset Transactions with Filtering, Pagination, Ordering Options
     * Get the list of all asset transaction hashes (newest first)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy      Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName        Asset Name in hexadecimal format (hex) (required)
     * @param afterBlockHeight Block height for specifying time delta
     * @param history          Include all historical transactions, setting to false includes only the non-empty ones
     * @param options          Filtering and Pagination options (optional)
     * @return Result of Type List of {@link TxHash}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<TxHash>> getAssetTransactions(String assetPolicy, String assetName, Integer afterBlockHeight, boolean history, Options options) throws ApiException;
}
