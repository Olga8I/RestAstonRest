package org.example.dto;

import org.example.model.Role;

import java.util.List;
import java.util.Set;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Role role; // Поле для роли, можно заменить на RoleUpdate или RoleOutGoing в зависимости от контекста
    private List<PhoneNumberDto> phoneNumberList; // Должен быть класс DTO для телефонных номеров
    private Set<DepartmentDto> departmentList; // Должен быть класс DTO для департаментов

    public UserDto(Long id, String firstName, String lastName) {
    }

    public UserDto(Long id, String firstName, String lastName, Role role, List<PhoneNumberDto> phoneNumberList, Set<DepartmentDto> departmentList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.phoneNumberList = phoneNumberList;
        this.departmentList = departmentList;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }

    public List<PhoneNumberDto> getPhoneNumberList() {
        return phoneNumberList;
    }

    public Set<DepartmentDto> getDepartmentList() {
        return departmentList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPhoneNumberList(List<PhoneNumberDto> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    public void setDepartmentList(Set<DepartmentDto> departmentList) {
        this.departmentList = departmentList;
    }

}


