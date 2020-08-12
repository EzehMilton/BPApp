package com.milton.register.repository;

import com.milton.register.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByPatientId(String patientId);
    Optional<Patient> findByDateOfBirthAndFullName(String dateOfBirth, String fullName);

}
