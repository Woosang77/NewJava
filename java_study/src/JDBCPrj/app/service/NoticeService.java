package JDBCPrj.app.service;

import JDBCPrj.app.entity.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeService {

    private String url = "jdbc:oracle:thin:@localhost:1521/xe";
    private String uid = "C##woosang";
    private String upwd = "486715";
    private String driver = "oracle.jdbc.driver.OracleDriver";

    //JDBC 정보 출력
    public List<Notice> getList() throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM NOTICE";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, upwd);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        List<Notice> list = new ArrayList<>();

        while(rs.next()){
            //Notice Info
            int id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String writerId = rs.getString("WRITER_ID");
            Date regDate = rs.getDate("REGDATE");
            String content = rs.getString("CONTENT");
            int hit = rs.getInt("HIT");
            String files = rs.getString("FILES");

            Notice notice = new Notice(
                    id,
                    title,
                    writerId,
                    regDate,
                    content,
                    hit,
                    files
            );

            list.add(notice);
        };

        rs.close();
        st.close();
        con.close();

        return list;
    }
    //JDBC 정보 입력
    public int insert(Notice notice) throws ClassNotFoundException, SQLException {
        String title = notice.getTitle();
        String writer_id = notice.getWriterId();
        String content = notice.getContent();
        String files = notice.getFiles();

        String sql = "INSERT INTO notice (" +
                "    title," +
                "    writer_id," +
                "    content," +
                "    files" +
                ") VALUES (?,?,?,?)";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, upwd);
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,title);
        st.setString(2,writer_id);
        st.setString(3,content);
        st.setString(4,files);

        int result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }
    //JDBC 정보 수정
    public int update(Notice notice) throws ClassNotFoundException, SQLException {

        String title = notice.getTitle();
        String content = notice.getContent();
        String files = notice.getFiles();
        int id = notice.getId();

        String sql = "update notice " +
                "set" +
                "    title = ?," +
                "    content = ?," +
                "    files = ?" +
                "WHERE id = ?";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,  uid, upwd);
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,title);
        st.setString(2,content);
        st.setString(3,files);
        st.setInt(4,id);

        int result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }
    //JDBC 정보 삭제
    public int delete(int id) throws ClassNotFoundException, SQLException {

        String sql = "delete notice WHERE id = ?";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, upwd);
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,id);

        int result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }
}
