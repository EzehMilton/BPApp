package com.milton.register.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PATIENTS")
public class Patient {
    //TODO Add column annotations to
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "patientid")
    private String patientId;
    @Column(name = "name")
    private String fullName;
    @Column(name = "telno")
    private String telNumber;
    @Column(name = "kintelno")
    private String telNextOfKin;
    @Column(name = "datetime")
    private LocalDateTime localDateTime;
    @Column(name = "dateofbirth")
    private String dateOfBirth;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "maritalstatus")
    private String maritalStatus;
    @Column(name = "health")
    private String healthConditions;


    public Patient() {

    }

    public Patient(String patientId, String fullName, String telNumber, String telNextOfKin, LocalDateTime localDateTime, String dateOfBirth, Gender gender, String maritalStatus, String healthConditions) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.telNumber = telNumber;
        this.telNextOfKin = telNextOfKin;
        this.localDateTime = localDateTime;
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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