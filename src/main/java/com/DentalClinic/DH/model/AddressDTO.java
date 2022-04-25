package com.DentalClinic.DH.model;

import lombok.Getter;

@Getter

public class AddressDTO {
    private Long id;
    private String street;
    private Integer number;
    private String city;
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

    @Override
    public String toString() {
        return "AddressDTO{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
