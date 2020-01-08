package COM.SUT.SA.Group22.iSwap.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="time")
public class Time {
    @Id
    @SequenceGenerator(name="time_seq",sequenceName="time_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="time_seq")
    @Column(name="TIME_ID",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String timename;

}