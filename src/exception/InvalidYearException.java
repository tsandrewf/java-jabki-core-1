package exception;

public class InvalidYearException extends Exception {
    public InvalidYearException(String reason) {
        super(reason);
    }
}
