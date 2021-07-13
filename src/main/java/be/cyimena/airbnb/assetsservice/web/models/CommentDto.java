package be.cyimena.airbnb.assetsservice.web.models;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class CommentDto {

    private UUID id;
    private String text;
    private Timestamp createAt;
    private Timestamp updateAt;
    private RealEstateDto realEstate;
    private UserDto user;

}
