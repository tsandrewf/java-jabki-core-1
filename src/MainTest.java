import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import service.Service;

class MainTest {
    @Test
    void isEmailValidTest() {
        Assertions.assertTrue(Service.isEmailValid("abc@def.ghi"));
        Assertions.assertFalse(Service.isEmailValid("abc.def.ghi"));
        Assertions.assertFalse(Service.isEmailValid(""));
        Assertions.assertFalse(Service.isEmailValid(null));
    }
}