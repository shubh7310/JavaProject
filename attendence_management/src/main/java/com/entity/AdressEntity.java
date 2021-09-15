package com.entity;


import javax.persistence.*;

@Entity
@Table(name = "student_address")
public class AdressEntity {


    @Id // primary key // 1,1 // constraint Voilation
    @GeneratedValue(strategy = GenerationType.AUTO)  // 1,2,3,4 Auto increment
    private Long id;   // primary key

    private String distict;

    private String state;

    private String country;

    private Long pinCode;

    public AdressEntity() {
    }

    public AdressEntity(String distict, String state, String country, Long pinCode) {
        this.distict = distict;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistict() {
        return distict;
    }

    public void setDistict(String distict) {
        this.distict = distict;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }
}
