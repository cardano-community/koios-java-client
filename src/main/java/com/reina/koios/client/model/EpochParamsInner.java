package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * EpochParamsInner
 */
public class EpochParamsInner {
  @SerializedName("epoch_no")
  private Integer epochNo = null;

  @SerializedName("min_fee_a")
  private Integer minFeeA = null;

  @SerializedName("min_fee_b")
  private Integer minFeeB = null;

  @SerializedName("max_block_size")
  private Integer maxBlockSize = null;

  @SerializedName("max_tx_size")
  private Integer maxTxSize = null;

  @SerializedName("max_bh_size")
  private Integer maxBhSize = null;

  @SerializedName("key_deposit")
  private Integer keyDeposit = null;

  @SerializedName("pool_deposit")
  private Integer poolDeposit = null;

  @SerializedName("max_epoch")
  private Integer maxEpoch = null;

  @SerializedName("optimal_pool_count")
  private Integer optimalPoolCount = null;

  @SerializedName("influence")
  private Double influence = null;

  @SerializedName("monetary_expand_rate")
  private Double monetaryExpandRate = null;

  @SerializedName("treasury_growth_rate")
  private Double treasuryGrowthRate = null;

  @SerializedName("decentralisation")
  private Double decentralisation = null;

  @SerializedName("entropy")
  private String entropy = null;

  @SerializedName("protocol_major")
  private Integer protocolMajor = null;

  @SerializedName("protocol_minor")
  private Integer protocolMinor = null;

  @SerializedName("min_utxo_value")
  private Integer minUtxoValue = null;

  @SerializedName("min_pool_cost")
  private Integer minPoolCost = null;

  @SerializedName("nonce")
  private String nonce = null;

  @SerializedName("block_hash")
  private String blockHash = null;

  @SerializedName("cost_models")
  private String costModels = null;

  @SerializedName("price_mem")
  private Double priceMem = null;

  @SerializedName("price_step")
  private Double priceStep = null;

  @SerializedName("max_tx_ex_mem")
  private BigDecimal maxTxExMem = null;

  @SerializedName("max_tx_ex_steps")
  private BigDecimal maxTxExSteps = null;

  @SerializedName("max_block_ex_mem")
  private BigDecimal maxBlockExMem = null;

  @SerializedName("max_block_ex_steps")
  private BigDecimal maxBlockExSteps = null;

  @SerializedName("max_val_size")
  private BigDecimal maxValSize = null;

  @SerializedName("collateral_percent")
  private Integer collateralPercent = null;

  @SerializedName("max_collateral_inputs")
  private Integer maxCollateralInputs = null;

  @SerializedName("coins_per_utxo_word")
  private Integer coinsPerUtxoWord = null;

  public EpochParamsInner epochNo(Integer epochNo) {
    this.epochNo = epochNo;
    return this;
  }

   /**
   * Epoch number
   * @return epochNo
  **/
  @Schema(example = "294", description = "Epoch number")
  public Integer getEpochNo() {
    return epochNo;
  }

  public void setEpochNo(Integer epochNo) {
    this.epochNo = epochNo;
  }

  public EpochParamsInner minFeeA(Integer minFeeA) {
    this.minFeeA = minFeeA;
    return this;
  }

   /**
   * The &#x27;a&#x27; parameter to calculate the minimum transaction fee
   * @return minFeeA
  **/
  @Schema(example = "44", description = "The 'a' parameter to calculate the minimum transaction fee")
  public Integer getMinFeeA() {
    return minFeeA;
  }

  public void setMinFeeA(Integer minFeeA) {
    this.minFeeA = minFeeA;
  }

  public EpochParamsInner minFeeB(Integer minFeeB) {
    this.minFeeB = minFeeB;
    return this;
  }

   /**
   * The &#x27;b&#x27; parameter to calculate the minimum transaction fee
   * @return minFeeB
  **/
  @Schema(example = "155381", description = "The 'b' parameter to calculate the minimum transaction fee")
  public Integer getMinFeeB() {
    return minFeeB;
  }

  public void setMinFeeB(Integer minFeeB) {
    this.minFeeB = minFeeB;
  }

  public EpochParamsInner maxBlockSize(Integer maxBlockSize) {
    this.maxBlockSize = maxBlockSize;
    return this;
  }

