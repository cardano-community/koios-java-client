package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Certificate Info
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxCertificateInfo {

    /**
     * Cardano staking address in bech32 format
     */
    private String stakeAddress;

    /**
     * Cardano pool ID in bech32 format
     */
    private String poolIdBech32;

    /**
     * Pool ID (Hex format)
     */
    private String poolIdHex;
}
