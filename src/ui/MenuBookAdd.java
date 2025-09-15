package ui;

import java.time.LocalDate;

import model.Library;
import model.Book;

public class MenuBookAdd extends MenuAction {
    protected MenuBookAdd() {
        super("Добавление книги");
    }

    public void run() {
        String title;
        String author;
        int year;
        int totalCopies;

        System.out.println("-------------------------------------");
        System.out.println("Новая книга");

        do {
            System.out.print("Введите название: ");
            title = ConsoleMenu.getScanner().nextLine().trim();
        } while (title.isBlank());

        do {
            System.out.print("Введите автора: ");
            author = ConsoleMenu.getScanner().nextLine().trim();
        } while (author.isBlank());

        while (true) {
            System.out.print("Введите год: ");
            String nextLine = ConsoleMenu.getScanner().nextLine().trim();
            try {
                year = Integer.parseInt(nextLine);
                int yearMin = 2000;
                int yearMax = LocalDate.now().getYear();
                if (year < yearMin || year > yearMax) {
                    System.out.printf("Год должен быть не меньше %s и не больше %s\n", yearMin, yearMax);
                    continue;
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Введите число");
            }
        }

        while (true) {
            System.out.print("Введите количество копий: ");
            String nextLine = ConsoleMenu.getScanner().nextLine().trim();
            try {
                totalCopies = Integer.parseInt(nextLine);
                if (totalCopies < 1) {
                    System.out.println("Количество копий должно быть больше 1");
                    continue;
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Введите число");
            }
        }

        Library.addBook(new Book(title, author, year, totalCopies));

        System.out.println("Новая книга добавлена");
    }
}
