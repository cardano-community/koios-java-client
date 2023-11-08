package rest.koios.client.backend.api.script.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

/**
 * Script Redeemer
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ScriptRedeemer {

    /**
     * Hash of Transaction for which details are being shown
     */
    private String scriptHash;

    /**
     * List of {@link Redeemer}
     */
    private List<Redeemer> redeemers = null;
}
