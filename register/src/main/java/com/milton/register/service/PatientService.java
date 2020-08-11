package com.milton.register.service;

import com.milton.register.model.PatientReq;
import com.milton.register.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public String addPatient(PatientReq patient){
        patientRepository.save(patient);
        return patient.getPatientId();
    }
}
