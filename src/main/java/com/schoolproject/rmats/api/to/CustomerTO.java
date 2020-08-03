package com.schoolproject.rmats.api.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;

public class CustomerTO {

    @Size(min = 2, max = 20)
    @NotBlank
    private final String firstName;

    @NotNull
    @Size(min = 2, max = 20)
    private final String lastName;

    @NotNull
    @Size(min = 2, max = 50)
    private final String company;

    @NotNull
    @Size(min = 9, max = 20)
    private final String phone;

    @Size(min = 6, max = 50)
    @Email
    private final String email;
    @NotNull
    @NotBlank
    @Size(min = 1, max = 20)
    private final String password;

    @JsonCreator
    public CustomerTO(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("company") String company,
            @JsonProperty("phone") String phone,
            @JsonProperty("email") String email,
            @JsonProperty("password") String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
