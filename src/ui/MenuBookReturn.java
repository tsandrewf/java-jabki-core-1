package ui;

import model.Library;
import model.Loan;
import service.LibraryService;
import service.LoanValidationService;

public class MenuBookReturn extends MenuLoan {
    protected MenuBookReturn() {
        super("Возврат книги пользователем");
    }

    public void run() {
        super.run();

        if (bookId <= 0 || userId <= 0) {
            return;
        }

        try {
            Loan loan = new Loan(bookId, userId);
            LoanValidationService.checkLoanReturn(loan);
            LibraryService.loanReturn(loan);

            System.out.println("Пользователь:");
            (new UserUI(Library.getUser(userId))).show();
            System.out.println("Вернул книгу:");
            (new BookUI(Library.getBook(bookId))).show();
        } catch (Exception ex) {
            System.out.println("Возврат книги не зарегистрирован: " + ex.getMessage());
        }
    }
}
