package ui;

import model.User;
import service.UserValidationService;
import service.ValidationService;
import service.LibraryService;

public class MenuUserAdd extends MenuAction {
    protected MenuUserAdd() {
        super("Добавление пользователя");
    }

    public void run() {
        String name;
        String email;

        System.out.println("-------------------------------------");
        System.out.println("Новый пользователь");

        do {
            System.out.print("Введите имя: ");
            name = ConsoleMenu.getScanner().nextLine();
            if (name.isBlank()) {
                System.out.println("Добавление нового пользователя отменено");
                return;
            }
        } while (!UserValidationService.isUserNameValid(name));

        do {
            System.out.print("Введите email: ");
            email = ConsoleMenu.getScanner().nextLine().trim();

            if (ValidationService.isEmailValid(email)) {
                break;
            } else {
                System.out.println("Email имеет недопустимый формат");
            }
        } while (true);

        LibraryService.addUser(new User(name, email));

        System.out.println("Новый пользователь добавлен");
    }
}
