package com.reina.koios.client.backend.api.asset;

import com.reina.koios.client.backend.api.asset.model.*;
import com.reina.koios.client.backend.api.base.exception.ApiException;
import com.reina.koios.client.backend.factory.options.Options;

public interface AssetService {

    /**
     * Asset List
     * Get the list of all native assets (paginated)
     * <p><b>200</b> - Array of policy IDs and asset names
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering & Pagination options (optional)
     * @return Array of {@link Asset} - policy IDs and asset names
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Asset[] getAssetList(Options options) throws ApiException;

    /**
     * Assets Address List
     * Get a list of all addresses for a given asset
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName   Asset Name in hexadecimal format (hex) (required)
     * @return Array of {@link AssetAddress}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    AssetAddress[] getAssetsAddressList(String assetPolicy, String assetName) throws ApiException;

    /**
     * Asset Information
     * Get the information of an asset incl first minting &amp; token registry metadata
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName   Asset Name in hexadecimal format (hex) (required)
     * @return Array of {@link AssetInformation}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    AssetInformation[] getAssetInformation(String assetPolicy, String assetName) throws ApiException;

    /**
     * Asset Summary
     * Get the summary of an asset (total transactions exclude minting/total wallets include only wallets with asset balance)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName   Asset Name in hexadecimal format (hex) (required)
     * @return Array of {@link AssetTx}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    AssetSummary[] getAssetSummary(String assetPolicy, String assetName) throws ApiException;

    /**
     * Asset Transaction History
     * Get the list of all asset transaction hashes (newest first)
     * <p><b>200</b> - Success!
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param assetPolicy Asset Policy ID in hexadecimal format (hex) (required)
     * @param assetName   Asset Name in hexadecimal format (hex) (required)
     * @return Array of {@link AssetTx}
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    AssetTx[] getAssetTransactionHistory(String assetPolicy, String assetName) throws ApiException;
}
