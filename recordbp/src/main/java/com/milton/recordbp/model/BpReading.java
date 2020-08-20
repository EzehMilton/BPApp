package com.milton.recordbp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "BPREADINGS")
public class BpReading {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "patientid")
    private String patientId;
    @Column(name = "systolic")
    private int systolic;
    @Column(name = "diastolic")
    private int diastolic;
    @Column(name = "heartrate")
    private int heartRate;
    @Column(name = "weight")
    private int weight;
    @Column(name = "date")
    private LocalDateTime localDateTime;


    public BpReading() {
    }

    public BpReading(String patientId, int systolic, int diastolic, int heartRate, int weight, LocalDateTime localDateTime) {
        this.patientId = patientId;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartRate = heartRate;
        this.weight = weight;
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
