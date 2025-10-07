package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    static private int idMax = 0;
    private final int id;
    private String name;
    private String email;
    private List<Loan> currentLoans;

    public User(String name, String email) {
        this.id = ++idMax;
        this.name = name;
        this.email = email;
        this.currentLoans = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public List<Loan> getCurrentLoans() {
        return this.currentLoans;
    }
}
