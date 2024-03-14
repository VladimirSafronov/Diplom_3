package exceptions;

public class UnknownBrowserNameException extends RuntimeException {

  public UnknownBrowserNameException(String message) {
    super(message);
  }
}
