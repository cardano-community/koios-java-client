package rest.koios.client.backend.api.governance.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Vote
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Vote {

    /**
     * The transaction hash where-in vote was posted
     */
    private String voteTxHash;

    /**
     * The role of the voter (ConstitutionalCommittee, DRep, SPO)
     */
    private String voterRole;

    /**
     * Voter's DRep ID (CIP-129 bech32 format), pool ID (bech32 format) or committee
     */
    private String voterId;

    /**
     * Proposal Action ID in accordance with CIP-129 format
     */
    private String proposalId;

    /**
     * Hash identifier of the proposal transaction
     */
    private String proposalTxHash;

    /**
     * Index of governance proposal in transaction
     */
    private Integer proposalIndex;

    /**
     * Proposal Action Type (ParameterChange, HardForkInitiation, TreasuryWithdrawals, NoConfidence, NewCommittee, NewConstitution, InfoAction)
     */
    private String proposalType;

    /**
     * Epoch number of the block
     */
    private Integer epochNo;

    /**
     * Block Height
     */
    private Integer blockHeight;

    /**
     * UNIX timestamp of the block
     */
    private Integer blockTime;

    /**
     * Actual Vote casted (Yes, No, Abstain)
     */
    private String vote;

    /**
     * A URL to a JSON payload of metadata (null if not applicable)
     */
    private String metaUrl;

    /**
     * A hash of the contents of the metadata URL (null if not applicable)
     */
    private String metaHash;

    /**
     * The payload as JSON
     */
    private JsonNode metaJson;
}
