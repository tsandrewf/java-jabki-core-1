import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exception.InvalidTotalCopiesException;
import exception.InvalidYearException;
import service.BookService;

class BookServiceTest {
    @Test
    void getYearTest() throws InvalidYearException {
        assertEquals(1234, BookService.getYear("1234"));
        assertEquals(-1, BookService.getYear("-1"));

        assertThrows(InvalidYearException.class, () -> BookService.getYear("qwerty"));
    }

    @Test
    void getTotalCopiesTest() throws InvalidTotalCopiesException {
        assertEquals(5, BookService.getTotalCopies("5"));

        assertThrows(InvalidTotalCopiesException.class, () -> BookService.getTotalCopies("0"));
        assertThrows(InvalidTotalCopiesException.class, () -> BookService.getTotalCopies("qwerty"));
    }
}