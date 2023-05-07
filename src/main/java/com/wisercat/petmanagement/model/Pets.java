package com.wisercat.petmanagement.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

// Pet model class
@Entity
public class Pets implements Serializable {

    @Id
    // Start generating Id from value 6 because id's 1-5 are inserted during program
    // startup by liquidbase
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_gen")
    @SequenceGenerator(name = "id_gen", sequenceName = "start_from_six", allocationSize = 1, initialValue = 6)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String petName;
    private String code;
    private String petType;
    private String furColor;
    private String country;

    public Pets() {
    }

    public Pets(String petName, String code, String petType, String furColor, String country) {

        this.petName = petName;
        this.code = code;
        this.petType = petType;
        this.furColor = furColor;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Pet{" +
                " id='" + getId() + "'" +
                ", petName='" + getPetName() + "'" +
                ", code='" + getCode() + "'" +
                ", petType='" + getPetType() + "'" +
                ", furColor='" + getFurColor() + "'" +
                ", country='" + getCountry() + "'" +
                "}";
    }

}
