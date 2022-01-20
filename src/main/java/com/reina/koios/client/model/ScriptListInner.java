package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * ScriptListInner
 */
public class ScriptListInner {
  @SerializedName("script_hash")
  private String scriptHash = null;

  @SerializedName("creation_tx_hash")
  private String creationTxHash = null;

  public ScriptListInner scriptHash(String scriptHash) {
    this.scriptHash = scriptHash;
    return this;
  }

   /**
   * Hash of a script
   * @return scriptHash
  **/
  @Schema(example = "d8480dc869b94b80e81ec91b0abe307279311fe0e7001a9488f61ff8", description = "Hash of a script")
  public String getScriptHash() {
    return scriptHash;
  }

  public void setScriptHash(String scriptHash) {
    this.scriptHash = scriptHash;
  }

  public ScriptListInner creationTxHash(String creationTxHash) {
    this.creationTxHash = creationTxHash;
    return this;
  }

   /**
   * Hash of the script creation transaction
   * @return creationTxHash
  **/
  @Schema(example = "fda6c7697009237975ffc30f36666addf4c6e2a2c6f90411a24431b700baaab1", description = "Hash of the script creation transaction")
  public String getCreationTxHash() {
    return creationTxHash;
  }

  public void setCreationTxHash(String creationTxHash) {
    this.creationTxHash = creationTxHash;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScriptListInner scriptListInner = (ScriptListInner) o;
    return Objects.equals(this.scriptHash, scriptListInner.scriptHash) &&
        Objects.equals(this.creationTxHash, scriptListInner.creationTxHash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scriptHash, creationTxHash);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScriptListInner {\n");
    
    sb.append("    scriptHash: ").append(toIndentedString(scriptHash)).append("\n");
    sb.append("    creationTxHash: ").append(toIndentedString(creationTxHash)).append("\n");
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
