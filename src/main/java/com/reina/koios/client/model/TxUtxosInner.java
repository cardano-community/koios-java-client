package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TxUtxosInner
 */
public class TxUtxosInner {
  @SerializedName("tx_hash")
  private String txHash = null;

  @SerializedName("inputs")
  private List<Object> inputs = null;

  @SerializedName("outputs")
  private List<Object> outputs = null;

  public TxUtxosInner txHash(String txHash) {
    this.txHash = txHash;
    return this;
  }

   /**
   * Hash of Transaction for which details are being shown
   * @return txHash
  **/
  @Schema(example = "f144a8264acf4bdfe2e1241170969c930d64ab6b0996a4a45237b623f1dd670e", description = "Hash of Transaction for which details are being shown")
  public String getTxHash() {
    return txHash;
  }

  public void setTxHash(String txHash) {
    this.txHash = txHash;
  }

  public TxUtxosInner inputs(List<Object> inputs) {
    this.inputs = inputs;
    return this;
  }

  public TxUtxosInner addInputsItem(Object inputsItem) {
    if (this.inputs == null) {
      this.inputs = new ArrayList<Object>();
    }
    this.inputs.add(inputsItem);
    return this;
  }

   /**
   * An array with details about inputs used in a transaction
   * @return inputs
  **/
  @Schema(description = "An array with details about inputs used in a transaction")
  public List<Object> getInputs() {
    return inputs;
  }

  public void setInputs(List<Object> inputs) {
    this.inputs = inputs;
  }

  public TxUtxosInner outputs(List<Object> outputs) {
    this.outputs = outputs;
    return this;
  }

  public TxUtxosInner addOutputsItem(Object outputsItem) {
    if (this.outputs == null) {
      this.outputs = new ArrayList<Object>();
    }
    this.outputs.add(outputsItem);
    return this;
  }

   /**
   * An array with details about outputs from the transaction
   * @return outputs
  **/
  @Schema(description = "An array with details about outputs from the transaction")
  public List<Object> getOutputs() {
    return outputs;
  }

  public void setOutputs(List<Object> outputs) {
    this.outputs = outputs;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TxUtxosInner txUtxosInner = (TxUtxosInner) o;
    return Objects.equals(this.txHash, txUtxosInner.txHash) &&
        Objects.equals(this.inputs, txUtxosInner.inputs) &&
        Objects.equals(this.outputs, txUtxosInner.outputs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(txHash, inputs, outputs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TxUtxosInner {\n");
    
    sb.append("    txHash: ").append(toIndentedString(txHash)).append("\n");
    sb.append("    inputs: ").append(toIndentedString(inputs)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
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
