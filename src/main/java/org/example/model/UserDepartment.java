package org.example.model;

import org.springframework.stereotype.Component;

/**
 * UserDepartment entity
 * ManyToMany
 * User <-> Department
 */
@Component
public class UserDepartment {
    private Long id;
    private Long userId;
    private Long departmentId;

    public UserDepartment() {
    }

    public UserDepartment(Long id, Long userId, Long departmentId) {
        this.id = id;
        this.userId = userId;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
