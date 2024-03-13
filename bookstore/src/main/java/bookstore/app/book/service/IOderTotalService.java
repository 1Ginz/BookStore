package bookstore.app.book.service;

import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.OrderTotalDto;
import bookstore.app.book.dto.UserDto;

public interface IOderTotalService {
    OrderTotalDto addOrderDetail(BookDto bookDto, int quantity, UserDto userDto);

    OrderTotalDto updateOrderTotal(BookDto bookDto, int quantity, UserDto userDto);

    OrderTotalDto removeOrderDetail(BookDto bookDto, UserDto userDto);

    OrderTotalDto getAll(UserDto user);

    void deleteOrderTotalById (Long id);

}
