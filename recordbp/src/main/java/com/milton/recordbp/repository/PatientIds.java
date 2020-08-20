package com.milton.recordbp.repository;

import org.springframework.beans.factory.annotation.Value;

public interface PatientIds {
    @Value("#{target.patientid}")
    String getPatientId();
}
