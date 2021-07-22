package JDBCPrj.ex1;

import java.sql.*;
import java.util.Date;

public class Program2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String title = "TEST2";
        String writer_id = "오복";
        String content = "hahah";
        String files = "";


        String url = "jdbc:oracle:thin:@localhost:1521/xe";
        String sql = "INSERT INTO notice (" +
                "    title," +
                "    writer_id," +
                "    content," +
                "    files" +
                ") VALUES (?,?,?,?)";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, "C##woosang", "486715");
//        Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,title);
        st.setString(2,writer_id);
        st.setString(3,content);
        st.setString(4,files);

        int result = st.executeUpdate();

        System.out.println(result);





        st.close();
        con.close();

    }
}
