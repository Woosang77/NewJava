package smartphone;

import java.util.Scanner;

public class MainConsole {
    MainProgram program;

    public MainConsole() {
        program = new MainProgram();
    }

    public void powerOn() {

        Scanner scan = new Scanner(System.in);
        int index;
        int count;

        System.out.println("Hello :)");
        program.identify();

        Exit:
        while(true) {
            program.listUp();
            count = program.arr.length;
            index = scan.nextInt();

            if (index > count){
                System.out.println("> 1~3번의 기능을 선택해주세요");
                continue;
            }
            switch (index) {
                //전화
                case 1:
                    program.phone();
                    break;
                case 2:
                    program.myPage();
                    break;
                case 3:
                    System.out.println("Bye~");
                    break Exit;
            }
        }
    }
}
