package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import bean.SinhVien;
import connection.ConnectionDB;

public class SinhVienDAO {
	final static Connection connection = ConnectionDB.getConnect("localhost", "ffse1703014", "admin", "123456");

	public ArrayList<SinhVien> listSinhVien(int start, int maxItems) throws SQLException {
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();
		String sql = "SELECT * FROM sinhvien LIMIT ?,?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, maxItems);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("ID");
			String hoDem = rs.getString("HoDem");
			String ten = rs.getString("Ten");
			String namSinh = rs.getString("NamSinh");
			String gioiTinh = rs.getString("GioiTinh");
			String email = rs.getString("Email");
			String sdt = rs.getString("SDT");
			String diaChi = rs.getString("DiaChi");
			String lop = rs.getString("Lop");
			SinhVien sv = new SinhVien(id, hoDem, ten, namSinh, gioiTinh, email, sdt, diaChi, lop);
			listSinhVien.add(sv);
		}
		rs.close();
		ps.close();
		return listSinhVien;
	}

	public SinhVien getSinhVien(SinhVien sv) throws SQLException {
		SinhVien extSV = null;
		String sql = "SELECT * FROM sinhvien WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, sv.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("ID");
			String hoDem = rs.getString("HoDem");
			String ten = rs.getString("Ten");
			String namSinh = rs.getString("NamSinh");
			String gioiTinh = rs.getString("GioiTinh");
			String email = rs.getString("Email");
			String sdt = rs.getString("SDT");
			String diaChi = rs.getString("DiaChi");
			String lop = rs.getString("Lop");
			extSV = new SinhVien(id, hoDem, ten, namSinh, gioiTinh, email, sdt, diaChi, lop);
		}
		rs.close();
		ps.close();
		return extSV;
	}

	public boolean insertSinhVien(SinhVien sv) throws SQLException {
		String sql = "INSERT INTO sinhvien VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, sv.getHoDem());
		ps.setString(2, sv.getTen());
		ps.setString(3, sv.getNamSinh());
		ps.setString(4, sv.getGioiTinh());
		ps.setString(5, sv.getEmail());
		ps.setString(6, sv.getSdt());
		ps.setString(7, sv.getDiaChi());
		ps.setString(8, sv.getLop());

		boolean rowUpdate = ps.executeUpdate() > 0;
		ps.close();
		return rowUpdate;
	}

	public boolean updateSinhVien(SinhVien sv) throws SQLException {
		String sql = "UPDATE sinhvien SET Hodem = ?, Ten = ?, NamSinh = ?, GioiTinh = ?, Email = ?, SDT = ?, DiaChi = ?, Lop = ? WHERE ID = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, sv.getHoDem());
		ps.setString(2, sv.getTen());
		ps.setString(3, sv.getNamSinh());
		ps.setString(4, sv.getGioiTinh());
		ps.setString(5, sv.getEmail());
		ps.setString(6, sv.getSdt());
		ps.setString(7, sv.getDiaChi());
		ps.setString(8, sv.getLop());
		ps.setInt(9, sv.getId());

		boolean rowUpdate = ps.executeUpdate() > 0;
		ps.close();
		return rowUpdate;
	}

	public boolean deleteSinhVien(int id) throws SQLException {
		String sql = "DELETE FROM sinhvien WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);

		boolean rowUpadate = ps.executeUpdate() > 0;
		return rowUpadate;
	}

	public int rowCount() throws SQLException {
		int row = 0;
		String sql = "SELECT COUNT(*) FROM sinhvien";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			row = rs.getInt("COUNT(*)");
		}
		rs.close();
		st.close();

		return row;
	}
}
