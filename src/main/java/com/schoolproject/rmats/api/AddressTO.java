package com.schoolproject.rmats.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class AddressTO {
    @Positive
    private final Integer userId;

    @Size(min = 3, max = 255)
    @NotBlank
    private final String street;

    @Size(min = 5, max = 50)
    @NotBlank
    private final String zipCode;

    @Size(min = 2, max = 50)
    @NotBlank
    private final String city;

    @Size(min = 2, max = 50)
    @NotBlank
    private final String country;

    @JsonCreator
    public AddressTO(@JsonProperty("customerId") Integer userId, @JsonProperty("street") String street,
                     @JsonProperty("zipCode") String zipCode,
                     @JsonProperty("city") String city,
                     @JsonProperty("country") String country) {
        this.userId = userId;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Integer getCustomerId() {
        return userId;
    }
}
