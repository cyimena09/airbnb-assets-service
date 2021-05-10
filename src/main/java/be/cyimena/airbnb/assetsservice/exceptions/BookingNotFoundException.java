package be.cyimena.airbnb.assetsservice.exceptions;

import java.util.UUID;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(UUID id) {
        super("No reservation with id : " + id);
    }
}
