package com.DentalClinic.DH.persistence.repository;

import com.DentalClinic.DH.persistence.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository <Address, Long> {
}
