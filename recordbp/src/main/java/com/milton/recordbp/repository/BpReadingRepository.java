package com.milton.recordbp.repository;

import com.milton.recordbp.model.BpReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BpReadingRepository extends JpaRepository <BpReading, Long> {
    @Query(value = "select patientid from BPREADINGS where systolic > 90", nativeQuery = true)
    List<PatientIds> findAllHighBPPatients();

}
