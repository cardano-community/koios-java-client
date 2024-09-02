package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rest.koios.client.backend.api.base.common.Asset;

import java.util.List;

/**
 * Transaction Information
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TxInfo {

    /**
     * Hash identifier of the transaction
     */
    private String txHash = null;

    /**
     * Hash of the Block
     */
    private String blockHash = null;

    /**
     * Block height
     */
    private Long blockHeight = null;

    /**
     * Epoch number of the block
     */
    private Integer epochNo = null;

    /**
     * Slot number of the block in epoch
     */
    private Integer epochSlot = null;

    /**
     * Absolute slot number of the block
     */
    private Long absoluteSlot = null;

    /**
     * UNIX timestamp of the transaction
     */
    private Long txTimestamp = null;

    /**
     * Index of transaction within block
     */
    private Integer txBlockIndex = null;

    /**
     * Size in bytes of transaction
     */
    private Integer txSize = null;

    /**
     * Total sum of all transaction outputs (in lovelaces)
     */
    private String totalOutput = null;

    /**
     * Total Transaction fee (in lovelaces)
     */
    private String fee = null;

    /**
     * Total Donation to on-chain treasury (in numbers)
     */
    private String treasuryDonation;

    /**
     * Total Deposits included in transaction (for example, if it is registering a pool/key)
     */
    private String deposit = null;

    /**
     * Slot before which transaction cannot be validated (if supplied, else null)
     */
    private String invalidBefore = null;

    /**
     * Slot after which transaction cannot be validated
     */
    private String invalidAfter = null;

    /**
     * List of collateral inputs needed when dealing with smart contracts (same json schema as inputs)
     */
    private List<TxIO> collateralInputs = null;

    /**
     * List of collateral outputs
     */
    private TxIO collateralOutput = null;

    /**
     * Reference Inputs
     */
    private List<TxIO> referenceInputs;

    /**
     * An array with details about inputs used in a transaction
     */
    private List<TxIO> inputs = null;

    /**
     * An array with details about outputs from the transaction
     */
    private List<TxIO> outputs = null;

    /**
     * Array of withdrawals with-in a transaction (if any)
     */
    private List<TxWithdrawal> withdrawals = null;

    /**
     * Array of minted assets with-in a transaction (if any)
     */
    private List<Asset> assetsMinted = null;

    /**
     * Metadata present with-in a transaction (if any)
     */
    private JsonNode metadata = null;

    /**
     * Certificates present with-in a transaction (if any)
     */
    private List<TxCertificate> certificates = null;

    /**
     * Native scripts present in a transaction (if any)
     */
    private List<TxNativeScript> nativeScripts;

    /**
     * Plutus contracts present in transaction (if any)
     */
    private List<TxPlutusContract> plutusContracts;

    /**
     * Governance votes in a transaction (if any)
     */
    private List<VotingProcedure> votingProcedures;

    /**
     * Governance proposals in a transaction (if any)
     */
    private List<ProposalProcedure> proposalProcedures;
}
