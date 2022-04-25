package com.DentalClinic.DH.service;

import com.DentalClinic.DH.exceptions.BadRequestException;
import com.DentalClinic.DH.exceptions.ResourceNotFoundException;
import com.DentalClinic.DH.model.AppointmentDTO;
import com.DentalClinic.DH.persistence.entities.Appointment;
import com.DentalClinic.DH.persistence.repository.IAppointmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppointmentService {
    private IAppointmentRepository appointmentRepository;
    private ObjectMapper objectMapper;
    @Autowired
    public void setAppointmentRepository(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
     public AppointmentDTO save(AppointmentDTO appointmentDTO){
        Appointment appointment = appointmentRepository.save(objectMapper.convertValue(appointmentDTO, Appointment.class));
        return objectMapper.convertValue(appointment, AppointmentDTO.class);
    }

    public AppointmentDTO getById(Long id) throws ResourceNotFoundException {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        AppointmentDTO appointmentDTO = null;
        if (appointment.isPresent()) {
            appointmentDTO = objectMapper.convertValue(appointment, AppointmentDTO.class);
        }else {
            throw new ResourceNotFoundException("Appointment with id " + id + " not found");
        }
        return appointmentDTO;
    }

    public AppointmentDTO update(AppointmentDTO appointmentDTO) {
        Appointment appointment = objectMapper.convertValue(appointmentDTO, Appointment.class);
        appointment = appointmentRepository.save(appointment);
        return objectMapper.convertValue(appointment, AppointmentDTO.class);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        AppointmentDTO appointmentSerched = getById(id);
        if (appointmentSerched.getId() != null) {
            appointmentRepository.delete(objectMapper.convertValue(appointmentSerched, Appointment.class));
        } else {
            throw new ResourceNotFoundException("Appointment with id " + id + " not found");
        }
    }

    public Set<AppointmentDTO> getAll() {
        Set<AppointmentDTO> appointments = new HashSet<>();
        for (Appointment appointment : appointmentRepository.findAll()) {
            appointments.add(objectMapper.convertValue(appointment, AppointmentDTO.class));
        }
        return appointments;
    }


}
