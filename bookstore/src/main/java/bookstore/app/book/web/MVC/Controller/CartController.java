package bookstore.app.book.web.MVC.Controller;

import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.OrderTotalDto;
import bookstore.app.book.dto.UserDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.service.IAccountService;
import bookstore.app.book.service.IBookService;
import bookstore.app.book.service.IOderTotalService;
import bookstore.app.book.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private final IUserService userService;
    private final IAccountService accountService;
    private final IOderTotalService oderTotalService;
    private final IBookService bookService;
    @GetMapping("/info")
    public String getCart(Authentication authentication,
                          Model model){
        if(authentication.getName() == null){
            return "redirect:/login";
        }
        Account account = accountService.getByUserName(authentication.getName());
        UserDto user = userService.getByUserId(account.getUser().getId());
        OrderTotalDto cart = oderTotalService.getAll(user);
        model.addAttribute("cart",cart);
        model.addAttribute("user",user);
        return "cart";
    }

    @PostMapping("/add-to-cart")
    public String addItemToCart(@RequestParam("id") Long id,
                                @RequestParam("quantity")int quantity,
                                Model model,
                                Authentication authentication){
        if(authentication.getName() == null){
            return "redirect:/login";
        }
        Account account = accountService.getByUserName(authentication.getName());
        UserDto user = userService.getByUserId(account.getUser().getId());
        BookDto bookDto = bookService.getById(id);
        OrderTotalDto cart = oderTotalService.addOrderDetail(bookDto,quantity,user);
        model.addAttribute("cart",cart);
        return "redirect:/cart/info";
    }

    @PostMapping(value = "/update-cart",params = "action=update")
    public String updateCartItem(@RequestParam("id") Long id,
                             @RequestParam("quantity") int quantity,
                             Model model,
                             Authentication authentication){
        BookDto bookDto = bookService.getById(id);
        Account account = accountService.getByUserName(authentication.getName());
        UserDto userDto = userService.getByUserId(account.getUser().getId());
        OrderTotalDto cart = oderTotalService.updateOrderTotal(bookDto,quantity,userDto);
        model.addAttribute("cart",cart);
        return "redirect:/cart/info";
    }

    @PostMapping(value = "/update-cart",params = "action=delete")
    public String deleteCartItem(@RequestParam("id") Long id,
                             Model model,
                             Authentication authentication){
        BookDto bookDto = bookService.getById(id);
        Account account = accountService.getByUserName(authentication.getName());
        UserDto userDto = userService.getByUserId(account.getUser().getId());
        OrderTotalDto cart = oderTotalService.removeOrderDetail(bookDto,userDto);
        model.addAttribute("cart",cart);
        return "redirect:/cart/info";
    }



}
