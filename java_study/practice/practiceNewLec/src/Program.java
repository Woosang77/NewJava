import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        ExamConsole console = new ExamConsole();

        int menu;
        boolean keepLoop = true;

        while (keepLoop) {
            menu = inputMenu();
            switch (menu) {
                case 1:
                    console.inputList();
                    break;
                case 2:
                    console.printList();
                    break;
                case 3:
                    System.out.println("시스템 종료");
                    keepLoop = false;
                    break;
                default:
                    System.out.println("입력 오류 1~3까지 입력 가능");
            }
        }
    }

    private static int inputMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("----------메인 메뉴---------");
        System.out.println("\t1.성적입력");
        System.out.println("\t2.성적출력");
        System.out.println("\t3.종료");
        System.out.print("\t>");
        int menu = scan.nextInt();

        return menu;
    }


}
