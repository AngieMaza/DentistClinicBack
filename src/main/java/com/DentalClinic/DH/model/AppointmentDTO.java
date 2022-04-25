package com.DentalClinic.DH.model;

import lombok.Getter;


import java.util.Date;
@Getter
public class AppointmentDTO {
    private Long id;
    private Date date;
    private DentistDTO dentist;
    private PatientDTO patient;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDentist(DentistDTO dentist) {
        this.dentist = dentist;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "id=" + id +
                ", date=" + date +
                ", dentist=" + dentist +
                ", patient=" + patient +
                '}';
    }
}
