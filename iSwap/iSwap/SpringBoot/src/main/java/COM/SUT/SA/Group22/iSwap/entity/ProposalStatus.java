package COM.SUT.SA.Group22.iSwap.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "proposalStatus")
public class ProposalStatus {
    @Id
    @SequenceGenerator(name="proposalStatus_seq",sequenceName="proposalStatus_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="proposalStatus_seq")
    @Column(name="PROPOSALSTATUS_ID",unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String statusName;

    public ProposalStatus(String statusName) {
        this.statusName = statusName;
    }
}

