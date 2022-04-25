package com.DentalClinic.DH.service;


import com.DentalClinic.DH.exceptions.ResourceNotFoundException;
import com.DentalClinic.DH.model.DentistDTO;
import com.DentalClinic.DH.persistence.entities.Dentist;
import com.DentalClinic.DH.persistence.repository.IDentistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DentistService {
    final static Logger logger = LogManager.getLogger(DentistService.class);

    public DentistService() {
    }
    private IDentistRepository iDentistRepository;
    @Autowired
   public void setiDentistRepository(IDentistRepository iDentistRepository) {
       this.iDentistRepository = iDentistRepository;
  }

    private ObjectMapper objectMapper;
    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public DentistDTO save(DentistDTO dentistDTO) {
        Dentist dentist = iDentistRepository.save(objectMapper.convertValue(dentistDTO, Dentist.class));
        return objectMapper.convertValue(dentist, DentistDTO.class);

    }

    public Set<DentistDTO> getAllDentists() {
        Set<DentistDTO> dentistDTOS = new HashSet<>();
        for (Dentist dentist : iDentistRepository.findAll()) {
            dentistDTOS.add(objectMapper.convertValue(dentist, DentistDTO.class));
        }
        return dentistDTOS;
    }

    public void delete(Long id) throws ResourceNotFoundException {
        DentistDTO dentistSerched = findById(id);
        if (dentistSerched.getId() != null) {
            iDentistRepository.delete(objectMapper.convertValue(dentistSerched, Dentist.class));
        } else {
            throw new ResourceNotFoundException("Dentist with id " + id + " not found");
        }
    }

    public DentistDTO findById(Long id)throws ResourceNotFoundException {
        Optional<Dentist> dentist = iDentistRepository.findById(id);
        DentistDTO dentistDTO = null;
        if (dentist.isPresent()) {
            dentistDTO = objectMapper.convertValue(dentist, DentistDTO.class);
        }else
            throw new ResourceNotFoundException("Dentist with id " + id + " not found");

        return dentistDTO;
    }

    public DentistDTO update(DentistDTO dentistDTO) throws ResourceNotFoundException {
        Dentist dentist = objectMapper.convertValue(dentistDTO, Dentist.class);
            if (dentistDTO.getId()!=null){
                Dentist updatedDentist = iDentistRepository.save(dentist);
                objectMapper.convertValue(updatedDentist, DentistDTO.class);
            } else {
                throw new ResourceNotFoundException("Dentist with id:" +dentistDTO.getId()+ " is not Found");
            }
        return dentistDTO;
    }

    public  DentistDTO findByRegistrationNumber(String registrationNumber){
        Dentist dentist = iDentistRepository.findByRegistrationNumber(registrationNumber);
        DentistDTO dentistDTO = null;
        if (dentist != null) {
            dentistDTO = objectMapper.convertValue(dentist, DentistDTO.class);
        }
        return dentistDTO;
    }

}
