package JDBCPrj.app.library.console;

import JDBCPrj.app.library.entity.User;
import JDBCPrj.app.library.program.MainProgram;
import JDBCPrj.app.library.service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class UserConsole {

    private UserService UService;

    public UserConsole() {
        UService = new UserService();
    }

    public boolean showOption() throws SQLException, ClassNotFoundException {
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        EXIT:
        while (flag) {
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 나가기");
            System.out.print("> ");
            int num = scan.nextInt();
            switch (num) {
                case 1: //로그인
                    logIn();
                    flag = false;
                    break;
                case 2: //회원가입
                    register();
                    break;
                case 3:
                    break EXIT;
                default: //잘못 입력
                    System.out.println("다시 입력해주세요.");
            }
        }
        return flag;
    }

    private void register() throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);

        String id;
        String pw;
        String name;
        String gender;
        String sex;
        String phone;
        String email;

        System.out.print("ID : ");
        id = scan.nextLine();
        System.out.print("PW : ");
        pw = scan.nextLine();
        System.out.print("이름 : ");
        name = scan.nextLine();
        System.out.print("성별(남/여) : ");
        sex = scan.nextLine();
        System.out.print("주민등록번호(- 제외) : ");
        gender = scan.nextLine();
        System.out.print("전화번호 : ");
        phone = scan.nextLine();
        System.out.print("Email : ");
        email = scan.nextLine();

        User reg_user = new User(id, pw, name, sex, gender, phone, email);
        int num = UService.checkID(reg_user);
        if (num != 0){
            System.out.println("중복되는 아이디가 존재합니다.");
        }else {
            UService.add(reg_user);
        }

    }


    public void logIn() throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        String id;
        String pw;
        User user;

        while(true){
            System.out.print("ID : ");
            id = scan.nextLine();
            System.out.print("PW : ");
            pw = scan.nextLine();
            user = new User(id, pw);
            int idFlag = UService.checkID(user);
            if (idFlag == 0){
                System.out.println("존재하지 않는 ID입니다.");
                continue;
            }
            boolean flag = UService.checkPW(id, pw);
            if (!flag){
                System.out.println("비밀번호 오류");
                continue;
            }
            break;
        }
    }
}
