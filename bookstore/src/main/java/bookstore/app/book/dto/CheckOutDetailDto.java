package bookstore.app.book.dto;

import bookstore.app.book.entity.OrderTotal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckOutDetailDto {
    private Long id;

   private int quantity;

   private BookDto book;

   @JsonIgnore
   private CheckoutDto checkout;
}
