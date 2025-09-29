package ui;

import exception.UserNotFoundException;
import model.Library;

public class MenuUserSearch extends MenuAction {
    protected MenuUserSearch() {
        super("Поиск пользователя по ID");
    }

    public void run() {
        int id;

        while (true) {
            System.out.print("Введите Id: ");
            String nextLine = ConsoleMenu.getScanner().nextLine().trim();
            try {
                id = Integer.parseInt(nextLine);
                if (id < 0) {
                    System.out.println("Id должен быть больше нуля");
                    continue;
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Введите число");
            }
        }

        try {
            (new UserUI(Library.getUser(id))).show();
        } catch (UserNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
