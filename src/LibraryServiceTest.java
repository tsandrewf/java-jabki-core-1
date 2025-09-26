import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Book;
import model.Library;
import model.User;
import service.LibraryService;

import java.util.Map;

class LibraryServiceTest {
    @Test
    void getBooksTest() {
        LibraryService.initBooks();

        Book book1 = new Book("Му-Му", "Тургенев", 2025,5);
        Book book2 = new Book("Война и мир", "Толстой", 2024,4);

        {
            Map<Integer, Book> books = LibraryService.getBooks("Поиск книг", null);
            assertEquals(books.size(), 2);

            Book book = books.get(1);
            assertEquals(book.getTitle(), book1.getTitle());
            assertEquals(book.getAuthor(), book1.getAuthor());
            assertEquals(book.getYear(), book1.getYear());
            assertEquals(book.getTotalCopies(), book1.getTotalCopies());
            assertEquals(book.getAvailableCopies(), book1.getAvailableCopies());

            book = books.get(2);
            assertEquals(book.getAuthor(), book2.getAuthor());
            assertEquals(book.getTitle(), book2.getTitle());
            assertEquals(book.getYear(), book2.getYear());
            assertEquals(book.getTotalCopies(), book2.getTotalCopies());
            assertEquals(book.getAvailableCopies(), book2.getAvailableCopies());
        }

        {
            Map<Integer, Book> books = LibraryService.getBooks("Поиск книг по названию", "му");
            assertEquals(books.size(), 1);

            Book book = books.get(1);
            assertEquals(book.getTitle(), book1.getTitle());
            assertEquals(book.getAuthor(), book1.getAuthor());
            assertEquals(book.getYear(), book1.getYear());
            assertEquals(book.getTotalCopies(), book1.getTotalCopies());
            assertEquals(book.getAvailableCopies(), book1.getAvailableCopies());
        }

        {
            Map<Integer, Book> books = LibraryService.getBooks("Поиск книг по автору", "Толстой");
            assertEquals(books.size(), 1);

            Book book = books.get(2);
            assertEquals(book.getAuthor(), book2.getAuthor());
            assertEquals(book.getTitle(), book2.getTitle());
            assertEquals(book.getYear(), book2.getYear());
            assertEquals(book.getTotalCopies(), book2.getTotalCopies());
            assertEquals(book.getAvailableCopies(), book2.getAvailableCopies());
        }

        {
            Map<Integer, Book> books = LibraryService.getBooks("Поиск книг по году", "2025");
            assertEquals(books.size(), 1);

            Book book = books.get(1);
            assertEquals(book.getTitle(), book1.getTitle());
            assertEquals(book.getAuthor(), book1.getAuthor());
            assertEquals(book.getYear(), book1.getYear());
            assertEquals(book.getTotalCopies(), book1.getTotalCopies());
            assertEquals(book.getAvailableCopies(), book1.getAvailableCopies());
        }
    }

    @Test
    void getUserTest() {
        LibraryService.initUsers();

        User user = Library.getUser(1);
        User user1 = new User("John", "john@unknown.com");

        assertEquals(user.getName(), user1.getName());
        assertEquals(user.getEmail(), user1.getEmail());
    }
}