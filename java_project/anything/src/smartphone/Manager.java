package smartphone;

public class Manager extends User{

    String[] menu = {"Phone", "Exit"};

    public Manager() {
        this(null, null);
    }

    public Manager(String id, String pw) {
        super(id, pw);
    }

    @Override
    public String[] getMenu() {
        return menu;
    }
}
