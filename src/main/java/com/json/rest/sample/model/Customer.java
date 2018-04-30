package com.json.rest.sample.model;

import javax.persistence.*;

/**
 * @author Praneeth
 */

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String _id;

    @Column(name = "tags")
    private String[] tags;

    @Column(name = "phone")
    private String phone;

    @Column(name = "index")
    private String index;

    @ManyToOne
    @JoinColumn(name = "Address")
    private Address address;

    @Column(name = "email")
    private String email;

    @Column(name = "eyeColor")
    private String eyeColor;

    @Column(name = "registered")
    private String registered;

    @Column(name = "company")
    private String company;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "about")
    private String about;

    @Column(name = "gender")
    private String gender;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    // Getters * Setters
    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "ClassPojo [tags = " + tags + ", phone = " + phone + ", index = " + index + ", _id = " + _id + ", address = " + address + ", email = " + email + ", eyeColor = " + eyeColor + ", registered = " + registered + ", company = " + company + ", name = " + name + ", age = " + age + ", about = " + about + ", gender = " + gender + ", longitude = " + longitude + ", latitude = " + latitude + "]";
    }
}