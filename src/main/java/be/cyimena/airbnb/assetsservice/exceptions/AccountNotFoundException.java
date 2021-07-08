package be.cyimena.airbnb.assetsservice.exceptions;

import java.util.UUID;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String email) {
        super("No account with email : " + email);
    }
}
