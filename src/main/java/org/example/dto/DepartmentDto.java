package org.example.dto;

import java.util.List;

public class DepartmentDto {
    private Long id;
    private String name;
    private List<UserDto> userList; // Объявление переменной

    public DepartmentDto() {}

    public DepartmentDto(String name) {
        this.name = name;
    }

    public DepartmentDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDto(Long id, String name, List<UserDto> userList) {
        this.id = id;
        this.name = name;
        this.userList = userList; // Инициализация переменной
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<UserDto> getUserList() { return userList; }
    public void setUserList(List<UserDto> userList) { this.userList = userList; }
}
