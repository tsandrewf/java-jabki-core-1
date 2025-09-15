package model;

public class Book {
    private String title;
    private String author;
    private int year;
    private int totalCopies;
    private int availableCopies;

    public Book(String title, String author, int year, int totalCopies) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
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
}
