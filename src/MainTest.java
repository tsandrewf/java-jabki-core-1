import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Library;
import model.Book;
import model.User;
import service.Service;

import java.util.Map;

class MainTest {
    @Test
    void isEmailValidTest() {
        Assertions.assertTrue(Service.isEmailValid("abc@def.ghi"));
        Assertions.assertFalse(Service.isEmailValid("abc.def.ghi"));
        Assertions.assertFalse(Service.isEmailValid(""));
        Assertions.assertFalse(Service.isEmailValid(null));
    }

    @Test
    void getBooksTest() {
        Library.initBooks();

        Book book1 = new Book("Му-Му", "Тургенев", 2025,5);
        Book book2 = new Book("Война и мир", "Толстой", 2024,4);

        {
            Map<Integer, Book> books = Library.getBooks("Поиск книг", null);
            Assertions.assertEquals(books.size(), 2);

            Book book = books.get(1);
            Assertions.assertEquals(book.getTitle(), book1.getTitle());
            Assertions.assertEquals(book.getAuthor(), book1.getAuthor());
            Assertions.assertEquals(book.getYear(), book1.getYear());
            Assertions.assertEquals(book.getTotalCopies(), book1.getTotalCopies());
            Assertions.assertEquals(book.getAvailableCopies(), book1.getAvailableCopies());

            book = books.get(2);
            Assertions.assertEquals(book.getAuthor(), book2.getAuthor());
            Assertions.assertEquals(book.getTitle(), book2.getTitle());
            Assertions.assertEquals(book.getYear(), book2.getYear());
            Assertions.assertEquals(book.getTotalCopies(), book2.getTotalCopies());
            Assertions.assertEquals(book.getAvailableCopies(), book2.getAvailableCopies());
        }

        {
            Map<Integer, Book> books = Library.getBooks("Поиск книг по названию", "му");
            Assertions.assertEquals(books.size(), 1);

            Book book = books.get(1);
            Assertions.assertEquals(book.getTitle(), book1.getTitle());
            Assertions.assertEquals(book.getAuthor(), book1.getAuthor());
            Assertions.assertEquals(book.getYear(), book1.getYear());
            Assertions.assertEquals(book.getTotalCopies(), book1.getTotalCopies());
            Assertions.assertEquals(book.getAvailableCopies(), book1.getAvailableCopies());
        }

        {
            Map<Integer, Book> books = Library.getBooks("Поиск книг по автору", "Толстой");
            Assertions.assertEquals(books.size(), 1);

            Book book = books.get(2);
            Assertions.assertEquals(book.getAuthor(), book2.getAuthor());
            Assertions.assertEquals(book.getTitle(), book2.getTitle());
            Assertions.assertEquals(book.getYear(), book2.getYear());
            Assertions.assertEquals(book.getTotalCopies(), book2.getTotalCopies());
            Assertions.assertEquals(book.getAvailableCopies(), book2.getAvailableCopies());
        }

        {
            Map<Integer, Book> books = Library.getBooks("Поиск книг по году", "2025");
            Assertions.assertEquals(books.size(), 1);

            Book book = books.get(1);
            Assertions.assertEquals(book.getTitle(), book1.getTitle());
            Assertions.assertEquals(book.getAuthor(), book1.getAuthor());
            Assertions.assertEquals(book.getYear(), book1.getYear());
            Assertions.assertEquals(book.getTotalCopies(), book1.getTotalCopies());
            Assertions.assertEquals(book.getAvailableCopies(), book1.getAvailableCopies());
        }
    }

    @Test
    void getUserTest() {
        Library.initUsers();

        User user = Library.getUser(1);
        User user1 = new User("John", "john@unknown.com");

        Assertions.assertEquals(user.getName(), user1.getName());
        Assertions.assertEquals(user.getEmail(), user1.getEmail());
    }
}