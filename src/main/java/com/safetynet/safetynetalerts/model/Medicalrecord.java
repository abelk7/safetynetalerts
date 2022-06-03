package com.safetynet.safetynetalerts.model;

import java.util.Date;
import java.util.List;

public class Medicalrecord {

    private String firstName;
    private String lastName;
    private Date birthdate;
    private List<String>  medication;
    private List<String> allergie;


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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<String> getMedication() {
        return medication;
    }

    public void setMedication(List<String> medication) {
        this.medication = medication;
    }

    public List<String> getAllergie() {
        return allergie;
    }

    public void setAllergie(List<String> allergie) {
        this.allergie = allergie;
    }

}
