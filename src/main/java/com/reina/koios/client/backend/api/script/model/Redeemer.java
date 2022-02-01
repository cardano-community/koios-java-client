package com.reina.koios.client.backend.api.script.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Redeemer {

    /**
     * Hash of Transaction containing the redeemer
     */
    private String txHash;

    /**
     * The index of the redeemer pointer in the transaction
     */
    private Integer txIndex;

    /**
     * The budget in Memory to run a script
     */
    private Integer unitMem;

    /**
     * The budget in Cpu steps to run a script
     */
    private Integer unitSteps;

    /**
     * The budget in fees to run a script - the fees depend on the ExUnits and the current prices
     */
    private BigInteger fee;

    /**
     * What kind pf validation this redeemer is used for, it can be one of 'spend', 'mint', 'cert', 'reward'
     */
    private String purpose;

    /**
     * The Hash of the Plutus Data
     */
    private String datumHash;

    /**
     * The actual data in json format
     */
    private Object datumValue;
}
