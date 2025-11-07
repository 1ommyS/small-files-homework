package Exceptions;

public class QuantityInvalidException extends RuntimeException {
    public QuantityInvalidException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "QuantityInvalidException{" +
                "message = " + getMessage() + "\n" +
                "}";
    }
}
