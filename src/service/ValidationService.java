package service;
import java.util.regex.Pattern;

public class ValidationService {
    // https://www.geeksforgeeks.org/java/check-email-address-valid-not-java/
    public static boolean isEmailValid(String email) {
        if (email.isBlank()) {
            return true;
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern p = Pattern.compile(emailRegex);

        return p.matcher(email).matches();
    }
}
