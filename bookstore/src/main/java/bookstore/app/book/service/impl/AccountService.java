package bookstore.app.book.service.impl;

import bookstore.app.book.dto.OrderTotalDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.entity.Checkout;
import bookstore.app.book.entity.OrderTotal;
import bookstore.app.book.entity.User;
import bookstore.app.book.repository.AccountRepository;
import bookstore.app.book.repository.CheckoutRepository;
import bookstore.app.book.repository.OrderTotalRepository;
import bookstore.app.book.repository.UserRepository;
import bookstore.app.book.service.IAccountService;
import bookstore.app.book.service.mapper.IConverterDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class AccountService implements IAccountService {

    private AccountRepository accountRepository;

    private UserRepository userRepository;

    private final OrderTotalRepository orderTotalRepository;
    @Qualifier("OrderTotalMapper")
    private final IConverterDto<OrderTotal, OrderTotalDto> orderTotalMapper;

//    private final CheckoutRepository checkoutRepository;


    @Override
    public Account createAccount(Account account) {
        if (accountRepository.getByUserName(account.getUsername()) != null){
            return null;
        }
        Account account1 = accountRepository.save(account);
        User user = new User();
        user.setName("guest000"+account1.getId());
        user.setAccount(account1);
        OrderTotalDto orderTotalDto = new OrderTotalDto();
        OrderTotal total = orderTotalRepository.save(orderTotalMapper.convertToEntity(orderTotalDto));
        user.setOrderTotal(total);
        user.setAvatar("/data/user/guest.jpg");
//        Checkout checkout = new Checkout();
        user = userRepository.save(user);
//        checkout.setUser(user);
//        checkout.setCheckoutDetails(new ArrayList<>());
//        checkoutRepository.save(checkout);
        account1.setUser(user);
        return accountRepository.save(account1);
    }

    @Override
    public Account getById(Long id) {
        return accountRepository.getById(id);
    }

    @Override
    public Account getByUserName(String userName) {
        return accountRepository.getByUserName(userName);
    }
}
