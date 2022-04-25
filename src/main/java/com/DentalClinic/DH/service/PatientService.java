package com.DentalClinic.DH.service;

import com.DentalClinic.DH.exceptions.ResourceNotFoundException;
import com.DentalClinic.DH.model.PatientDTO;
import com.DentalClinic.DH.persistence.entities.Patient;
import com.DentalClinic.DH.persistence.repository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientService{
    private IPatientRepository patientRepository;
    private ObjectMapper objectMapper;
    @Autowired
    public void setPatientRepository(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public PatientDTO save(PatientDTO patientDTO){
        Patient patient = patientRepository.save(objectMapper.convertValue(patientDTO, Patient.class));
        return objectMapper.convertValue(patient, PatientDTO.class);
    }
    public void delete(Long id) throws ResourceNotFoundException {
        PatientDTO patientSerched = findById(id);
        if (patientSerched.getId() != null) {
            patientRepository.delete(objectMapper.convertValue(patientSerched, Patient.class));
        } else {
            throw new ResourceNotFoundException("Patient with id " + id + " not found");
        }
    }

    public PatientDTO findById(Long id) throws ResourceNotFoundException {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO patientDTO = null;
        if(patient.isPresent()){
            patientDTO = objectMapper.convertValue(patient, PatientDTO.class);
        }else {
            throw new ResourceNotFoundException("Patient with id " + id + " not found");
        }
        return patientDTO;
    }

    public PatientDTO update(PatientDTO patientDTO){
        Patient patient = objectMapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patient);
        return objectMapper.convertValue(patient, PatientDTO.class);
    }

    public Set<PatientDTO> findAll(){
        Set<PatientDTO> patients = new HashSet<>();
        for(Patient patient : patientRepository.findAll()){
            patients.add(objectMapper.convertValue(patient, PatientDTO.class));
        }
        return patients;
    }

}
