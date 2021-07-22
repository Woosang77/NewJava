package JDBCPrj.app.console;

import JDBCPrj.app.entity.Notice;
import JDBCPrj.app.service.NoticeService;

import java.sql.SQLException;
import java.util.List;

public class NoticeConsole {

    private NoticeService service;
    public NoticeConsole() {
        service = new NoticeService();
    }

    public void printNoticeList() throws SQLException, ClassNotFoundException {
        List<Notice> list = service.getList();

        System.out.println("─────────────────────────────────");
        System.out.printf("        <공지사항> 총 %d게시글\n", 12);
        System.out.println("─────────────────────────────────");
        for (Notice n : list) {
            System.out.printf("%d. %s / %s / %s\n",
                    n.getId(),
                    n.getTitle(),
                    n.getWriterId(),
                    n.getRegDate());
        }
        System.out.println("─────────────────────────────────");
        System.out.printf("            %d / %d pages      \n",1, 2);

    }

    public int inputNoticeMenu() {
        return 0;
    }
}
