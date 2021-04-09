package be.cyimena.airbnb.assetsservice.exceptions;


public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(Integer id) {
        super("No comment for the real estate with id : " + id);
    }
}
