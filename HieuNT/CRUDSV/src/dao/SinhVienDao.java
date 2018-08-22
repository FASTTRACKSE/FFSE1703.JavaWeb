package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;

import bean.SinhVien;
import connnection.connect;

public class SinhVienDao {
	public static Connection conn = connect.getConnect();

	public static int rowCount() throws SQLException {
		int row = 0;
		String sql = "SELECT COUNT(*) FROM SinhVien";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			row = rs.getInt("COUNT(*)");
		}
		return row;
	}

	public static ArrayList<SinhVien> arrSV(int start, int end) throws SQLException {
		ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
		String sql = "SELECT * FROM sinhvien LIMIT ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			SinhVien e = new SinhVien();
			e.setMaSinhVien(rs.getString("Ma_Sinh_Vien"));
			e.setName(rs.getString("Name"));
			e.setSex(rs.getString("SEX"));
			e.setAge(rs.getString("Age"));
			e.setLop(rs.getString("Class"));
			e.setDress(rs.getString("Dress"));
			arrSV.add(e);
		}
		return arrSV;

	}

	public static boolean themSV(SinhVien newStudentObj) throws SQLException {

		String sql = "INSERT INTO SinhVien(Ma_Sinh_Vien,Name,SEX,Age,Class,Dress)" + " VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, newStudentObj.getMaSinhVien());
		statement.setString(2, newStudentObj.getName());
		statement.setString(3, newStudentObj.getSex());
		statement.setString(4, newStudentObj.getAge());
		statement.setString(5, newStudentObj.getLop());
		statement.setString(6, newStudentObj.getDress());
		boolean rowUpdate = statement.executeUpdate() > 0;
		return rowUpdate;

	}
	public static boolean  xoaSV(String maSinhVien) throws SQLException {
		String sql = "DELETE FROM SinhVien where Ma_Sinh_Vien  = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, maSinhVien);
		boolean row = statement.executeUpdate() > 0;
		return row;

	}
	public static SinhVien edit(String maSinhVien) throws SQLException {
		SinhVien editRecord=null;
		String sql = "select * from SinhVien where Ma_Sinh_Vien = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, maSinhVien);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			editRecord = new SinhVien();
			editRecord.setMaSinhVien(resultSet.getString("Ma_Sinh_Vien"));
			editRecord.setName(resultSet.getString("Name"));
			editRecord.setSex(resultSet.getString("SEX"));
			editRecord.setAge(resultSet.getString("Age"));
			editRecord.setLop(resultSet.getString("Class"));
			editRecord.setDress(resultSet.getString("Dress"));
		}
		return editRecord;
	}



	public static void updateSinhVien(SinhVien updateStudentObj) throws SQLException {
		String sql = "UPDATE SinhVien SET Ma_Sinh_Vien = ?, Name = ?, SEX = ?,Age=?,Class=?,Dress=? where Ma_Sinh_Vien=? ";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, updateStudentObj.getMaSinhVien());
		statement.setString(2, updateStudentObj.getName());
		statement.setString(3, updateStudentObj.getSex());
		statement.setString(4, updateStudentObj.getAge());
		statement.setString(5, updateStudentObj.getLop());
		statement.setString(6, updateStudentObj.getDress());
		statement.setString(7, updateStudentObj.getMaSinhVien());
		statement.executeUpdate();		
	}
	
}
