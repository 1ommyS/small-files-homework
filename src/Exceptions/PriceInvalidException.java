package Exceptions;

public class PriceInvalidException extends RuntimeException {
    public PriceInvalidException(String message) {
        super(message);
    }

  @Override
  public String toString() {
    return "PriceInvalidException{" +
            "message = " + getMessage() + "\n" +
            "}";
  }
}
