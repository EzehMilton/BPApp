package com.milton.recordbp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BPREADINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
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


}
