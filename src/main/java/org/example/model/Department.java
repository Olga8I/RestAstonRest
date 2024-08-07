package org.example.model;

import org.example.repository.UserToDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The Department where User works
 * Relation:
 * Many To Many: Department <-> User
 */
@Component
public class Department {

    private Long id;
    private String name;
    private List<User> userList;

    private final UserToDepartmentRepository userToDepartmentRepository;

    @Autowired
    public Department(UserToDepartmentRepository userToDepartmentRepository) {
        this.userToDepartmentRepository = userToDepartmentRepository;
    }

    public Department(Long id, String name, UserToDepartmentRepository userToDepartmentRepository) {
        this.id = id;
        this.name = name;
        this.userToDepartmentRepository = userToDepartmentRepository;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        if (userList == null) {
            userList = userToDepartmentRepository.findUsersByDepartmentId(this.id);
        }
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
