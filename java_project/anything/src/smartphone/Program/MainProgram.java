package smartphone.Program;

import smartphone.User.User;

import java.util.Scanner;

public abstract class MainProgram {
    User user;
    String[] arr;

    public abstract void start();

    public int listUp() {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        int num = 0;
        while (flag){
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%d. %s\n", i+1, arr[i]);
            }
            System.out.print("> 사용할 기능의 번호를 눌러주세요 : ");
            num = scan.nextInt();
            flag = num < 1 || num > arr.length;
        }
        return num;
    }

    public String[] setIdPw() {
        Scanner scan = new Scanner(System.in);
        String[] idPw = new String[2];

        System.out.print("> ID : ");
        idPw[0] = scan.nextLine();
        System.out.print("> PW : ");
        idPw[1] = scan.nextLine();
        return idPw;
    }

    public void phone() {
        System.out.println("따르릉 전화중");
    }

    public void myPage() {
        System.out.println("Welcome");
    }

}
