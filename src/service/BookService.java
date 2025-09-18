package service;

import exception.InvalidTotalCopiesException;
import exception.InvalidYearException;

import java.time.LocalDate;

public class BookService {
    static public int getYear(String stringYear) throws InvalidYearException{
        int year;

        try {
            year = Integer.parseInt(stringYear);
            int yearMax = LocalDate.now().getYear();
            if (year > yearMax) {
                throw new InvalidYearException("Год должен быть не больше текущего");
            }
            return year;
        } catch (NumberFormatException ex) {
            throw new InvalidYearException("Введенное значение не является числом");
        }
    }

    static public int getTotalCopies(String stringTotalCopies) throws InvalidTotalCopiesException {
        int totalCopies;

        try {
            totalCopies = Integer.parseInt(stringTotalCopies);
            if (totalCopies <= 0) {
                throw new InvalidTotalCopiesException("Количество копий должно быть больше нуля");
            }
            return totalCopies;
        } catch (NumberFormatException ex) {
            throw new InvalidTotalCopiesException("Введенное значение не является числом");
        }
    }
}
