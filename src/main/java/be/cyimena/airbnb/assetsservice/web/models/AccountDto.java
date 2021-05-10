package be.cyimena.airbnb.assetsservice.web.models;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
public class AccountDto implements Serializable {

    private UUID id;
    private String email;
    private String password;
    private UserDto user;

}
