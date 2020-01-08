package COM.SUT.SA.Group22.iSwap.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @SequenceGenerator(name = "item_seq", sequenceName = "item_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @Column(name = "ITEM_ID", unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String itemName;
    private @NonNull String descrition;
    private @NonNull String img;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_ID")
    private @NonNull User user;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name="categoryid")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Hashtag.class)
    @JoinColumn(name = "hashtagid", insertable = true)
    private Hashtag hashtag;

    public Item() {
    }

}

