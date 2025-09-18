import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import service.BookValidationService;

class BookValidationServiceTest {
    @Test
    void isTitleValid() {
        assertTrue(BookValidationService.isTitleValid("Книга"));
        assertFalse(BookValidationService.isTitleValid(""));
    }

    @Test
    void isAuthorValidValid() {
        assertTrue(BookValidationService.isAuthorValid("Книга"));
        assertFalse(BookValidationService.isAuthorValid(""));
    }
}