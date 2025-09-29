package ui;

import exception.OperationCancelException;
import exception.UserNotFoundException;
import model.Library;
import model.Loan;

public class MenuBookLoansHistory extends MenuAction {
    int bookId;

    protected MenuBookLoansHistory() {
        super("История выдачи книги пользователям");
    }

    public void run() {
        System.out.println("-------------------------------------");
        System.out.println(this.getCaption());

        try {
            this.bookId = BookUI.readId();
        } catch (OperationCancelException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        //(new BookUI(Library.getBook(this.bookId))).show();
        for (Loan loan : Library.getLoans().stream().filter(l -> l.getBookId() == this.bookId).toList()) {
            System.out.println("Книга:");
            (new BookUI(Library.getBook(loan.getBookId()))).show();
            System.out.printf("Выдана: %s\n", loan.getLoanDate());
            if (loan.getReturnDate() != null) {
                System.out.printf("Возвращена: %s\n", loan.getReturnDate());
            }
            System.out.println("-------------------------------------");
        }
    }
}
