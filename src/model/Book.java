package model;

public class Book {
    static private int idMax = 0;
    private final int id;
    private final String title;
    private final String author;
    private int year;
    private int totalCopies;
    private int availableCopies;

    public Book(String title, String author, int year, int totalCopies) {
        this.id = ++idMax;
        this.title = title;
        this.author = author;
        this.year = year;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.year;
    }

    public int getTotalCopies() {
        return this.totalCopies;
    }

    public int getAvailableCopies() {
        return this.availableCopies;
    }

    public void loan() {
        this.availableCopies--;
    }

    public void returnLoan() {
        this.availableCopies++;
    }
}
