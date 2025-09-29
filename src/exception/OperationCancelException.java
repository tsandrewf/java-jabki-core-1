package exception;

public class OperationCancelException extends Exception {
    public OperationCancelException() {
        super("Операция отменена");
    }
}
