package bookstore.app.book.service.mapper.impl;

import bookstore.app.book.dto.UserDto;
import bookstore.app.book.entity.User;
import bookstore.app.book.service.mapper.AbstractDtoMapperAdapter;

public class UserMapper extends AbstractDtoMapperAdapter<User, UserDto> {
    public UserMapper(Class<User> classParameter, Class<UserDto> classDtoParameter) {
        super(classParameter, classDtoParameter);
    }
}
