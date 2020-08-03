package com.schoolproject.rmats.api.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class AuthorizationTO {
    @Size(min = 4, max = 50)
    @Email
    private String email;

    @Size(min = 4, max = 50)
    private String authority;

    public AuthorizationTO(@JsonProperty("email") String email, @JsonProperty("authority") String authority) {
        this.email = email;
        this.authority = authority;
    }

    public String getEmail() {
        return email;
    }

    public String getAuthority() {
        return authority;
    }
}
