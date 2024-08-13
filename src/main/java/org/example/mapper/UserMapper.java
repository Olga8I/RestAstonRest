package org.example.mapper;

import org.example.model.User;
import org.example.dto.UserDto;

import java.util.List;

public interface UserMapper {
    User mapToEntity(UserDto userDto);

    UserDto mapToDto(User user);

    List<UserDto> mapToListToDto(List<User> user);

}
