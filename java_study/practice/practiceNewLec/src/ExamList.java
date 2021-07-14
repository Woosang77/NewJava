import java.util.Scanner;

public class ExamList {
    private Exam[] exams;
    private int current;

    public ExamList() {
        this(3);
    }

    public ExamList(int size){
        exams = new Exam[size];
        current = 0;
    }

    public void inputList() {
        Scanner scan = new Scanner(System.in);
        System.out.println("----------성적 입력---------");
        int kor, eng, math;
        do {
            System.out.printf("국어: ");
            kor = scan.nextInt();
            if (kor < 0 || 100 < kor) {
                System.out.println("성적 범위 초과");
            }
        } while (kor < 0 || 100 < kor);
        do {
            System.out.printf("영어: ");
            eng = scan.nextInt();
            if (eng < 0 || 100 < eng) {
                System.out.println("성적 범위 초과");
            }
        } while (eng < 0 || 100 < eng);
        do {
            System.out.printf("수학: ");
            math = scan.nextInt();
            if (math < 0 || 100 < math) {
                System.out.println("성적 범위 초과");
            }
        } while (math < 0 || 100 < math);

        Exam exam = new Exam(kor, eng, math);

        if (exams.length == current){
            Exam[] temp = new Exam[current + 5];
            for (int i = 0; i < current; i++) {
                temp[i] = exams[i];
                exams = temp;
            }
        }
        exams[current] = exam;
        current++;
    }

    public void printList(){ printList(current); }

    public void printList(int size){
        System.out.println("----------성적 출력---------");

        for (int i = 0; i < size; i++) {
            Exam exam = exams[i];
            int kor = exam.getKor();
            int eng = exam.getEng();
            int math = exam.getMath();

            int total = exam.total();
            float avg = exam.avg();

            System.out.printf("국어: %d\n",kor);
            System.out.printf("영어: %d\n", eng);
            System.out.printf("수학: %d\n", math);
            System.out.printf("총점 : %3d\n", total);
            System.out.printf("평균 : %6.2f\n", avg);
            System.out.println("--------------------------");
        }
    }

}
