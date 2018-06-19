package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connector.GetConnect;

public class SinhVienDao {
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_Li_Sinh_Vien_JSP_Servlet", "phamquy481", "a0163763123");
	ArrayList<SinhVien_model> arrSinhVienList = new ArrayList<>();
	private PreparedStatement ps;
	
	double total;
	
//	public int check() {
//		kt = 0;
//		
//		try {
//			String sql = "select count(*) from Sinh_vien where Id = " + "'" + 999 + "'" ;
//			Statement statement=conn.createStatement();
//			ResultSet result=statement.executeQuery(sql);
//			while(result.next())
//			{
//				kt = result.getInt("COUNT(*)");
//			}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//		
//		return kt;
//	}
	
	public ArrayList<SinhVien_model> SinhVienList(int start, int end){
		
		arrSinhVienList.clear();
		try {
			//Statement statement = conn.createStatement();
			String sql = "select * from Sinh_Vien limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet result=ps.executeQuery();
			while(result.next())
			{
				String maSv = result.getString("Masv");
				String hoTen = result.getString("Hoten");
				String tuoi = result.getString("Tuoi");
				String queQuan = result.getString("Quequan");
				String gioiTinh = result.getString("Gioitinh");
				String maLop = result.getString("Malop");
				double diemLp1 = Double.parseDouble(result.getString("Diemlp1"));
				double diemLp2 = Double.parseDouble(result.getString("Diemlp2"));
				arrSinhVienList.add(new SinhVien_model(maSv, hoTen, tuoi, queQuan, gioiTinh, maLop, diemLp1, diemLp2));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		
		return arrSinhVienList;
	}
	
	public int insert(SinhVien_model sinhVien) throws SQLException {
		String sql = "INSERT INTO Sinh_vien (Masv, Hoten, Tuoi, Quequan, Gioitinh, MaLop, Diemlp1, Diemlp2) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, sinhVien.getMaSV());
		ps.setString(2, sinhVien.getHoTen());
		ps.setString(3, sinhVien.getTuoi());
		ps.setString(4, sinhVien.getQueQuan());
		ps.setString(5, sinhVien.getGioiTinh());
		ps.setString(6, sinhVien.getMaLop());
		ps.setString(7, String.valueOf(sinhVien.getDiemLp1()));
		ps.setString(8, String.valueOf(sinhVien.getDiemLp2()));
		
		
		return ps.executeUpdate();
	}
	
	public int update(SinhVien_model sinhVien) throws SQLException {
		 String sql = "UPDATE Sinh_vien SET Hoten = ?, Tuoi = ?, Quequan = ?, Gioitinh = ?, Malop = ?, Diemlp1 = ?, Diemlp2 = ?";
	        sql += " WHERE Masv = ?";
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, sinhVien.getHoTen());
			ps.setString(2, sinhVien.getTuoi());
			ps.setString(3, sinhVien.getQueQuan());
			ps.setString(4, sinhVien.getGioiTinh());
			ps.setString(5, sinhVien.getMaLop());
			ps.setString(6, String.valueOf(sinhVien.getDiemLp1()));
			ps.setString(7, String.valueOf(sinhVien.getDiemLp2()));
			ps.setString(8, sinhVien.getMaSV());
			
			return ps.executeUpdate();
	
	}
	
	public SinhVien_model getSv(String maSv) throws SQLException {
		SinhVien_model sv = null;
		String sql = "SELECT * FROM Sinh_vien WHERE Masv = ?";
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, maSv);
		
		ResultSet result = ps.executeQuery();
		while(result.next())
		{
			String maSV = result.getString("Masv");
			String hoTen = result.getString("Hoten");
			String tuoi = result.getString("Tuoi");
			String queQuan = result.getString("Quequan");
			String gioiTinh = result.getString("Gioitinh");
			String maLop = result.getString("Malop");
			double diemLp1 = Double.parseDouble(result.getString("Diemlp1"));
			double diemLp2 = Double.parseDouble(result.getString("Diemlp2"));
			
			sv = new SinhVien_model(maSV, hoTen, tuoi, queQuan, gioiTinh, maLop, diemLp1, diemLp2);
		}
		return sv;
		
	}
	
	public void delete(String maSv) {
		try
		{
			String sql="delete from Sinh_vien where Masv='" + maSv + "'";
			Statement statement=conn.createStatement();
			statement.executeUpdate(sql);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public double countSinhVien() {
		try {
			String sql = "select count(*) from Sinh_vien";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				total = result.getDouble("COUNT(*)");
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		return total;
	}
	
}
