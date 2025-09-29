package exception;

public class InvalidUserLoanBookException extends Exception {
    public InvalidUserLoanBookException(String caption) {
        super(caption);
    }
}
