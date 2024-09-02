package rest.koios.client.backend.api.transactions.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Voting Procedure
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VotingProcedure {

    /**
     * Hash identifier of the transaction
     */
    private String proposalTxHash;

    /**
     * Index of governance proposal in transaction
     */
    private Integer proposalIndex;

    /**
     * The role of the voter
     * Allowed: ConstitutionalCommittee|DRep|SPO
     */
    private String voterRole;

    /**
     * Voter's DRep ID (CIP-129 bech32 format), pool ID (bech32 format) or committee hot ID (CIP-129 bech32 format)
     */
    private String voter;

    /**
     * Voter's DRep ID , pool ID or committee hash in hex format
     */
    private String voterHex;

    /**
     * Actual Vote casted
     * Allowed: Yes|No|Abstain
     */
    private String vote;
}
