package com.milton.register.service;

import com.milton.register.model.Patient;

import java.util.Optional;

public interface IPatientService {
    String addPatient(Patient patient);

    Optional<Patient> findPatientById(String id);

    String getTelNumberForPatientId(String patientId);
}
