package be.cyimena.airbnb.assetsservice.web.models;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
public class UserDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String birthDate;
    private Timestamp createdDate;
    private Timestamp lastModifiedDate;
    private AddressDto address;
    private AccountDto account;
    private Set<RealEstateDto> realEstates;
    private Set<BookingDto> bookings;

}
