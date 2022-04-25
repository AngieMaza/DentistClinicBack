package com.DentalClinic.DH.persistence.repository;

import com.DentalClinic.DH.persistence.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
}
