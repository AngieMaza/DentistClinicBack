package com.DentalClinic.DH.servicesTests;

import com.DentalClinic.DH.exceptions.BadRequestException;
import com.DentalClinic.DH.exceptions.ResourceNotFoundException;
import com.DentalClinic.DH.model.AppointmentDTO;
import com.DentalClinic.DH.model.DentistDTO;
import com.DentalClinic.DH.model.PatientDTO;
import com.DentalClinic.DH.service.AppointmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Set;

@SpringBootTest
public class ServiceAppointmetTests {
    private static AppointmentService appointmentService;
    @Autowired
    public  ServiceAppointmetTests (AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @Test
    public void saveAndGetId() throws BadRequestException {
        AppointmentDTO appointment =new AppointmentDTO();
        appointment.setDate( new Date(122,12,12));
        appointment.setDentist(new DentistDTO());
        appointment.setPatient(new PatientDTO());
        AppointmentDTO appointmentSaved = appointmentService.save(appointment);
        Assertions.assertTrue(appointmentSaved.getId() != null);
    }
    @Test
    public void deleteById () throws ResourceNotFoundException {
        AppointmentDTO appointment = new AppointmentDTO();
        appointment.setDate( new Date(122,12,12));
        appointment.setDentist(new DentistDTO());
        appointment.setPatient(new PatientDTO());
        AppointmentDTO appointmentSaved = appointmentService.save(appointment);
        appointmentService.delete(appointmentSaved.getId());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            appointmentService.delete(appointmentSaved.getId());
        });
    }
    @Test
    public void getAllAppointments() {
        appointmentService.save(new AppointmentDTO());
        Set<AppointmentDTO> appointmentDTOS = appointmentService.getAll();
        Assertions.assertTrue(appointmentDTOS.size() > 0);
    }


}
