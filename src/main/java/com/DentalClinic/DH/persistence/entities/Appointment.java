package com.DentalClinic.DH.persistence.entities;


import lombok.Getter;


import javax.persistence.*;


@Getter
@Entity
public class Appointment {
    @Id
    @SequenceGenerator(name = "appointment_seq", sequenceName = "appointment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
    private Long id;
    @Column
    private String date;
    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne()
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;


    public void setDate(String date) {
        this.date = date;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
}


