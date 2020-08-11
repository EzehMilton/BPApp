package com.milton.register.controller;

import com.milton.register.model.PatientReq;
import com.milton.register.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/register/")
@Api(value="patientsregistration")
public class RegistrationController {

    private PatientService patientService;

    public RegistrationController(PatientService patientService) {
        this.patientService = patientService;
    }

    // view -> http://localhost:8080/swagger-ui.html
    @ApiOperation(value = "Add a new patient",response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Patient successfully added"),
            @ApiResponse(code = 401, message = "You are not authorized to add a patient"),
            @ApiResponse(code = 403, message = "Adding a patient is forbidden"),
            @ApiResponse(code = 422, message = "Patient already registered")
    }
    )
    @PostMapping("add")
    ResponseEntity<String> addPatient(@RequestBody PatientReq patientReq){
        return ResponseEntity.status(201).body("Patient Added. ID: " + patientService.addPatient(patientReq));
    }


}
