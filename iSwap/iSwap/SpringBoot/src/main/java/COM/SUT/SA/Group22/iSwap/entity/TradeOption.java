package COM.SUT.SA.Group22.iSwap.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tradeOption")
public class TradeOption {
    @Id
    @SequenceGenerator(name = "tradeoption_seq", sequenceName = "tradeoption_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tradeoption_seq")
    @Column(name = "TRADEOPTION_ID", unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String optionName;

    public TradeOption(String optionName) {
        this.optionName = optionName;
    }


}

