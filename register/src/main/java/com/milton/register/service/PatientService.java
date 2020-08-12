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

/**
 * Patient regitration class
 * Registers and gets patient
 */
@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Add Patient to DB
     * @param patient
     * @return Patient ID
     */
    public String addPatient(Patient patient){
        checkIfPatientIsAlreadyRegistered(patient);
        setIdDateTimeForPatient(patient);
        patientRepository.save(patient);
        return patient.getPatientId();
    }

    /**
     * Gets Patient using Patient's ID
     * @param id - Patient ID genereated during registration
     * @return Patent
     */
    public Optional<Patient> findPatientById(String id) {
        System.out.println("id = " + id);
        return patientRepository.findByPatientId(id);
    }

    /**
     * Helper class - updates patient's registration details.
     * @param patient
     */
    private void setIdDateTimeForPatient(Patient patient) {
        patient.setPatientId(RandomStringUtils.randomAlphanumeric(6));
        patient.setRegistrationDate(LocalDate.now().toString());
        patient.setRegistrationTime(LocalTime.now().toString().substring(0,8));
    }

    /**
     * Helper class - Checks if patient is registered already
     * @param patient
     */
    private void checkIfPatientIsAlreadyRegistered(Patient patient) {
        //TODO Rework double registration logic.
        final Optional<Patient> patientExists = patientRepository.findByDateOfBirthAndFullName(patient.getDateOfBirth(),
                patient.getFullName());

        if(patientExists.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patient Already Registered");
        }
    }

}
