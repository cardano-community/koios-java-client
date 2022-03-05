package rest.koios.client.backend.api.address.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.Set;

/**
 * Address Information
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressInfo {

    /**
     * Balance of Address for which details are being shown
     */
    private String balance;

    /**
     * Cardano staking address in bech32 format
     */
    private String stakeAddress;

    /**
     * Signifies whether the address is a script address
     */
    private Boolean scriptAddress;

    /**
     * Set of UTxOs of Address for which details are being shown
     */
    private Set<AddressUtxo> utxoSet;
}
