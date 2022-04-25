package com.DentalClinic.DH.persistence.entities;

import lombok.Getter;

import javax.persistence.*;
@Getter
@Entity
public class Address {
    @Id
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    private Long id;
    @Column
    private String street;
    @Column
    private Integer number;
    @Column
    private String city;
    @Column
    private String province;


    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
