package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * TipInner
 */
public class TipInner {
  @SerializedName("hash")
  private String hash = null;

  @SerializedName("epoch")
  private Integer epoch = null;

  @SerializedName("abs_slot")
  private Integer absSlot = null;

  @SerializedName("epoch_slot")
  private Integer epochSlot = null;

  @SerializedName("block_no")
  private Integer blockNo = null;

  @SerializedName("block_time")
  private String blockTime = null;

  public TipInner hash(String hash) {
    this.hash = hash;
    return this;
  }

   /**
   * Block Hash in hex
   * @return hash
  **/
  @Schema(example = "3cc8cfdb2d68fdb2a467292bf0acda7b91ab677741e3e1c1dc111f5be0cef0fe", description = "Block Hash in hex")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public TipInner epoch(Integer epoch) {
    this.epoch = epoch;
    return this;
  }

   /**
   * Epoch number
   * @return epoch
  **/
  @Schema(example = "294", description = "Epoch number")
  public Integer getEpoch() {
    return epoch;
  }

  public void setEpoch(Integer epoch) {
    this.epoch = epoch;
  }

  public TipInner absSlot(Integer absSlot) {
    this.absSlot = absSlot;
    return this;
  }

   /**
   * Absolute Slot number (slots not divided into epochs)
   * @return absSlot
  **/
  @Schema(example = "41997413", description = "Absolute Slot number (slots not divided into epochs)")
  public Integer getAbsSlot() {
    return absSlot;
  }

  public void setAbsSlot(Integer absSlot) {
    this.absSlot = absSlot;
  }

  public TipInner epochSlot(Integer epochSlot) {
    this.epochSlot = epochSlot;
    return this;
  }

   /**
   * Slot number within Epoch
   * @return epochSlot
  **/
  @Schema(example = "352613", description = "Slot number within Epoch")
  public Integer getEpochSlot() {
    return epochSlot;
  }

  public void setEpochSlot(Integer epochSlot) {
    this.epochSlot = epochSlot;
  }

  public TipInner blockNo(Integer blockNo) {
    this.blockNo = blockNo;
    return this;
  }

   /**
   * Block Height number on chain
   * @return blockNo
  **/
  @Schema(example = "6338276", description = "Block Height number on chain")
  public Integer getBlockNo() {
    return blockNo;
  }

  public void setBlockNo(Integer blockNo) {
    this.blockNo = blockNo;
  }

  public TipInner blockTime(String blockTime) {
    this.blockTime = blockTime;
    return this;
  }

   /**
   * Timestamp for when the block was created
   * @return blockTime
  **/
  @Schema(example = "2021-10-06T23:41:44", description = "Timestamp for when the block was created")
  public String getBlockTime() {
    return blockTime;
  }

  public void setBlockTime(String blockTime) {
    this.blockTime = blockTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TipInner tipInner = (TipInner) o;
    return Objects.equals(this.hash, tipInner.hash) &&
        Objects.equals(this.epoch, tipInner.epoch) &&
        Objects.equals(this.absSlot, tipInner.absSlot) &&
        Objects.equals(this.epochSlot, tipInner.epochSlot) &&
        Objects.equals(this.blockNo, tipInner.blockNo) &&
        Objects.equals(this.blockTime, tipInner.blockTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hash, epoch, absSlot, epochSlot, blockNo, blockTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TipInner {\n");
    
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
    sb.append("    epoch: ").append(toIndentedString(epoch)).append("\n");
    sb.append("    absSlot: ").append(toIndentedString(absSlot)).append("\n");
    sb.append("    epochSlot: ").append(toIndentedString(epochSlot)).append("\n");
    sb.append("    blockNo: ").append(toIndentedString(blockNo)).append("\n");
    sb.append("    blockTime: ").append(toIndentedString(blockTime)).append("\n");
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
