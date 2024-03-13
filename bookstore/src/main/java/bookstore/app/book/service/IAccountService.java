package bookstore.app.book.service;

import bookstore.app.book.entity.Account;

public interface IAccountService {
    Account createAccount(Account account);

    Account getById(Long id);

    Account getByUserName(String userName);
}
