package JDBCPrj.app.library.service;

import JDBCPrj.app.library.entity.User;

import java.sql.*;

public class UserService {

    private String url = "jdbc:oracle:thin:@localhost:1521/xe";
    private String uId = "C##woosang";
    private String uPwd = "486715";
    private String driver = "oracle.jdbc.driver.OracleDriver";

    public int checkID(User user) throws ClassNotFoundException, SQLException {
        String id = user.getId();
        String sql = "SELECT NAME from MEMBER WHERE id LIKE ?";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uId, uPwd);
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,id);
        int result = st.executeUpdate();

        st.close();
        con.close();

        return result;

    }

    public boolean checkPW(String id, String pw) throws ClassNotFoundException, SQLException {
        String sql = "SELECT PWD from MEMBER WHERE id LIKE ?";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uId, uPwd);
        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1,id);

        ResultSet rs = st.executeQuery();
        rs.next();
        String pwd = rs.getString("PWD");
        if (pw.equals(pwd)){
            return true;
        } else {
            return false;
        }
    }

    public void add(User reg_user) throws ClassNotFoundException, SQLException {
        String id = reg_user.getId();
        String pw = reg_user.getPw();
        String name = reg_user.getName();
        String birth = reg_user.getBirth();
        String gender = reg_user.getGender();
        String phone = reg_user.getPhone();
        String email = reg_user.getEmail();

        String sql = "INSERT INTO MEMBER (" +
                "    name," +
                "    birthday," +
                "    id," +
                "    pwd," +
                "    gender," +
                "    email," +
                "    phone" +
                ") VALUES (?,?,?,?,?,?,?)";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uId, uPwd);
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,name);
        st.setString(2,birth);
        st.setString(3,id);
        st.setString(4,pw);
        st.setString(5,gender);
        st.setString(6,phone);
        st.setString(7,email);

        int result = st.executeUpdate();
        System.out.println(result);
        st.close();
        con.close();

    }
}
