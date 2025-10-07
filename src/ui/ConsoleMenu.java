package ui;

import java.util.Scanner;

public class ConsoleMenu {
    static private final Scanner scanner = new Scanner(System.in);
    static private int menuLevel = 0;

    static final MenuAction[] menu = {
            new MenuItem(
                    "Работа с книгами",
                    new MenuAction[]{
                            new MenuBookAdd(),
                            new MenuBooksSearch(""),
                            new MenuItem(
                                    "Поиск книг",
                                    new MenuAction[]{
                                            new MenuBooksSearch("Поиск книг по названию"),
                                            new MenuBooksSearch("Поиск книг по автору"),
                                            new MenuBooksSearch("Поиск книг по году")
                                    }
                            ),
                            new MenuBookLoan(),
                            new MenuBookReturn(),
                            new MenuBookLoansHistory(),
                            new MenuOverdueLoan(),
                    }),
            new MenuItem(
                    "Работа с пользователями",
                    new MenuAction[]{
                            new MenuUserAdd(),
                            new MenuUsersView(),
                            new MenuUserSearch(),
                            new MenuUserLoansHistory(),
                    })
    };

    static public void show(MenuAction[] menu) {
        if (menu == null ) {
            return;
        }

        while (true) {
            for (int i = 0; i < menu.length; i++) {
                System.out.printf("%s: " + menu[i].getCaption() + "\n", i + 1);
            }

            if (menuLevel == 0) {
                System.out.println("0: Выход");
            } else {
                System.out.println("0: Назад");
            }

            System.out.print("Введите число: ");

            String nextLine = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(nextLine);

                if (choice == 0) {
                    menuLevel--;
                    break;
                }

                if (choice > 0 && choice <= menu.length) {
                    MenuAction menuAction = menu[choice - 1];
                    System.out.printf("Выбрана опция: %s (" + menuAction.getCaption() + ")", choice);
                    if (menuAction instanceof MenuItem) {
                        System.out.println(", которая подразумевает вызов подменю");
                        menuLevel++;
                    } else {
                        System.out.println();
                    }
                    menuAction.run();
                }
            } catch (NumberFormatException ex) {
            }
        }
    }

    public void start() {
        show(menu);
    }

    static public Scanner getScanner() {
        return scanner;
    }
}
