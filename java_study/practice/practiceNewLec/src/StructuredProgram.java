import java.util.Scanner;

public class StructuredProgram {

    public static void main(String[] args) {

        int[] korList = new int[3];
        int[] engList = new int[3];
        int[] mathList = new int[3];

        Exam exam = new Exam();
        exam.kor = 30;
        exam.eng = 30;
        exam.math = 30;

        int menu;
        boolean keepLoop = true;
        for (int i = 0; i < 3; i++) {
            korList[i] = 0;
        }
        종료:
        while (keepLoop) {
            menu = inputMenu();
            switch (menu){
                case 1:
                    inputList(korList);
                    break;
                case 2:
                    printList(korList);
                    break;
                case 3:
                    System.out.println("시스템 종료");
                    keepLoop = false;
                    break 종료;
                default:
                    System.out.println("입력 오류 1~3까지 입력 가능");
            }
        }
    }
    //메뉴입력
    static int inputMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("----------메인 메뉴---------");
        System.out.println("\t1.성적입력");
        System.out.println("\t2.성적출력");
        System.out.println("\t3.종료");
        System.out.print("\t>");
        int menu = scan.nextInt();

        return menu;
    }

    //성적입력
    private static void inputList(int[] kors){
        int kor;
        Scanner scan = new Scanner(System.in);

        System.out.println("----------성적 입력---------");
        for (int i = 0; i < 3; i++) {
            do {
                System.out.printf("국어 %d :", i+1);
                kor = scan.nextInt();
                if (kor < 0 || 100 < kor) {
                    System.out.println("성적 범위 초과");
                }
            } while (kor < 0 || 100 < kor);
            kors[i] = kor;
        }
    }

    //성적출력
    private static void printList(int[] kors){
        int total = 0;
        float avg;

        for (int i = 0; i <3; i++) {
            total += kors[i];
        }
        avg = total / 3.0f;

        System.out.println("----------성적 출력---------");
        for (int i = 0; i < 3; i++) {
            System.out.printf("국어%d : %3d\n", i + 1, kors[i]);
        }
        System.out.printf("총점 : %3d\n", total);
        System.out.printf("평균 : %6.2f\n", avg);
        System.out.println("--------------------------");
    }
}
