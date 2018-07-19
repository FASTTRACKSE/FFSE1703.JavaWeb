package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.SinhVien;

public class StudentDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
	public StudentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
	protected void connect() throws SQLException {
	        if (jdbcConnection == null || jdbcConnection.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            throw new SQLException(e);
	        }
	        jdbcConnection = DriverManager.getConnection(
	                                    jdbcURL, jdbcUsername, jdbcPassword);
	    }
	}
	 
	protected void disconnect() throws SQLException {
	    if (jdbcConnection != null && !jdbcConnection.isClosed()) {
	        jdbcConnection.close();
	    }
	}
	public List<SinhVien> listSinhVien() throws SQLException {
		List<SinhVien> listSinhVien = new ArrayList<>();
		String sql = "SELECT * FROM sinhvien";
		
		connect();
		
		Statement st = jdbcConnection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String hodem = rs.getString("hodem");
			String ten = rs.getString("ten");
			String ngaysinh = rs.getString("ngaysinh");
			String gioitinh = rs.getString("gioitinh");
			String quequan = rs.getString("quequan");
			String lop = rs.getString("lop");
			float diemlp1 = rs.getFloat("diemlp1");
			float diemlp2 = rs.getFloat("diemlp2");
			float diemtb = rs.getFloat("diemtb");
			String xeploai = rs.getString("xeploai");
			
			SinhVien sv = new SinhVien(id, hodem, ten, ngaysinh, gioitinh, quequan, lop, diemlp1, diemlp2, diemtb, xeploai);
			listSinhVien.add(sv);
		}
		
		rs.close();
		st.close();
		disconnect();
		
		return listSinhVien;
	}
	public boolean insertStudent(SinhVien sv) throws SQLException {
		String sql = "INSERT INTO sinhvien VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		connect();
		
		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
		ps.setString(1, sv.getHodem());
		ps.setString(2, sv.getTen());
		ps.setString(3, sv.getNgaysinh());
		ps.setString(4, sv.getGioitinh());
		ps.setString(5, sv.getQuequan());
		ps.setString(6, sv.getLop());
		ps.setFloat(7, sv.getDiemlp1());
		ps.setFloat(8, sv.getDiemlp2());
		ps.setFloat(9, sv.tinhDiemTB());
		ps.setString(10, sv.xepLoai());
		
		boolean rowUpdate = ps.executeUpdate() > 0;
		
		ps.close();
		disconnect();
		
		return rowUpdate;
	}
	public SinhVien getSinhVien(SinhVien sv) throws SQLException {
		SinhVien extsv = null;
		String sql = "SELECT * FROM sinhvien WHERE id =? ";
		
		connect();
		
		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
		ps.setInt(1, sv.getId());
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String hodem = rs.getString("hodem");
			String ten = rs.getString("ten");
			String ngaysinh = rs.getString("ngaysinh");
			String gioitinh = rs.getString("gioitinh");
			String quequan = rs.getString("quequan");
			String lop = rs.getString("lop");
			float diemlp1 = rs.getFloat("diemlp1");
			float diemlp2 = rs.getFloat("diemlp2");
			
			extsv = new SinhVien(id, hodem, ten, ngaysinh, gioitinh, quequan, lop, diemlp1, diemlp2);
		}
		
		rs.close();
		ps.close();
		disconnect();
		
		return extsv;
	}
	public boolean updateStudent(SinhVien sv) throws SQLException {
		String sql = "UPDATE sinhvien SET hodem = ?, ten = ?, ngaysinh = ?, gioitinh = ?, quequan = ?, lop = ?, diemlp1 = ?, diemlp2 = ?, diemtb = ?, xeploai = ? WHERE id = ?";
		
		connect();
		
		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
		ps.setString(1, sv.getHodem());
		ps.setString(2, sv.getTen());
		ps.setString(3, sv.getNgaysinh());
		ps.setString(4, sv.getGioitinh());
		ps.setString(5, sv.getQuequan());
		ps.setString(6, sv.getLop());
		ps.setFloat(7, sv.getDiemlp1());
		ps.setFloat(8, sv.getDiemlp2());
		ps.setFloat(9, sv.tinhDiemTB());
		ps.setString(10, sv.xepLoai());
		ps.setInt(11, sv.getId());
		
		boolean rowUpdate = ps.executeUpdate() > 0;
		
		ps.close();
		disconnect();
		
		return rowUpdate;
	}
	public boolean deleteStudent(SinhVien sv) throws SQLException {
		String sql = "DELETE FROM sinhvien WHERE id = ?";
		
		connect();
		
		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
		ps.setInt(1, sv.getId());		
		boolean rowUpdate = ps.executeUpdate() > 0;
		
		ps.close();
		disconnect();
		
		return rowUpdate;
	}
}
