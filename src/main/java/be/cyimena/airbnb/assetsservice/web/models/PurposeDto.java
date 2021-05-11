package be.cyimena.airbnb.assetsservice.web.models;

import be.cyimena.airbnb.assetsservice.domain.RealEstate;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class PurposeDto {

    private UUID id;
    private String name;
    private Set<RealEstate> realEstates;

}
