package org.example.model;

import jakarta.persistence.*;

/**
 * Phone entity
 * One To One: PhoneNumber - User
 */
@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public PhoneNumber() {
    }

    public PhoneNumber(Long id, String number, User user) {
        this.id = id;
        this.number = number;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", user=" + (user != null ? user.getId() : null) +
                '}';
    }
}


