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

    public Exam get(int i) {
        return exams[i];
    }

    public int size() {
        return current;
    }
}
