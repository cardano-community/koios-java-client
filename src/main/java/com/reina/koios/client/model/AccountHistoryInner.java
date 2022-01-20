package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * AccountHistoryInner
 */
public class AccountHistoryInner {
  @SerializedName("stake_address")
  private String stakeAddress = null;

  @SerializedName("pool_id")
  private String poolId = null;

  @SerializedName("epoch_no")
  private Integer epochNo = null;

  @SerializedName("active_stake")
  private Integer activeStake = null;

  public AccountHistoryInner stakeAddress(String stakeAddress) {
    this.stakeAddress = stakeAddress;
    return this;
  }

   /**
   * Cardano staking address (reward account) in bech32 format
   * @return stakeAddress
  **/
  @Schema(example = "stake1u8yxtugdv63wxafy9d00nuz6hjyyp4qnggvc9a3vxh8yl0ckml2uz", description = "Cardano staking address (reward account) in bech32 format")
  public String getStakeAddress() {
    return stakeAddress;
  }

  public void setStakeAddress(String stakeAddress) {
    this.stakeAddress = stakeAddress;
  }

  public AccountHistoryInner poolId(String poolId) {
    this.poolId = poolId;
    return this;
  }

   /**
   * Bech32 representation of pool ID
   * @return poolId
  **/
  @Schema(example = "pool1z5uqdk7dzdxaae5633fqfcu2eqzy3a3rgtuvy087fdld7yws0xt", description = "Bech32 representation of pool ID")
  public String getPoolId() {
    return poolId;
  }

  public void setPoolId(String poolId) {
    this.poolId = poolId;
  }

  public AccountHistoryInner epochNo(Integer epochNo) {
    this.epochNo = epochNo;
    return this;
  }

   /**
   * Epoch number
   * @return epochNo
  **/
  @Schema(example = "301", description = "Epoch number")
  public Integer getEpochNo() {
    return epochNo;
  }

  public void setEpochNo(Integer epochNo) {
    this.epochNo = epochNo;
  }

  public AccountHistoryInner activeStake(Integer activeStake) {
    this.activeStake = activeStake;
    return this;
  }

   /**
   * Active stake amount (in lovelaces)
   * @return activeStake
  **/
  @Schema(example = "682334162", description = "Active stake amount (in lovelaces)")
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
    AccountHistoryInner accountHistoryInner = (AccountHistoryInner) o;
    return Objects.equals(this.stakeAddress, accountHistoryInner.stakeAddress) &&
        Objects.equals(this.poolId, accountHistoryInner.poolId) &&
        Objects.equals(this.epochNo, accountHistoryInner.epochNo) &&
        Objects.equals(this.activeStake, accountHistoryInner.activeStake);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stakeAddress, poolId, epochNo, activeStake);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountHistoryInner {\n");
    
    sb.append("    stakeAddress: ").append(toIndentedString(stakeAddress)).append("\n");
    sb.append("    poolId: ").append(toIndentedString(poolId)).append("\n");
    sb.append("    epochNo: ").append(toIndentedString(epochNo)).append("\n");
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
