package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * TxMetalabelsInner
 */
public class TxMetalabelsInner {
  @SerializedName("metalabel")
  private BigDecimal metalabel = null;

  public TxMetalabelsInner metalabel(BigDecimal metalabel) {
    this.metalabel = metalabel;
    return this;
  }

   /**
   * A distinct known metalabel
   * @return metalabel
  **/
  @Schema(example = "721", description = "A distinct known metalabel")
  public BigDecimal getMetalabel() {
    return metalabel;
  }

  public void setMetalabel(BigDecimal metalabel) {
    this.metalabel = metalabel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TxMetalabelsInner txMetalabelsInner = (TxMetalabelsInner) o;
    return Objects.equals(this.metalabel, txMetalabelsInner.metalabel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metalabel);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TxMetalabelsInner {\n");
    
    sb.append("    metalabel: ").append(toIndentedString(metalabel)).append("\n");
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
