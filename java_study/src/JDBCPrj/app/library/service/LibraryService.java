package JDBCPrj.app.library.service;

import JDBCPrj.app.library.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibraryService {

    private String url = "jdbc:oracle:thin:@localhost:1521/xe";
    private String uid = "C##woosang";
    private String upwd = "486715";
    private String driver = "oracle.jdbc.driver.OracleDriver";

    //JDBC 정보 출력
    public List<Book> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {

        int start = 10*(page-1)+1;
        int end = 10*page;

        String sql = "select * from notice_view WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, upwd);
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,"%"+query+"%");
        st.setInt(2, start);
        st.setInt(3, end);
        ResultSet rs = st.executeQuery();

        List<Book> list = new ArrayList<>();

        while(rs.next()){
            //Notice Info
            String title = rs.getString("TITLE");
            String writer = rs.getString("WRITER");
            String clazz = rs.getString("FILES");
            int id = rs.getInt("ID");

            Book book = new Book(
                    title,
                    writer,
                    clazz,
                    id
            );

            list.add(book);
        };

        rs.close();
        st.close();
        con.close();

        return list;
    }

    //Scarlar
    public int getCount(String field, String query) throws ClassNotFoundException, SQLException {

        int count = 0;
        String sql = "select COUNT(id) count FROM notice where "+field+" like ? ";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, upwd);
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,"%"+query+"%");
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            count = rs.getInt("count");
        }
        rs.close();
        st.close();
        con.close();
        return count;
    }

    //JDBC 정보 입력
    public int insert(Book book) throws ClassNotFoundException, SQLException {
        String title = book.getTitle();
        String writer = book.getWriter();
        String clazz = book.getClazz();

        String sql = "INSERT INTO book (" +
                "    title," +
                "    writer," +
                "    class" +
                ") VALUES (?,?,?)";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, upwd);
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,title);
        st.setString(2,writer);
        st.setString(3,clazz);

        int result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }
    //JDBC 정보 수정
    public int update(Book book) throws ClassNotFoundException, SQLException {

        String title = book.getTitle();
        String writer = book.getWriter();
        String clazz = book.getClazz();
        int id = book.getId();

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
        st.setString(2,writer);
        st.setString(3,clazz);
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
