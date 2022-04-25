package com.DentalClinic.DH.persistence.repository;

import com.DentalClinic.DH.persistence.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository <Dentist, Long> {
    @Query("select d from Dentist d where d.registration_number = ?1")
    Dentist findByRegistrationNumber(String registrationNumber);
}
