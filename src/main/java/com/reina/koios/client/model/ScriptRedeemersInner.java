package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * ScriptRedeemersInner
 */
public class ScriptRedeemersInner {
  @SerializedName("script_hash")
  private String scriptHash = null;

  @SerializedName("redeemers")
  private List<Object> redeemers = null;

  public ScriptRedeemersInner scriptHash(String scriptHash) {
    this.scriptHash = scriptHash;
    return this;
  }

   /**
   * Hash of Transaction for which details are being shown
   * @return scriptHash
  **/
  @Schema(example = "f144a8264acf4bdfe2e1241170969c930d64ab6b0996a4a45237b623f1dd670e", description = "Hash of Transaction for which details are being shown")
  public String getScriptHash() {
    return scriptHash;
  }

  public void setScriptHash(String scriptHash) {
    this.scriptHash = scriptHash;
  }

  public ScriptRedeemersInner redeemers(List<Object> redeemers) {
    this.redeemers = redeemers;
    return this;
  }

  public ScriptRedeemersInner addRedeemersItem(Object redeemersItem) {
    if (this.redeemers == null) {
      this.redeemers = new ArrayList<Object>();
    }
    this.redeemers.add(redeemersItem);
    return this;
  }

   /**
   * Get redeemers
   * @return redeemers
  **/
  @Schema(description = "")
  public List<Object> getRedeemers() {
    return redeemers;
  }

  public void setRedeemers(List<Object> redeemers) {
    this.redeemers = redeemers;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScriptRedeemersInner scriptRedeemersInner = (ScriptRedeemersInner) o;
    return Objects.equals(this.scriptHash, scriptRedeemersInner.scriptHash) &&
        Objects.equals(this.redeemers, scriptRedeemersInner.redeemers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scriptHash, redeemers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScriptRedeemersInner {\n");
    
    sb.append("    scriptHash: ").append(toIndentedString(scriptHash)).append("\n");
    sb.append("    redeemers: ").append(toIndentedString(redeemers)).append("\n");
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
