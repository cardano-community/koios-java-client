package com.reina.koios.client.backend.api.script.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@NoArgsConstructor
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
    private Long unitSteps;

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
