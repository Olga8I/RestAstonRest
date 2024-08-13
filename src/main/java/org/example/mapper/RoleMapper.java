package org.example.mapper;

import org.example.dto.RoleDto;
import org.example.model.Role;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role mapToEntity(RoleDto roleDto);

    RoleDto mapToDto(Role role);

    List<RoleDto> mapToListToDto(List<Role> roleList);
}
