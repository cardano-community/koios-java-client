package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Plutus Contract
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxPlutusContract {

    /**
     * Plutus script address
     */
    private String address;

    /**
     * Hash of a script
     */
    private String scriptHash;

    /**
     * CBOR-encoded Plutus script data
     */
    private String bytecode;

    /**
     * The size of the CBOR serialised script (in bytes)
     */
    private Integer size;

    /**
     * True if the contract is valid or there is no contract
     */
    private Boolean validContract;

    /**
     * Plutus Script Input
     */
    private PlutusScriptInput input;
}
