package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Certificates present within a transaction
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxCertificate {

    /**
     * Certificate index
     */
    private Integer index;

    /**
     * Type of certificate (could be delegation, stake_registration, stake_deregistraion, pool_update, pool_retire, param_proposal, reserve_MIR, treasury_MIR, drep_registration, vote_delegation)
     */
    private String type;

    /**
     * A JSON array containing information from the certificate
     */
    private JsonNode info;
}
