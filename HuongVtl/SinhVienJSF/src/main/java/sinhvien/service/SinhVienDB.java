package sinhvien.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import com.mysql.jdbc.Statement;

import sinhvien.bean.QuanLyBean;

public class SinhVienDB {
	static Connection conn = ConnectDB.getConnect("localhost", "sinhvienjsf", "huong", "12345");
	public static int themSV(SinhVien sv) {
		try {
			String sql = "insert into sinhvien (id, ho_ten, gioi_tinh, email,dia_chi, lop, dien_thoai, nam_sinh) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setInt(1, sv.getId());
			stm.setString(2, sv.getHoTen());
			stm.setString(3, sv.getGioiTinh());
			stm.setString(4, sv.getEmail());
			stm.setString(5, sv.getDiaChi());
			stm.setString(6, sv.getLop());
			stm.setString(7, sv.getSdt());
			stm.setString(8, sv.getNamSinh());
			int i = stm.executeUpdate();						
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public ArrayList<SinhVien> SinhVien() {
		ArrayList<SinhVien> arrSv = new ArrayList<SinhVien>();
		try {
			String sql = "select * from sinhvien ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setId(rs.getInt("id"));
				sv.setHoTen(rs.getString("ho_ten"));
				sv.setGioiTinh(rs.getString("gioi_tinh"));
				sv.setEmail(rs.getString("email"));
				sv.setDiaChi(rs.getString("dia_chi"));
				sv.setLop(rs.getString("lop"));
				sv.setSdt(rs.getString("dien_thoai"));
				sv.setNamSinh(rs.getString("nam_sinh"));
				arrSv.add(sv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrSv;
	}
	
	
	
	public static void editRecordDB(int id) throws SQLException {
		QuanLyBean editRecord =new QuanLyBean();
		java.util.Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String sql ="select * from sinhvien where id = ? ";
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setInt(1, id );
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			editRecord.setHoTen(rs.getString("ho_ten"));
			editRecord.setGioiTinh(rs.getString("gioi_tinh"));
			editRecord.setEmail(rs.getString("email"));
			editRecord.setDiaChi(rs.getString("dia_chi"));
			editRecord.setLop(rs.getString("lop"));
			editRecord.setSdt(rs.getString("dien_thoai"));
			editRecord.setNamSinh(rs.getString("nam_sinh"));
			editRecord.setId(rs.getInt("id"));
		}
		sessionMapObj.put("obj", editRecord);
	}
	
	public static int updateSv(QuanLyBean sv) {
		try {
			String sql = "update sinhvien set id = ?, ho_ten = ? , gioi_tinh = ?, email=?, dia_chi=?, lop=? ,"
					+ "dien_thoai = ?, nam_sinh = ? where id = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, sv.getHoTen());
			stm.setString(2, sv.getGioiTinh());
			stm.setString(3, sv.getEmail());
			stm.setString(4, sv.getDiaChi());
			stm.setString(5, sv.getLop());
			stm.setString(6, sv.getSdt());
			stm.setString(7, sv.getNamSinh());
			stm.setInt(8, sv.getId());
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int deleteSv( int id) {
		try {
			String sql = "DELETE FROM sinhvien WHERE id = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setInt(1, id);

			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int countStudent() {
		int count=-1;
		try {
			String sql = "SELECT COUNT(*) AS total FROM sinhvien"; 
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				count=rs.getInt("total");
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static ArrayList<SinhVien> sinhVienList(int start, int end){
		ArrayList<SinhVien> arrSv = new ArrayList<SinhVien>();
		try {
		String sql = "select * from sinhvien limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			SinhVien sv = new SinhVien();
			sv.setId(rs.getInt("id"));
			sv.setHoTen(rs.getString("ho_ten"));
			sv.setGioiTinh(rs.getString("gioi_tinh"));
			sv.setEmail(rs.getString("email"));
			sv.setDiaChi(rs.getString("dia_chi"));
			sv.setLop(rs.getString("lop"));
			sv.setSdt(rs.getString("dien_thoai"));
			sv.setNamSinh(rs.getString("nam_sinh"));
			arrSv.add(sv);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrSv;
	}
}
