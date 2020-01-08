package COM.SUT.SA.Group22.iSwap.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@ToString 
@EqualsAndHashCode
@Table(name = "Hashtag")

public class  Hashtag{
    @Id 
    @SequenceGenerator(name="hashtag_seq",sequenceName="hashtag_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hashtag_seq")
    @Column(name="Hashtag_ID",unique = true, nullable = false)
    private @NonNull Long hashtagid;
    private @NonNull String hashtagname;

    public Hashtag(String hashtagname) {
        this.hashtagname = hashtagname;
    }
}

