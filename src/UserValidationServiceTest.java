import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import service.UserValidationService;

class UserValidationServiceTest {
    @Test
    void isUserNameValidTest() {
        assertTrue(UserValidationService.isUserNameValid("qwerty"));
        assertFalse(UserValidationService.isUserNameValid("  "));
    }
}