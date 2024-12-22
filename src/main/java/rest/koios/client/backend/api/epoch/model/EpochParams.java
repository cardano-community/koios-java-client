package rest.koios.client.backend.api.epoch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

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
     * Extra Entropy
     */
    private String extraEntropy;

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
    private JsonNode costModels = null;

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
     * Pool Voting threshold for motion of no-confidence.
     */
    private BigDecimal pvtMotionNoConfidence = null;

    /**
     * Pool Voting threshold for new committee/threshold (normal state).
     */
    private BigDecimal pvtCommitteeNormal = null;

    /**
     * Pool Voting threshold for new committee/threshold (state of no-confidence).
     */
    private BigDecimal pvtCommitteeNoConfidence = null;

    /**
     * Pool Voting threshold for hard-fork initiation.
     */
    private BigDecimal pvtHardForkInitiation = null;

    /**
     * DRep Vote threshold for motion of no-confidence.
     */
    private BigDecimal dvtMotionNoConfidence = null;

    /**
     * DRep Vote threshold for new committee/threshold (normal state).
     */
    private BigDecimal dvtCommitteeNormal = null;

    /**
     * DRep Vote threshold for new committee/threshold (state of no-confidence).
     */
    private BigDecimal dvtCommitteeNoConfidence = null;

    /**
     * DRep Vote threshold for update to the Constitution.
     */
    private BigDecimal dvtUpdateToConstitution = null;

    /**
     * DRep Vote threshold for hard-fork initiation.
     */
    private BigDecimal dvtHardForkInitiation = null;

    /**
     * DRep Vote threshold for protocol parameter changes, network group.
     */
    @JsonProperty("dvt_p_p_network_group")
    private BigDecimal dvtPPNetworkGroup = null;

    /**
     * DRep Vote threshold for protocol parameter changes, economic group.
     */
    @JsonProperty("dvt_p_p_economic_group")
    private BigDecimal dvtPPEconomicGroup = null;

    /**
     * DRep Vote threshold for protocol parameter changes, technical group.
     */
    @JsonProperty("dvt_p_p_technical_group")
    private BigDecimal dvtPPTechnicalGroup = null;

    /**
     * DRep Vote threshold for protocol parameter changes, governance group.
     */
    @JsonProperty("dvt_p_p_gov_group")
    private BigDecimal dvtPPGovGroup = null;

    /**
     * DRep Vote threshold for treasury withdrawal.
     */
    private BigDecimal dvtTreasuryWithdrawal = null;

    /**
     * Minimal constitutional committee size.
     */
    private Integer committeeMinSize = null;

    /**
     * Constitutional committee term limits.
     */
    private Integer committeeMaxTermLength = null;

    /**
     * Governance action expiration.
     */
    private Integer govActionLifetime = null;

    /**
     * Governance action deposit.
     */
    private String govActionDeposit = null;

    /**
     * DRep deposit amount.
     */
    private String drepDeposit = null;

    /**
     * DRep activity period.
     */
    private Integer drepActivity = null;

    /**
     * Pool Voting threshold for protocol parameter changes, security group.
     */
    private BigDecimal pvtppSecurityGroup = null;

    /**
     * Minimum Fee for Reference Script cost per byte.
     */
    private BigDecimal minFeeRefScriptCostPerByte = null;
}
