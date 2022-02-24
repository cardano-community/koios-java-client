package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * withdrawals within a transaction
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxWithdrawal {

    /**
     * Withdrawal amount (in lovelaces)
     */
    private String amount;

    /**
     * List of withdrawals with-in a transaction (if any)
     */
    private List<String> stakeAddr;
}
