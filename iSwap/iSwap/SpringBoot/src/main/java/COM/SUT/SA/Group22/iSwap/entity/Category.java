package COM.SUT.SA.Group22.iSwap.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter @Setter
@Table(name = "Category")
@ToString
@EqualsAndHashCode
public class  Category{
    @Id 
    @SequenceGenerator(name="category_seq",sequenceName="category_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_seq")
    @Column(name="Category_ID",unique = true, nullable = false)
    private @NonNull Long categoryid;
    private @NonNull String categoryname;

    public Category(String categoryname) {
        this.categoryname = categoryname;
    }
}

