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


@Data
@Entity
@Table(name="gender")
public class Gender {
    @Id
    @SequenceGenerator(name="gender_seq",sequenceName="gender_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gender_seq")
    @Column(name="GENDER_ID",unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String gendertype;

    public Gender(String gendertype) {
        this.gendertype = gendertype;
    }
}
