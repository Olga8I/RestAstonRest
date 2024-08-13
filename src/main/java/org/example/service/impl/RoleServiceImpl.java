package org.example.service.impl;

import org.example.exception.NotFoundException;
import org.example.dto.RoleDto;
import org.example.mapper.RoleMapper;
import org.example.model.Role;
import org.example.repository.RoleRepository;
import org.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        Role role = roleMapper.mapToEntity(roleDto);
        role = roleRepository.save(role);
        return roleMapper.mapToDto(role);
    }

    @Override
    public void update(RoleDto roleDto) throws NotFoundException {
        checkRoleExist(roleDto.getId());
        Role role = roleMapper.mapToEntity(roleDto);
        roleRepository.save(role);
    }

    @Override
    public RoleDto findById(Long roleId) throws NotFoundException {
        Role role = roleRepository.findById(roleId).orElseThrow(() ->
                new NotFoundException("Role not found."));
        return roleMapper.mapToDto(role);
    }

    @Override
    public List<RoleDto> findAll() {
        List<Role> roleList = roleRepository.findAll();
        return roleMapper.mapToListToDto(roleList);
    }

    @Override
    public void delete(Long roleId) throws NotFoundException {
        checkRoleExist(roleId);
        roleRepository.deleteById(roleId);
    }

    private void checkRoleExist(Long roleId) throws NotFoundException {
        if (!roleRepository.existsById(roleId)) {
            throw new NotFoundException("Role not found.");
        }
    }
}
