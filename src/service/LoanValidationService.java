package service;

import exception.*;
import model.Book;
import model.Library;
import model.Loan;

import java.util.List;

public class LoanValidationService {
    public static void checkLoanNew(Loan loan) throws InvalidBookIdException, InvalidUserCurrentLoansException, InvalidUserLoanBookException, UserNotFoundException, BookAvailableCopiesException {
        Book book = Library.getBook(loan.getBookId());
        if (book == null) {
            throw new InvalidBookIdException();
        }

        List<Loan> currentLoans = Library.getUser(loan.getUserId()).getCurrentLoans();
        int maxBooksPerUser = 3;
        if (currentLoans.size() >= maxBooksPerUser) {
            throw new InvalidUserCurrentLoansException(maxBooksPerUser);
        }

        if (Library.isUserLoanBook(loan.getUserId(), loan.getBookId())) {
            throw new InvalidUserLoanBookException("Пользователь уже взял эту книгу");
        }

        if (book.getAvailableCopies() <= 0) {
            throw new BookAvailableCopiesException();
        }
    }

    public static void checkLoanReturn(Loan loan) throws InvalidBookIdException, UserNotFoundException, InvalidUserLoanBookException {
        Book book = Library.getBook(loan.getBookId());
        if (book == null) {
            throw new InvalidBookIdException();
        }

        if (!Library.isUserLoanBook(loan.getUserId(), loan.getBookId())) {
            throw new InvalidUserLoanBookException("Пользователь не брал эту книгу");
        }
    }
}
