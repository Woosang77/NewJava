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
        int lastPage = (count / 10);
        lastPage = (count % 10) > 0 ? lastPage + 1 : lastPage;

        System.out.println("────────────────────────────────────────────");
        System.out.printf("           <전자 도서관>      총 %d권\n", count);
        System.out.println("────────────────────────────────────────────");
        for (Book n : list) {
            System.out.printf("%d. %s | %s | %s | %s\n",
                    n.getId(),
                    n.getTitle(),
                    n.getWriter(),
                    n.getClazz(),
                    n.getRentable());
        }
        System.out.println("────────────────────────────────────────────");
        System.out.printf("                 %d / %d pages      \n", page, lastPage);
    }

    public int inputLibraryMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.print("1.도서 검색 / 2.이전 / 3.다음 / 4.도서 등록 / 5.도서 대출 / 6. 도서 반납 / 7.종료  >");
        String menu_ = scan.nextLine();
        int menu = Integer.parseInt(menu_);

        return menu;
    }

    public void movePrevList() {
        if (page == 1) {
            System.out.println("┌──────────────────────────────┐");
            System.out.println("│      이전 페이지가 없습니다      │");
            System.out.println("└──────────────────────────────┘");
            return;
        }
        page--;
    }

    public void moveNextList() throws SQLException, ClassNotFoundException {
        int count = LService.getCount(searchField, searchWord);
        int lastPage = (count / 10);
        lastPage = count % 10 > 0 ? lastPage + 1 : lastPage;
        if (page == lastPage) {
            System.out.println("┌──────────────────────────────┐");
            System.out.println("│       마지막 페이지입니다       │");
            System.out.println("└──────────────────────────────┘");
            return;
        }
        page++;
    }

    public void inputSearchWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println("검색 범주(Title / Writer / Class )중에 하나를 입력하세요");
        System.out.print(" > ");
        searchField = scan.nextLine();

        System.out.print("검색어 > ");
        searchWord = scan.nextLine();
    }

    public void registerBook() throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        String title;
        String writer;
        String clazz;

        System.out.print("제목 : ");
        title = scan.nextLine();
        System.out.print("작가 : ");
        writer = scan.nextLine();
        System.out.print("분류 : ");
        clazz = scan.nextLine();
        Book book = new Book(title, writer, clazz);
        LService.insert(book);

    }

    public void rentBook(User user) throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("대여할 책의 번호를 입력해주세요 : ");
        int rentID = scan.nextInt();
        Book rentBook = LService.getRentList(rentID);
        try{
            System.out.printf("%s | %s | %s\n",
                            rentBook.getTitle(),
                            rentBook.getWriter(),
                            rentBook.getClazz()
                    );
        } catch (NullPointerException e){
            System.out.println("────────────────────────────────────────────");
            System.out.println("대여할 수 없는 상태입니다.\n" +
                    "* 대출여부나 번호를 다시 확인해주세요.");
            return;
        }
        while(true){
            System.out.println("대여 하시겠습니까? [1(네) | 2(아니오)]");
            System.out.print("> ");
            int answer = scan.nextInt();
            if(answer == 1){
                System.out.println("대출이 완료되었습니다.");
                rentBook.setRentable("N");
                LService.update(rentBook, user.getId());
                break;
            }else if (answer ==2){
                break;
            }else{
                System.out.println("다시 입력해주세요");
            }
        }
    }

    public void returnBook(User user) throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        String rentId = user.getId();

        List<Book> list = LService.getList(1, "LENDER_ID", rentId);
        System.out.println("────────────────────────────────────────────");
        System.out.printf("%s님의 대여 도서\n", user.getName());
        for (Book n : list) {
            System.out.printf("%d. %s | %s | %s \n",
                    n.getId(),
                    n.getTitle(),
                    n.getWriter(),
                    n.getClazz());
        }
        System.out.println("────────────────────────────────────────────");
        System.out.println("반납할 도서의 번호를 입력해주세요.");
        System.out.print("> ");
        int returnBookNum = scan.nextInt();
        Book book = new Book(returnBookNum);
        book.setRentable("Y");
        LService.update(book, null);
    }
}
