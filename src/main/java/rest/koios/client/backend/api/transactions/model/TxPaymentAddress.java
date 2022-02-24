package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * A Cardano payment/base address for transaction's input/output UTxO
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxPaymentAddress {

    /**
     * A Cardano payment/base address (bech32 encoded) for transaction's input/output UTxO
     */
    private String bech32;

    /**
     * Payment credential
     */
    private String cred;
}
