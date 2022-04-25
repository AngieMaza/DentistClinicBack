package com.DentalClinic.DH.servicesTests;

import com.DentalClinic.DH.exceptions.ResourceNotFoundException;
import com.DentalClinic.DH.model.AddressDTO;
import com.DentalClinic.DH.model.PatientDTO;
import com.DentalClinic.DH.service.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Set;

@SpringBootTest
public class ServicePatientTests {
    private static PatientService patientService;
    @Autowired
    public ServicePatientTests(PatientService patientService) {
        this.patientService = patientService;
    }

    @Test
    public void saveAndGetId() {
        PatientDTO patient =new PatientDTO();
        patient.setName("Gabriel");
        patient.setLastName("Franke");
        patient.setEntryDate(new Date(122,05,12));
        patient.setDni("123456789");
        patient.setAddress(new AddressDTO());
        patient.getAddress().setCity("CABA");
        patient.getAddress().setStreet("Av. Rivadavia");
        patient.getAddress().setNumber(123);
        patient.getAddress().setProvince("Buenos Aires");

        PatientDTO patientSaved = patientService.save(patient);
        Assertions.assertTrue(patientSaved.getId() != null);
    }
    @Test
    public void deleteById () throws ResourceNotFoundException {
        PatientDTO patient = new PatientDTO();
        patient.setName("Gabriel");
        patient.setLastName("Franke");
        patient.setEntryDate(new Date(122,05,12));
        patient.setDni("123456789");
        patient.setAddress(new AddressDTO());
        patient.getAddress().setCity("CABA");
        patient.getAddress().setStreet("Av. Rivadavia");
        patient.getAddress().setNumber(123);
        patient.getAddress().setProvince("Buenos Aires");
        PatientDTO patientSaved = patientService.save(patient);
        patientService.delete(patientSaved.getId());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            patientService.delete(patientSaved.getId());
        });
    }
    @Test
    public void getAllPatients() {
        patientService.save(new PatientDTO());
        Set<PatientDTO> patientDTOS = patientService.findAll();
        Assertions.assertTrue(patientDTOS.size() > 0);
    }

}
