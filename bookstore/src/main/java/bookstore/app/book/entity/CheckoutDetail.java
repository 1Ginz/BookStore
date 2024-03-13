package bookstore.app.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "checkout_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "quantity")
    private int quantity;


    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "checkout_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"user,checkoutDetails"},allowSetters = true)
    private Checkout checkout;

    @OneToOne()
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;


}

