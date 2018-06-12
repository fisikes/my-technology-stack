package liyudong.exception;

public class RequestLimitException extends Exception {
  private static final long serialVersionUID = 1364225358754654702L;

  public RequestLimitException() {
    super("form repeat");
  }

  public RequestLimitException(String message) {
    super(message);
  }

}