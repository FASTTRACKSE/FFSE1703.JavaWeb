package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import bean.SinhVien;
import dao.ConnectDB;

public class SVDao {
	private Connection conn = ConnectDB.getConnect("localhost", "java_web_asm", "root", "");
	public static SVDao instance;

	public void connect() throws SQLException {
		if (conn == null || conn.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			System.out.print("ket noi thanh cong");
			conn = ConnectDB.getConnect("localhost", "java_web_asm", "root", "");
		}
	}

	public static SVDao getInstance() {
		if (instance == null) {
			instance = new SVDao();
		}
		return instance;
	}

	public ArrayList<SinhVien> listSinhVien() throws Exception {
		ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();
		try {
			Statement stm;
			ResultSet rs;
			connect();
			stm = conn.createStatement();
			rs = stm.executeQuery("select * from jsf_sinh_vien");
			// process result set
			while (rs.next()) {
				SinhVien sv = new SinhVien(rs.getInt("id"), rs.getString("ten"), rs.getString("email"),
						rs.getString("password"), rs.getString("gender"), rs.getString("address"));
				listSV.add(sv);
			}
			return listSV;
		} finally {
			conn.close();
		}
	}

	public ArrayList<SinhVien> listSinhVien(int pageStart, int pageLimit) throws SQLException {
		ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();
		int offset = (pageStart - 1) * pageLimit;
		try {
			connect();
			Statement stm = conn.createStatement();
			String sqlQuery = "select * from jsf_sinh_vien limit " + offset + "," + pageLimit + "";
			ResultSet rs = stm.executeQuery(sqlQuery);
			while (rs.next()) {
				SinhVien sv = new SinhVien(rs.getInt("id"), rs.getString("ten"), rs.getString("email"),
						rs.getString("password"), rs.getString("gender"), rs.getString("address"));
				listSV.add(sv);
			}
			return listSV;
		} finally {
			conn.close();
		}
	}

	public int countSV() throws SQLException {
		int totalSV = 0;
		connect();
		Statement stm;
		ResultSet rs;
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery("select count(*) from jsf_sinh_vien");
			if (rs.next()) {
				totalSV = rs.getInt(1);
			}
			return totalSV;
		} finally {
			conn.close();
		}
	}

	public SinhVien getSV(int svID) throws Exception {
		connect();
		Statement stm;
		SinhVien sv = new SinhVien();
		try {
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select * from jsf_sinh_vien where id=" + svID + "");
			if (rs.next()) {
				sv = new SinhVien(rs.getInt("id"), rs.getString("ten"), rs.getString("email"), rs.getString("password"),
						rs.getString("gender"), rs.getString("address"));
			} else {
				throw new Exception("Khong tim thay sinh vien id :" + svID);
			}
		} finally {
			conn.close();
		}
		return sv;
	}

	public void addSV(SinhVien sv) throws Exception {
		connect();
		PreparedStatement stm;
		try {
			String sql = "insert into jsf_sinh_vien(id,ten,email,password," + "gender,address) values(?,?,?,?,?,?)";
			stm = conn.prepareStatement(sql);
			stm.setInt(1, sv.getId());
			stm.setString(2, sv.getName());
			stm.setString(3, sv.getEmail());
			stm.setString(4, sv.getPassword());
			stm.setString(5, sv.getGender());
			stm.setString(6, sv.getAddress());
			stm.execute();
		} finally {
			conn.close();
		}
	}

	public boolean updateSV(SinhVien sv) throws SQLException {
		connect();
		PreparedStatement pstm;
		boolean rowUpdate = false;
		try {
		pstm = conn.prepareStatement
			("update jsf_sinh_vien set ten=?,email=?,password=?,gender=?,address=? where id=?");
		pstm.setString(1, sv.getName());
		pstm.setString(2, sv.getEmail());
		pstm.setString(3, sv.getPassword());
		pstm.setString(4, sv.getGender());
		pstm.setString(5, sv.getAddress());
		pstm.setInt(6, sv.getId());
		rowUpdate =  pstm.executeUpdate() > 0;
		} finally {
			conn.close();
		}
		return rowUpdate;
	}
	public void deleteSV(int svID) throws Exception {
		connect();
		PreparedStatement pstm;
		try {
		pstm = conn.prepareStatement("delete from jsf_sinh_vien where id="+svID+"");
		pstm.execute();
		} finally {
			conn.close();
		}
	}
}
