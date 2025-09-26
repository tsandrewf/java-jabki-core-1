package model;

import java.util.Map;
import java.util.HashMap;

public class Library {
    static private final Map<Integer, Book> books = new HashMap<>();
    static private final Map<Integer, User> users = new HashMap<>();

    static public Map<Integer, Book> getBooks() {
        return books;
    }

    static public Map<Integer, User> getUsers() {
        return users;
    }

    static public User getUser(int id) {
        return users.get(id);
    }
}
