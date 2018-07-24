package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	// kết nối Database
		private String jdbcURL = "jdbc:mysql://localhost:3306/Quan_Li_Sinh_Vien_JSF?useUnicode=true&characterEncoding=utf-8";
		private String jdbcUsername = "phamquy481";
		private String jdbcPassword = "a0163763123";
		private Connection conn;

		protected void connect() throws SQLException {
			if (conn == null || conn.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					throw new SQLException(e);
				}
				conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			}
		}

		protected void disconnect() throws SQLException {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		}
		
		
		public int check(String user, String pass) {
			int kt = 0;
			try {
				connect();
				String sql = "select count(*) from User where User_name = ? and Pass = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user);
				ps.setString(2, pass);
				ResultSet result= ps.executeQuery();
				while(result.next())
				{
					kt = result.getInt("COUNT(*)");
				}
				disconnect();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			return kt;
		}
		
}
