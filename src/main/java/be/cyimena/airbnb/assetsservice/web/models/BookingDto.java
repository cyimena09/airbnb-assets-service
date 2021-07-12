package be.cyimena.airbnb.assetsservice.web.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;


@Data
public class BookingDto {

    private UUID id;
    private UserDto user;
    private RealEstateDto realEstate;


    //@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime startDate;

    //@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime endDate;


    private String status;
    //private  Integer rating;

}
