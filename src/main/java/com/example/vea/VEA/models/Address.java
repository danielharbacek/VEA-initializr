package com.example.vea.VEA.models;

import com.example.vea.VEA.serializers.AddressSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = AddressSerializer.class)
public class Address {

    private String street;
    private String city;

    public Address() {
        super();
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
