package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * TotalsInner
 */
public class TotalsInner {
  @SerializedName("epoch_no")
  private Integer epochNo = null;

  @SerializedName("circulation")
  private Integer circulation = null;

  @SerializedName("treasury")
  private Integer treasury = null;

  @SerializedName("reward")
  private Integer reward = null;

  @SerializedName("supply")
  private Integer supply = null;

  @SerializedName("reserves")
  private Integer reserves = null;

  public TotalsInner epochNo(Integer epochNo) {
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

  public TotalsInner circulation(Integer circulation) {
    this.circulation = circulation;
    return this;
  }

   /**
   * Circulating UTxOs for given epoch (in lovelaces)
   * @return circulation
  **/
  @Schema(example = "32081169442642320", description = "Circulating UTxOs for given epoch (in lovelaces)")
  public Integer getCirculation() {
    return circulation;
  }

  public void setCirculation(Integer circulation) {
    this.circulation = circulation;
  }

  public TotalsInner treasury(Integer treasury) {
    this.treasury = treasury;
    return this;
  }

   /**
   * Funds in treasury for given epoch (in lovelaces)
   * @return treasury
  **/
  @Schema(example = "637024173474141", description = "Funds in treasury for given epoch (in lovelaces)")
  public Integer getTreasury() {
    return treasury;
  }

  public void setTreasury(Integer treasury) {
    this.treasury = treasury;
  }

  public TotalsInner reward(Integer reward) {
    this.reward = reward;
    return this;
  }

   /**
   * Rewards accumulated as of given epoch (in lovelaces)
   * @return reward
  **/
  @Schema(example = "506871250479840", description = "Rewards accumulated as of given epoch (in lovelaces)")
  public Integer getReward() {
    return reward;
  }

  public void setReward(Integer reward) {
    this.reward = reward;
  }

  public TotalsInner supply(Integer supply) {
    this.supply = supply;
    return this;
  }

   /**
   * Total Active Supply (sum of treasury funds, rewards, UTxOs, deposits and fees) for given epoch (in lovelaces)
   * @return supply
  **/
  @Schema(example = "33228495612391330", description = "Total Active Supply (sum of treasury funds, rewards, UTxOs, deposits and fees) for given epoch (in lovelaces)")
  public Integer getSupply() {
    return supply;
  }

  public void setSupply(Integer supply) {
    this.supply = supply;
  }

  public TotalsInner reserves(Integer reserves) {
    this.reserves = reserves;
    return this;
  }

   /**
   * Total Reserves yet to be unlocked on chain
   * @return reserves
  **/
  @Schema(example = "11771504387608670", description = "Total Reserves yet to be unlocked on chain")
  public Integer getReserves() {
    return reserves;
  }

  public void setReserves(Integer reserves) {
    this.reserves = reserves;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TotalsInner totalsInner = (TotalsInner) o;
    return Objects.equals(this.epochNo, totalsInner.epochNo) &&
        Objects.equals(this.circulation, totalsInner.circulation) &&
        Objects.equals(this.treasury, totalsInner.treasury) &&
        Objects.equals(this.reward, totalsInner.reward) &&
        Objects.equals(this.supply, totalsInner.supply) &&
        Objects.equals(this.reserves, totalsInner.reserves);
  }

  @Override
  public int hashCode() {
    return Objects.hash(epochNo, circulation, treasury, reward, supply, reserves);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TotalsInner {\n");
    
    sb.append("    epochNo: ").append(toIndentedString(epochNo)).append("\n");
    sb.append("    circulation: ").append(toIndentedString(circulation)).append("\n");
    sb.append("    treasury: ").append(toIndentedString(treasury)).append("\n");
    sb.append("    reward: ").append(toIndentedString(reward)).append("\n");
    sb.append("    supply: ").append(toIndentedString(supply)).append("\n");
    sb.append("    reserves: ").append(toIndentedString(reserves)).append("\n");
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
