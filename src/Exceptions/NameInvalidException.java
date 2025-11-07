package Exceptions;

public class NameInvalidException extends RuntimeException {
    public NameInvalidException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "NameInvalidException{" +
                "message = " + getMessage() + "\n" +
                "}";
    }
}
