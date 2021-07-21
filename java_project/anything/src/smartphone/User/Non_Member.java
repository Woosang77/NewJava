package smartphone.User;

public class Non_Member extends User{

    String[] menu = {"My page", "Exit"};

    public Non_Member() {}

    @Override
    public String[] getMenu() {
        return menu;
    }
}