   /**
   * The maximum block size (in bytes)
   * @return maxBlockSize
  **/
  @Schema(example = "65536", description = "The maximum block size (in bytes)")
  public Integer getMaxBlockSize() {
    return maxBlockSize;
  }

  public void setMaxBlockSize(Integer maxBlockSize) {
    this.maxBlockSize = maxBlockSize;
  }

  public EpochParamsInner maxTxSize(Integer maxTxSize) {
    this.maxTxSize = maxTxSize;
    return this;
  }

   /**
   * The maximum transaction size (in bytes)
   * @return maxTxSize
  **/
  @Schema(example = "16384", description = "The maximum transaction size (in bytes)")
  public Integer getMaxTxSize() {
    return maxTxSize;
  }

  public void setMaxTxSize(Integer maxTxSize) {
    this.maxTxSize = maxTxSize;
  }

  public EpochParamsInner maxBhSize(Integer maxBhSize) {
    this.maxBhSize = maxBhSize;
    return this;
  }

   /**
   * The maximum block header size (in bytes)
   * @return maxBhSize
  **/
  @Schema(example = "1100", description = "The maximum block header size (in bytes)")
  public Integer getMaxBhSize() {
    return maxBhSize;
  }

  public void setMaxBhSize(Integer maxBhSize) {
    this.maxBhSize = maxBhSize;
  }

  public EpochParamsInner keyDeposit(Integer keyDeposit) {
    this.keyDeposit = keyDeposit;
    return this;
  }

   /**
   * The amount (in lovelace) required for a deposit to register a stake address
   * @return keyDeposit
  **/
  @Schema(example = "2000000", description = "The amount (in lovelace) required for a deposit to register a stake address")
  public Integer getKeyDeposit() {
    return keyDeposit;
  }

  public void setKeyDeposit(Integer keyDeposit) {
    this.keyDeposit = keyDeposit;
  }

  public EpochParamsInner poolDeposit(Integer poolDeposit) {
    this.poolDeposit = poolDeposit;
    return this;
  }

   /**
   * The amount (in lovelace) required for a deposit to register a stake pool
   * @return poolDeposit
  **/
  @Schema(example = "500000000", description = "The amount (in lovelace) required for a deposit to register a stake pool")
  public Integer getPoolDeposit() {
    return poolDeposit;
  }

  public void setPoolDeposit(Integer poolDeposit) {
    this.poolDeposit = poolDeposit;
  }

  public EpochParamsInner maxEpoch(Integer maxEpoch) {
    this.maxEpoch = maxEpoch;
    return this;
  }

   /**
   * The maximum number of epochs in the future that a pool retirement is allowed to be scheduled for
   * @return maxEpoch
  **/
  @Schema(example = "18", description = "The maximum number of epochs in the future that a pool retirement is allowed to be scheduled for")
  public Integer getMaxEpoch() {
    return maxEpoch;
  }

  public void setMaxEpoch(Integer maxEpoch) {
    this.maxEpoch = maxEpoch;
  }

  public EpochParamsInner optimalPoolCount(Integer optimalPoolCount) {
    this.optimalPoolCount = optimalPoolCount;
    return this;
  }

   /**
   * The optimal number of stake pools
   * @return optimalPoolCount
  **/
  @Schema(example = "500", description = "The optimal number of stake pools")
  public Integer getOptimalPoolCount() {
    return optimalPoolCount;
  }

  public void setOptimalPoolCount(Integer optimalPoolCount) {
    this.optimalPoolCount = optimalPoolCount;
  }

  public EpochParamsInner influence(Double influence) {
    this.influence = influence;
    return this;
  }

   /**
   * The pledge influence on pool rewards
   * @return influence
  **/
  @Schema(example = "0.3", description = "The pledge influence on pool rewards")
  public Double getInfluence() {
    return influence;
  }

  public void setInfluence(Double influence) {
    this.influence = influence;
  }

  public EpochParamsInner monetaryExpandRate(Double monetaryExpandRate) {
    this.monetaryExpandRate = monetaryExpandRate;
    return this;
  }

   /**
   * The monetary expansion rate
   * @return monetaryExpandRate
  **/
  @Schema(example = "0.003", description = "The monetary expansion rate")
  public Double getMonetaryExpandRate() {
    return monetaryExpandRate;
  }

