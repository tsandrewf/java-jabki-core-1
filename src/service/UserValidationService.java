package service;

public class UserValidationService {

    public static boolean isUserNameValid(String name) {
        return !name.isBlank();
    }

    public static int getUserId(String stringId) throws Exception {
        int id;

        try {
            id = Integer.parseInt(stringId);
            return id;
        } catch (NumberFormatException ex) {
            throw new Exception("Введенное значение не является числом");
        }
    }
}
