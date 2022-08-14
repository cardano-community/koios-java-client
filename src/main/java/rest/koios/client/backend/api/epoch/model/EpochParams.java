package rest.koios.client.backend.api.epoch.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rest.koios.client.backend.api.epoch.helper.CostModelsDeserializer;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Epoch Parameters
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EpochParams {

    /**
     * Epoch number
     */
    private Integer epochNo = null;

    /**
     * Extra Entropy
     */
    private String extraEntropy;

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
    private String keyDeposit = null;

    /**
     * The amount (in lovelace) required for a deposit to register a stake pool
     */
    private String poolDeposit = null;

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
    private BigDecimal influence = null;

    /**
     * The monetary expansion rate
     */
    private BigDecimal monetaryExpandRate = null;

    /**
     * The treasury growth rate
     */
    private BigDecimal treasuryGrowthRate = null;

    /**
     * The decentralisation parameter (1 fully centralised, 0 fully decentralised)
     */
    private BigDecimal decentralisation = null;

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
    private String minUtxoValue = null;

    /**
     * The minimum pool cost
     */
    private String minPoolCost = null;

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
    @JsonDeserialize(using = CostModelsDeserializer.class)
    private Map<String, Map<String, Long>> costModels = null;

    /**
     * The per word cost of script memory usage
     */
    private BigDecimal priceMem = null;

    /**
     * The cost of script execution step usage
     */
    private BigDecimal priceStep = null;

    /**
     * The maximum number of execution memory allowed to be used in a single transaction
     */
    private String maxTxExMem = null;

    /**
     * The maximum number of execution steps allowed to be used in a single transaction
     */
    private String maxTxExSteps = null;

    /**
     * The maximum number of execution memory allowed to be used in a single block
     */
    private String maxBlockExMem = null;

    /**
     * The maximum number of execution steps allowed to be used in a single block
     */
    private String maxBlockExSteps = null;

    /**
     * The maximum Val size
     */
    private String maxValSize = null;

    /**
     * The percentage of the tx fee which must be provided as collateral when including non-native scripts
     */
    private Integer collateralPercent = null;

    /**
     * The maximum number of collateral inputs allowed in a transaction
     */
    private Integer maxCollateralInputs = null;

    /**
     * The cost per UTxO size
     */
    private String coinsPerUtxoSize = null;

    /**
     * The cost per UTxO word
     */
    @Deprecated
    private String coinsPerUtxoWord = null;
}
