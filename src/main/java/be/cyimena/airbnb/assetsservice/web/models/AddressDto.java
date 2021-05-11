package be.cyimena.airbnb.assetsservice.web.models;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressDto {

    private UUID id;
    private String street;
    private String streetNumber;
    private String PostalCode;
    private String city;
    private String country;
    private RealEstateDto user;
    private RealEstateDto realEstate;

}
