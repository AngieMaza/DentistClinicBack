package com.DentalClinic.DH.controller;

import com.DentalClinic.DH.exceptions.ResourceNotFoundException;
import com.DentalClinic.DH.model.PatientDTO;
import com.DentalClinic.DH.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/patient")
@CrossOrigin("http://localhost:3000")

public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/add")
    public ResponseEntity<PatientDTO> savePatient(@RequestBody PatientDTO patientDTO) {
        return ResponseEntity.ok(patientService.save(patientDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO patientDTO) throws ResourceNotFoundException {
        ResponseEntity<PatientDTO> response = null;
        if (patientDTO.getId() != null && patientService.findById(patientDTO.getId()) != null) {
            response = ResponseEntity.ok(patientService.update(patientDTO));
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
    @GetMapping("{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") Long id) throws ResourceNotFoundException {
        ResponseEntity<PatientDTO> response = null;
        if (patientService.findById(id)!=null) {
            response = ResponseEntity.ok(patientService.findById(id));
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
    @GetMapping("/all")
    public ResponseEntity<Set<PatientDTO>> getAllPatients() {
        if(patientService.findAll()!=null) {
            return ResponseEntity.ok(patientService.findAll());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") Long id) throws ResourceNotFoundException {
        patientService.delete(id);
        return ResponseEntity.ok("Patient Deleted");

    }
}
