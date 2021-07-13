import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        int[] kors = new int[3];
        int total = 0;
        float avg;
        int menu;
        boolean keepLoop = true;
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            kors[i] = 0;
        }

        종료:
        while (keepLoop) {
            //----------메인 메뉴------------------------------
            System.out.println("----------메인 메뉴---------");
            System.out.println("\t1.성적입력");
            System.out.println("\t2.성적출력");
            System.out.println("\t3.종료");
            System.out.print("\t>");
            menu = scan.nextInt();

            switch (menu){
                case 1:
                    //------성적입력------------------------------------
                    System.out.println("----------성적 입력---------");
                    for (int i = 0; i < 3; i++) {
                        do {
                            System.out.printf("국어 %d :", i+1);
                            kors[i] = scan.nextInt();
                            if (kors[i] < 0 || 100 < kors[i]) {
                                System.out.println("성적 범위 초과");
                            }
                        } while (kors[i] < 0 || 100 < kors[i]);
                    }
                    break;
                case 2:
                    //-------성적 출력-----------------------------------------
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
}
