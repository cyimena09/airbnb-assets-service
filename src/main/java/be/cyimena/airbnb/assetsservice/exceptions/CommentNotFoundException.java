package be.cyimena.airbnb.assetsservice.exceptions;

import java.util.UUID;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(UUID id) {
        super("No comment for the real estate with id : " + id);
    }
}
