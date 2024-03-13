package bookstore.app.book.web.MVC.admin;

import bookstore.app.book.service.IAccountService;
import bookstore.app.book.service.IUserService;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
@AllArgsConstructor
public class AdminHomeController {

    private final IAccountService accountService;

    private final IUserService userService;

    @GetMapping("/")
    public String getAdminHome(){
        return "home-admin";
    }

}
