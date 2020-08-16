package com.milton.register.model;

import javax.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String patientId;
    private String fullName;
    private String telNumber;
    private String telNextOfKin;
    // TODO convert to date
    private String registrationDate;
    private String registrationTime;
    private String dateOfBirth;
    // TODO convert to enum
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String maritalStatus;
    private String healthConditions;


    public Patient() {

    }

    public Patient(String patientId, String fullName, String telNumber, String telNextOfKin, String registrationDate, String registrationTime, String dateOfBirth, Gender gender, String maritalStatus, String healthConditions) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.telNumber = telNumber;
        this.telNextOfKin = telNextOfKin;
        this.registrationDate = registrationDate;
        this.registrationTime = registrationTime;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.healthConditions = healthConditions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getTelNextOfKin() {
        return telNextOfKin;
    }

    public void setTelNextOfKin(String telNextOfKin) {
        this.telNextOfKin = telNextOfKin;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getHealthConditions() {
        return healthConditions;
    }

    public void setHealthConditions(String healthConditions) {
        this.healthConditions = healthConditions;
    }
}