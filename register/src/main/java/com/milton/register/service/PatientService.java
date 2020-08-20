package com.milton.register.service;

import com.milton.register.config.AppConfig;
import com.milton.register.model.Patient;
import com.milton.register.repository.PatientRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * Patient regitration class
 * Registers and gets patient
 */
@Service
public class PatientService implements IPatientService {

    private PatientRepository patientRepository;
    private AppConfig appConfig;

    public PatientService(PatientRepository patientRepository, AppConfig appConfig) {
        this.patientRepository = patientRepository;
        this.appConfig = appConfig;
    }

    /**
     * Add Patient to DB
     * @param patient
     * @return Patient ID
     */
    @Override
    public String addPatient(Patient patient){
        // do this to fail fast
        Objects.requireNonNull(patient);
        System.out.println("Application Name: " + appConfig.getAppname());
        System.out.println("Application Version: " + appConfig.getVersion());
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
    @Override
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
        patient.setLocalDateTime(LocalDateTime.now());
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

    /**
     * Get telephone number from patient ID
     * @param patientId
     * @return Telephone Number
     */
    @Override
    public String getTelNumberForPatientId(String patientId){
        return patientRepository.getTelNo(patientId);
    }

}
