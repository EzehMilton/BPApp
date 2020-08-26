package com.milton.recordbp.service;

import com.milton.recordbp.model.BpReading;
import com.milton.recordbp.repository.BpReadingRepository;
import com.milton.recordbp.repository.PatientIds;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Primary
public class BpReadingService implements IBpReadingService {
    private BpReadingRepository bpReadingRepository;

    public BpReadingService(BpReadingRepository bpReadingRepository) {
        this.bpReadingRepository = bpReadingRepository;
    }

    /**
     * Save BP readings of a patient
     * @param bpReading
     * @return
     */
    @Override
    public BpReading BpReading(BpReading bpReading){
        bpReading.setLocalDateTime(LocalDateTime.now());
        bpReadingRepository.save(bpReading);
        return bpReading;
    }

    /**
     * List of patients with high BP
     * @return
     */
    @Override
    public List<PatientIds> listAllHighBps(){
        return bpReadingRepository.findAllHighBPPatients();
    }
}
