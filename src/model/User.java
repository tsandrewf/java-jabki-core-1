package model;

public class User {
    static private int idMax = 0;
    private final int id;
    private String name;
    private String email;

    public int getId() {
        return this.id;
    }

    public User(String name, String email) {
        this.id = ++idMax;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}
