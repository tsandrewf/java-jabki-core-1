package ui;

import model.User;

public class UserUI {
    User user;

    public UserUI(User user) {
        this.user = user;
    }

    public void show() {
        try {
            System.out.printf("Имя: %s\n", user.getName());
            System.out.printf("Email: %s\n", user.getEmail());
        } catch (NullPointerException ex) {
            System.out.println("Пользователь не найден");
        }
        System.out.println("-------------------------------------");
    }
}
