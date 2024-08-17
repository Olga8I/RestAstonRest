package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PhoneNumberDto {
    private Long id;
    private String number;
    @JsonProperty("user")
    private UserDto userDto;

    public PhoneNumberDto() {}

    public PhoneNumberDto(String number, UserDto userDto) {
        this.number = number;
        this.userDto = userDto;
    }

    public Long getId() { return id; }
    public void setId(Long id) {this.id = id;}
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public UserDto getUserDto() { return userDto; }
    public void setUserDto(UserDto userDto) { this.userDto = userDto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumberDto that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(number, that.number) && Objects.equals(userDto, that.userDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }

    @Override
    public String toString() {
        return "PhoneNumberDto{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", userDto=" + userDto +
                '}';
    }
}

