package com.counties.customers.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    private final UUID id;
    @NotBlank private final String name;
    @NotBlank private final String surname;
    private final String email;

    public Customer(@JsonProperty("id") UUID id, 
                    @JsonProperty("name") String name, 
                    @JsonProperty("surname") String surname, 
                    @JsonProperty("email") String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
