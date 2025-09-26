package ui;

import exception.InvalidYearException;
import exception.InvalidTotalCopiesException;
import model.Book;
import service.BookService;
import service.BookValidationService;
import service.LibraryService;

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
            if (title.isBlank()) {
                System.out.println("Добавление новой книги отменено");
                return;
            }
        } while (!BookValidationService.isTitleValid(title));

        do {
            System.out.print("Введите автора: ");
            author = ConsoleMenu.getScanner().nextLine().trim();
        } while (!BookValidationService.isAuthorValid(author));

        do {
            System.out.print("Введите год: ");
            try {
                year = BookService.getYear(ConsoleMenu.getScanner().nextLine().trim());
                break;
            } catch (InvalidYearException ex) {
                System.out.println(ex.getMessage());
            }
        } while (true);

        while (true) {
            System.out.print("Введите количество копий: ");
            try {
                totalCopies = BookService.getTotalCopies(ConsoleMenu.getScanner().nextLine().trim());
                break;
            } catch (InvalidTotalCopiesException ex) {
                System.out.println(ex.getMessage());
            }
        }

        LibraryService.addBook(new Book(title, author, year, totalCopies));

        System.out.println("Новая книга добавлена");
    }
}
