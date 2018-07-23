package ffse20.quanlysinhvien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ffse20.quanlysinhvien.connect.*;
import ffse20.quanlysinhvien.modle.*;

public class SinhVienDao {
	public static List<SinhVienModle> getAllUsers() {
		Connection conn = Connect.getConnection();
		String sql = "SELECT * FROM users";
		List<SinhVienModle> SinhVien = new ArrayList<SinhVienModle>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SinhVienModle sv = new SinhVienModle();
				sv.setId(rs.getString("userid"));
				sv.setName(rs.getString("ten"));
				sv.setNgaysinh(rs.getString("ngay_sinh"));
				sv.setQuequan(rs.getString("que_quan"));
				sv.setGioitinh(rs.getString("gioi_tinh"));
				sv.setLop(rs.getString("lop"));
				SinhVienModle SV = new SinhVienModle(rs.getString("userid"), rs.getString("ten"), rs.getString("ngay_sinh"),
						rs.getString("que_quan"), rs.getString("gioi_tinh"), rs.getString("lop"));

				SinhVien.add(SV);

			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SinhVien;
	}

	public static boolean insertBook(SinhVienModle SV) throws SQLException {
		Connection conn = Connect.getConnection();
		String sql = "INSERT INTO users(userid, ten, ngay_sinh, que_quan, gioi_tinh, lop) VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, SV.getId());
		statement.setString(2, SV.getName());
		statement.setString(3, SV.getNgaysinh());
		statement.setString(4, SV.getQuequan());
		statement.setString(5, SV.getGioitinh());
		statement.setString(6, SV.getLop());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		return rowInserted;
	}

	public static boolean deleteBook(String maSinhVien) throws SQLException {
		Connection conn = Connect.getConnection();

		String sql = "DELETE FROM users WHERE userid=?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, maSinhVien);

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		return rowDeleted;
	}

	public static SinhVienModle getBook(String maSV) throws SQLException {
		Connection conn = Connect.getConnection();

		SinhVienModle SV = null;
		String sql = "SELECT * FROM users WHERE userid=?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, maSV);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {

			String maSinhVien = resultSet.getString("userid");
			String ten = resultSet.getString("ten");
			String gioiTinh = resultSet.getString("gioi_tinh");
			String tuoi = resultSet.getString("ngay_sinh");
			String lop = resultSet.getString("que_quan");
			String diaChi = resultSet.getString("lop");
			SV = new SinhVienModle(maSinhVien, ten, tuoi, diaChi, gioiTinh, lop);
		}

		statement.close();

		return SV;
	}

	public static boolean updateBook(SinhVienModle SV) throws SQLException {
		Connection conn = Connect.getConnection();

		String sql = "UPDATE users SET ten =?, ngay_sinh =?, que_quan =?, gioi_tinh =?, lop =? WHERE userid=?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, SV.getName());
		statement.setString(2, SV.getNgaysinh());
		statement.setString(3, SV.getQuequan());
		statement.setString(4, SV.getGioitinh());
		statement.setString(5, SV.getLop());
		statement.setString(6, SV.getId());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		return rowUpdated;
	}

	public static List<SinhVienModle> getRecords(int start, int total) {
		List<SinhVienModle> list = new ArrayList<SinhVienModle>();
		try {
			Connection conn = Connect.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from users limit " + start + "," + total);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SinhVienModle e = new SinhVienModle();
				e.setId(rs.getString(2));
				e.setName(rs.getString(3));
				e.setNgaysinh(rs.getString(4));
				e.setQuequan(rs.getString(5));
				e.setGioitinh(rs.getString(6));
				e.setLop(rs.getString(7));

				list.add(e);
			}
			ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static int soTrang() throws SQLException {
		int soTrang = 0;
		Connection conn = Connect.getConnection();
		String sql = "select count(userid) from users";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			soTrang = rs.getInt("count(userid)");
			break;
		}
		statement.close();
		return soTrang;
	}

}
