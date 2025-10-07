package ui;

import exception.UserNotFoundException;
import model.Library;
import model.Loan;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

public class MenuOverdueLoan extends MenuAction {
    protected MenuOverdueLoan() {
        super("Просроченные выдачи");
    }

    public void run() {
        System.out.println("-------------------------------------");
        System.out.println(this.getCaption());

        for (Loan loan : Library.getLoans().stream()
                .filter(l -> l.getReturnDate() == null && ChronoUnit.DAYS.between(l.getLoanDate(), LocalDate.now()) > 30)
                .toList()) {
            System.out.println("Книга:");
            (new BookUI(Library.getBook(loan.getBookId()))).show();
            System.out.printf("Выдана: %s\n", loan.getLoanDate());
            System.out.println("Пользователю:");
            try {
                (new UserUI(Library.getUser(loan.getUserId()))).show();
            } catch (UserNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("-------------------------------------");
        }
    }
}
