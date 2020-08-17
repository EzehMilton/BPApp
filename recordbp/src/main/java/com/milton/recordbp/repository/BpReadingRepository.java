package com.milton.recordbp.repository;

import com.milton.recordbp.model.BpReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BpReadingRepository extends JpaRepository <BpReading, Long> {
}
