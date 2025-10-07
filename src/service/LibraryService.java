package service;

import exception.UserNotFoundException;
import model.Book;
import model.Library;
import model.Loan;
import model.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    static public void addBook(Book book) {
        Library.getBooks().put(Library.getBooks().size() + 1, book);
    }

    static public void addUser(User user) {
        Library.getUsers().put(Library.getUsers().size() + 1, user);
    }

    static public void addLoan(Loan loan) throws UserNotFoundException {
        Library.getLoans().add(loan);
        Library.getUser(loan.getUserId()).getCurrentLoans().add(loan);
        Library.getBook(loan.getBookId()).loan();
    }

    static public void loanReturn(Loan loan) throws UserNotFoundException {
        Loan loanToReturn = null;
        for (Loan loanCurr : Library.getUser(loan.getUserId()).getCurrentLoans()) {
            if (loanCurr.getBookId() == loan.getBookId() && loanCurr.getUserId() == loan.getUserId()) {
                loanToReturn = loanCurr;
            }
        }

        assert loanToReturn != null;
        loanToReturn.setReturnDate(LocalDate.now());
        Library.getUser(loan.getUserId()).getCurrentLoans().remove(loanToReturn);
        Library.getBook(loan.getBookId()).returnLoan();
    }

    static public void initBooks() {
        addBook(new Book("Му-Му", "Тургенев", 2025,1));
        addBook(new Book("Война и мир", "Толстой", 2024,4));
        addBook(new Book("Горе от ума", "Грибоедов", 2020,1));
        addBook(new Book("Мертвые души", "Гоголь", 2021,2));
    }

    static public void initUsers() {
        addUser(new User("John", "john@unknown.com"));
        addUser(new User("Bill", "bill@unknown.com"));
    }

    static public void initLoans() {
        try {
            addLoan(new Loan(1, 1, LocalDate.parse("2025-01-12")));
            addLoan(new Loan(2, 2, LocalDate.parse("2025-04-01")));
        } catch (UserNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
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
