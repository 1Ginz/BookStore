package bookstore.app.book.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private Long id;

    private int quantity;

    private BigDecimal total;

    @JsonIgnoreProperties(value = {"orderDetails","category","comments"}, allowSetters = true)
    private BookDto book;

    @JsonIgnoreProperties(value = {"orderDetails","user"},allowSetters = true)
    private OrderTotalDto orderTotal;


}
