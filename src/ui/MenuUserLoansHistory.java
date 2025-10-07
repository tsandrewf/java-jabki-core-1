package ui;

import exception.OperationCancelException;
import exception.UserNotFoundException;
import model.Library;
import model.Loan;

public class MenuUserLoansHistory extends MenuAction {
    int userId;

    protected MenuUserLoansHistory() {
        super("История выдачи книг пользователю");
    }

    public void run() {
        System.out.println("-------------------------------------");
        System.out.println(this.getCaption());

        try {
            this.userId = UserUI.readId();
        } catch (OperationCancelException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        try {
            (new UserUI(Library.getUser(this.userId))).show();
            for (Loan loan : Library.getLoans().stream()
                    .filter(l -> l.getUserId() == this.userId)
                    .toList()) {
                System.out.println("Книга:");
                (new BookUI(Library.getBook(loan.getBookId()))).show();
                System.out.printf("Выдана: %s\n", loan.getLoanDate());
                if (loan.getReturnDate() != null) {
                    System.out.printf("Возвращена: %s\n", loan.getReturnDate());
                }
                System.out.println("-------------------------------------");
            }
        } catch (UserNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
