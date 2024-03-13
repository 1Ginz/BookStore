package bookstore.app.book.web.api;

import bookstore.app.book.dto.CheckOutDetailDto;
import bookstore.app.book.dto.CheckoutDto;
import bookstore.app.book.dto.OrderTotalDto;
import bookstore.app.book.dto.UserDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.service.IAccountService;
import bookstore.app.book.service.ICheckoutService;
import bookstore.app.book.service.IOderTotalService;
import bookstore.app.book.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CheckoutApi {

    private final IUserService userService;

    private final IAccountService accountService;

    private final IOderTotalService cartService;

    private final ICheckoutService checkoutService;

    @GetMapping("/check-out")
    public ResponseEntity<?> checkout(Authentication authentication){
        Account account = accountService.getByUserName(authentication.getName());
        UserDto user = userService.getByUserId(account.getUser().getId());
        OrderTotalDto cart = cartService.getAll(user);
        CheckoutDto checkoutDto = checkoutService.save(cart);
        return ResponseEntity.ok().body(checkoutDto);
    }

    @GetMapping("/user/order")
    public ResponseEntity<?> getOrder(Authentication authentication){
        Account account = accountService.getByUserName(authentication.getName());
        UserDto user = userService.getByUserId(account.getUser().getId());
        List<CheckoutDto> orders = checkoutService.findAllByUser(user);
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/user/order/{id}")
    public ResponseEntity<CheckoutDto> getOrderDetail(@PathVariable("id") Long id,
                                 Authentication authentication){
        Account account = accountService.getByUserName(authentication.getName());
        UserDto user = userService.getByUserId(account.getUser().getId());
        CheckoutDto checkoutDto = checkoutService.getById(id);
        if(checkoutDto.getUser().getId() == user.getId()){
            return ResponseEntity.ok().body(checkoutDto);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/user/cancel-order/{id}")
    public ResponseEntity<?> cancelOrder(@PathVariable("id") Long id){
        CheckoutDto checkoutDto = checkoutService.cancelCheckout(id);
        return ResponseEntity.ok().body(checkoutDto);
    }

    @GetMapping("/admin/checkout")
    public ResponseEntity<?> getOrders(){
        List<CheckoutDto> orders = checkoutService.findAll();
        return  ResponseEntity.ok().body(orders);
    }

    @GetMapping("/admin/accept-order/{id}")
    public ResponseEntity<?> acceptOrder(@PathVariable("id") Long id){
        CheckoutDto checkoutDto = checkoutService.acceptCheckout(id);
        return ResponseEntity.ok().body(checkoutDto);
    }

    @GetMapping("/admin/checkout/{id}")
    public ResponseEntity<?> getOrderDetail(@PathVariable("id") Long id){
        CheckoutDto checkoutDto = checkoutService.getById(id);
        return ResponseEntity.ok().body(checkoutDto);
    }

}
