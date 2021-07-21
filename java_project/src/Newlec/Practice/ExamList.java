package Newlec.Practice;

public class ExamList {
    //ExamList, Exam 관계 : Aggregation Has A 상속관계
    // ExamList의 생성과 동시에 Exam 객체가 생성되지 않고, 나중에 필요에 따라 추가될 것이다.
    private Exam[] exams;
    private int current;

    public ExamList() { this(3); }

    public ExamList(int size){
        exams = new Exam[size];
        current = 0;
    }

    public void add(Exam exam) {

        if (exams.length == current){
            Exam[] temp = new Exam[current + 5];
            for (int i = 0; i < current; i++) {
                temp[i] = exams[i];
            }
            exams = temp;
        }
        exams[current] = exam;
        current++;
    }

    public Exam get(int i) {return exams[i]; }

    public int size() { return current; }
}
