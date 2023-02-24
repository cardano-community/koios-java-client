package rest.koios.client.backend.api.network.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * ParamUpdateProposal
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ParamUpdateProposal {

    /**
     * Hash identifier of the transaction
     */
    private String txHash;

    /**
     * Block height
     */
    private Integer blockHeight;

    /**
     * UNIX timestamp of the block
     */
    private Integer blockTime;

    /**
     * Epoch number
     */
    private Integer epochNo;

    /**
     * JSON encoded data with details about the parameter update
     */
    private JsonNode data;
}
