package rest.koios.client.backend.api.asset.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Asset Address
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaymentAddress {

    /**
     * A Cardano payment/base address (bech32 encoded) for transaction's input UTxO
     */
    private String paymentAddress;

    /**
     * Cardano staking address (reward account) in bech32 format
     */
    private String stakeAddress;
}
