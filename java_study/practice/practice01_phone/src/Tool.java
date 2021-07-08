import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tool {
    Scanner scan = new Scanner(System.in);
    private String password = "486715";
    String[] manual = {"통화", "사진", "시간", "전화번호등록", "비밀번호변경", "비밀번호확인"};

    List nameBook = new ArrayList();
    List numberBook = new ArrayList();

//    전화하기
    public void calling() {
        System.out.println("누구에게 전화를 할까요?" + nameBook);
        String name = scan.nextLine();
        System.out.println(name + "님께 전화걸기");
    }

//    사진찍기
    public void takingPhoto(){
        for (int i = 0; i < 3; i++) {
            System.out.println(i+1);
        }
        System.out.println("사진이 촬영되었습니다.");
    }

//    날짜, 시간보기
    public void clock(){
        long time = System.currentTimeMillis();
        SimpleDateFormat simpl = new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
        String s = simpl.format(time);
        System.out.println(s);
    }

//    비밀번호 변경
    public void pwChange(){
        System.out.print("변경 비밀번호: " );
        this.password = scan.nextLine();
    }

//    비밀번호 확인
    public void checkPW(){
        System.out.println(password);
    }

//    잠금해체하기
    public boolean unlock(){
        do {
            System.out.print("비밀번호 입력: ");
            String pw = scan.nextLine();
            if (pw.equals(password)) {
                System.out.println("Unlock :)");
                return true;
            }else {
                System.out.println("Wrong PW :(");
            }
        }while (true);
    }

//    전화번호등록
    public void putNumber(){
        boolean check = true;
        System.out.print("번호를 입력해주세요 : ");
        String number = scan.nextLine();
        for (int i = 0; i < numberBook.size(); i++) {
            if (numberBook.contains(number)) {
                System.out.println("동일 번호가 저장됨 : " + nameBook.get(i));
                check = false;
                break;
            }
        }
        if (check==true){
            System.out.print("이름 : ");
            String name = scan.nextLine();
            nameBook.add(name);
            numberBook.add(number);
            System.out.println("Conplete ;)");

        }
    }

    public void start(){
        while (true){
            System.out.println("기능을 선택하세요 : " + Arrays.toString(manual));
            String choose = scan.nextLine();
            switch (choose) {
                case "통화":
                    calling();
                    break;
                case "사진":
                    takingPhoto();
                    break;
                case "시간":
                    clock();
                    break;
                case "전화번호등록":
                    putNumber();
                    break;
                case "비밀번호변경":
                    pwChange();
                    break;
                case "비밀번호확인":
                    checkPW();
                    break;
            }
        }
    }

}
