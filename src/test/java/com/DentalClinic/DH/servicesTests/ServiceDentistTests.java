package com.DentalClinic.DH.servicesTests;


import com.DentalClinic.DH.exceptions.ResourceNotFoundException;
import com.DentalClinic.DH.model.DentistDTO;
import com.DentalClinic.DH.service.DentistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Set;

@SpringBootTest
public class ServiceDentistTests {

    private static DentistService dentistService;
    @Autowired
    public  ServiceDentistTests (DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @Test
    public void saveAndGetId() {
        DentistDTO dentist =new DentistDTO();
        dentist.setRegistration_number("123456789");
        dentist.setName("Gabriel");
        dentist.setLastName("Franke");
        DentistDTO dentistSaved = dentistService.save(dentist);
        Assertions.assertTrue(dentistSaved.getId() != null);
    }

    @Test
    public void deleteById () throws ResourceNotFoundException {
        DentistDTO dentist = new DentistDTO();
        dentist.setRegistration_number("123456789");
        dentist.setName("Gabriel");
        dentist.setLastName("Franke");
        DentistDTO dentistSaved = dentistService.save(dentist);
        dentistService.delete(dentistSaved.getId());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            dentistService.delete(dentistSaved.getId());
        });
    }
    @Test
    public void getAllDentists() {
        dentistService.save(new DentistDTO());
        Set<DentistDTO> dentistDTOS = dentistService.getAllDentists();
        Assertions.assertTrue(dentistDTOS.size() > 0);
    }
}
