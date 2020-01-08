package COM.SUT.SA.Group22.iSwap.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name="shippingstatus")
public class ShippingStatus {
    @Id
    @SequenceGenerator(name="status_seq",sequenceName="status_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="status_seq")
    @Column(name ="STATUS_ID",unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String ShippingStatusName;

    public ShippingStatus() {}

    public ShippingStatus(String shippingStatusName) {
        ShippingStatusName = shippingStatusName;
    }

}
