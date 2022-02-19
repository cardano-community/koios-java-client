package rest.koios.client.backend.api.epoch;

import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.epoch.model.EpochInfo;
import rest.koios.client.backend.api.epoch.model.EpochParams;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

/**
 * Epoch Service
 */
public interface EpochService {

    /**
     * Epoch Information
     * Get the epoch information, all epochs if no epoch specified
     * <p><b>200</b> - Array of detailed summary for each epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param epochNo Epoch Number to fetch details for (optional)
     * @return Result of Type List of {@link EpochInfo} detailed summary for each epoch
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<EpochInfo>> getEpochInformation(Long epochNo) throws ApiException;

    /**
     * Epoch Information
     * Get the epoch information, all epochs if no epoch specified
     * <p><b>200</b> - Array of detailed summary for each epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link EpochInfo} detailed summary for each epoch
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<EpochInfo>> getEpochInformation(Options options) throws ApiException;

    /**
     * Epoch's Protocol Parameters
     * Get the protocol parameters for specific epoch, returns information about all epochs if no epoch specified
     * <p><b>200</b> - Array of protocol parameters for each epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param epochNo Epoch Number to fetch details for (optional)
     * @return Result of Type List of {@link EpochParams} protocol parameters for each epoch
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<EpochParams>> getEpochParameters(Long epochNo) throws ApiException;

    /**
     * Epoch's Protocol Parameters
     * Get the protocol parameters for specific epoch, returns information about all epochs if no epoch specified
     * <p><b>200</b> - Array of protocol parameters for each epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link EpochParams} protocol parameters for each epoch
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<EpochParams>> getEpochParameters(Options options) throws ApiException;
}
