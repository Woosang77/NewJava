package smartphone.User;

//회원
public class Member extends User {

    private String[] menu = {"Phone", "My page", "Exit"};

    public Member() {
        this(null,null);
    }

    public Member(String id, String pw) {
        super(id, pw);
    }

    @Override
    public String[] getMenu() {
        return menu;
    }
}
