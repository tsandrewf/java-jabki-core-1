package exception;

public class InvalidUserCurrentLoansException extends Exception {
    public InvalidUserCurrentLoansException(int maxBooksPerUser) {
        super("Максимальное количество книг в одни руки - " + maxBooksPerUser + ", эта " + (maxBooksPerUser + 1) + "-я");
    }
}
