package com.milton.register.repository;

import com.milton.register.model.PatientReq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientReq, Long> {
}
