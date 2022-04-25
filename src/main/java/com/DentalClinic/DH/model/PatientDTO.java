package com.DentalClinic.DH.model;
import lombok.Getter;


import java.util.Date;
@Getter

public class PatientDTO {
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private Date entryDate;
    private AddressDTO address;



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

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", entryDate=" + entryDate +
                ", address=" + address +
                '}';
    }
}
