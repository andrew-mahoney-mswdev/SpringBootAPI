package com.counties.customers.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Surname {
    @NotBlank private final String value;

    public Surname (@JsonProperty("surname") String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
