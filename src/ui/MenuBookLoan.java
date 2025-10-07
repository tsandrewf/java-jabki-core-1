package ui;

import model.Library;
import model.Loan;
import service.LibraryService;
import service.LoanValidationService;

public class MenuBookLoan extends MenuLoan {
    protected MenuBookLoan() {
        super("Выдача книги пользователю");
    }

    public void run() {
        super.run();

        if (bookId <= 0 || userId <= 0) {
            return;
        }

        try {
            Loan loan = new Loan(bookId, userId);
            LoanValidationService.checkLoanNew(loan);
            LibraryService.addLoan(loan);

            System.out.println("Книга:");
            (new BookUI(Library.getBook(bookId))).show();
            System.out.println("Выдана пользователю:");
            (new UserUI(Library.getUser(userId))).show();
        } catch (Exception ex) {
            System.out.println("Выдача книги не зарегистрирована: " + ex.getMessage());
        }
    }
}
