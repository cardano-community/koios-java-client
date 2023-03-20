package rest.koios.client.backend.api.epoch;

import rest.koios.client.backend.api.base.Result;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.epoch.model.EpochBlockProtocols;
import rest.koios.client.backend.api.epoch.model.EpochInfo;
import rest.koios.client.backend.api.epoch.model.EpochParams;
import rest.koios.client.backend.factory.options.Options;

import java.util.List;

/**
 * Epoch Service
 */
public interface EpochService {

    /**
     * Latest Epoch Information
     * Get the epoch information
     * <p><b>200</b> - Array of detailed summary for each epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @return Result of {@link EpochInfo} detailed summary
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<EpochInfo> getLatestEpochInfo() throws ApiException;

    /**
     * Epoch Information by Specific Epoch
     * Get the epoch information
     * <p><b>200</b> - detailed summary for specified epoch
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param epochNo Epoch Number to fetch details for
     * @return Result of {@link EpochInfo} detailed summary
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<EpochInfo> getEpochInformationByEpoch(Integer epochNo) throws ApiException;

    /**
     * Epoch Information
     * Get the epoch information for all epochs
     * <p><b>200</b> - Array of detailed summary for each epoch
     * <p><b>400</b> - The server cannot process the request due to invalid input
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options          Filtering and Pagination options (optional)
     * @param includeNextEpoch Include information about nearing but not yet started epoch, to get access to active stake snapshot information if available
     * @return Result of Type List of {@link EpochInfo} detailed summary for each epoch
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<EpochInfo>> getEpochInformation(boolean includeNextEpoch, Options options) throws ApiException;

    /**
     * Latest Epoch's Protocol Parameters
     * Get the protocol parameters for latest epoch
     * <p><b>200</b> - protocol parameters for latest epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @return Result of {@link EpochParams} protocol parameters
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<EpochParams> getLatestEpochParameters() throws ApiException;

    /**
     * Epoch's Protocol Parameters by specific Epoch
     * Get the protocol parameters for specific epoch, returns information about all epochs if no epoch specified
     * <p><b>200</b> - Array of protocol parameters for each epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param epochNo Epoch Number to fetch details for
     * @return Result of {@link EpochParams} protocol parameters
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<EpochParams> getEpochParametersByEpoch(Integer epochNo) throws ApiException;

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

    /**
     * Epoch's Block Protocols By Epoch
     * Get the information about block protocol distribution in epoch
     * <p><b>200</b> - Array of distinct block protocol versions counts in epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param epochNo Epoch Number to fetch details for
     * @return Result of {@link EpochParams} protocol parameters
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<EpochBlockProtocols> getEpochBlockProtocolsByEpoch(Integer epochNo) throws ApiException;

    /**
     * Epoch's Block Protocols
     * Get the information about block protocol distribution in epoch
     * <p><b>200</b> - Array of distinct block protocol versions counts in epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param options Filtering and Pagination options (optional)
     * @return Result of Type List of {@link EpochParams} protocol parameters for each epoch
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    Result<List<EpochBlockProtocols>> getEpochBlockProtocols(Options options) throws ApiException;
}
