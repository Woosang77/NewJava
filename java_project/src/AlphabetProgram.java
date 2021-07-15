import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AlphabetProgram {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //B가 아니라 다른것을 써도 변화할 수 있게 만들기
//        B b = new B();

//        변수를 인터페이스로 두고, 객체 부분을 읽어오자.
        FileInputStream fis = new FileInputStream("java_project/src/setting");
        Scanner scan = new Scanner(fis);
        String className = scan.nextLine();
        scan.close();
        fis.close();

        Class clazz = Class.forName(className);
        A a = new A();
        X x = (X) clazz.newInstance();
        a.setX(x);
        a.print();
    }
}