  public void setMonetaryExpandRate(Double monetaryExpandRate) {
    this.monetaryExpandRate = monetaryExpandRate;
  }

  public EpochParamsInner treasuryGrowthRate(Double treasuryGrowthRate) {
    this.treasuryGrowthRate = treasuryGrowthRate;
    return this;
  }

   /**
   * The treasury growth rate
   * @return treasuryGrowthRate
  **/
  @Schema(example = "0.2", description = "The treasury growth rate")
  public Double getTreasuryGrowthRate() {
    return treasuryGrowthRate;
  }

  public void setTreasuryGrowthRate(Double treasuryGrowthRate) {
    this.treasuryGrowthRate = treasuryGrowthRate;
  }

  public EpochParamsInner decentralisation(Double decentralisation) {
    this.decentralisation = decentralisation;
    return this;
  }

   /**
   * The decentralisation parameter (1 fully centralised, 0 fully decentralised)
   * @return decentralisation
  **/
  @Schema(example = "0.1", description = "The decentralisation parameter (1 fully centralised, 0 fully decentralised)")
  public Double getDecentralisation() {
    return decentralisation;
  }

  public void setDecentralisation(Double decentralisation) {
    this.decentralisation = decentralisation;
  }

  public EpochParamsInner entropy(String entropy) {
    this.entropy = entropy;
    return this;
  }

   /**
   * The hash of 32-byte string of extra random-ness added into the protocol&#x27;s entropy pool
   * @return entropy
  **/
  @Schema(example = "d982e06fd33e7440b43cefad529b7ecafbaa255e38178ad4189a37e4ce9bf1fa", description = "The hash of 32-byte string of extra random-ness added into the protocol's entropy pool")
  public String getEntropy() {
    return entropy;
  }

  public void setEntropy(String entropy) {
    this.entropy = entropy;
  }

  public EpochParamsInner protocolMajor(Integer protocolMajor) {
    this.protocolMajor = protocolMajor;
    return this;
  }

   /**
   * The protocol major version
   * @return protocolMajor
  **/
  @Schema(example = "5", description = "The protocol major version")
  public Integer getProtocolMajor() {
    return protocolMajor;
  }

  public void setProtocolMajor(Integer protocolMajor) {
    this.protocolMajor = protocolMajor;
  }

  public EpochParamsInner protocolMinor(Integer protocolMinor) {
    this.protocolMinor = protocolMinor;
    return this;
  }

   /**
   * The protocol minor version
   * @return protocolMinor
  **/
  @Schema(example = "0", description = "The protocol minor version")
  public Integer getProtocolMinor() {
    return protocolMinor;
  }

  public void setProtocolMinor(Integer protocolMinor) {
    this.protocolMinor = protocolMinor;
  }

  public EpochParamsInner minUtxoValue(Integer minUtxoValue) {
    this.minUtxoValue = minUtxoValue;
    return this;
  }

   /**
   * The minimum value of a UTxO entry
   * @return minUtxoValue
  **/
  @Schema(example = "34482", description = "The minimum value of a UTxO entry")
  public Integer getMinUtxoValue() {
    return minUtxoValue;
  }

  public void setMinUtxoValue(Integer minUtxoValue) {
    this.minUtxoValue = minUtxoValue;
  }

  public EpochParamsInner minPoolCost(Integer minPoolCost) {
    this.minPoolCost = minPoolCost;
    return this;
  }

   /**
   * The minimum pool cost
   * @return minPoolCost
  **/
  @Schema(example = "340000000", description = "The minimum pool cost")
  public Integer getMinPoolCost() {
    return minPoolCost;
  }

  public void setMinPoolCost(Integer minPoolCost) {
    this.minPoolCost = minPoolCost;
  }

  public EpochParamsInner nonce(String nonce) {
    this.nonce = nonce;
    return this;
  }

   /**
   * The nonce value for this epoch
   * @return nonce
  **/
  @Schema(example = "01304ddf5613166be96fce27be110747f2c8fcb38776618ee79225ccb59b81e2", description = "The nonce value for this epoch")
  public String getNonce() {
    return nonce;
  }

  public void setNonce(String nonce) {
    this.nonce = nonce;
  }

  public EpochParamsInner blockHash(String blockHash) {
    this.blockHash = blockHash;
    return this;
  }

