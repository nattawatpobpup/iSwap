package COM.SUT.SA.Group22.iSwap.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode
@Table(name="MeetingStatus")
public class MeetingStatus {
    @Id
    @SequenceGenerator(name="meetingstatus_seq",sequenceName="meetingstatus_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="meetingstatus_seq")
    @Column(name="MEETINGSTATUS_ID",unique = true, nullable = true)
    private @NonNull Long Id;
    private @NonNull String MeetingStatusName;




//    @OneToMany(mappedBy = "meetingStatus")
//    private Set<Meeting> Meeting;


    public MeetingStatus() {}
    public MeetingStatus(String MeetingStatusName) {
        this.MeetingStatusName = MeetingStatusName;
    }

}
