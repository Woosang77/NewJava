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
            console.printLibraryList();
            int menu = console.inputLibraryMenu();

            switch (menu){
                case 1: //상세조회

                    break;
                case 2: //이전
                    console.movePrevList();
                    break;
                case 3: //다음
                    console.moveNextList();
                    break;
                case 4: //글쓰기

                    break;
                case 5://검색
                    console.inputSearchWord();
                    break;
                case 6: //종료
                    System.out.println("Bye~~~");
                    break EXIT;
                default:
                    System.out.println("<<< 사용법 : 1~5를 입력해주세요. >>>");
                    break;
            }
        }
    }
}
