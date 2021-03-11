package be.cyimena.airbnbassetsservice.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super("No user with id : " + id);
    }
}
