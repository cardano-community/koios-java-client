package rest.koios.client.backend.api.account.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Account History Inner
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountHistoryInner {

    /**
     * Bech32 representation of pool ID
     */
    private String poolId = null;

    /**
     * Epoch number
     */
    private Integer epochNo = null;

    /**
     * Active stake amount (in lovelaces)
     */
    private String activeStake = null;
}
