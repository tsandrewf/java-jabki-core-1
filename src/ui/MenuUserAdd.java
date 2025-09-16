package ui;

import model.User;
import model.Library;
import service.Service;

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
            name = ConsoleMenu.getScanner().nextLine().trim();
        } while (name.isBlank());

        do {
            System.out.print("Введите email: ");
            email = ConsoleMenu.getScanner().nextLine().trim();

            if (email.isEmpty()) {
                break;
            } else if (!Service.isEmailValid(email)) {
                System.out.println("Email имеет недопустимый формат");
            } else {
                break;
            }
        } while (true);

        Library.addUser(new User(name, email));

        System.out.println("Новый пользователь добавлен");
    }
}
