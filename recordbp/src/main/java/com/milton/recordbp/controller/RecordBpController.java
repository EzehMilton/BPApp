package com.milton.recordbp.controller;

import com.milton.recordbp.model.BpReading;
import com.milton.recordbp.service.BpReadingService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/recordbp/")
@Api(value = "recordbp")
public class RecordBpController {

    private BpReadingService bpReadingService;

    public RecordBpController(BpReadingService bpReadingService) {
        this.bpReadingService = bpReadingService;
    }

    @PostMapping("/recordbp")
    ResponseEntity<BpReading> recordBpOfPatient(@RequestBody BpReading bpReading){
        return ResponseEntity.ok().body(bpReadingService.BpReading(bpReading));

    }
}