   /**
   * The hash of the first block where these parameters are valid
   * @return blockHash
  **/
  @Schema(example = "f9dc2a2fc3a2db09a71af007a740261de585afc9e3022b8e30535592ff4dd9e5", description = "The hash of the first block where these parameters are valid")
  public String getBlockHash() {
    return blockHash;
  }

  public void setBlockHash(String blockHash) {
    this.blockHash = blockHash;
  }

  public EpochParamsInner costModels(String costModels) {
    this.costModels = costModels;
    return this;
  }

   /**
   * The per language cost models
   * @return costModels
  **/
  @Schema(description = "The per language cost models")
  public String getCostModels() {
    return costModels;
  }

  public void setCostModels(String costModels) {
    this.costModels = costModels;
  }

  public EpochParamsInner priceMem(Double priceMem) {
    this.priceMem = priceMem;
    return this;
  }

   /**
   * The per word cost of script memory usage
   * @return priceMem
  **/
  @Schema(example = "0.0577", description = "The per word cost of script memory usage")
  public Double getPriceMem() {
    return priceMem;
  }

  public void setPriceMem(Double priceMem) {
    this.priceMem = priceMem;
  }

  public EpochParamsInner priceStep(Double priceStep) {
    this.priceStep = priceStep;
    return this;
  }

   /**
   * The cost of script execution step usage
   * @return priceStep
  **/
  @Schema(example = "0.0000721", description = "The cost of script execution step usage")
  public Double getPriceStep() {
    return priceStep;
  }

  public void setPriceStep(Double priceStep) {
    this.priceStep = priceStep;
  }

  public EpochParamsInner maxTxExMem(BigDecimal maxTxExMem) {
    this.maxTxExMem = maxTxExMem;
    return this;
  }

   /**
   * The maximum number of execution memory allowed to be used in a single transaction
   * @return maxTxExMem
  **/
  @Schema(example = "10000000", description = "The maximum number of execution memory allowed to be used in a single transaction")
  public BigDecimal getMaxTxExMem() {
    return maxTxExMem;
  }

  public void setMaxTxExMem(BigDecimal maxTxExMem) {
    this.maxTxExMem = maxTxExMem;
  }

  public EpochParamsInner maxTxExSteps(BigDecimal maxTxExSteps) {
    this.maxTxExSteps = maxTxExSteps;
    return this;
  }

   /**
   * The maximum number of execution steps allowed to be used in a single transaction
   * @return maxTxExSteps
  **/
  @Schema(example = "10000000000", description = "The maximum number of execution steps allowed to be used in a single transaction")
  public BigDecimal getMaxTxExSteps() {
    return maxTxExSteps;
  }

  public void setMaxTxExSteps(BigDecimal maxTxExSteps) {
    this.maxTxExSteps = maxTxExSteps;
  }

  public EpochParamsInner maxBlockExMem(BigDecimal maxBlockExMem) {
    this.maxBlockExMem = maxBlockExMem;
    return this;
  }

   /**
   * The maximum number of execution memory allowed to be used in a single block
   * @return maxBlockExMem
  **/
  @Schema(example = "50000000", description = "The maximum number of execution memory allowed to be used in a single block")
  public BigDecimal getMaxBlockExMem() {
    return maxBlockExMem;
  }

  public void setMaxBlockExMem(BigDecimal maxBlockExMem) {
    this.maxBlockExMem = maxBlockExMem;
  }

  public EpochParamsInner maxBlockExSteps(BigDecimal maxBlockExSteps) {
    this.maxBlockExSteps = maxBlockExSteps;
    return this;
  }

   /**
   * The maximum number of execution steps allowed to be used in a single block
   * @return maxBlockExSteps
  **/
  @Schema(example = "40000000000", description = "The maximum number of execution steps allowed to be used in a single block")
  public BigDecimal getMaxBlockExSteps() {
    return maxBlockExSteps;
  }

  public void setMaxBlockExSteps(BigDecimal maxBlockExSteps) {
    this.maxBlockExSteps = maxBlockExSteps;
  }

  public EpochParamsInner maxValSize(BigDecimal maxValSize) {
    this.maxValSize = maxValSize;
    return this;
  }

   /**
   * The maximum Val size
   * @return maxValSize
  **/
  @Schema(example = "5000", description = "The maximum Val size")
  public BigDecimal getMaxValSize() {
    return maxValSize;
  }

