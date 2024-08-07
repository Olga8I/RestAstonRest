package org.example.config;

import org.example.repository.PhoneNumberRepository;
import org.example.repository.UserToDepartmentRepository;
import org.example.repository.impl.PhoneNumberRepositoryImpl;
import org.example.repository.impl.UserToDepartmentRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

    @Bean
    public PhoneNumberRepository phoneNumberRepository() {
        return new PhoneNumberRepositoryImpl.getInstance();
    }

    @Bean
    public UserToDepartmentRepository userToDepartmentRepository() {
        return new  UserToDepartmentRepositoryImpl.getInstance();
    }
    @Bean
    public UserDepartment userDepartment() {
        return new UserDepartment();
    }

    @Bean
    public Role adminRole() {
        return new Role(1L, "ADMIN");
    }

    @Bean
    public Role userRole() {
        return new Role(2L, "USER");
    }
    @Bean
    public UserDepartment userDepartment() {
        return new UserDepartment(1L, 10L, 20L);
    }
}
