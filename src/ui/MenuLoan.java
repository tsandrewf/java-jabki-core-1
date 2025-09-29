package ui;

import exception.OperationCancelException;
import service.BookValidationService;
import service.UserValidationService;

public abstract class MenuLoan extends MenuAction {
    int userId;
    int bookId;

    protected MenuLoan(String caption) {
        super(caption);
    }

    public void run() {
        System.out.println("-------------------------------------");
        System.out.println("Выдача книги пользователю");

        try {
            this.userId = UserUI.readId();
        } catch (OperationCancelException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        try {
            this.bookId = BookUI.readId();
        } catch (OperationCancelException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
