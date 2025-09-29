package ui;

import exception.OperationCancelException;
import model.Library;
import model.User;
import service.LibraryService;
import service.UserValidationService;

public class UserUI {
    User user;

    public UserUI(User user) {
        this.user = user;
    }

    public void show() {
        try {
            System.out.printf("Id: %s\n", user.getId());
            System.out.printf("Имя: %s\n", user.getName());
            System.out.printf("Email: %s\n", user.getEmail());
            System.out.printf("Книг на руках: %s\n", user.getCurrentLoans().size());
        } catch (NullPointerException ex) {
            System.out.println("Пользователь не найден");
        }
    }

    public static int readId() throws OperationCancelException {
        int userId;

        do {
            System.out.print("Введите Id пользователя: ");
            try {
                String stringUserId = ConsoleMenu.getScanner().nextLine().trim();
                if (stringUserId.isBlank()) {
                    throw new OperationCancelException();
                }
                userId = UserValidationService.getUserId(stringUserId);
                Library.getUser(userId);
                break;
            } catch (OperationCancelException ex) {
                throw new OperationCancelException();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (true);

        return userId;
    }
}
