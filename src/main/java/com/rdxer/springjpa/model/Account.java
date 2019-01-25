package com.rdxer.springjpa.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Account {

    private String id;
    private String username;
    private String password;

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
