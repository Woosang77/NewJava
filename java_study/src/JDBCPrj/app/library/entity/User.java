package JDBCPrj.app.library.entity;

public class User {

    private String id;
    private String pw;
    private String name;
    private String birth;
    private String gender;
    private String phone;
    private String email;
    private boolean flag = false;

    public User() {
    }

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public User(String id, String pw, String name, String birth) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.birth = birth;
    }

    public User(String id, String pw, String name, String gender, String birth, String phone, String email) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