  public void setMaxValSize(BigDecimal maxValSize) {
    this.maxValSize = maxValSize;
  }

  public EpochParamsInner collateralPercent(Integer collateralPercent) {
    this.collateralPercent = collateralPercent;
    return this;
  }

   /**
   * The percentage of the tx fee which must be provided as collateral when including non-native scripts
   * @return collateralPercent
  **/
  @Schema(example = "150", description = "The percentage of the tx fee which must be provided as collateral when including non-native scripts")
  public Integer getCollateralPercent() {
    return collateralPercent;
  }

  public void setCollateralPercent(Integer collateralPercent) {
    this.collateralPercent = collateralPercent;
  }

  public EpochParamsInner maxCollateralInputs(Integer maxCollateralInputs) {
    this.maxCollateralInputs = maxCollateralInputs;
    return this;
  }

   /**
   * The maximum number of collateral inputs allowed in a transaction
   * @return maxCollateralInputs
  **/
  @Schema(example = "3", description = "The maximum number of collateral inputs allowed in a transaction")
  public Integer getMaxCollateralInputs() {
    return maxCollateralInputs;
  }

  public void setMaxCollateralInputs(Integer maxCollateralInputs) {
    this.maxCollateralInputs = maxCollateralInputs;
  }

  public EpochParamsInner coinsPerUtxoWord(Integer coinsPerUtxoWord) {
    this.coinsPerUtxoWord = coinsPerUtxoWord;
    return this;
  }

   /**
   * The cost per UTxO word
   * @return coinsPerUtxoWord
  **/
  @Schema(example = "34482", description = "The cost per UTxO word")
  public Integer getCoinsPerUtxoWord() {
    return coinsPerUtxoWord;
  }

  public void setCoinsPerUtxoWord(Integer coinsPerUtxoWord) {
    this.coinsPerUtxoWord = coinsPerUtxoWord;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EpochParamsInner epochParamsInner = (EpochParamsInner) o;
    return Objects.equals(this.epochNo, epochParamsInner.epochNo) &&
        Objects.equals(this.minFeeA, epochParamsInner.minFeeA) &&
        Objects.equals(this.minFeeB, epochParamsInner.minFeeB) &&
        Objects.equals(this.maxBlockSize, epochParamsInner.maxBlockSize) &&
        Objects.equals(this.maxTxSize, epochParamsInner.maxTxSize) &&
        Objects.equals(this.maxBhSize, epochParamsInner.maxBhSize) &&
        Objects.equals(this.keyDeposit, epochParamsInner.keyDeposit) &&
        Objects.equals(this.poolDeposit, epochParamsInner.poolDeposit) &&
        Objects.equals(this.maxEpoch, epochParamsInner.maxEpoch) &&
        Objects.equals(this.optimalPoolCount, epochParamsInner.optimalPoolCount) &&
        Objects.equals(this.influence, epochParamsInner.influence) &&
        Objects.equals(this.monetaryExpandRate, epochParamsInner.monetaryExpandRate) &&
        Objects.equals(this.treasuryGrowthRate, epochParamsInner.treasuryGrowthRate) &&
        Objects.equals(this.decentralisation, epochParamsInner.decentralisation) &&
        Objects.equals(this.entropy, epochParamsInner.entropy) &&
        Objects.equals(this.protocolMajor, epochParamsInner.protocolMajor) &&
        Objects.equals(this.protocolMinor, epochParamsInner.protocolMinor) &&
        Objects.equals(this.minUtxoValue, epochParamsInner.minUtxoValue) &&
        Objects.equals(this.minPoolCost, epochParamsInner.minPoolCost) &&
        Objects.equals(this.nonce, epochParamsInner.nonce) &&
        Objects.equals(this.blockHash, epochParamsInner.blockHash) &&
        Objects.equals(this.costModels, epochParamsInner.costModels) &&
        Objects.equals(this.priceMem, epochParamsInner.priceMem) &&
        Objects.equals(this.priceStep, epochParamsInner.priceStep) &&
        Objects.equals(this.maxTxExMem, epochParamsInner.maxTxExMem) &&
        Objects.equals(this.maxTxExSteps, epochParamsInner.maxTxExSteps) &&
        Objects.equals(this.maxBlockExMem, epochParamsInner.maxBlockExMem) &&
        Objects.equals(this.maxBlockExSteps, epochParamsInner.maxBlockExSteps) &&
        Objects.equals(this.maxValSize, epochParamsInner.maxValSize) &&
        Objects.equals(this.collateralPercent, epochParamsInner.collateralPercent) &&
        Objects.equals(this.maxCollateralInputs, epochParamsInner.maxCollateralInputs) &&
        Objects.equals(this.coinsPerUtxoWord, epochParamsInner.coinsPerUtxoWord);
  }

