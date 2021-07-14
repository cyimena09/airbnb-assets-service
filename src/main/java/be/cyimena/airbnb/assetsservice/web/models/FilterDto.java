package be.cyimena.airbnb.assetsservice.web.models;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class FilterDto {

    private String category;
    private String type;
    private Integer minBedroom;
    private Integer maxBedroom;
    private Double minPrice;
    private Double maxPrice;
    private String city;
    private String country;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;

}
