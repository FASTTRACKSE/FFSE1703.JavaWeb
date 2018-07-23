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
	public List<SinhVien> listSinhVien(int start, int perPage) throws SQLException {
		List<SinhVien> listSinhVien = new ArrayList<>();
		String sql = "SELECT * FROM sinhvien1 LIMIT ?, ?";
		
		connect();
		
		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, perPage);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("Id");
			String hodem = rs.getString("HoDem");
			String ten = rs.getString("Ten");
			String ngaysinh = rs.getString("NgaySinh");
			String gioitinh = rs.getString("GioiTinh");
			String quequan = rs.getString("QueQuan");
			String lop = rs.getString("LopHoc");
			float diemlp1 = rs.getFloat("DiemLP1");
			float diemlp2 = rs.getFloat("DiemLP2");
			float diemtb = rs.getFloat("DiemTB");
			String xeploai = rs.getString("XepLoai");
			
			SinhVien sv = new SinhVien(id, hodem, ten, ngaysinh, gioitinh, quequan, lop, diemlp1, diemlp2, diemtb, xeploai);
			listSinhVien.add(sv);
		}
		
		rs.close();
		ps.close();
		disconnect();
		
		return listSinhVien;
	}
	public boolean insertStudent(SinhVien sv) throws SQLException {
		String sql = "INSERT INTO sinhvien1 VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
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
		String sql = "SELECT * FROM sinhvien1 WHERE id =? ";
		
		connect();
		
		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
		ps.setInt(1, sv.getId());
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("Id");
			String hodem = rs.getString("HoDem");
			String ten = rs.getString("Ten");
			String ngaysinh = rs.getString("NgaySinh");
			String gioitinh = rs.getString("GioiTinh");
			String quequan = rs.getString("QueQuan");
			String lop = rs.getString("LopHoc");
			float diemlp1 = rs.getFloat("DiemLP1");
			float diemlp2 = rs.getFloat("DiemLP2");
			
			extsv = new SinhVien(id, hodem, ten, ngaysinh, gioitinh, quequan, lop, diemlp1, diemlp2);
		}
		
		rs.close();
		ps.close();
		disconnect();
		
		return extsv;
	}
	public boolean updateStudent(SinhVien sv) throws SQLException {
		String sql = "UPDATE sinhvien1 SET HoDem = ?, Ten = ?, NgaySinh = ?, GioiTinh = ?, QueQuan = ?, LopHoc = ?, DiemLP1 = ?, DiemLP2 = ?, DiemTB = ?, XepLoai = ? WHERE Id = ?";
		
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
		String sql = "DELETE FROM sinhvien1 WHERE id = ?";
		
		connect();
		
		PreparedStatement ps = jdbcConnection.prepareStatement(sql);
		ps.setInt(1, sv.getId());		
		boolean rowUpdate = ps.executeUpdate() > 0;
		
		ps.close();
		disconnect();
		
		return rowUpdate;
	}
	
	public int rowCount() throws SQLException {
		String sql = "SELECT COUNT(*) FROM sinhvien1";
		int rowCount = 0;
		connect();
		
		Statement st = jdbcConnection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			rowCount = rs.getInt("COUNT(*)");
		}
		
		rs.close();
		st.close();
		disconnect();
		return rowCount;
	}
}
