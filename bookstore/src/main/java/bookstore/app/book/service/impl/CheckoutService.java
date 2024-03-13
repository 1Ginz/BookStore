package bookstore.app.book.service.impl;

import bookstore.app.book.dto.*;
import bookstore.app.book.entity.*;
import bookstore.app.book.repository.CheckoutDetailRepository;
import bookstore.app.book.repository.CheckoutRepository;
import bookstore.app.book.repository.OrderTotalRepository;
import bookstore.app.book.repository.UserRepository;
import bookstore.app.book.service.ICheckoutService;
import bookstore.app.book.service.IOderTotalService;
import bookstore.app.book.service.mapper.IConverterDto;
import bookstore.app.book.service.mapper.impl.UserMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckoutService implements ICheckoutService {

    private final IConverterDto<OrderTotal, OrderTotalDto> orderTotalMapper;

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final OrderTotalRepository orderTotalRepository;

    private final CheckoutRepository checkoutRepository;

    private final CheckoutDetailRepository checkoutDetailRepository;
    private final IConverterDto<CheckoutDetail, CheckOutDetailDto> checkoutDetailMapper;
    private final IConverterDto<Checkout, CheckoutDto> checkoutMapper;

    private final IOderTotalService oderTotalService;

    public CheckoutService(OrderTotalRepository orderTotalRepository,
                           IOderTotalService oderTotalService,
                           UserRepository userRepository,
                           UserMapper userMapper,
                           CheckoutRepository checkoutRepository,
                           CheckoutDetailRepository checkoutDetailRepository,
                           @Qualifier("CheckoutMapper") IConverterDto<Checkout, CheckoutDto> checkoutMapper,
                           @Qualifier("CheckoutDetailMapper") IConverterDto<CheckoutDetail, CheckOutDetailDto> checkoutDetailMapper,
                           @Qualifier("OrderTotalMapper")IConverterDto<OrderTotal, OrderTotalDto> orderTotalMapper){
        this.orderTotalRepository = orderTotalRepository;
        this.orderTotalMapper = orderTotalMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.checkoutRepository = checkoutRepository;
        this.checkoutDetailRepository = checkoutDetailRepository;
        this.checkoutMapper = checkoutMapper;
        this.checkoutDetailMapper = checkoutDetailMapper;
        this.oderTotalService = oderTotalService;
    }

    @Override
    @Transactional
    public CheckoutDto save(OrderTotalDto cart) {
        CheckoutDto checkoutDto = new CheckoutDto();
        checkoutDto.setStatus("Chờ xác nhận");
        checkoutDto.setOrderDate(LocalDate.now());
        checkoutDto.setUser(cart.getUser());
//        checkoutDto.setAccept(false);
        checkoutDto.setTotal(cart.getAmountTotal().add(BigDecimal.valueOf(15.000)));
        checkoutDto.setPaymentMethod("Cash");
        Checkout checkout = checkoutRepository.save(checkoutMapper.convertToEntity(checkoutDto));
        checkoutDto = checkoutMapper.convertToDto(checkout);
        List<CheckOutDetailDto> checkoutDetails = new ArrayList<>();
        for (OrderDetailDto item : cart.getOrderDetails()){
           CheckOutDetailDto checkOutDetailDto = new CheckOutDetailDto();
           checkOutDetailDto.setCheckout(checkoutDto);
           checkOutDetailDto.setBook(item.getBook());
           checkOutDetailDto.setQuantity(item.getQuantity());
           CheckoutDetail checkoutDetail = checkoutDetailRepository.save(checkoutDetailMapper.convertToEntity(checkOutDetailDto));
           checkOutDetailDto = checkoutDetailMapper.convertToDto(checkoutDetail);
           checkoutDetails.add(checkOutDetailDto);
        }
        checkoutDto.setCheckoutDetails(checkoutDetails);
        checkout = checkoutRepository.save(checkoutMapper.convertToEntity(checkoutDto));
        checkoutDto = checkoutMapper.convertToDto(checkout);
        // add new cart for user
        OrderTotalDto newOrder = new OrderTotalDto();
        OrderTotal total = orderTotalRepository.save(orderTotalMapper.convertToEntity(newOrder));
        UserDto userDto = cart.getUser();
        userDto.setOrderTotal(orderTotalMapper.convertToDto(total));
        userRepository.save(userMapper.convertToEntity(userDto));
        return  checkoutDto;
    }

    @Override
    public CheckoutDto getById(Long id) {
        return checkoutMapper.convertToDto(checkoutRepository.getOne(id));
    }

    @Override
    public List<CheckoutDto> findAll() {
        return (List<CheckoutDto>) checkoutMapper.convertToListDto(checkoutRepository.findAllOrderByDesc());
    }

    @Override
    public List<CheckoutDto> findAllByUser(UserDto userDto) {
        User user = userMapper.convertToEntity(userDto);
        return (List<CheckoutDto>) checkoutMapper.convertToListDto(checkoutRepository.findAllByUserOrderByIdDesc(user));
    }

    @Override
    public CheckoutDto acceptCheckout(Long id) {
        CheckoutDto checkoutDto = checkoutMapper.convertToDto(checkoutRepository.getOne(id));
        checkoutDto.setAccept(true);
        checkoutDto.setDeliveryDate(LocalDate.now());
        checkoutDto.setStatus("Đang giao hàng");
        Checkout result = checkoutRepository.save(checkoutMapper.convertToEntity(checkoutDto));
        checkoutDto = checkoutMapper.convertToDto(result);
        return checkoutDto;
    }

    @Override
    public CheckoutDto cancelCheckout(Long id) {
        CheckoutDto checkoutDto = checkoutMapper.convertToDto(checkoutRepository.getOne(id));
        checkoutDto.setAccept(false);
        checkoutDto.setDeliveryDate(null);
        checkoutDto.setStatus("Đã hủy");
        Checkout result = checkoutRepository.save(checkoutMapper.convertToEntity(checkoutDto));
        checkoutDto = checkoutMapper.convertToDto(result);
        return checkoutDto;
    }

}
