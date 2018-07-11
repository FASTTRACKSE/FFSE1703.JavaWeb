package model;

import java.sql.SQLException;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;

public class ConnectDB {
	private static String strServer = "localhost";
	private static String strDatabase = "Java";
	private static String strUser = "ttien96";
	private static String strPwd = "zxcv1234";
	public static Connection getConnect() {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
			System.out.println("Kết nối thành công");
		} catch (SQLException ex) {
			System.err.println("Kết nối Database thất bại!");
			// ex.printStackTrace();
		}
		return conn;
	}
}
