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

        String sql = "select * from book_view WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
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
            String clazz = rs.getString("CLASS");
            int id = rs.getInt("ID");
            String rentable = rs.getString("RENTABLE");

            Book book = new Book(
                    title,
                    writer,
                    clazz,
                    id,
                    rentable
            );

            list.add(book);
        };

        rs.close();
        st.close();
        con.close();

        return list;
    }

    public Book getRentList(int rentID) throws ClassNotFoundException, SQLException {

        String sql = "select * from book_view where id like ? and rentable = 'Y'";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, upwd);
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,rentID);
        ResultSet rs = st.executeQuery();

        if (rs.next()){
            String title = rs.getString("TITLE");
            String writer = rs.getString("WRITER");
            String clazz = rs.getString("CLASS");
            int id = rs.getInt("ID");
            String rentable = rs.getString("RENTABLE");

            Book book = new Book(
                    title,
                    writer,
                    clazz,
                    id,
                    rentable
            );
            return book;
        }

        rs.close();
        st.close();
        con.close();

        return null;
    }

    //Scarlar
    public int getCount(String field, String query) throws ClassNotFoundException, SQLException {

        int count = 0;
        String sql = "select COUNT(id) count FROM book_view where "+field+" like ? ";
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
                "    id," +
                "    title," +
                "    writer," +
                "    class" +
                ") VALUES (BOOK_SEQ.nextval,?,?,?)";

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
//    //책 정보 수정
//    public int update(Book book, String lender_id) throws ClassNotFoundException, SQLException {
//
//        String title = book.getTitle();
//        String writer = book.getWriter();
//        String clazz = book.getClazz();
//        String rentable = book.getRentable();
//        int id = book.getId();
//
//        String sql = "update book " +
//                "set" +
//                "    title = ?," +
//                "    writer = ?," +
//                "    class = ?," +
//                "    rentable = ?"+
//                "WHERE id = ?";
//
//        Class.forName(driver);
//        Connection con = DriverManager.getConnection(url,  uid, upwd);
//        PreparedStatement st = con.prepareStatement(sql);
//        st.setString(1,title);
//        st.setString(2,writer);
//        st.setString(3,clazz);
//        st.setString(4,rentable);
//        st.setInt(5,id);
//
//        int result = st.executeUpdate();
//
//        st.close();
//        con.close();
//
//        return result;
//    }
    //책 대출
    public int update(Book book, String lender_id) throws ClassNotFoundException, SQLException {

        String rentable = book.getRentable();
        int id = book.getId();

        String sql = "update book " +
                "set" +
                "    rentable = ?,"+
                "    lender_id = ?"+
                "WHERE id = ?";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,  uid, upwd);
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,rentable);
        st.setString(2, lender_id);
        st.setInt(3,id);

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
