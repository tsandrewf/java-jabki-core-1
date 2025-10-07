package model;

import exception.InvalidBookIdException;
import exception.InvalidUserCurrentLoansException;
import exception.InvalidUserLoanBookException;
import exception.UserNotFoundException;
import exception.BookAvailableCopiesException;

import java.time.LocalDate;

public class Loan {
    private int bookId;
    private int userId;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(int bookId, int userId, LocalDate loanDate, LocalDate returnDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Loan(int bookId, int userId, LocalDate loanDate) {
        this(bookId, userId, loanDate, null);
    }

    public Loan(int bookId, int userId) throws InvalidBookIdException, InvalidUserCurrentLoansException, InvalidUserLoanBookException, UserNotFoundException, BookAvailableCopiesException {
        this(bookId, userId, LocalDate.now());
    }

    public int getBookId() {
        return this.bookId;
    }

    public LocalDate getLoanDate() {
        return this.loanDate;
    }

    public LocalDate getReturnDate() {
        return this.returnDate;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
