package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Plutus Script Redeemer
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PlutusScriptRedeemer {

    /**
     * What kind of validation this redeemer is used for
     */
    private Purpose purpose;

    /**
     * The budget in fees to run a script - the fees depend on the ExUnits and the current prices
     */
    private String fee;

    /**
     * Unit
     */
    private Unit unit;

    /**
     * Datum
     */
    private Datum datum;
}
