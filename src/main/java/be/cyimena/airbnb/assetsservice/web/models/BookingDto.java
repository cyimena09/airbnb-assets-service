package be.cyimena.airbnb.assetsservice.web.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class BookingDto {

    private UUID id;
    private UserDto user;
    private RealEstateDto realEstate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    private String status;
    private  Integer rating;

}
