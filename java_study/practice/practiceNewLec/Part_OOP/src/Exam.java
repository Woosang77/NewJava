public abstract class Exam {

    //멤버
    private int kor;
    private int eng;
    private int math;

    public Exam() {this(0,0,0);}

    public Exam(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }


    public abstract int total();

    //protected : 자식클래스만 사용가능능
   protected int onTotal(){
        return kor+eng+math;
    }

    public abstract float avg();
}
