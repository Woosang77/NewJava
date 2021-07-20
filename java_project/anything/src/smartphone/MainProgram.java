package smartphone;

import java.util.Scanner;

public class MainProgram {
    User user;
    String[] arr;

    public void listUp() {
        arr = user.getMenu();
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d. %s\n", i+1, arr[i]);
        }
        System.out.print("> 사용할 기능의 번호를 눌러주세요 : ");
    }

    public void identify() {
        Scanner scan = new Scanner(System.in);
        String[] idPw;
        int num = 0;
        boolean flag = true;
        while (flag){
            System.out.print("어떤 신분으로 로그인하시겠습니까?\n" +
                    "1. 회원\n" +
                    "2. 비회원\n" +
                    "3. 관리자\n" +
                    "> ");
            num = scan.nextInt();
            flag = (num<1||num>3) ? true : false;
        }
        switch (num){
            case 1:
                user = new Member();
                idPw = setIDPW();
                user.setId(idPw[0]);
                user.setPw(idPw[1]);
                break;
            case 2:
                user = new Non_Member();
                break;
            case 3:
                user = new Manager();
                idPw = setIDPW();
                user.setId(idPw[0]);
                user.setPw(idPw[1]);
                break;
        }
    }

    private String[] setIDPW() {
        Scanner scan = new Scanner(System.in);
        String[] idPw = new String[2];

        System.out.print("> ID : ");
        idPw[0] = scan.nextLine();
        System.out.print("> PW : ");
        idPw[1] = scan.nextLine();
        return idPw;
    }

//
    public void phone() {
        System.out.println("따르릉 전화중");
    }
//
    public void myPage() {
        System.out.println("Welcome");
    }

}
