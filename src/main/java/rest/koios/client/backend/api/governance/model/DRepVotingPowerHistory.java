package rest.koios.client.backend.api.governance.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * DRep Voting Power History
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DRepVotingPowerHistory {

    /**
     * DRep ID in CIP-129 bech32 format
     */
    private String drepId;

    /**
     * Epoch number of the block
     */
    private Integer epochNo;

    /**
     * History of DReps voting power against each (or requested) epoch
     */
    private String amount;
}
