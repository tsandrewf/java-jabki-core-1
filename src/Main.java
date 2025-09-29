import service.LibraryService;
import ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        LibraryService.initBooks();
        LibraryService.initUsers();
        LibraryService.initLoans();

        (new ConsoleMenu()).start();
    }
}