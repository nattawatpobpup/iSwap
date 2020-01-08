package COM.SUT.SA.Group22.iSwap.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="Review")
public class Review {

    @Id
    @SequenceGenerator(name="review_seq",sequenceName="review_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="review_seq")
    @Column(name="REVIEW_ID")
    private @NonNull Long review_id;
    private @NonNull String comments;
    private @NonNull int rating;
    private @NonNull Date reviewdate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @ManyToOne
    @JoinColumn(name = "propos_id")
    private Proposal proposal;

    public Review() {}



}