package be.cyimena.airbnb.assetsservice.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(UUID id) {
        super("No user with id : " + id);
    }
}
