package smartphone.main;

import smartphone.Program.MainProgram;
import smartphone.Program.ManagerProgram;
import smartphone.Program.MemberProgram;
import smartphone.Program.NMemberProgram;

import java.util.Scanner;

public class MainConsole {
    MainProgram program;

    public void powerOn() {
        System.out.println("Hello :)");
        identify();
        program.start();
    }

    public void identify(){
        Scanner scan = new Scanner(System.in);
        int num = 0;
        boolean flag = true;
        while (flag){
            System.out.print("어떤 신분으로 로그인하시겠습니까\n" +
                             "1. 회원\n" +
                             "2. 비회원\n" +
                             "3. 관리자\n" +
                             "> ");
            num = scan.nextInt();
            flag = num < 1 || num > 3;
        }
        switch (num){
            case 1:
                program = new MemberProgram();
                break;
            case 2:
                program = new NMemberProgram();
                break;
            case 3:
                program = new ManagerProgram();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + num);
        }
    }

}
