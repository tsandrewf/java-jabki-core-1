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
        System.out.println("Новая книга");

        do {
            System.out.print("Введите имя: ");
            name = ConsoleMenu.getScanner().nextLine().trim();
        } while (name.isBlank());

        do {
            System.out.print("Введите email: ");
            email = ConsoleMenu.getScanner().nextLine().trim();
        } while (email.isBlank() || !Service.isEmailValid(email));

        Library.addUser(new User(name, email));

        System.out.println("Новый пользователь добавлен");
    }
}
