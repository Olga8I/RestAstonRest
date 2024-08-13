package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneNumberDto {
    private Long id; // Поле id возможно будет пустым для входящих запросов
    private String number;
    private Long userId;
    @JsonProperty("user")
    private UserDto userDto;

    public PhoneNumberDto() {}

    public PhoneNumberDto(String number) {
        this.number = number;
    }

    public PhoneNumberDto(Long id, String number, UserDto userDto) {
        this.id = id;
        this.number = number;
        this.userDto = userDto;
    }

    public PhoneNumberDto(Long id, String number, Long userId) {
        this.id = id;
        this.number = number;
        this.userId = userId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public UserDto getUserDto() { return userDto; }
    public void setUserDto(UserDto userDto) { this.userDto = userDto; }
}

