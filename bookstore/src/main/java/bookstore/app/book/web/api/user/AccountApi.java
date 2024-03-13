package bookstore.app.book.web.api.user;


import bookstore.app.book.dto.LoginDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class AccountApi {

    private final IAccountService accountService;
    private final PasswordEncoder encoder;
    private AuthenticationManager authenticationManager;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto account){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            account.getUsername(), account.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            if(authentication.isAuthenticated()){
                Account returnAccount = accountService.getByUserName(account.getUsername());
                account.setRole(returnAccount.getRole());
                return ResponseEntity.ok().body(account);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<?> addAccount(@RequestBody Account account){
        account.setPassword(encoder.encode(account.getPassword()));
        account.setRole("ROLE_USER");
        Account accountSignup = accountService.createAccount(account);
        if (accountSignup != null){
            return ResponseEntity.ok().body(accountSignup);
        }
        return ResponseEntity.badRequest().body("register fail!");

    }
}
