package rest.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Account Updates
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountUpdates {

    /**
     * Allowed: registration | delegation | withdrawal | deregistration
     * Type of certificate submitted
     */
    private String actionType;

    /**
     * Hash identifier of the transaction
     */
    private String txHash;
}
