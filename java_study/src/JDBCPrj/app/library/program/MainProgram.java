package JDBCPrj.app.library.program;

import JDBCPrj.app.library.console.LibraryConsole;
import JDBCPrj.app.library.console.UserConsole;

import java.sql.SQLException;

public class MainProgram {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        LibraryConsole console = new LibraryConsole();
        UserConsole UConsole = new UserConsole();

        boolean flag = UConsole.showOption();
        EXIT:
        while (!flag){
            //전체 도서 보여주기
            console.printLibraryList();
            int menu = console.inputLibraryMenu();
            switch (menu){
                case 1: //도서 검색
                    console.inputSearchWord();
                    break;
                case 2: //이전
                    console.movePrevList();
                    break;
                case 3: //다음
                    console.moveNextList();
                    break;
                case 4: //도서 등록
                    console.registerBook();
                    break;
                case 5: //도서 대출
                    console.rentBook();
                    break;
                case 6: //도서 반납
                    break;
                case 7: //나가기
                    System.out.println("Bye~~~");
                    break EXIT;
                default:
                    System.out.println("<<< 사용법 : 1~7를 입력해주세요. >>>");
                    break;
            }
        }
    }
}
