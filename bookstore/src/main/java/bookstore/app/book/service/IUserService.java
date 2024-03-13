package bookstore.app.book.service;

import bookstore.app.book.dto.UserDto;
import bookstore.app.book.entity.User;

import java.util.Set;

public interface IUserService {

    UserDto save(UserDto userDto) throws Exception;
    Set<UserDto> getAll();

    UserDto getByUserId(Long id);

    void deleteById(Long id) throws Exception;

    boolean isExitsById(Long id);

}
