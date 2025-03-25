package my.lab.exceptions;

public class NoSuchIdException extends RuntimeException {
    public NoSuchIdException(String message) {
        super(message);
    }
}
