import model.Library;
import ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        Library.initBooks();
        Library.initUsers();

        (new ConsoleMenu()).start();
    }
}