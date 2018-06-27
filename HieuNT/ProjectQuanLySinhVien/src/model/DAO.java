package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class DAO {

//	public static SinhVien getBook(String maSV) throws SQLException {
//		Connection conn = connect.getConnect();
//
//		SinhVien SV = null;
//		String sql = "SELECT * FROM SinhVien WHERE Ma_Sinh_Vien = ?";
//
//		PreparedStatement statement = conn.prepareStatement(sql);
//		statement.setString(1, maSV);
//
//		ResultSet resultSet = statement.executeQuery();
//
//		if (resultSet.next()) {
//
//			String maSinhVien = resultSet.getString("Ma_Sinh_Vien");
//			String ten = resultSet.getString("Name");
//			String gioiTinh = resultSet.getString("SEX");
//			String tuoi = resultSet.getString("Age");
//			String lop = resultSet.getString("Dress");
//			String diaChi = resultSet.getString("Class");
//			byte[] photo = resultSet.getBytes("Image");
//			String imageFileName = resultSet.getString("IMAGE_FILE_NAME");
//
//			SV = new SinhVien(maSinhVien, ten, gioiTinh, tuoi, lop, diaChi, imageFileName, photo);
//		}
//
//		resultSet.close();
//		statement.close();
//
//		return SV;
//	}

	public static boolean insertBook(SinhVien SV) throws SQLException {
		Connection conn = connect.getConnect();
		String sql = "INSERT INTO SinhVien(Ma_Sinh_Vien,Name,SEX,Age,Class,Dress,Image)"
				+ " VALUES (?, ?, ?, ?, ?, ?,?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, SV.getMaSV());
		statement.setString(2, SV.getName());
		statement.setString(3, SV.getSex());
		statement.setString(4, SV.getAge());
		statement.setString(5, SV.getCls());
		statement.setString(6, SV.getDress());
		statement.setString(7, SV.getPhoto());

		boolean rowInserted = statement.executeUpdate() > 0;
		return rowInserted;
	}
//
//	public static boolean updateBook(SinhVien SV) throws SQLException {
//		Connection conn = connect.getConnect();
//
//		String sql = "UPDATE SinhVien SET Ma_Sinh_Vien = ?, Name = ?, SEX = ?,Age=?,Class=?,Dress=?,Image=? where Ma_Sinh_Vien=? ";
//		PreparedStatement statement = conn.prepareStatement(sql);
//		statement.setString(1, SV.getMaSV());
//		statement.setString(2, SV.getName());
//		statement.setString(3, SV.getSex());
//		statement.setString(4, SV.getAge());
//		statement.setString(5, SV.getCls());
//		statement.setString(6, SV.getDress());
//		statement.setString(7, SV.getPhoto());
//
//		boolean rowUpdated = statement.executeUpdate() > 0;
//		statement.close();
//		return rowUpdated;
//	}
//
//	public static boolean deleteBook(String maSinhVien) throws SQLException {
//		Connection conn = connect.getConnect();
//
//		String sql = "DELETE FROM SinhVien where Ma_Sinh_Vien  = ?";
//
//		PreparedStatement statement = conn.prepareStatement(sql);
//		statement.setString(1, maSinhVien);
//
//		boolean rowDeleted = statement.executeUpdate() > 0;
//		statement.close();
//		return rowDeleted;
//	}
//
//	public static List<SinhVien> getRecords(int start, int total) {
//		List<SinhVien> list = new ArrayList<SinhVien>();
//		try {
//			Connection conn = connect.getConnect();
//			PreparedStatement ps = conn.prepareStatement("select * from SinhVien limit " + start + "," + total);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				SinhVien e = new SinhVien();
//
//				e.setMaSV(rs.getString(1));
//				e.setName(rs.getString(2));
//				e.setSex(rs.getString(3));
//				e.setAge(rs.getString(4));
//				e.setCls(rs.getString(5));
//				e.setDress(rs.getString(6));
//				e.setPhoto(rs.getString(7));
//
//				list.add(e);
//			}
//			conn.close();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return list;
//	}
//
//	public int soTrang() throws SQLException {
//		int soTrang = 0;
//		Connection conn = connect.getConnect();
//		String sql = "select count(Ma_Sinh_Vien) from SinhVien";
//		PreparedStatement statement = conn.prepareStatement(sql);
//		ResultSet rs = statement.executeQuery();
//		while (rs.next()) {
//			soTrang = rs.getInt("count(Ma_Sinh_Vien)");
//		}
//		return soTrang;
//	}
}
