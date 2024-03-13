package bookstore.app.book.service.impl;

import bookstore.app.book.dto.OrderTotalDto;
import bookstore.app.book.dto.UserDto;
import bookstore.app.book.entity.OrderTotal;
import bookstore.app.book.entity.User;
import bookstore.app.book.repository.OrderTotalRepository;
import bookstore.app.book.repository.UserRepository;
import bookstore.app.book.service.IUserService;
import bookstore.app.book.service.mapper.IConverterDto;
import bookstore.app.book.service.mapper.impl.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto save(UserDto userDto) throws Exception {


        User user= userRepository.save(userMapper.convertToEntity(userDto));
        return userMapper.convertToDto(user);
    }

    @Override
    public Set<UserDto> getAll() {
        return (Set<UserDto>) userMapper.convertToListDto(userRepository.findAll());
    }

    @Override
    public UserDto getByUserId(Long id) {
        return userMapper.convertToDto(userRepository.getById(id));
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (isExitsById(id)) userRepository.deleteById(id);
        else throw new Exception("ko ton tai");
    }

    @Override
    public boolean isExitsById(Long id) {
        return getByUserId(id) == null ? false : true;
    }

}
