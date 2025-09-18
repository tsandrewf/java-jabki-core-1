package exception;

public class InvalidTotalCopiesException extends Exception {
    public InvalidTotalCopiesException(String reason) {
        super(reason);
    }
}
