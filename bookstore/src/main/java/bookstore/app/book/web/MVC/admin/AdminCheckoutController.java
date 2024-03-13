package bookstore.app.book.web.MVC.admin;

import bookstore.app.book.dto.CheckoutDto;
import bookstore.app.book.dto.UserDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.service.IAccountService;
import bookstore.app.book.service.ICheckoutService;
import bookstore.app.book.service.IOderTotalService;
import bookstore.app.book.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/orders")
public class AdminCheckoutController {

    private final IUserService userService;

    private final IAccountService accountService;

    private final IOderTotalService cartService;

    private final ICheckoutService checkoutService;
    @GetMapping("/accept-order/{id}")
    public String acceptOrder(@PathVariable("id") Long id,
                              Model model){
        CheckoutDto checkoutDto = checkoutService.acceptCheckout(id);
//        model.addAttribute("success","Bạn đã chấp nhận đơn hàng thành công");
        return "redirect:/admin/orders/";
    }

    @GetMapping("/")
    public String getOrders(Model model){
        List<CheckoutDto> order = checkoutService.findAll();
        model.addAttribute("orders",order);
        return "admin-checkout";
    }
    @GetMapping("/cancel-order/{id}")
    public String cancelOrder(@PathVariable("id") Long id){
        CheckoutDto checkoutDto = checkoutService.cancelCheckout(id);
        return "redirect:/admin/orders/";
    }

    @GetMapping("/{id}")
    public String getOrderDetail(@PathVariable("id") Long id,
                                 Model model){
        CheckoutDto checkoutDto = checkoutService.getById(id);
        model.addAttribute("order",checkoutDto);
        return "checkout-details";
    }

}
