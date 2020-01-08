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
@Table(name="level")
public class Level {
    @Id
    @SequenceGenerator(name="level_seq",sequenceName="level_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="level_seq")
    @Column(name="LEVEL_ID",unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String levelname;
    public Level(String levelname) {
        this.levelname = levelname;
    }

    public Level() {
    }
}
