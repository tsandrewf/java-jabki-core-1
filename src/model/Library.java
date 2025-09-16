package model;

import java.util.Map;
import java.util.HashMap;

public class Library {
    static private final Map<Integer, Book> books = new HashMap<>();
    static private final Map<Integer, User> users = new HashMap<>();

    static public void addBook(Book book) {
        books.put(books.size() + 1, book);
    }

    static public void addUser(User user) {
        users.put(users.size() + 1, user);
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
            case "Поиск книг по названию" -> books.entrySet().stream()
                    .filter(e -> e.getValue().getTitle().toLowerCase().contains(searchCriteria.toLowerCase()))
                    .collect(HashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
            case "Поиск книг по автору" -> books.entrySet().stream()
                    .filter(e -> e.getValue().getAuthor().toLowerCase().contains(searchCriteria.toLowerCase()))
                    .collect(HashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
            case "Поиск книг по году" -> books.entrySet().stream()
                    .filter(e -> Integer.toString(e.getValue().getYear()).equals(searchCriteria))
                    .collect(HashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
            default -> books;
        };
    }

    static public Map<Integer, User> getUsers() {
        return users;
    }

    static public User getUser(int id) {
        return users.get(id);
    }
}
