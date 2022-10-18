package com.example.vea.VEA.models;

public class Person {

private long id;
    private String firstName;
    private String lastName;
    private Address address;

    public Person(){
        super();
    }

    public Person(long id, String firstName, String lastName, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCity(){
        return address.getCity();
    }

    public String getStreet(){
        return address.getStreet();
    }
}
