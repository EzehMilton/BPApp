package com.milton.register.controller;

import com.milton.register.model.Patient;
import com.milton.register.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("v1/register/")
@Api(value = "patientsregistration")
public class RegistrationController {


    private PatientService patientService;

    public RegistrationController(PatientService patientService) {
        this.patientService = patientService;
    }

    // view -> http://localhost:8080/swagger-ui.html
    @ApiOperation(value = "Add a new patient", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Patient successfully added"),
            @ApiResponse(code = 400, message = "Patient already registered"),
            @ApiResponse(code = 401, message = "You are not authorized to add a patient"),
            @ApiResponse(code = 403, message = "Adding a patient is forbidden"),
            @ApiResponse(code = 422, message = "Patient already registered")
    }
    )
    @PostMapping("add")
    ResponseEntity<String> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.status(201).body("Patient Added. ID: " + patientService.addPatient(patient));
    }


    @ApiOperation(value = "Find patient by patient ID", response = Patient.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found patient"),
            @ApiResponse(code = 401, message = "You are not authorized to view the patient"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The patient you were trying to reach is not found")
    }
    )
    @GetMapping("patient/{patientId}")
    Patient getPatientById(@PathVariable(required = true) String patientId) {
        // not need for a get when you use orElse...
        return patientService.findPatientById(patientId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient Not found"));
    }


    @ApiOperation(value = "Get telephone number by patient ID", response = Patient.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found telephone number"),
            @ApiResponse(code = 401, message = "You are not authorized to view the telephone number"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The telephone number you were trying to reach is not found")
    }
    )
    @GetMapping("/telno/{patientId}")
    String getTelNo(@PathVariable String patientId){
        return patientService.getTelNumberForPatientId(patientId);
    }
}
