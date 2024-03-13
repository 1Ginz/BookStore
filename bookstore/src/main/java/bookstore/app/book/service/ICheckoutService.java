package bookstore.app.book.service;

import bookstore.app.book.dto.*;
import bookstore.app.book.entity.Checkout;

import java.util.List;

public interface ICheckoutService {

    CheckoutDto save(OrderTotalDto cart);

    CheckoutDto getById(Long id);

    List<CheckoutDto> findAllByUser(UserDto userDto);

    List<CheckoutDto> findAll();

    CheckoutDto acceptCheckout(Long id);

    CheckoutDto cancelCheckout(Long id);

}
