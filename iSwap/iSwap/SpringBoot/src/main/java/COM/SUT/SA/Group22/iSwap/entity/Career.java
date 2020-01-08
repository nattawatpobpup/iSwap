package COM.SUT.SA.Group22.iSwap.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Date;

@Data
@Entity
@Table(name="career")
public class Career {
    @Id
    @SequenceGenerator(name="career_seq",sequenceName="career_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="career_seq")
    @Column(name="CAREER_ID",unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String careername;

    public Career(String careername) {
        this.careername = careername;
    }
}
