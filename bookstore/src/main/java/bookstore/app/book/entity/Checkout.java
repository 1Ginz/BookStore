package bookstore.app.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "checkout")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "status")
    private String status;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "accept")
    private boolean isAccept;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"orderTotal,account,comments,checkouts"}, allowSetters = true)
    private User user;

    @OneToMany(mappedBy = "checkout")
    @JsonIgnoreProperties(value = {"checkout,book"},allowSetters = true)
    private List<CheckoutDetail> checkoutDetails;
}
