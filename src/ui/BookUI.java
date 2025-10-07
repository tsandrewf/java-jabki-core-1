package ui;

import exception.OperationCancelException;
import model.Book;
import model.Library;
import service.UserValidationService;

public class BookUI {
    private final Book book;

    public BookUI(Book book) {
        this.book = book;
    }

    public void show() {
        System.out.printf("Id: %s\n", book.getId());
        System.out.printf("Автор: %s\n", book.getAuthor());
        System.out.printf("Год: %s\n", book.getYear());
        System.out.printf("Всего копий: %s\n", book.getTotalCopies());
        System.out.printf("Доступно копий: %s\n", book.getAvailableCopies());
    }

    public static int readId() throws OperationCancelException {
        int bookId;

        do {
            System.out.print("Введите Id книги: ");
            try {
                String stringBookId = ConsoleMenu.getScanner().nextLine().trim();
                if (stringBookId.isBlank()) {
                    throw new OperationCancelException();
                }
                bookId = UserValidationService.getUserId(stringBookId);
                Library.getUser(bookId);
                break;
            } catch (OperationCancelException ex) {
                throw new OperationCancelException();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (true);

        return bookId;
    }
}
