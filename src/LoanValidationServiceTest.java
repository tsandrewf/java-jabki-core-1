import exception.*;
import model.Loan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import service.LibraryService;
import service.LoanValidationService;

class LoanValidationServiceTest {
    @BeforeEach
    public void setUp() {
        LibraryService.initBooks();
        LibraryService.initUsers();
        LibraryService.initLoans();
    }

    @Test
    void checkLoanNew() throws InvalidUserCurrentLoansException, UserNotFoundException, InvalidUserLoanBookException, BookAvailableCopiesException, InvalidBookIdException {
        LoanValidationService.checkLoanNew(new Loan(2, 1));
        Assertions.assertThrowsExactly(InvalidUserLoanBookException.class, () -> LoanValidationService.checkLoanNew(new Loan(1, 1)));
        Assertions.assertThrowsExactly(InvalidBookIdException.class, () -> LoanValidationService.checkLoanNew(new Loan(6, 1)));
        Assertions.assertThrowsExactly(UserNotFoundException.class, () -> LoanValidationService.checkLoanNew(new Loan(2, 7)));
        Assertions.assertThrowsExactly(BookAvailableCopiesException.class, () -> LoanValidationService.checkLoanNew(new Loan(1, 2)));
    }

    @Test
    void checkLoanReturnTest() throws InvalidUserCurrentLoansException, UserNotFoundException, InvalidUserLoanBookException, BookAvailableCopiesException, InvalidBookIdException {
        LoanValidationService.checkLoanReturn(new Loan(1, 1));
        Assertions.assertThrowsExactly(InvalidUserLoanBookException.class, () -> LoanValidationService.checkLoanReturn(new Loan(2, 1)));
        Assertions.assertThrowsExactly(UserNotFoundException.class, () -> LoanValidationService.checkLoanReturn(new Loan(2, 7)));
    }
}