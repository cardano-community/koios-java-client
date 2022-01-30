package com.reina.koios.client.backend.api.epoch;

import com.reina.koios.client.backend.api.epoch.model.EpochInfo;
import com.reina.koios.client.backend.api.epoch.model.EpochParams;

public interface EpochService {

    /**
     * Epoch Information
     * Get the epoch information, all epochs if no epoch specified
     * <p><b>200</b> - Array of detailed summary for each epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param epochNo Epoch Number to fetch details for (optional)
     * @return Array of {@link EpochInfo} detailed summary for each epoch
     */
    EpochInfo[] getEpochInformation(String epochNo);

    /**
     * Epoch's Protocol Parameters
     * Get the protocol parameters for specific epoch, returns information about all epochs if no epoch specified
     * <p><b>200</b> - Array of protocol parameters for each epoch
     * <p><b>401</b> - The selected server has restricted the endpoint to be only usable via authentication. The authentication supplied was not authorized to access the endpoint
     * <p><b>404</b> - The server does not recognise the combination of endpoint and parameters provided
     *
     * @param epochNo Epoch Number to fetch details for (optional)
     * @return Array of {@link EpochParams} protocol parameters for each epoch
     */
    EpochParams[] getEpochParameters(String epochNo);
}
