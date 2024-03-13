package bookstore.app.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "oder_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private int quantity;


    @Column(name = "total", precision = 21, scale = 2)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"orderDetails","category","comments"}, allowSetters = true)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordertotal_id",referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"orderDetails","user"},allowSetters = true)
    private OrderTotal orderTotal;

    public BigDecimal getTotal() {
        if(book == null){
            return new BigDecimal("0");
        }
        return book.getPrice()
                .multiply(new BigDecimal(quantity));
    }

}
