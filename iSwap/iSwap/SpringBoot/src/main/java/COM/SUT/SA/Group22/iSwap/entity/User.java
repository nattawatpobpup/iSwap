package COM.SUT.SA.Group22.iSwap.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name = "USER_ID", unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String firstname;
    private @NonNull String lastname;
    private @NonNull String username;
    private @NonNull String password;
    private @NonNull Date brithday;
    private @NonNull String address;
    private @NonNull String postcode;
    private @NonNull String phonenum;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private Province userProvince;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Career.class)
    @JoinColumn(name = "CAREER_ID", insertable = true)
    private Career userCareer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "GENDER_ID", insertable = true)
    private Gender userGender;

    public User() {
    }

    public User(String firstname, String lastname, String username, String password, Date brithday, String address, String postcode, String phonenum, Province userProvince, Career userCareer, Gender userGender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.brithday = brithday;
        this.address = address;
        this.postcode = postcode;
        this.phonenum = phonenum;
        this.userProvince = userProvince;
        this.userCareer = userCareer;
        this.userGender = userGender;

    }
}

