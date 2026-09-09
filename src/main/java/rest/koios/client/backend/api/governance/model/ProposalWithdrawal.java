package rest.koios.client.backend.api.governance.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Amount withdrawn from treasury into a specified stake address by a governance proposal
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProposalWithdrawal {

    /**
     * Withdrawal amount (in lovelaces)
     */
    private String amount;

    /**
     * A Cardano staking address (reward account, bech32 encoded)
     */
    private String stakeAddress;
}
