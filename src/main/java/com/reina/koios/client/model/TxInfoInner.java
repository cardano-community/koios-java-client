package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TxInfoInner
 */
public class TxInfoInner {
    @SerializedName("tx_hash")
    private String txHash = null;

    @SerializedName("block_hash")
    private String blockHash = null;

    @SerializedName("block_height")
    private Integer blockHeight = null;

    @SerializedName("epoch")
    private Integer epoch = null;

    @SerializedName("epoch_slot")
    private Integer epochSlot = null;

    @SerializedName("absolute_slot")
    private Integer absoluteSlot = null;

    @SerializedName("tx_timestamp")
    private String txTimestamp = null;

    @SerializedName("tx_block_index")
    private Integer txBlockIndex = null;

    @SerializedName("tx_size")
    private Integer txSize = null;

    @SerializedName("total_output")
    private Integer totalOutput = null;

    @SerializedName("fee")
    private Integer fee = null;

    @SerializedName("deposit")
    private Integer deposit = null;

    @SerializedName("invalid_before")
    private Integer invalidBefore = null;

    @SerializedName("invalid_after")
    private Integer invalidAfter = null;

    @SerializedName("inputs")
    private List<Object> inputs = null;

    @SerializedName("outputs")
    private List<Object> outputs = null;

    @SerializedName("withdrawals")
    private List<Object> withdrawals = null;

    @SerializedName("assets_minted")
    private List<Object> assetsMinted = null;

    @SerializedName("metadata")
    private List<Object> metadata = null;

    @SerializedName("certificates")
    private List<Object> certificates = null;

    public TxInfoInner txHash(String txHash) {
        this.txHash = txHash;
        return this;
    }

    /**
     * Hash of Transaction for which details are being shown
     *
     * @return txHash
     **/
    @Schema(example = "f144a8264acf4bdfe2e1241170969c930d64ab6b0996a4a45237b623f1dd670e", description = "Hash of Transaction for which details are being shown")
    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public TxInfoInner blockHash(String blockHash) {
        this.blockHash = blockHash;
        return this;
    }

    /**
     * Hash of Block in which transaction was included
     *
     * @return blockHash
     **/
    @Schema(example = "90062dfc314c7dc3430922a48f79032a63032206fdca2dfd144cf0930d4aa426", description = "Hash of Block in which transaction was included")
    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public TxInfoInner blockHeight(Integer blockHeight) {
        this.blockHeight = blockHeight;
        return this;
    }

    /**
     * Block number on chain where transaction was included
     *
     * @return blockHeight
     **/
    @Schema(example = "6354154", description = "Block number on chain where transaction was included")
    public Integer getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(Integer blockHeight) {
        this.blockHeight = blockHeight;
    }

    public TxInfoInner epoch(Integer epoch) {
        this.epoch = epoch;
        return this;
    }

    /**
     * Epoch number
     *
     * @return epoch
     **/
    @Schema(example = "295", description = "Epoch number")
    public Integer getEpoch() {
        return epoch;
    }

    public void setEpoch(Integer epoch) {
        this.epoch = epoch;
    }

    public TxInfoInner epochSlot(Integer epochSlot) {
        this.epochSlot = epochSlot;
        return this;
    }

    /**
     * Slot number within epoch
     *
     * @return epochSlot
     **/
    @Schema(example = "248243", description = "Slot number within epoch")
    public Integer getEpochSlot() {
        return epochSlot;
    }

    public void setEpochSlot(Integer epochSlot) {
        this.epochSlot = epochSlot;
    }

    public TxInfoInner absoluteSlot(Integer absoluteSlot) {
        this.absoluteSlot = absoluteSlot;
        return this;
    }

    /**
     * Overall slot number (slots from genesis block of chain)
     *
     * @return absoluteSlot
     **/
    @Schema(example = "42325043", description = "Overall slot number (slots from genesis block of chain)")
    public Integer getAbsoluteSlot() {
        return absoluteSlot;
    }

    public void setAbsoluteSlot(Integer absoluteSlot) {
        this.absoluteSlot = absoluteSlot;
    }

    public TxInfoInner txTimestamp(String txTimestamp) {
        this.txTimestamp = txTimestamp;
        return this;
    }

    /**
     * Timestamp where block containing transaction was created
     *
     * @return txTimestamp
     **/
    @Schema(example = "2021-10-10T18:42:14", description = "Timestamp where block containing transaction was created")
    public String getTxTimestamp() {
        return txTimestamp;
    }

    public void setTxTimestamp(String txTimestamp) {
        this.txTimestamp = txTimestamp;
    }

    public TxInfoInner txBlockIndex(Integer txBlockIndex) {
        this.txBlockIndex = txBlockIndex;
        return this;
    }

    /**
     * Index of transaction within block
     *
     * @return txBlockIndex
     **/
    @Schema(example = "6", description = "Index of transaction within block")
    public Integer getTxBlockIndex() {
        return txBlockIndex;
    }

