package com.reina.koios.client.backend.api.script.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ScriptRedeemer {

    /**
     * Hash of Transaction for which details are being shown
     */
    private String scriptHash = null;

    /**
     * List of {@link Redeemer}
     */
    private List<Redeemer> redeemers = null;
}
