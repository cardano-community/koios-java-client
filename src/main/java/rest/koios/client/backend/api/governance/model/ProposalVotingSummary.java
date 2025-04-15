package rest.koios.client.backend.api.governance.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Proposal Voting Summary
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProposalVotingSummary {

    /**
     * Proposal Action Type (ParameterChange, HardForkInitiation, TreasuryWithdrawals, NoConfidence, NewCommittee, NewConstitution, InfoAction)
     */
    private String proposalType;

    /**
     * Epoch for which data was collated
     */
    private Integer epochNo;

    /**
     * Number of 'yes' votes casted by dreps
     */
    private Integer drepYesVotesCast;

    /**
     * Power of 'yes' votes that were explicitly cast
     */
    private String drepActiveYesVotePower;

    /**
     * Power of 'yes' votes from dreps (includes explicit yes and inferred via other means)
     */
    private String drepYesVotePower;

    /**
     * Percentage of 'yes' votes from dreps
     */
    private Double drepYesPct;

    /**
     * Number of 'no' votes casted by dreps
     */
    private Integer drepNoVotesCast;

    /**
     * Power of 'no' votes that were explicitly cast
     */
    private String drepActiveNoVotePower;

    /**
     * Power of 'no' votes from dreps (includes explicit no and inferred via other means)
     */
    private String drepNoVotePower;

    /**
     * Percentage of 'no' votes from dreps
     */
    private Double drepNoPct;

    /**
     * Number of active 'abstain' votes from dreps
     */
    private Integer drepAbstainVotesCast;

    /**
     * Power of 'abstain' votes that were explicitly cast
     */
    private String drepActiveAbstainVotePower;

    /**
     * Power of votes delegated to 'always_no_confidence' predefined drep
     */
    private String drepAlwaysNoConfidenceVotePower;

    /**
     * Power of votes delegated to 'always_abstain' predefined drep
     */
    private String drepAlwaysAbstainVotePower;

    /**
     * Number of 'yes' votes casted by pools
     */
    private Integer poolYesVotesCast;

    /**
     * Power of 'yes' pool votes that were explicitly cast
     */
    private String poolActiveYesVotePower;

    /**
     * Power of 'yes' votes from pools (includes explicit yes and inferred via other means)
     */
    private String poolYesVotePower;

    /**
     * Percentage of 'yes' votes from pools
     */
    private Double poolYesPct;

    /**
     * Number of 'no' votes casted by pools
     */
    private Integer poolNoVotesCast;

    /**
     * Power of 'no' pool votes that were explicitly cast
     */
    private String poolActiveNoVotePower;

    /**
     * Power of 'no' votes from pools (includes explicit no and inferred via other means)
     */
    private String poolNoVotePower;

    /**
     * Percentage of 'no' votes from pools
     */
    private Double poolNoPct;

    /**
     * Percentage of 'abstain' votes from pools
     */
    private Double poolAbstainVotesCast;

    /**
     * Power of 'abstain' pool votes that were explicitly cast
     */
    private String poolActiveAbstainVotePower;

    /**
     * Number of non-voting SPO pool reward addresses delegating to 'always_abstain' drep
     */
    private Integer poolPassiveAlwaysAbstainVotesAssigned;

    /**
     * Combined power of non-voting SPO pool votes where reward addresses delegate to 'always_abstain'
     */
    private Integer poolPassiveAlwaysAbstainVotePower;

    /**
     * Number of non-voting SPO pool reward addresses delegating to 'always_no_confidence' drep
     */
    private Integer poolPassiveAlwaysNoConfidenceVotesAssigned;

    /**
     * Combined power of non-voting SPO pool votes where reward addresses delegate to
     */
    private Integer poolPassiveAlwaysNoConfidenceVotePower;

    /**
     * Number of 'yes' votes casted by committee
     */
    private Integer committeeYesVotesCast;

    /**
     * Percentage of 'yes' votes from committee
     */
    private Double committeeYesPct;

    /**
     * Number of 'no' votes casted by committee
     */
    private Integer committeeNoVotesCast;

    /**
     * Percentage of 'no' votes from committee
     */
    private Double committeeNoPct;

    /**
     * Percentage of 'abstain' votes from committee
     */
    private Double committeeAbstainVotesCast;
}
