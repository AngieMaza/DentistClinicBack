package com.DentalClinic.DH.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Entity
public class Patient {
    @Id
    @SequenceGenerator(name = "patient_seq", sequenceName = "patient_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    private Long id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String dni;
    @Column
    private Date entryDate;
    @OneToOne (fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Appointment> appointments;


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
