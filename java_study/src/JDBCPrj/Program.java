package JDBCPrj;

import java.sql.*;
import java.util.Date;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521/xe";
        String sql = "SELECT * FROM NOTICE WHERE HIT > 10";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, "C##woosang", "486715");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){
            int id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String writerId = rs.getString("WRITER_ID");
            Date regDate = rs.getDate("REGDATE");
            String content = rs.getString("CONTENT");
            int hit = rs.getInt("HIT");

            System.out.printf("ID: %d,TITLE: %s, WRITERID: %s, REGDATE: %s, CONTENT: %s, HIT: %d\n",
                    id, title, writerId, regDate, content,hit);
        };


        rs.close();
        st.close();
        con.close();

    }
}
