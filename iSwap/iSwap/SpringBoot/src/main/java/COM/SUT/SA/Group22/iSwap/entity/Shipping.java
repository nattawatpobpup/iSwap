package COM.SUT.SA.Group22.iSwap.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="shipping")
public class Shipping {
    @Id
    @SequenceGenerator(name="shipping_seq",sequenceName="shipping_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shipping_seq")
    @Column(name ="SHIPPING_ID",unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String Shipper;
    private @NonNull String Receiver;
    private @NonNull Date Date;
    private @NonNull String Address;
    private @NonNull String Postcode;
    private @NonNull String TrackingNo;
    private @NonNull String Agency;

    @ManyToOne()
    @JoinColumn(name = "STATUS_ID", insertable = true)
    private ShippingStatus ShippingStatus;

    @ManyToOne()
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private Province ShippingProvince;

    @OneToOne()
    @JoinColumn(name="PROPOSAL_ID", insertable = true)
    private Proposal ShippingProposal;

    public Shipping() {}

    public Shipping(String shipper, String receiver, java.util.Date date, String address, String postcode, String trackingNo, String agency, COM.SUT.SA.Group22.iSwap.entity.ShippingStatus shippingStatus, Province shippingProvince, Proposal shippingProposal) {
        Shipper = shipper;
        Receiver = receiver;
        Date = date;
        Address = address;
        Postcode = postcode;
        TrackingNo = trackingNo;
        Agency = agency;

        ShippingStatus = shippingStatus;
        ShippingProvince = shippingProvince;
        ShippingProposal = shippingProposal;
    }

}
