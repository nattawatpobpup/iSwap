package COM.SUT.SA.Group22.iSwap.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Getter @Setter
//@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="meeting")
public class Meeting {
    @Id
    @SequenceGenerator(name="meeting_seq",sequenceName="meeting_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="meeting_seq")
    @Column(name="MEETING_ID",unique = true, nullable = true)
    private @NonNull Long Id;
    private  String CallOther;
    private  Date Dates;
//    private  String LandMark;
    private  String Telephone;
    private  String Text;


    @ManyToOne
    @JoinColumn(name = "MEETINGSTATUS_ID")
    private MeetingStatus meetingStatus;

    @ManyToOne
    @JoinColumn(name = "TIME_ID")
    private Time time;

    @ManyToOne
    @JoinColumn(name = "LANDMARK_ID")
    private Province province;

    @OneToOne
    @JoinColumn(name="PROPOSAL_ID")
    private Proposal proposal;

    public Meeting(Long id) {
        Id = id;
    }

    public Meeting() {}
    public Meeting(String
                           CallOther,Date Dates, String LandMark, String Telephone, String Text) {
      //  this.Meeting = Meeting;

        this.CallOther = CallOther;
        this.Dates = Dates;
//        this.LandMark = LandMark;
        this.Telephone = Telephone;
        this.Text = Text;
    }
}