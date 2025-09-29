package exception;

public class InvalidBookIdException extends Exception {
    public InvalidBookIdException() {
        super("Недопустимый Id книги");
    }
}
