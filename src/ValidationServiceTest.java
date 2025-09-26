import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import service.ValidationService;

class ValidationServiceTest {
    @Test
    void isEmailValidTest() {
        assertTrue(ValidationService.isEmailValid("abc@def.ghi"));
        assertFalse(ValidationService.isEmailValid("abc.def.ghi"));
        assertTrue(ValidationService.isEmailValid(""));
    }
}