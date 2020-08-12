package com.milton.register.service;

import com.milton.register.model.Patient;
import com.milton.register.repository.PatientRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public String addPatient(Patient patient){
        // set id, date and time before saving.
        setIdDateTime(patient);
        patientRepository.save(patient);
        return patient.getPatientId();
    }

    private void setIdDateTime(Patient patient) {
        patient.setPatientId(RandomStringUtils.randomAlphanumeric(6));
        patient.setRegistrationDate(LocalDate.now().toString());
        patient.setRegistrationTime(LocalTime.now().toString().substring(0,8));
        // check if patient has registered before.
        final Optional<Patient> patientExists = patientRepository.findByDateOfBirthAndFullName(patient.getDateOfBirth(),
                patient.getFullName());
       //TODO Tidy this up so double registration is not allowed
       if(patientExists.isPresent()){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patient Already Registered");
       }
    }


    public Optional<Patient> findPatientById(String id) {
        System.out.println("id = " + id);
        return patientRepository.findByPatientId(id);
    }
}
