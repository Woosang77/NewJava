import java.util.Scanner;

public abstract class ExamConsole {

//    ExamConsole, ExamList 관계 : Composition Has A 상속관계 (일체형)

//    private ExamList list;
//    public ExamConsole() {
//        list = new ExamList();
//                ExamConsole의 생성과 동시에 ExamList는 생성된다.(일체형)
//    }
//    위 코드와 밑 코드는 같다.
    private ExamList examList = new ExamList();

    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("----------성적 입력---------");
        int kor, eng, math;
        do {
            System.out.print("국어: ");
            kor = scan.nextInt();
            if (kor < 0 || 100 < kor) {
                System.out.println("성적 범위 초과");
            }
        } while (kor < 0 || 100 < kor);
        do {
            System.out.print("영어: ");
            eng = scan.nextInt();
            if (eng < 0 || 100 < eng) {
                System.out.println("성적 범위 초과");
            }
        } while (eng < 0 || 100 < eng);
        do {
            System.out.print("수학: ");
            math = scan.nextInt();
            if (math < 0 || 100 < math) {
                System.out.println("성적 범위 초과");
            }
        } while (math < 0 || 100 < math);

        Exam exam = makeExam();
        exam.setKor(kor);
        exam.setEng(eng);
        exam.setMath(math);
        //Exam exam = new Exam(kor, eng, math) Exam이 abstract라 생성 불가

        //이벤트 함수
        onInput(exam);

        examList.add(exam);
    }

    public void print(){ print(examList.size());}

    public void print(int size){
        System.out.println("----------성적 출력---------");

        for (int i = 0; i < size; i++) {
            Exam exam = examList.get(i);
             int kor = exam.getKor();
            int eng = exam.getEng();
            int math = exam.getMath();

            int total = exam.total();
            float avg = exam.avg();

            System.out.printf("국어: %d\n",kor);
            System.out.printf("영어: %d\n", eng);
            System.out.printf("수학: %d\n", math);

            //이벤트 함수
            onPrint(exam);

            System.out.printf("총점 : %3d\n", total);
            System.out.printf("평균 : %6.2f\n", avg);
            System.out.println("--------------------------");
        }
    }

    protected abstract void onPrint(Exam exam);

    protected abstract void onInput(Exam exam);

    protected abstract Exam makeExam();
}
