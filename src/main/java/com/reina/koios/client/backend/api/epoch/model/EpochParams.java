package com.reina.koios.client.backend.api.epoch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EpochParams {

    /**
     * Epoch number
     */
    private Long epochNo = null;

    /**
     * The 'a' parameter to calculate the minimum transaction fee
     */
    private Integer minFeeA = null;

    /**
     * The 'b' parameter to calculate the minimum transaction fee
     */
    private Integer minFeeB = null;

    /**
     * The maximum block size (in bytes)
     */
    private Integer maxBlockSize = null;

    /**
     * The maximum transaction size (in bytes)
     */
    private Integer maxTxSize = null;

    /**
     * The maximum block header size (in bytes)
     */
    private Integer maxBhSize = null;

    /**
     * The amount (in lovelace) required for a deposit to register a stake address
     */
    private Integer keyDeposit = null;

    /**
     * The amount (in lovelace) required for a deposit to register a stake pool
     */
    private Integer poolDeposit = null;

    /**
     * The maximum number of epochs in the future that a pool retirement is allowed to be scheduled for
     */
    private Integer maxEpoch = null;

    /**
     * The optimal number of stake pools
     */
    private Integer optimalPoolCount = null;

    /**
     * The pledge influence on pool rewards
     */
    private Double influence = null;

    /**
     * The monetary expansion rate
     */
    private Double monetaryExpandRate = null;

    /**
     * The treasury growth rate
     */
    private Double treasuryGrowthRate = null;

    /**
     * The decentralisation parameter (1 fully centralised, 0 fully decentralised)
     */
    private Double decentralisation = null;

    /**
     * The hash of 32-byte string of extra random-ness added into the protocol's entropy pool
     */
    private String entropy = null;

    /**
     * The protocol major version
     */
    private Integer protocolMajor = null;

    /**
     * The protocol minor version
     */
    private Integer protocolMinor = null;

    /**
     * The minimum value of a UTxO entry
     */
    private Integer minUtxoValue = null;

    /**
     * The minimum pool cost
     */
    private Integer minPoolCost = null;

    /**
     * The nonce value for this epoch
     */
    private String nonce = null;

    /**
     * The hash of the first block where these parameters are valid
     */
    private String blockHash = null;

    /**
     * The per language cost models
     */
    private String costModels = null;

    /**
     * The per word cost of script memory usage
     */
    private Double priceMem = null;

    /**
     * The cost of script execution step usage
     */
    private Double priceStep = null;

    /**
     * The maximum number of execution memory allowed to be used in a single transaction
     */
    private BigDecimal maxTxExMem = null;

    /**
     * The maximum number of execution steps allowed to be used in a single transaction
     */
    private BigDecimal maxTxExSteps = null;

    /**
     * The maximum number of execution memory allowed to be used in a single block
     */
    private BigDecimal maxBlockExMem = null;

    /**
     * The maximum number of execution steps allowed to be used in a single block
     */
    private BigDecimal maxBlockExSteps = null;

    /**
     * The maximum Val size
     */
    private BigDecimal maxValSize = null;

    /**
     * The percentage of the tx fee which must be provided as collateral when including non-native scripts
     */
    private Integer collateralPercent = null;

    /**
     * The maximum number of collateral inputs allowed in a transaction
     */
    private Integer maxCollateralInputs = null;

    /**
     * The cost per UTxO word
     */
    private Integer coinsPerUtxoWord = null;
}
