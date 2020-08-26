package com.milton.recordbp.service;

import com.milton.recordbp.model.BpReading;
import com.milton.recordbp.repository.PatientIds;

import java.util.List;

public interface IBpReadingService {
    BpReading BpReading(BpReading bpReading);

    List<PatientIds> listAllHighBps();
}
