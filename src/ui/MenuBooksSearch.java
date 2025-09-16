package ui;

import java.time.LocalDate;
import java.util.Map;

import model.Book;
import model.Library;

public class MenuBooksSearch extends MenuAction {
    protected MenuBooksSearch(String searchCaption) {
        super(searchCaption.isBlank() ? "Просмотр всех книг" : searchCaption);
    }

    public void run() {
        String searchCriteria; // = "Война и мир";
        switch (this.getCaption()) {
            case "Поиск книг по названию" :
            case "Поиск книг по автору" :
                do {
                    System.out.print(this.getCaption() + ": ");
                    searchCriteria = ConsoleMenu.getScanner().nextLine().trim();
                } while (searchCriteria.isBlank());
                break;
            case "Поиск книг по году" :
                while (true) {
                    System.out.print(this.getCaption() + ": ");
                    String nextLine = ConsoleMenu.getScanner().nextLine().trim();
                    try {
                        int year = Integer.parseInt(nextLine);
                        int yearMin = 2000;
                        int yearMax = LocalDate.now().getYear();
                        if (year < yearMin || year > yearMax) {
                            System.out.printf("Год должен быть не меньше %s и не больше %s\n", yearMin, yearMax);
                            continue;
                        }
                        searchCriteria = Integer.toString(year);
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Введите число");
                    }
                }
                break;
            default:
                searchCriteria = this.getCaption();
                break;
        }

        int i = 0;
        for (Map.Entry<Integer, Book> entryBook : Library.getBooks(this.getCaption(), searchCriteria).entrySet()) {
            if (i == 0) {
                System.out.println("-------------------------------------");
            }
            System.out.printf("№: %s\n", ++i);
            System.out.printf("Id: %s\n", entryBook.getKey());
            (new BookUI(entryBook.getValue())).show();
        }

        if (i == 0) {
            System.out.println("Книги не найдены");
            System.out.println("-------------------------------------");
        }
    }

    private String getCaption(String searchCriteria) {
        return "Поиск книг " + searchCriteria;
    }
}
