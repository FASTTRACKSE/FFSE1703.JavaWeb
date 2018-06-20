package javaweb.modle.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import javaweb.modle.bean.Student;

public class StudentDAO {
	final static Connection conn = ConnectDB.getConnect("localhost", "Java-web", "tuan18081999", "tuan123");

	public static List<Student> selectStudent(int pageid, int total) {
		List<Student> arrStudent = new ArrayList<>();
		try {
			Statement statement = (Statement) conn.createStatement();
			String sql = "select * from Student  LIMIT " + pageid + "," + total + "";

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Student st = new Student();
				st.setCode(rs.getString("code"));
				st.setName(rs.getString("name"));
				st.setAge(rs.getString("age"));
				st.setClassSt(rs.getString("class"));
				st.setSex(rs.getString("sex"));
				st.setCountry(rs.getString("country"));
				st.setLp1(rs.getDouble("lp1"));
				st.setLp2(rs.getDouble("lp2"));
				arrStudent.add(st);
			}
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrStudent;
	}

	public static Student getStudent(String code) {
		Student st = null;
		try {
			Statement statement = (Statement) conn.createStatement();
			String sql = "select * from Student where code = '" + code + "'";
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				st = new Student();
				st.setCode(rs.getString("code"));
				st.setName(rs.getString("name"));
				st.setAge(rs.getString("age"));
				st.setClassSt(rs.getString("class"));
				st.setSex(rs.getString("sex"));
				st.setCountry(rs.getString("country"));
				st.setLp1(rs.getDouble("lp1"));
				st.setLp2(rs.getDouble("lp2"));
			}
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}

	public static boolean insertStudent(Student st) throws SQLException {
		String sql = "INSERT INTO Student(code, name, age, class, sex, country, lp1, lp2) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
		statement.setString(1, st.getCode());
		statement.setString(2, st.getName());
		statement.setString(3, st.getAge());
		statement.setString(4, st.getClassSt());
		statement.setString(5, st.getSex());
		statement.setString(6, st.getCountry());
		statement.setDouble(7, st.getLp1());
		statement.setDouble(8, st.getLp2());
		boolean rowInserted = statement.executeUpdate() > 0;
		return rowInserted;
	}

	public static boolean updateStudent(Student st) throws SQLException {
		String sql = "UPDATE `Student` SET `name`=?,`age`=?,`class`=?,`sex`=?,`country`=?,`lp1`=?,`lp2`=? WHERE code = ?";
		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
		statement.setString(1, st.getName());
		statement.setString(2, st.getAge());
		statement.setString(3, st.getClassSt());
		statement.setString(4, st.getSex());
		statement.setString(5, st.getCountry());
		statement.setDouble(6, st.getLp1());
		statement.setDouble(7, st.getLp2());
		statement.setString(8, st.getCode());
		boolean rowInserted = statement.executeUpdate() > 0;
		return rowInserted;
	}

	public static int totalStudent() throws SQLException {
		String sql = "select COUNT(*) from Student";
		Statement statement = (Statement) conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		int total = 0;
		while (rs.next()) {
			total = rs.getInt("COUNT(*)");
		}
		return total;
	}

	public static boolean deleteStudent(String maSV) throws SQLException {
		String sql = "DELETE FROM Student WHERE code = ?";
		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
		statement.setString(1, maSV);
		boolean rowInserted = statement.executeUpdate() > 0;
		return rowInserted;
	}
}
