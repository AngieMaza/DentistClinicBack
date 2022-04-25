package com.DentalClinic.DH.controller;

import com.DentalClinic.DH.exceptions.ResourceNotFoundException;
import com.DentalClinic.DH.model.DentistDTO;
import com.DentalClinic.DH.service.DentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/dentist")
@CrossOrigin("http://localhost:3000")

public class DentistController {

    @Autowired
    private DentistService dentistService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/add")
    public DentistDTO registrarOdontologo(@RequestBody DentistDTO dentistDTO) {
        return dentistService.save(dentistDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> getDentist(@PathVariable("id") Long id) throws ResourceNotFoundException {
        ResponseEntity<DentistDTO> response = null;
        if (dentistService.findById(id) != null) {
            response = ResponseEntity.ok(dentistService.findById(id));
        }else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }
    @GetMapping("/all")
    public ResponseEntity<Set<DentistDTO>> getAllDentists() {
        return ResponseEntity.ok(dentistService.getAllDentists());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <?> deleteDentist(@PathVariable("id") Long id) throws ResourceNotFoundException {
        dentistService.delete(id);
        return ResponseEntity.ok("Dentist Deleted");
    }
    @PutMapping ("/update")
    public ResponseEntity<DentistDTO> updateDentist(@RequestBody DentistDTO dentistDTO) throws ResourceNotFoundException {
        return ResponseEntity.ok(dentistService.update(dentistDTO));
    }

}



