package org.example.mapper;

import org.example.model.User;
import org.example.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class, DepartmentMapper.class, PhoneNumberMapper.class})
public interface UserMapper {
    User mapToEntity(UserDto userDto);

    UserDto mapToDto(User user);

    List<UserDto> mapToListToDto(List<User> user);

}
