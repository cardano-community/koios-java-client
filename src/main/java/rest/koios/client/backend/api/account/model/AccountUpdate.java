package rest.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Account Update
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountUpdate {

    /**
     * Type of certificate submitted
     * Allowed: registration | delegation | withdrawal | deregistration
     */
    private String actionType;

    /**
     * Hash identifier of the transaction
     */
    private String txHash;

    /**
     * Epoch number of the block
     */
    private Integer epochNo;

    /**
     * Slot number of the block in epoch
     */
    private Integer epochSlot;

    /**
     * Absolute slot number of the block
     */
    private Integer absoluteSlot;

    /**
     * UNIX timestamp of the block
     */
    private Integer blockTime;
}