    public void setTxBlockIndex(Integer txBlockIndex) {
        this.txBlockIndex = txBlockIndex;
    }

    public TxInfoInner txSize(Integer txSize) {
        this.txSize = txSize;
        return this;
    }

    /**
     * Size in bytes of transaction
     *
     * @return txSize
     **/
    @Schema(example = "391", description = "Size in bytes of transaction")
    public Integer getTxSize() {
        return txSize;
    }

    public void setTxSize(Integer txSize) {
        this.txSize = txSize;
    }

    public TxInfoInner totalOutput(Integer totalOutput) {
        this.totalOutput = totalOutput;
        return this;
    }

    /**
     * Total sum of all transaction outputs (in lovelaces)
     *
     * @return totalOutput
     **/
    @Schema(example = "157832856", description = "Total sum of all transaction outputs (in lovelaces)")
    public Integer getTotalOutput() {
        return totalOutput;
    }

    public void setTotalOutput(Integer totalOutput) {
        this.totalOutput = totalOutput;
    }

    public TxInfoInner fee(Integer fee) {
        this.fee = fee;
        return this;
    }

    /**
     * Total Transaction fee (in lovelaces)
     *
     * @return fee
     **/
    @Schema(example = "172761", description = "Total Transaction fee (in lovelaces)")
    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public TxInfoInner deposit(Integer deposit) {
        this.deposit = deposit;
        return this;
    }

    /**
     * Total Deposits included in transaction (for example, if it is registering a pool/key)
     *
     * @return deposit
     **/
    @Schema(example = "0", description = "Total Deposits included in transaction (for example, if it is registering a pool/key)")
    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public TxInfoInner invalidBefore(Integer invalidBefore) {
        this.invalidBefore = invalidBefore;
        return this;
    }

    /**
     * Slot before which transaction cannot be validated (if supplied, else null)
     *
     * @return invalidBefore
     **/
    @Schema(description = "Slot before which transaction cannot be validated (if supplied, else null)")
    public Integer getInvalidBefore() {
        return invalidBefore;
    }

    public void setInvalidBefore(Integer invalidBefore) {
        this.invalidBefore = invalidBefore;
    }

    public TxInfoInner invalidAfter(Integer invalidAfter) {
        this.invalidAfter = invalidAfter;
        return this;
    }

    /**
     * Slot after which transaction cannot be validated
     *
     * @return invalidAfter
     **/
    @Schema(example = "42332172", description = "Slot after which transaction cannot be validated")
    public Integer getInvalidAfter() {
        return invalidAfter;
    }

    public void setInvalidAfter(Integer invalidAfter) {
        this.invalidAfter = invalidAfter;
    }

    public TxInfoInner inputs(List<Object> inputs) {
        this.inputs = inputs;
        return this;
    }

    public TxInfoInner addInputsItem(Object inputsItem) {
        if (this.inputs == null) {
            this.inputs = new ArrayList<Object>();
        }
        this.inputs.add(inputsItem);
        return this;
    }

    /**
     * An array with details about inputs used in a transaction
     *
     * @return inputs
     **/
    @Schema(description = "An array with details about inputs used in a transaction")
    public List<Object> getInputs() {
        return inputs;
    }

    public void setInputs(List<Object> inputs) {
        this.inputs = inputs;
    }

    public TxInfoInner outputs(List<Object> outputs) {
        this.outputs = outputs;
        return this;
    }

    public TxInfoInner addOutputsItem(Object outputsItem) {
        if (this.outputs == null) {
            this.outputs = new ArrayList<Object>();
        }
        this.outputs.add(outputsItem);
        return this;
    }