  @Override
  public int hashCode() {
    return Objects.hash(epochNo, minFeeA, minFeeB, maxBlockSize, maxTxSize, maxBhSize, keyDeposit, poolDeposit, maxEpoch, optimalPoolCount, influence, monetaryExpandRate, treasuryGrowthRate, decentralisation, entropy, protocolMajor, protocolMinor, minUtxoValue, minPoolCost, nonce, blockHash, costModels, priceMem, priceStep, maxTxExMem, maxTxExSteps, maxBlockExMem, maxBlockExSteps, maxValSize, collateralPercent, maxCollateralInputs, coinsPerUtxoWord);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EpochParamsInner {\n");
    
    sb.append("    epochNo: ").append(toIndentedString(epochNo)).append("\n");
    sb.append("    minFeeA: ").append(toIndentedString(minFeeA)).append("\n");
    sb.append("    minFeeB: ").append(toIndentedString(minFeeB)).append("\n");
    sb.append("    maxBlockSize: ").append(toIndentedString(maxBlockSize)).append("\n");
    sb.append("    maxTxSize: ").append(toIndentedString(maxTxSize)).append("\n");
    sb.append("    maxBhSize: ").append(toIndentedString(maxBhSize)).append("\n");
    sb.append("    keyDeposit: ").append(toIndentedString(keyDeposit)).append("\n");
    sb.append("    poolDeposit: ").append(toIndentedString(poolDeposit)).append("\n");
    sb.append("    maxEpoch: ").append(toIndentedString(maxEpoch)).append("\n");
    sb.append("    optimalPoolCount: ").append(toIndentedString(optimalPoolCount)).append("\n");
    sb.append("    influence: ").append(toIndentedString(influence)).append("\n");
    sb.append("    monetaryExpandRate: ").append(toIndentedString(monetaryExpandRate)).append("\n");
    sb.append("    treasuryGrowthRate: ").append(toIndentedString(treasuryGrowthRate)).append("\n");
    sb.append("    decentralisation: ").append(toIndentedString(decentralisation)).append("\n");
    sb.append("    entropy: ").append(toIndentedString(entropy)).append("\n");
    sb.append("    protocolMajor: ").append(toIndentedString(protocolMajor)).append("\n");
    sb.append("    protocolMinor: ").append(toIndentedString(protocolMinor)).append("\n");
    sb.append("    minUtxoValue: ").append(toIndentedString(minUtxoValue)).append("\n");
    sb.append("    minPoolCost: ").append(toIndentedString(minPoolCost)).append("\n");
    sb.append("    nonce: ").append(toIndentedString(nonce)).append("\n");
    sb.append("    blockHash: ").append(toIndentedString(blockHash)).append("\n");
    sb.append("    costModels: ").append(toIndentedString(costModels)).append("\n");
    sb.append("    priceMem: ").append(toIndentedString(priceMem)).append("\n");
    sb.append("    priceStep: ").append(toIndentedString(priceStep)).append("\n");
    sb.append("    maxTxExMem: ").append(toIndentedString(maxTxExMem)).append("\n");
    sb.append("    maxTxExSteps: ").append(toIndentedString(maxTxExSteps)).append("\n");
    sb.append("    maxBlockExMem: ").append(toIndentedString(maxBlockExMem)).append("\n");
    sb.append("    maxBlockExSteps: ").append(toIndentedString(maxBlockExSteps)).append("\n");
    sb.append("    maxValSize: ").append(toIndentedString(maxValSize)).append("\n");
    sb.append("    collateralPercent: ").append(toIndentedString(collateralPercent)).append("\n");
    sb.append("    maxCollateralInputs: ").append(toIndentedString(maxCollateralInputs)).append("\n");
    sb.append("    coinsPerUtxoWord: ").append(toIndentedString(coinsPerUtxoWord)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
