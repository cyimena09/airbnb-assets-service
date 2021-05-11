package be.cyimena.airbnb.assetsservice.web.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
public class RealEstateDto implements Serializable {

    private UUID id;
    private String name;
    private String description;
    private Integer bedroom;
    private Boolean hasGarden;
    private double price;
    private AddressDto address;
    private CategoryDto category;
    private PurposeDto purpose;
    private UserDto user;
    private Set<CommentDto> comments;
    private Set<BookingDto> bookings;

}
