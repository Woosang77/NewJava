package Newlec.Practice;

import java.util.Scanner;

public class NewlecExamConsole extends ExamConsole {

    @Override
    protected void onPrint(Exam exam) {
        //객체는 NewlecExam이지만, 가져온 자료형이 Exam이기 때문에 getCom()을 사용할 수 없다.
        //강제 형변환
        NewlecExam newlecExam = (NewlecExam)exam;
        int com = newlecExam.getCom();
        System.out.printf("컴퓨터: %d\n", com);
    }

    @Override
    protected void onInput(Exam exam) {
        NewlecExam newlecExam = (NewlecExam)exam;
        Scanner scan = new Scanner(System.in);
        int com;
        do {
            System.out.print("컴퓨터: ");
            com = scan.nextInt();
            if (com < 0 || 100 < com) {
                System.out.println("성적 범위 초과");
            }
        } while (com < 0 || 100 < com);
        newlecExam.setCom(com);
    }

    @Override
    protected Exam makeExam() {
        return new NewlecExam();
    }
}
