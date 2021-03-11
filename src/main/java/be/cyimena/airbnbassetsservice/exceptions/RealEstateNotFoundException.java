package be.cyimena.airbnbassetsservice.exceptions;

public class RealEstateNotFoundException extends RuntimeException {
    public RealEstateNotFoundException(Integer id) {
        super("No real estate with id : " + id);
    }
}
