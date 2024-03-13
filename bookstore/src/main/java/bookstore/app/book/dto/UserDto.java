package bookstore.app.book.dto;

import bookstore.app.book.entity.Checkout;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private String gender;
    private String avatar;
    @JsonIgnoreProperties(value = {"book","user"}, allowSetters = true)
    private Set<CommentDto> comments;
    @JsonIgnoreProperties(value = {"user","orderDetails"},allowSetters = true)
    private OrderTotalDto orderTotal;
    @JsonIgnoreProperties(value = {"user","checkoutDetails"},allowSetters = true)
    private List<CheckoutDto> checkouts;
}
