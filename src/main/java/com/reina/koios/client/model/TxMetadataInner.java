package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * TxMetadataInner
 */
public class TxMetadataInner {
  @SerializedName("tx_hash")
  private String txHash = null;

  @SerializedName("metadata")
  private String metadata = null;

  public TxMetadataInner txHash(String txHash) {
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

  public TxMetadataInner metadata(String metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * A JSON array containing details about metadata within transaction
   * @return metadata
  **/
  @Schema(example = "{\"721\":{\"version\":1,\"copyright\":\"...\",\"publisher\":[\"p...o\"],\"4bf184e01e0f163296ab253edd60774e2d34367d0e7b6cbc689b567d\":{}}}", description = "A JSON array containing details about metadata within transaction")
  public String getMetadata() {
    return metadata;
  }

  public void setMetadata(String metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TxMetadataInner txMetadataInner = (TxMetadataInner) o;
    return Objects.equals(this.txHash, txMetadataInner.txHash) &&
        Objects.equals(this.metadata, txMetadataInner.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(txHash, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TxMetadataInner {\n");
    
    sb.append("    txHash: ").append(toIndentedString(txHash)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
