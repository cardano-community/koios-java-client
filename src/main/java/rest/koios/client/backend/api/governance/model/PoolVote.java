package rest.koios.client.backend.api.governance.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Pool Vote
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PoolVote {

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
     * Hash identifier of the vote transaction
     */
    private String voteTxHash;

    /**
     * UNIX timestamp of the block
     */
    private Long blockTime;

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
}
