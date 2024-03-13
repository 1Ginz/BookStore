package bookstore.app.book.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private String username;

    private String password;

    private String role;



}
