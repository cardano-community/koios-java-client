package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * EpochInfoInner
 */
public class EpochInfoInner {
  @SerializedName("epoch_no")
  private Integer epochNo = null;

  @SerializedName("out_sum")
  private Integer outSum = null;

  @SerializedName("fees")
  private Integer fees = null;

  @SerializedName("tx_count")
  private Integer txCount = null;

  @SerializedName("blk_count")
  private Integer blkCount = null;

  @SerializedName("first_block_time")
  private String firstBlockTime = null;

  @SerializedName("last_block_time")
  private String lastBlockTime = null;

  @SerializedName("active_stake")
  private Integer activeStake = null;

  public EpochInfoInner epochNo(Integer epochNo) {
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

  public EpochInfoInner outSum(Integer outSum) {
    this.outSum = outSum;
    return this;
  }

   /**
   * Total output value across all transactions in epoch
   * @return outSum
  **/
  @Schema(example = "15432725054364942", description = "Total output value across all transactions in epoch")
  public Integer getOutSum() {
    return outSum;
  }

  public void setOutSum(Integer outSum) {
    this.outSum = outSum;
  }

  public EpochInfoInner fees(Integer fees) {
    this.fees = fees;
    return this;
  }

   /**
   * Total fees incurred by transactions in epoch
   * @return fees
  **/
  @Schema(example = "74325855210", description = "Total fees incurred by transactions in epoch")
  public Integer getFees() {
    return fees;
  }

  public void setFees(Integer fees) {
    this.fees = fees;
  }

  public EpochInfoInner txCount(Integer txCount) {
    this.txCount = txCount;
    return this;
  }

   /**
   * Number of transactions submitted in epoch
   * @return txCount
  **/
  @Schema(example = "357919", description = "Number of transactions submitted in epoch")
  public Integer getTxCount() {
    return txCount;
  }

  public void setTxCount(Integer txCount) {
    this.txCount = txCount;
  }

  public EpochInfoInner blkCount(Integer blkCount) {
    this.blkCount = blkCount;
    return this;
  }

   /**
   * Number of blocks created in epoch
   * @return blkCount
  **/
  @Schema(example = "17321", description = "Number of blocks created in epoch")
  public Integer getBlkCount() {
    return blkCount;
  }

  public void setBlkCount(Integer blkCount) {
    this.blkCount = blkCount;
  }

  public EpochInfoInner firstBlockTime(String firstBlockTime) {
    this.firstBlockTime = firstBlockTime;
    return this;
  }

   /**
   * Timestamp for first block created in epoch
   * @return firstBlockTime
  **/
  @Schema(example = "2021-10-02T21:50:11", description = "Timestamp for first block created in epoch")
  public String getFirstBlockTime() {
    return firstBlockTime;
  }

  public void setFirstBlockTime(String firstBlockTime) {
    this.firstBlockTime = firstBlockTime;
  }

  public EpochInfoInner lastBlockTime(String lastBlockTime) {
    this.lastBlockTime = lastBlockTime;
    return this;
  }

   /**
   * Timestamp for last block created in epoch
   * @return lastBlockTime
  **/
  @Schema(example = "2021-10-02T21:50:11", description = "Timestamp for last block created in epoch")
  public String getLastBlockTime() {
    return lastBlockTime;
  }

  public void setLastBlockTime(String lastBlockTime) {
    this.lastBlockTime = lastBlockTime;
  }

  public EpochInfoInner activeStake(Integer activeStake) {
    this.activeStake = activeStake;
    return this;
  }

   /**
   * Rewards accumulated as of given epoch (in lovelaces)
   * @return activeStake
  **/
  @Schema(example = "23395112387185880", description = "Rewards accumulated as of given epoch (in lovelaces)")
  public Integer getActiveStake() {
    return activeStake;
  }

  public void setActiveStake(Integer activeStake) {
    this.activeStake = activeStake;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EpochInfoInner epochInfoInner = (EpochInfoInner) o;
    return Objects.equals(this.epochNo, epochInfoInner.epochNo) &&
        Objects.equals(this.outSum, epochInfoInner.outSum) &&
        Objects.equals(this.fees, epochInfoInner.fees) &&
        Objects.equals(this.txCount, epochInfoInner.txCount) &&
        Objects.equals(this.blkCount, epochInfoInner.blkCount) &&
        Objects.equals(this.firstBlockTime, epochInfoInner.firstBlockTime) &&
        Objects.equals(this.lastBlockTime, epochInfoInner.lastBlockTime) &&
        Objects.equals(this.activeStake, epochInfoInner.activeStake);
  }

  @Override
  public int hashCode() {
    return Objects.hash(epochNo, outSum, fees, txCount, blkCount, firstBlockTime, lastBlockTime, activeStake);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EpochInfoInner {\n");
    
    sb.append("    epochNo: ").append(toIndentedString(epochNo)).append("\n");
    sb.append("    outSum: ").append(toIndentedString(outSum)).append("\n");
    sb.append("    fees: ").append(toIndentedString(fees)).append("\n");
    sb.append("    txCount: ").append(toIndentedString(txCount)).append("\n");
    sb.append("    blkCount: ").append(toIndentedString(blkCount)).append("\n");
    sb.append("    firstBlockTime: ").append(toIndentedString(firstBlockTime)).append("\n");
    sb.append("    lastBlockTime: ").append(toIndentedString(lastBlockTime)).append("\n");
    sb.append("    activeStake: ").append(toIndentedString(activeStake)).append("\n");
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
