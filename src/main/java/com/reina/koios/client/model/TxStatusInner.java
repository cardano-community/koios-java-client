package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * TxStatusInner
 */
public class TxStatusInner {
  @SerializedName("tx_hash")
  private String txHash = null;

  @SerializedName("num_confirmations")
  private Integer numConfirmations = null;

  public TxStatusInner txHash(String txHash) {
    this.txHash = txHash;
    return this;
  }

   /**
   * Hash of the transaction for which details are being shown
   * @return txHash
  **/
  @Schema(example = "f144a8264acf4bdfe2e1241170969c930d64ab6b0996a4a45237b623f1dd670e", description = "Hash of the transaction for which details are being shown")
  public String getTxHash() {
    return txHash;
  }

  public void setTxHash(String txHash) {
    this.txHash = txHash;
  }

  public TxStatusInner numConfirmations(Integer numConfirmations) {
    this.numConfirmations = numConfirmations;
    return this;
  }

   /**
   * Number of block confirmations
   * @return numConfirmations
  **/
  @Schema(example = "17", description = "Number of block confirmations")
  public Integer getNumConfirmations() {
    return numConfirmations;
  }

  public void setNumConfirmations(Integer numConfirmations) {
    this.numConfirmations = numConfirmations;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TxStatusInner txStatusInner = (TxStatusInner) o;
    return Objects.equals(this.txHash, txStatusInner.txHash) &&
        Objects.equals(this.numConfirmations, txStatusInner.numConfirmations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(txHash, numConfirmations);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TxStatusInner {\n");
    
    sb.append("    txHash: ").append(toIndentedString(txHash)).append("\n");
    sb.append("    numConfirmations: ").append(toIndentedString(numConfirmations)).append("\n");
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
