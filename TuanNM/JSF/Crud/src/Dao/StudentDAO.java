package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.StudentBean;

public class StudentDAO {
	final static Connection conn = ConnectDB.getConnect("localhost", "java-web", "tuan180899", "tuan123456");

	public static ArrayList<StudentBean> getStudent() {
		ArrayList<StudentBean> arrSt = new ArrayList<StudentBean>();
		try {
			String sql = "select * from student";

			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				StudentBean st = new StudentBean();
				st.setId(rs.getInt("id"));
				st.setFirstName(rs.getString("first_name"));
				st.setLastName(rs.getString("last_name"));
				st.setBirthYear(rs.getString("birth_yaer"));
				st.setGender(rs.getString("gender"));
				st.setEmail(rs.getString("email"));
				st.setDiaChi(rs.getString("address"));
				st.setSdt(rs.getString("sdt"));
				st.setClassSv(rs.getString("class"));
				arrSt.add(st);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrSt;
	}
	public static String deleteStudent(int id) throws SQLException {
		String sql = "DELETE FROM Student WHERE code = ?";
		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
		statement.setInt(1, id);
		return "index.xhtml";
	}
}
