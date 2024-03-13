package bookstore.app.book.web.MVC.Controller;


import bookstore.app.book.dto.CheckOutDetailDto;
import bookstore.app.book.dto.CheckoutDto;
import bookstore.app.book.dto.OrderTotalDto;
import bookstore.app.book.dto.UserDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.entity.Checkout;
import bookstore.app.book.entity.CheckoutDetail;
import bookstore.app.book.service.IAccountService;
import bookstore.app.book.service.ICheckoutService;
import bookstore.app.book.service.IOderTotalService;
import bookstore.app.book.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

@Controller
@AllArgsConstructor
public class CheckoutController {

    private final IUserService userService;

    private final IAccountService accountService;

    private final IOderTotalService cartService;

    private final ICheckoutService checkoutService;

    @GetMapping("/check-out")
    public String checkout(Authentication authentication,
                           Model model){
        Account account = accountService.getByUserName(authentication.getName());
        UserDto user = userService.getByUserId(account.getUser().getId());
        OrderTotalDto cart = cartService.getAll(user);
        CheckoutDto checkoutDto = checkoutService.save(cart);
        for (CheckOutDetailDto checkoutDetail : checkoutDto.getCheckoutDetails()){
            System.out.println(checkoutDetail.getBook().getImgCover());
        }
        model.addAttribute("user",user);
        model.addAttribute("order",checkoutDto);
        model.addAttribute("success", "Đặt hàng thành công");
        return "checkout-details";
    }

    @GetMapping("/user/order")
    public String getOrder(Authentication authentication,
                           Model model){
        Account account = accountService.getByUserName(authentication.getName());
        UserDto user = userService.getByUserId(account.getUser().getId());
//        List<CheckoutDto> orders = user.getCheckouts();
        List<CheckoutDto> orders = checkoutService.findAllByUser(user);
        model.addAttribute("user",user);
        model.addAttribute("orders",orders);
        return "checkout";
    }

    @GetMapping("/user/order/{id}")
    public String getOrderDetail(@PathVariable("id") Long id,
                                 Model model,
                                 Authentication authentication){
        Account account = accountService.getByUserName(authentication.getName());
        UserDto user = userService.getByUserId(account.getUser().getId());
        CheckoutDto checkoutDto = checkoutService.getById(id);
        model.addAttribute("user",user);
        model.addAttribute("order",checkoutDto);
        return "checkout-details";
    }

    @GetMapping("/user/cancel-order/{id}")
    public String cancelOrder(@PathVariable("id") Long id){
        CheckoutDto checkoutDto = checkoutService.cancelCheckout(id);
        return "redirect:/user/order";
    }


}
