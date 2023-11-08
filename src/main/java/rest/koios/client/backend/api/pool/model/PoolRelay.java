package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.ArrayList;

/**
 * Pool Relay
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolRelay {

    /**
     * Pool ID (bech32 format)
     */
    private String poolIdBech32;

    /**
     * Relays
     */
    private ArrayList<Relay> relays;

    /**
     * Pool Status: registered | retiring | retired
     */
    private String poolStatus;
}
