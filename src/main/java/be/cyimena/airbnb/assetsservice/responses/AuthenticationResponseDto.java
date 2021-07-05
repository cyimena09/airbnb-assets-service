package be.cyimena.airbnb.assetsservice.responses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public class AuthenticationResponseDto implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String token;

}
