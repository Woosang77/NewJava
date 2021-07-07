public class day03_Inheritance {
    public static void main(String[] args) {
        Student student = new Student("오복", "123", 1);
        System.out.println("name : " + student.name);
        System.out.println("ssn : " + student.ssn);
        System.out.println("studentNo : " + student.studentNo);
    }
}

class Student extends People {
    public int studentNo;

    public Student(String name, String ssn, int studentNo) {
        super(name, ssn);
        this.studentNo = studentNo;
    }
}


class People {
    public String name;
    public String ssn;

    public People(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }
}

