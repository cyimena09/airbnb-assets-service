package be.cyimena.airbnb.assetsservice.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthenticationRequestDto implements Serializable {
    private String email;
    private String password;
}
