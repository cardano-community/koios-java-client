package rest.koios.client.backend.api.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Proposal Procedure
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProposalProcedure {

    /**
     * Index of governance proposal in transaction
     */
    private Integer index;

    /**
     * Proposal Action Type
     * Allowed: ParameterChange|HardForkInitiation|TreasuryWithdrawals|NoConfidence|NewCommittee|NewConstitution|InfoAction
     */
    private String type;

    /**
     * Description for Proposal Action
     */
    private Object description;

    /**
     * DRep's registration deposit in number
     */
    private String deposit;

    /**
     * The StakeAddress index of the reward address to receive the deposit when it is repaid.
     */
    private String returnAddress;

    /**
     * Shows the epoch at which this governance action is expected to expire.
     */
    private Long expiration;

    /**
     * A URL to a JSON payload of metadata
     */
    private String metaUrl;

    /**
     * A hash of the contents of the metadata URL
     */
    private String metaHash;

    /**
     * If not null, the amount withdrawn from treasury into stake address by this this proposal
     */
    private List<TxWithdrawal> withdrawal;

    /**
     * If not null, the proposed new parameter set
     */
    private List<Object> paramProposal;
}