    /**
     * An array with details about outputs from the transaction
     *
     * @return outputs
     **/
    @Schema(description = "An array with details about outputs from the transaction")
    public List<Object> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<Object> outputs) {
        this.outputs = outputs;
    }

    public TxInfoInner withdrawals(List<Object> withdrawals) {
        this.withdrawals = withdrawals;
        return this;
    }

    public TxInfoInner addWithdrawalsItem(Object withdrawalsItem) {
        if (this.withdrawals == null) {
            this.withdrawals = new ArrayList<Object>();
        }
        this.withdrawals.add(withdrawalsItem);
        return this;
    }

    /**
     * Array of withdrawals with-in a transaction (if any)
     *
     * @return withdrawals
     **/
    @Schema(description = "Array of withdrawals with-in a transaction (if any)")
    public List<Object> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(List<Object> withdrawals) {
        this.withdrawals = withdrawals;
    }

    public TxInfoInner assetsMinted(List<Object> assetsMinted) {
        this.assetsMinted = assetsMinted;
        return this;
    }

    public TxInfoInner addAssetsMintedItem(Object assetsMintedItem) {
        if (this.assetsMinted == null) {
            this.assetsMinted = new ArrayList<Object>();
        }
        this.assetsMinted.add(assetsMintedItem);
        return this;
    }

    /**
     * Array of minted assets with-in a transaction (if any)
     *
     * @return assetsMinted
     **/
    @Schema(description = "Array of minted assets with-in a transaction (if any)")
    public List<Object> getAssetsMinted() {
        return assetsMinted;
    }

    public void setAssetsMinted(List<Object> assetsMinted) {
        this.assetsMinted = assetsMinted;
    }

    public TxInfoInner metadata(List<Object> metadata) {
        this.metadata = metadata;
        return this;
    }

    public TxInfoInner addMetadataItem(Object metadataItem) {
        if (this.metadata == null) {
            this.metadata = new ArrayList<Object>();
        }
        this.metadata.add(metadataItem);
        return this;
    }

    /**
     * Metadata present with-in a transaction (if any)
     *
     * @return metadata
     **/
    @Schema(description = "Metadata present with-in a transaction (if any)")
    public List<Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Object> metadata) {
        this.metadata = metadata;
    }

    public TxInfoInner certificates(List<Object> certificates) {
        this.certificates = certificates;
        return this;
    }

    public TxInfoInner addCertificatesItem(Object certificatesItem) {
        if (this.certificates == null) {
            this.certificates = new ArrayList<Object>();
        }
        this.certificates.add(certificatesItem);
        return this;
    }

    /**
     * Certificates present with-in a transaction (if any)
     *
     * @return certificates
     **/
    @Schema(description = "Certificates present with-in a transaction (if any)")
    public List<Object> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Object> certificates) {
        this.certificates = certificates;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TxInfoInner txInfoInner = (TxInfoInner) o;
        return Objects.equals(this.txHash, txInfoInner.txHash) &&
                Objects.equals(this.blockHash, txInfoInner.blockHash) &&
                Objects.equals(this.blockHeight, txInfoInner.blockHeight) &&
                Objects.equals(this.epoch, txInfoInner.epoch) &&
                Objects.equals(this.epochSlot, txInfoInner.epochSlot) &&
                Objects.equals(this.absoluteSlot, txInfoInner.absoluteSlot) &&
                Objects.equals(this.txTimestamp, txInfoInner.txTimestamp) &&
                Objects.equals(this.txBlockIndex, txInfoInner.txBlockIndex) &&
                Objects.equals(this.txSize, txInfoInner.txSize) &&
                Objects.equals(this.totalOutput, txInfoInner.totalOutput) &&
                Objects.equals(this.fee, txInfoInner.fee) &&
                Objects.equals(this.deposit, txInfoInner.deposit) &&
                Objects.equals(this.invalidBefore, txInfoInner.invalidBefore) &&
                Objects.equals(this.invalidAfter, txInfoInner.invalidAfter) &&
                Objects.equals(this.inputs, txInfoInner.inputs) &&
                Objects.equals(this.outputs, txInfoInner.outputs) &&
                Objects.equals(this.withdrawals, txInfoInner.withdrawals) &&
                Objects.equals(this.assetsMinted, txInfoInner.assetsMinted) &&
                Objects.equals(this.metadata, txInfoInner.metadata) &&
                Objects.equals(this.certificates, txInfoInner.certificates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(txHash, blockHash, blockHeight, epoch, epochSlot, absoluteSlot, txTimestamp, txBlockIndex, txSize, totalOutput, fee, deposit, invalidBefore, invalidAfter, inputs, outputs, withdrawals, assetsMinted, metadata, certificates);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TxInfoInner {\n");

        sb.append("    txHash: ").append(toIndentedString(txHash)).append("\n");
        sb.append("    blockHash: ").append(toIndentedString(blockHash)).append("\n");
        sb.append("    blockHeight: ").append(toIndentedString(blockHeight)).append("\n");
        sb.append("    epoch: ").append(toIndentedString(epoch)).append("\n");
        sb.append("    epochSlot: ").append(toIndentedString(epochSlot)).append("\n");
        sb.append("    absoluteSlot: ").append(toIndentedString(absoluteSlot)).append("\n");
        sb.append("    txTimestamp: ").append(toIndentedString(txTimestamp)).append("\n");
        sb.append("    txBlockIndex: ").append(toIndentedString(txBlockIndex)).append("\n");
        sb.append("    txSize: ").append(toIndentedString(txSize)).append("\n");
        sb.append("    totalOutput: ").append(toIndentedString(totalOutput)).append("\n");
        sb.append("    fee: ").append(toIndentedString(fee)).append("\n");
        sb.append("    deposit: ").append(toIndentedString(deposit)).append("\n");
        sb.append("    invalidBefore: ").append(toIndentedString(invalidBefore)).append("\n");
        sb.append("    invalidAfter: ").append(toIndentedString(invalidAfter)).append("\n");
        sb.append("    inputs: ").append(toIndentedString(inputs)).append("\n");
        sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
        sb.append("    withdrawals: ").append(toIndentedString(withdrawals)).append("\n");
        sb.append("    assetsMinted: ").append(toIndentedString(assetsMinted)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    certificates: ").append(toIndentedString(certificates)).append("\n");
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
