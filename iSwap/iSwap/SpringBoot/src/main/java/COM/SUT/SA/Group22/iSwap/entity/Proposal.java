package COM.SUT.SA.Group22.iSwap.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "proposal")
public class Proposal {
    @Id
    @SequenceGenerator(name = "proposal_seq", sequenceName = "proposal_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proposal_seq")
    @Column(name = "PROPOSAL_ID", unique = true, nullable = false)
    private @NonNull Long id;
    private String itemOfferName;
    private String itemReceiveName;
    private String userOfferName;
    private String userReceiveName;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ProposalStatus.class)
    @JoinColumn(name = "proposalStatus_ID", insertable = true)
    private ProposalStatus proposalStatus;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TradeOption.class)
    @JoinColumn(name = "tradeOption_ID", insertable = true)
    private TradeOption tradeOption;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Item.class)
    @JoinColumn(name = "itemOffer_ID", insertable = true)
    private Item itemOffer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Item.class)
    @JoinColumn(name = "itemReceive_ID", insertable = true)
    private Item itemReceive;

    public Proposal() {
    }

    public Proposal(Item itemOffer, Item itemReceive, TradeOption tradeOption, String description, ProposalStatus proposalStatus) {
        this.proposalStatus = proposalStatus;
        this.tradeOption = tradeOption;
        this.itemOffer = itemOffer;
        this.itemReceive = itemReceive;

        itemOfferName = itemOffer.getItemName();
        itemReceiveName = itemReceive.getItemName();
        userOfferName = itemOffer.getUser().getUsername();
        userReceiveName = itemReceive.getUser().getUsername();
        this.description = description;
    }

}

