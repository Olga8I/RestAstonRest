package mapper;

import org.example.dto.RoleDto;
import org.example.mapper.RoleMapper;
import org.example.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleMapperTest {

    private RoleMapper roleMapper;

    @BeforeEach
    void setUp() {
        roleMapper = Mappers.getMapper(RoleMapper.class);
    }

    @Test
    void testMapToEntity() {
        RoleDto dto = new RoleDto();
        dto.setName("Admin");

        Role role = roleMapper.mapToEntity(dto);

        assertNotNull(role);
        assertEquals(dto.getId(), role.getId());
        assertEquals(dto.getName(), role.getName());
    }

    @Test
    void testMapToDTO() {
        Role role = new Role();
        role.setName("Admin");

        RoleDto dto = roleMapper.mapToDto(role);

        assertNotNull(dto);
        assertEquals(role.getId(), dto.getId());
        assertEquals(role.getName(), dto.getName());
    }

    @Test
    void testMapToDTOList() {
        Role role1 = new Role();
        role1.setName("Admin");

        Role role2 = new Role();
        role2.setName("User");

        List<Role> roles = Arrays.asList(role1, role2);

        List<RoleDto> dtoList = roleMapper.mapToListToDto(roles);

        assertNotNull(dtoList);
        assertEquals(2, dtoList.size());

        RoleDto dto1 = dtoList.get(0);
        assertEquals(role1.getId(), dto1.getId());
        assertEquals(role1.getName(), dto1.getName());

        RoleDto dto2 = dtoList.get(1);
        assertEquals(role2.getId(), dto2.getId());
        assertEquals(role2.getName(), dto2.getName());
    }
}
