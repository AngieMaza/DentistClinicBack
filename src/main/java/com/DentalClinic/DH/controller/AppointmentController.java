package com.DentalClinic.DH.controller;


import com.DentalClinic.DH.exceptions.ResourceNotFoundException;
import com.DentalClinic.DH.model.AppointmentDTO;
import com.DentalClinic.DH.service.AppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/add")
    public ResponseEntity<AppointmentDTO> addAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appointmentService.save(appointmentDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(appointmentService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Set<AppointmentDTO>> getAllAppointment() {
        if (appointmentService.getAll() != null) {
            return ResponseEntity.ok(appointmentService.getAll());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
  }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) throws ResourceNotFoundException {
        appointmentService.delete(id);
        return ResponseEntity.ok("Appointment Deleted");
    }

    @PutMapping ("/update")
    public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        ResponseEntity <AppointmentDTO> response = null;
        if (appointmentDTO.getId() != null) {
            response = ResponseEntity.ok(appointmentService.update(appointmentDTO));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
