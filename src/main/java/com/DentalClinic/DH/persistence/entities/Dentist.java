package com.DentalClinic.DH.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;


import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
public class Dentist {
    @Id
    @SequenceGenerator(name = "dentist_seq", sequenceName = "dentist_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentist_seq")
    private Long id;
    @Column
    private String registration_number;
    @Column
    private String name;
    @Column
    private String lastName;
    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<Appointment> appointments;



    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
