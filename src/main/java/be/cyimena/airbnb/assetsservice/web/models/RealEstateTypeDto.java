package be.cyimena.airbnb.assetsservice.web.models;

import be.cyimena.airbnb.assetsservice.domain.RealEstate;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class RealEstateTypeDto {

    private UUID id;
    private String name;
    private Set<RealEstate> realEstates;

}
