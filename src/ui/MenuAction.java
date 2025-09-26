package ui;

public abstract class MenuAction {
    private final String caption;

    protected MenuAction(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return this.caption;
    }

    public abstract void run();
}
