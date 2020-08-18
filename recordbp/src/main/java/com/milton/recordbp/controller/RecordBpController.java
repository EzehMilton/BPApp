package com.milton.recordbp.controller;

import com.milton.recordbp.model.BpReading;
import com.milton.recordbp.repository.PatientIds;
import com.milton.recordbp.service.BpReadingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
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

    @ApiOperation(value = "Add a patient's BP", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "BP reading successfully added"),
            @ApiResponse(code = 401, message = "You are not authorized to add BP reading"),
            @ApiResponse(code = 403, message = "Adding a patient's BP reading is forbidden")
    }
    )
    @PostMapping("/recordbp")
    ResponseEntity<BpReading> recordBpOfPatient(@RequestBody BpReading bpReading){
        return ResponseEntity.ok().body(bpReadingService.BpReading(bpReading));

    }

    @ApiOperation(value = "Get list of Patient's with high BP", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found patient's with high BP"),
            @ApiResponse(code = 401, message = "You are not authorized to view list of patient's of high BP"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The list you were trying to reach is not found")
    }
    )
    @GetMapping("/highbplist")
    ResponseEntity<List<PatientIds>> test(){
        List<PatientIds> ids = bpReadingService.listAllHighBps();
        return ResponseEntity.status(HttpStatus.OK).body(ids);
    }
}
