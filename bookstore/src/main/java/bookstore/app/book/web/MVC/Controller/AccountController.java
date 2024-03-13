package bookstore.app.book.web.MVC.Controller;

import bookstore.app.book.entity.Account;
import bookstore.app.book.service.IAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AccountController {

    private final IAccountService accountService;
    private final PasswordEncoder encoder;

    public AccountController(IAccountService accountService,PasswordEncoder encoder){
        this.accountService = accountService;
        this.encoder = encoder;
    }

//    @PostMapping("/login")
//    public String lo

    @GetMapping ("/login")
    public String login(){
        return "sign-in";
    }

    @GetMapping ("/registration")
    public String getRegistration(){
        return "sign-up";
    }

    @PostMapping("/registration")
    public String addAccount(@ModelAttribute("account")Account account){
        account.setPassword(encoder.encode(account.getPassword()));
        account.setRole("ROLE_USER");
        if (accountService.createAccount(account) != null){
            return "redirect:/registration?success";
        }
        return "redirect:/registration?error";
    }

}
