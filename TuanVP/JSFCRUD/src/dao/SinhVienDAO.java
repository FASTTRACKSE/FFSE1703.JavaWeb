package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import bean.SinhVienBean;

public class SinhVienDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public SinhVienDAO() {
		this.jdbcURL = "jdbc:mysql://localhost:3306/ffse1703014";
		this.jdbcUsername = "admin";
		this.jdbcPassword = "123456";
	}

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public ArrayList<SinhVienBean> listSinhVien(int start, int maxItems) throws SQLException {
		ArrayList<SinhVienBean> listSinhVien = new ArrayList<SinhVienBean>();
		String sql = "SELECT * FROM sinhvien LIMIT ?,?";

		connect();

		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
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
			SinhVienBean sv = new SinhVienBean(id, hoDem, ten, namSinh, gioiTinh, email, sdt, diaChi, lop);
			listSinhVien.add(sv);
		}

		rs.close();
		ps.close();
		disconnect();

		return listSinhVien;
	}

	public SinhVienBean getSinhVien(SinhVienBean sv) throws SQLException {
		SinhVienBean extSV = null;
		String sql = "SELECT * FROM sinhvien WHERE id = ?";

		connect();

		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
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
			extSV = new SinhVienBean(id, hoDem, ten, namSinh, gioiTinh, email, sdt, diaChi, lop);
		}

		rs.close();
		ps.close();
		disconnect();
		return extSV;
	}

	public boolean insertSinhVien(SinhVienBean sv) throws SQLException {
		String sql = "INSERT INTO sinhvien VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";

		connect();

		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
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
		disconnect();

		return rowUpdate;
	}

	public boolean updateSinhVien(SinhVienBean sv) throws SQLException {
		String sql = "UPDATE sinhvien SET Hodem = ?, Ten = ?, NamSinh = ?, GioiTinh = ?, Email = ?, SDT = ?, DiaChi = ?, Lop = ? WHERE ID = ?";

		connect();

		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
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
		disconnect();
		
		return rowUpdate;
	}

	public boolean deleteSinhVien(int id) throws SQLException {
		String sql = "DELETE FROM sinhvien WHERE id = ?";
		
		connect();
		
		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
		ps.setInt(1, id);

		boolean rowUpadate = ps.executeUpdate() > 0;
		
		ps.close();
		disconnect();
		
		return rowUpadate;
	}

	public int rowCount() throws SQLException {
		int row = 0;
		String sql = "SELECT COUNT(*) FROM sinhvien";
		
		connect();
		
		Statement st = jdbcConnection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			row = rs.getInt("COUNT(*)");
		}
		
		rs.close();
		st.close();
		disconnect();

		return row;
	}
}
