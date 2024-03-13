package bookstore.app.book.dto;



import bookstore.app.book.entity.Book;
import bookstore.app.book.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long id;

    private String content;

    @JsonIgnoreProperties(value = {"comments", "category","orderDetails"}, allowSetters = true)
    private BookDto book;
    @JsonIgnoreProperties(value = {"comments","account","orderTotal","checkouts"}, allowSetters = true)
    private UserDto user;


}
