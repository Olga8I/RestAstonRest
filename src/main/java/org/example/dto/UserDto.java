package org.example.dto;

import org.example.model.Role;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Role role;
    private List<PhoneNumberDto> phoneNumberList;
    private Set<DepartmentDto> departmentList;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, Role role, List<PhoneNumberDto> phoneNumberList,
                   Set<DepartmentDto> departmentList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.phoneNumberList = phoneNumberList;
        this.departmentList = departmentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto userDto)) return false;
        return Objects.equals(id, userDto.id) && Objects.equals(firstName, userDto.firstName) && Objects.equals(lastName, userDto.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", phoneNumberList=" + phoneNumberList +
                ", departmentList=" + departmentList +
                '}';
    }
}


