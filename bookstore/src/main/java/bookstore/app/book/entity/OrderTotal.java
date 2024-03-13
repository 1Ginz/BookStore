package bookstore.app.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "order_total")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderTotal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "amount_totail", precision = 21, scale = 2)
    private BigDecimal amountTotal;

    @OneToMany(mappedBy = "orderTotal", cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"orderTotal","book"},allowSetters = true)
    private Set<OrderDetail> orderDetails;
    //

    @OneToOne(mappedBy = "orderTotal", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties(value = {"account","orderTotal","comments"},allowSetters = true)
    private User user;

//    @OneToOne(mappedBy = "orderTotal",cascade = CascadeType.ALL)
//    @JsonIgnoreProperties(value = {"orderTotal"}, allowSetters = true)
//    private CheckoutDetail checkoutDetail;



    public BigDecimal getAmountTotal() {
        BigDecimal total = new BigDecimal(0);
        for (OrderDetail orderDetail : orderDetails) {
            if (orderDetail != null) {
                total = total.add(orderDetail.getTotal());
            }
        }
        return total;
    }


}
