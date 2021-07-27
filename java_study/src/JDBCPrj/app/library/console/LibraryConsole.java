package JDBCPrj.app.library.console;

import JDBCPrj.app.library.entity.Book;
import JDBCPrj.app.library.entity.User;
import JDBCPrj.app.library.service.LibraryService;
import JDBCPrj.app.library.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LibraryConsole {

    private LibraryService LService;

    private int page;
    private String searchField;
    private String searchWord;


    public LibraryConsole() {
        LService = new LibraryService();
        page = 1;
        searchField = "TITLE";
        searchWord = "";
    }

    public void printLibraryList() throws SQLException, ClassNotFoundException {
        List<Book> list = LService.getList(page, searchField, searchWord);
        int count = LService.getCount(searchField, searchWord);
        int lastPage = (count/10);
        lastPage = (count%10)>0 ? lastPage+1 : lastPage ;

        System.out.println("────────────────────────────────────────────");
        System.out.printf("             <도서 목록> 총 %d권\n", count);
        System.out.println("────────────────────────────────────────────");
        for (Book n : list) {
            System.out.printf("%d. %s / %s / %s\n",
                    n.getId(),
                    n.getTitle(),
                    n.getWriterId(),
                    n.getRegDate());
        }
        System.out.println("────────────────────────────────────────────");
        System.out.printf("                 %d / %d pages      \n",page, lastPage);
    }

    public int inputLibraryMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.print("1.상세조회 / 2.이전 / 3.다음 / 4.글쓰기 / 5.검색 / 6.종료  >");
        String menu_ = scan.nextLine();
        int menu = Integer.parseInt(menu_);

        return menu;
    }

    public void movePrevList() {
        if (page==1){
            System.out.println("==============================");
            System.out.println("[     이전 페이지가 없습니다.    ]");
            System.out.println("==============================");
            return;
        }
        page--;
    }

    public void moveNextList() throws SQLException, ClassNotFoundException {
        int count = LService.getCount(searchField, searchWord);
        int lastPage = (count/10);
        lastPage = count%10>0? lastPage+1 : lastPage;
        if (page== lastPage){
            System.out.println("==============================");
            System.out.println("[      마지막 페이지입니다.     ]");
            System.out.println("==============================");
            return;
        }
        page++;
    }

    public void inputSearchWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println("검색 범주(title / content / writerId)중에 하나를 입력하세요");
        System.out.print(" > ");
        searchField = scan.nextLine();

        System.out.print("검색어 > ");
        searchWord = scan.nextLine();
    }


}
