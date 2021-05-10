package be.cyimena.airbnb.assetsservice.web.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
public class RealEstateDto implements Serializable {

    private UUID id;
    private String name;
    private String type;
    private String description;
    private Integer bedroom;
    private Boolean garden;
    private double price;
    private AddressDto address;
    private UserDto user;
    Set<CommentDto> comments;
    Set<BookingDto> bookings;

}
