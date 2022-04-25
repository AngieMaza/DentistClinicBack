package com.DentalClinic.DH.model;

import lombok.Getter;


@Getter

public class DentistDTO {
    private Long id;
    private String registration_number;
    private String name;
    private String lastName;


    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "DentistDTO{" +
                "id=" + id +
                ", registration_number='" + registration_number + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
