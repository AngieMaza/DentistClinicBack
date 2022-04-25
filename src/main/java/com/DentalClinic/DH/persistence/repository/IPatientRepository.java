package com.DentalClinic.DH.persistence.repository;

import com.DentalClinic.DH.persistence.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
}

