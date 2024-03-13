package bookstore.app.book.service.impl;

import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.OrderDetailDto;
import bookstore.app.book.dto.OrderTotalDto;
import bookstore.app.book.dto.UserDto;
import bookstore.app.book.entity.OrderDetail;
import bookstore.app.book.entity.OrderTotal;
import bookstore.app.book.repository.OrderDetailRepository;
import bookstore.app.book.repository.OrderTotalRepository;
import bookstore.app.book.repository.UserRepository;
import bookstore.app.book.service.IOderTotalService;
import bookstore.app.book.service.mapper.IConverterDto;
import bookstore.app.book.service.mapper.impl.UserMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderTotalService implements IOderTotalService {

    private final OrderDetailRepository orderDetailRepository;
    private final IConverterDto<OrderDetail, OrderDetailDto> orderDetailMapper;
    private final IConverterDto<OrderTotal, OrderTotalDto> orderTotalMapper;

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final OrderTotalRepository orderTotalRepository;

    public OrderTotalService(OrderDetailRepository orderDetailRepository,
                             OrderTotalRepository orderTotalRepository,
                             UserRepository userRepository,
                             UserMapper userMapper,
                             @Qualifier("OrderDetailMapper")IConverterDto<OrderDetail,OrderDetailDto> orderDetailMapper,
                             @Qualifier("OrderTotalMapper")IConverterDto<OrderTotal, OrderTotalDto> orderTotalMapper){
        this.orderDetailRepository = orderDetailRepository;
        this.orderDetailMapper = orderDetailMapper;
        this.orderTotalRepository = orderTotalRepository;
        this.orderTotalMapper = orderTotalMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public OrderTotalDto addOrderDetail(BookDto bookDto, int quantity, UserDto userDto) {
        OrderTotalDto cart = userDto.getOrderTotal();//
        LinkedHashSet<OrderDetailDto> items = cart.getOrderDetails();
        OrderDetailDto item = find(items, bookDto.getId());
        if (item == null){
            item = new OrderDetailDto();
            item.setBook(bookDto);
            item.setOrderTotal(cart);
            item.setQuantity(quantity);
            item.setTotal(BigDecimal.valueOf(item.getQuantity()*item.getBook().getPrice()));
//            item = orderDetailMapper.convertToDto(orderDetailRepository.save(orderDetailMapper.convertToEntity(item)));
//            items.add(item);
            cart.addOrderDetails(item);// object vao list
        } else {
//            int itemQuantity = item.getQuantity() + quantity;
//            item.setQuantity(itemQuantity);
//            orderDetailRepository.save(orderDetailMapper.convertToEntity(item));
        }
//        cart.setOrderDetails(items);
        cart.setUser(userDto);
        OrderTotal order = orderTotalRepository.save(orderTotalMapper.convertToEntity(cart));
        OrderTotalDto orderTotalDto = orderTotalMapper.convertToDto(order);
        return orderTotalDto;
    }
    //persit

    @Override
    @Transactional
    public OrderTotalDto updateOrderTotal(BookDto bookDto, int quantity, UserDto userDto) {
        OrderTotalDto cart = userDto.getOrderTotal();
        LinkedHashSet<OrderDetailDto> items = cart.getOrderDetails();
        OrderDetailDto item = find(items, bookDto.getId());
        item.setQuantity(quantity);
        orderDetailRepository.save(orderDetailMapper.convertToEntity(item));
        cart.setOrderDetails(items);
        OrderTotal order = orderTotalRepository.save(orderTotalMapper.convertToEntity(cart));
        OrderTotalDto orderTotalDto = orderTotalMapper.convertToDto(order);
        return orderTotalDto;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public OrderTotalDto removeOrderDetail(BookDto bookDto, UserDto userDto) {
        OrderTotalDto cart = userDto.getOrderTotal();
        LinkedHashSet<OrderDetailDto> items = cart.getOrderDetails();
        OrderDetailDto item = find(items, bookDto.getId());
        items.remove(item);
        orderDetailRepository.delete(orderDetailMapper.convertToEntity(item));
        cart.setOrderDetails(items);
        OrderTotal order = orderTotalRepository.save(orderTotalMapper.convertToEntity(cart));
        OrderTotalDto orderTotalDto = orderTotalMapper.convertToDto(order);
        return orderTotalDto;
    }

    @Override
    public OrderTotalDto getAll(UserDto user) {
        return user.getOrderTotal();
    }

    @Override
    public void deleteOrderTotalById(Long id) {

    }

    private OrderDetailDto find(Set<OrderDetailDto> items,long bookId){
        if (items == null) return null;
        OrderDetailDto orderDetailDto = null;
        for (OrderDetailDto item : items){
            if (item.getBook().getId() == bookId) orderDetailDto = item;
        }
        return orderDetailDto;
    }

}
