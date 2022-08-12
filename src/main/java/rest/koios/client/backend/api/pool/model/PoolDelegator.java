package rest.koios.client.backend.api.pool.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Pool Delegator
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolDelegator {

    private String stakeAddress;

    /**
     * Current delegator live stake (in lovelace)
     */
    private Long amount;

    /**
     * Epoch number
     */
    private Integer activeEpochNo;
}
