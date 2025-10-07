package exception;

public class BookAvailableCopiesException extends Exception {
    public BookAvailableCopiesException() {
        super("Все экземпляры выбранной книги на руках");
    }
}
