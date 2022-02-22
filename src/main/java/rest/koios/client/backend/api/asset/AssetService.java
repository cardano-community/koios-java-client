package rest.koios.client.backend.api.asset;

import rest.koios.client.backend.api.asset.model.*;
import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.options.Options;

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
     * Assets Address List with Filtering, Pagination, Ordering Options
     * Get a list of all addresses for a given asset
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName   Asset Name in hexadecimal format (hex) (required)
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AssetAddress}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AssetAddress>> getAssetsAddressList(String assetPolicy, String assetName, Options options) throws ApiException;

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
     * Asset Policy Information
     * Get the information for all assets under the same policy
     * <p><b>200</b> - Array of detailed information of assets under the same policy
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @return Result of Type List of {@link AssetPolicyInfo}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<AssetPolicyInfo> getAssetPolicyInformation(String assetPolicy) throws ApiException;

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
     * Asset Transaction History with Filtering, Pagination, Ordering Options
     * Get the list of all asset transaction hashes (newest first)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName   Asset Name in hexadecimal format (hex) (required)
     * @param options     Filtering and Pagination options (optional)
     * @return Result of Type List of {@link AssetTx}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<AssetTx>> getAssetTransactionHistory(String assetPolicy, String assetName, Options options) throws ApiException;
}
