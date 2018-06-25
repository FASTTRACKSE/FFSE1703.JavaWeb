package ffse20.quanlysinhvien.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static Connection con = null;

    public static Connection getConnection() {
        if (con != null)
            return con;
        else {
            try {
                
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/quanlysinhvien_javaweb?useUnicode=true&characterEncoding=utf-8";
                String user = "quanlysinhvien";
                String password = "12345";
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException cnfe) {
                System.out.println(cnfe);
            } catch (SQLException sqe) {
                System.out.println(sqe);
            } 
            return con;
        }

    }
}