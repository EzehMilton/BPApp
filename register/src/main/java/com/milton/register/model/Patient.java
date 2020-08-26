package com.milton.register.model;

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
@Table(name = "PATIENTS")
@JsonIgnoreProperties(ignoreUnknown = true)
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

}