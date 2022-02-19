package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

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
     * Hash of Transaction for which details are being shown
     */
    private String txHash = null;

    /**
     * Hash of Block in which transaction was included
     */
    private String blockHash = null;

    /**
     * Block number on chain where transaction was included
     */
    private Integer blockHeight = null;

    /**
     * Epoch number
     */
    private Integer epoch = null;

    /**
     * Slot number within epoch
     */
    private Integer epochSlot = null;

    /**
     * Overall slot number (slots from genesis block of chain)
     */
    private Integer absoluteSlot = null;

    /**
     * Timestamp where block containing transaction was created
     */
    private String txTimestamp = null;

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
    private Integer totalOutput = null;

    /**
     * Total Transaction fee (in lovelaces)
     */
    private Integer fee = null;

    /**
     * Total Deposits included in transaction (for example, if it is registering a pool/key)
     */
    private Integer deposit = null;

    /**
     * Slot before which transaction cannot be validated (if supplied, else null)
     */
    private Integer invalidBefore = null;

    /**
     * Slot after which transaction cannot be validated
     */
    private Integer invalidAfter = null;

    /**
     * An array of collateral inputs needed when dealing with smart contracts (same json schema as inputs)
     */
    private List<Object> collaterals = null;

    /**
     * An array with details about inputs used in a transaction
     */
    private List<Object> inputs = null;

    /**
     * An array with details about outputs from the transaction
     */
    private List<Object> outputs = null;

    /**
     * Array of withdrawals with-in a transaction (if any)
     */
    private List<Object> withdrawals = null;

    /**
     * Array of minted assets with-in a transaction (if any)
     */
    private List<Object> assetsMinted = null;

    /**
     * Metadata present with-in a transaction (if any)
     */
    private List<Object> metadata = null;

    /**
     * Certificates present with-in a transaction (if any)
     */
    private List<Object> certificates = null;
}
