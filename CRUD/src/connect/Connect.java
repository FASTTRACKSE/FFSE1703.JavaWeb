package connect;

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
	                String url = "jdbc:mysql://localhost:3306/sinhvien?useUnicode=true&characterEncoding=utf-8";
	                String user = "tuhv";
	                String password = "tuhv";
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
