package be.cyimena.airbnb.assetsservice.exceptions;

import java.util.UUID;

public class RealEstateNotFoundException extends RuntimeException {
    public RealEstateNotFoundException(UUID id) {
        super("No real estate with id : " + id);
    }
}
