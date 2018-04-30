package com.json.rest.sample.model;

import javax.persistence.*;

/**
 * @author Praneeth
 */

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String _id;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "street")
    private String street;

    @Column(name = "state")
    private String state;

    @Column(name = "number")
    private String number;

    @Column(name = "city")
    private String city;

    // Getters * Setters
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ClassPojo [zipcode = " + zipcode + ", street = " + street + ", state = " + state + ", number = " + number + ", city = " + city + "]";
    }
}