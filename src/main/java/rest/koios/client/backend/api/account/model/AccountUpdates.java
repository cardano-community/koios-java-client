package rest.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import rest.koios.client.backend.api.TxHash;
import lombok.*;

/**
 * Account Updates
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountUpdates extends TxHash {

    /**
     * Account Update Action Type
     */
    private String actionType;
}
