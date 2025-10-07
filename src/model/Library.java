package model;

import exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Library {
    static private final Map<Integer, Book> books = new HashMap<>();
    static private final Map<Integer, User> users = new HashMap<>();
    static private final List<Loan> loans = new ArrayList<>();

    static public Map<Integer, Book> getBooks() {
        return books;
    }

    static public Map<Integer, User> getUsers() {
        return users;
    }

    static public User getUser(int id) throws UserNotFoundException {
        User user = users.get(id);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    static public List<Loan> getLoans() {
        return loans;
    }

    static public Book getBook(int id) {
        return books.get(id);
    }

    static public boolean isUserLoanBook(int userId, int bookId) throws UserNotFoundException {
        return Library.getUser(userId).getCurrentLoans().stream()
                .map(Loan::getBookId)
                .toList()
                .contains(bookId);
    }
}
