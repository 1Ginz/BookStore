package bookstore.app.book.web.api;


import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.OrderTotalDto;
import bookstore.app.book.dto.UserDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.service.IAccountService;
import bookstore.app.book.service.IBookService;
import bookstore.app.book.service.IOderTotalService;
import bookstore.app.book.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderApi {

    private final IUserService userService;
    private final IAccountService accountService;
    private final IOderTotalService oderTotalService;
    private final IBookService bookService;

    @GetMapping("/")
    public ResponseEntity<OrderTotalDto> getCart(Authentication authentication){
        Account account = accountService.getByUserName(authentication.getName());
        UserDto user = userService.getByUserId(account.getUser().getId());
        OrderTotalDto cart = oderTotalService.getAll(user);
        return ResponseEntity.ok().body(cart);
    }


    //
    @GetMapping("/add")
    public ResponseEntity<?> addItemToCart(@RequestParam("id") Long Bookid,
                                @RequestParam("quantity")int quantity,
                                Authentication authentication){
        Account account = accountService.getByUserName(authentication.getName());
        UserDto user = userService.getByUserId(account.getUser().getId());
        BookDto bookDto = bookService.getById(Bookid);
        OrderTotalDto cart = oderTotalService.addOrderDetail(bookDto,quantity,user);
        return ResponseEntity.ok().body(cart);
    }

    @GetMapping("/update")
    public ResponseEntity<?> updateCartItem(@RequestParam("id") Long id,
                                 @RequestParam("quantity") int quantity,
                                 Authentication authentication){
        if(!authentication.isAuthenticated()){
            return ResponseEntity.badRequest().build();
        }
        BookDto bookDto = bookService.getById(id);
        Account account = accountService.getByUserName(authentication.getName());
        UserDto userDto = userService.getByUserId(account.getUser().getId());
        OrderTotalDto cart = oderTotalService.updateOrderTotal(bookDto,quantity,userDto);
        return ResponseEntity.ok().body(cart);

    }

    @DeleteMapping("/update")
    public ResponseEntity<?> deleteCartItem(@RequestParam("id") Long id,
                                 Authentication authentication){
        BookDto bookDto = bookService.getById(id);
        Account account = accountService.getByUserName(authentication.getName());
        UserDto userDto = userService.getByUserId(account.getUser().getId());
        OrderTotalDto cart = oderTotalService.removeOrderDetail(bookDto,userDto);
        return ResponseEntity.ok().body(cart);
    }

}
