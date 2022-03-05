package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Plutus Script Input
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PlutusScriptInput {

    /**
     * Plutus Script Redeemer
     */
    private PlutusScriptRedeemer redeemer;

    /**
     * Datum
     */
    private Datum datum;
}
