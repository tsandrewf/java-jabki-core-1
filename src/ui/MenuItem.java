package ui;

public class MenuItem extends MenuAction {
    private final MenuAction[] menu;

    public MenuItem(String caption, MenuAction[] menu) {
        super(caption);
        this.menu = menu;
    }

    public void run() {
        ConsoleMenu.show(this.menu);
    }
}
