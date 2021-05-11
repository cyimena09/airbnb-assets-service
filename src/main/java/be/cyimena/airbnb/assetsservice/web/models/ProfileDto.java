package be.cyimena.airbnb.assetsservice.web.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import java.util.UUID;

@Data
public class ProfileDto {

    private UUID id;
    private String name;

}
