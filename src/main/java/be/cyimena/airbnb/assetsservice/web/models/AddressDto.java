package be.cyimena.airbnb.assetsservice.web.models;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressDto {

    private UUID id;
    private String street;
    private Integer streetNumber;
    private Long PostalCode;
    private String city;
    private String country;
    private RealEstateDto user;
    private RealEstateDto realEstate;

}
