package com.milton.register.repository;

import org.springframework.beans.factory.annotation.Value;

public interface PatientTelNumber {
    @Value("#{target.telno}")
    String getTelNumber();
}
