package smartphone.App;

import java.util.Map;
import java.util.Scanner;

public class Phone {
    private PhoneBook book = new PhoneBook();

    public void searchMenu(){
        Scanner scan = new Scanner(System.in);
        int num;
        End:
        while (true){
            System.out.println("1. 아직없음\n" +
                               "2. 번호추가\n" +
                               "3. 번호조회\n" +
                               "4. 나가기\n" +
                               "> " );
            num = scan.nextInt();
            switch (num){
                case 1:
                    break;
                case 2:
                    book.addInfo();
                    break;
                case 3:
                    book.searchAll();
                    break;
                case 4:
                    System.out.println("메인으로");
                    break End;
            }
        }

    }




}
