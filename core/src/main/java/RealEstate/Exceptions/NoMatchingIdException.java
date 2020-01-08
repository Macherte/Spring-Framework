package RealEstate.Exceptions;

public class NoMatchingIdException extends Exception {
    public NoMatchingIdException() {
    }

    public NoMatchingIdException(String message) {
        super(message);
    }
}
