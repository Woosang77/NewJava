package smartphone.App;

public class Info {
    //개개인의 이름과 번호를 묶어서 PhoneBook에 넣기 위한 객체
    private String name;
    private String number;

    public Info(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
