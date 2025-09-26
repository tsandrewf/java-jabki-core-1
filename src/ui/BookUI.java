package ui;

import model.Book;

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
        System.out.println("-------------------------------------");
    }
}
