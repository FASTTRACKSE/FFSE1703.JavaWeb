package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
public class DAO {
	public static List<SinhVien> getAllUsers(){
	Connection conn = connect.getConnect();
	String sql = "SELECT * FROM sinhvien";
	List<SinhVien> SinhVien = new ArrayList<SinhVien>();

	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			SinhVien userBean = new SinhVien();
			userBean.setMaSV(rs.getString("Ma_Sinh_Vien"));
			userBean.setName(rs.getString("Name"));
			userBean.setName(rs.getString("SEX"));

			userBean.setAge(rs.getString("Age"));
			userBean.setDress(rs.getString("Dress"));
			userBean.setCls(rs.getString("Class"));
			SinhVien SV = new SinhVien(rs.getString("Ma_Sinh_Vien"), rs.getString("Name"), rs.getString("sex"),
					rs.getString("Age"), rs.getString("Class"), rs.getString("Dress"));

			SinhVien.add(SV);

		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return SinhVien;
}
	public static boolean insertBook(SinhVien SV) throws SQLException {
		Connection conn = connect.getConnect();
		String sql = "INSERT INTO sinhvien(Ma_Sinh_Vien,Name,SEX,Age,Class,Dress)" + " VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, SV.getMaSV());
		statement.setString(2, SV.getName());
		statement.setString(3, SV.getSex());
		statement.setString(4, SV.getAge());
		statement.setString(5, SV.getCls());
		statement.setString(6, SV.getDress());

		boolean rowInserted = statement.executeUpdate() > 0;
		return rowInserted;
	}
	public static boolean deleteBook(String maSinhVien) throws SQLException {
		Connection conn = connect.getConnect();

		String sql = "DELETE FROM sinhvien where Ma_Sinh_Vien  = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, maSinhVien);

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		return rowDeleted;
	}
	public static SinhVien getBook(String maSV) throws SQLException {
		Connection conn = connect.getConnect();

        SinhVien SV = null;
        String sql = "SELECT * FROM SinhVien WHERE Ma_Sinh_Vien = ?";
         
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, maSV);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
           
    		String maSinhVien = resultSet.getString("Ma_Sinh_Vien");
			String ten = resultSet.getString("Name");
			String gioiTinh = resultSet.getString("SEX");
			String tuoi = resultSet.getString("Age");
			String lop = resultSet.getString("Dress");
			String diaChi = resultSet.getString("Class");
			SV = new SinhVien(maSinhVien, ten, gioiTinh, tuoi, lop, diaChi);
        }
         
        resultSet.close();
        statement.close();
         
        return SV;
    }
	public static boolean updateBook(SinhVien SV) throws SQLException {
		Connection conn = connect.getConnect();

        String sql = "UPDATE SinhVien SET Ma_Sinh_Vien = ?, Name = ?, SEX = ?,Age=?,Class=?,Dress=? where Ma_Sinh_Vien=? ";         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, SV.getMaSV());
		statement.setString(2, SV.getName());
		statement.setString(3, SV.getSex());
		statement.setString(4, SV.getAge());
		statement.setString(5, SV.getCls());
		statement.setString(6, SV.getDress());
		statement.setString(7, SV.getMaSV());

         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        return rowUpdated;     
    }
}
