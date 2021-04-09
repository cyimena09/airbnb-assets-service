package be.cyimena.airbnb.assetsservice.exceptions;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(Integer id) {
        super("No reservation with id : " + id);
    }
}
