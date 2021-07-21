package smartphone.App;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PhoneBook {

    Set<Info> book;

    public PhoneBook() {
        book = new HashSet<>();
    }

    public void addInfo(){
        Scanner scan = new Scanner(System.in);
        String name;
        String number;
        System.out.print("> 이름 : ");
        name = scan.nextLine();
        System.out.print("> 전화번호 : ");
        number = scan.nextLine();
        System.out.printf("등록이름 : %s\n" +
                          "등록번호 : %s\n" +
                          "> 추가하시겠습니까? (Y | N)", name, number);
        String answer = scan.nextLine();
        if (answer.equals("Y") || answer.equals("y")){
            Info info = new Info(name, number);
            book.add(info);
            System.out.println("등록완료 :)");
        }else {
            System.out.println("취소되었습니다.");
        }
    }

    public void pullInfo(){

    }
}
