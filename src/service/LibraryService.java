package service;

import model.Book;
import model.User;
import model.Library;

import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    static public void addBook(Book book) {
        Library.getBooks().put(Library.getBooks().size() + 1, book);
    }

    static public void addUser(User user) {
        Library.getUsers().put(Library.getUsers().size() + 1, user);
    }

    static public void initBooks() {
        addBook(new Book("Му-Му", "Тургенев", 2025,5));
        addBook(new Book("Война и мир", "Толстой", 2024,4));
    }

    static public void initUsers() {
        addUser(new User("John", "john@unknown.com"));
        addUser(new User("Bill", "bill@unknown.com"));
    }

    static public Map<Integer, Book> getBooks(String searchName, String searchCriteria) {
        return switch (searchName) {
            case "Поиск книг по названию" -> Library.getBooks().entrySet().stream()
                    .filter(e -> e.getValue().getTitle().toLowerCase().contains(searchCriteria.toLowerCase()))
                    .collect(HashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
            case "Поиск книг по автору" -> Library.getBooks().entrySet().stream()
                    .filter(e -> e.getValue().getAuthor().toLowerCase().contains(searchCriteria.toLowerCase()))
                    .collect(HashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
            case "Поиск книг по году" -> Library.getBooks().entrySet().stream()
                    .filter(e -> Integer.toString(e.getValue().getYear()).equals(searchCriteria))
                    .collect(HashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
            default -> Library.getBooks();
        };
    }
}
