package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import bean.SinhVien;
import connection.ConnectionDB;

@ManagedBean(name = "sinhVienDAO")
@RequestScoped
public class SinhVienDAO {
	final static Connection connection = ConnectionDB.getConnect("localhost", "ffse1703014", "admin", "123456");

	public ArrayList<SinhVien> listSinhVien() throws SQLException {
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();
		String sql = "SELECT * FROM sinhvien";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			SinhVien sv = new SinhVien();
			sv.setId(rs.getInt("id"));
			sv.setHoDem(rs.getString("HoDem"));
			sv.setTen(rs.getString("Ten"));
			sv.setNamSinh(rs.getString("NamSinh"));
			sv.setGioiTinh(rs.getString("GioiTinh"));
			sv.setEmail(rs.getString("Email"));
			sv.setSdt(rs.getString("SDT"));
			sv.setDiaChi(rs.getString("DiaChi"));
			sv.setLop(rs.getString("Lop"));
			listSinhVien.add(sv);
		}
		return listSinhVien;
	}

	public String getSinhVien(int id) throws SQLException {
		Map<String, Object> sessionObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SinhVien sv = new SinhVien();
		String sql = "SELECT * FROM sinhvien WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			sv.setId(rs.getInt("id"));
			sv.setHoDem(rs.getString("HoDem"));
			sv.setTen(rs.getString("Ten"));
			sv.setNamSinh(rs.getString("NamSinh"));
			sv.setGioiTinh(rs.getString("GioiTinh"));
			sv.setEmail(rs.getString("Email"));
			sv.setSdt(rs.getString("SDT"));
			sv.setDiaChi(rs.getString("DiaChi"));
			sv.setLop(rs.getString("Lop"));
		}
		rs.close();
		ps.close();

		
		sessionObj.put("extSV", sv);
		return "FormUpdate?faces-redirect=true";
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
		String sql = "UPDATE sinhvien SET Hodem = ?, Ten = ?, NamSinh = ?, GioiTinh = ?, Email = ?, SDT = ?, DiaChi = ?, Lop = ?";
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
	public boolean deleteSinhVien(int id) throws SQLException {
		String sql = "DELETE FROM sinhvien WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		
		boolean rowUpadate = ps.executeUpdate() > 0;
		return rowUpadate;
	}

}
