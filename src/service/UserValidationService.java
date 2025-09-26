package service;

public class UserValidationService {

    public static boolean isUserNameValid(String name) {
        return !name.isBlank();
    }
}
