package com.milton.recordbp.service;

import com.milton.recordbp.model.BpReading;
import com.milton.recordbp.repository.BpReadingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BpReadingService {
    private BpReadingRepository bpReadingRepository;

    public BpReadingService(BpReadingRepository bpReadingRepository) {
        this.bpReadingRepository = bpReadingRepository;
    }

    public BpReading BpReading(BpReading bpReading){
        bpReading.setLocalDateTime(LocalDateTime.now());
        bpReadingRepository.save(bpReading);
        return bpReading;
    }

}
