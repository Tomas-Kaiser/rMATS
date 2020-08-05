package com.schoolproject.rmats.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities", schema = "sql_rmats")
public class Authorization {
    @Id
    private String email;
    private String authority;

    public Authorization() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        authority = authority;
    }
}
