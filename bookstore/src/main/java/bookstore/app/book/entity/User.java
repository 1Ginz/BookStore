package bookstore.app.book.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "sequenceGenerator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "avatar", nullable = true)
    private String avatar;

    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties(value = {"user"}, allowSetters = true)
    private Account account;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties(value = {"book","user"}, allowSetters = true)
    private Set<Comment> comments;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "odertotal_id",referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"user","orderDetails"},allowSetters = true)
    private OrderTotal orderTotal;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"user","checkoutDetails"},allowSetters = true)
    private List<Checkout> checkouts;


    @Transient
    public String getAvatar(){
//        if(this.avatar == null) return "/data/user/guest.jpg";
//        return "/data/user/" + this.id + "/" + this.avatar;
        return this.avatar;
    }
}
