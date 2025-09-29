package ui;

import model.User;
import model.Library;

import java.util.Map;

public class MenuUsersView extends MenuAction {
    protected MenuUsersView() {
        super("Просмотр всех пользователей");
    }

    public void run() {
        int i = 1;
        for (Map.Entry<Integer, User> entryUser : Library.getUsers().entrySet()) {
            System.out.printf("№: %s\n", i++);
            (new UserUI(entryUser.getValue())).show();
            System.out.println("-------------------------------------");
        }
    }
}
