package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;



import connector.GetConnect;

public class DAO {
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_Li_Sinh_Vien_JSF", "phamquy481", "a0163763123");
	ArrayList<SinhVien_Bean> arrSinhVienDB = new ArrayList<>();
	double total;
	
	
	public ArrayList<SinhVien_Bean> sinhVienList(int start, int end){
		arrSinhVienDB.clear();
		try {
		String sql = "select * from Sinh_vien limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet result=ps.executeQuery();
		while(result.next())
		{
			String maSv = result.getString("Masv");
			String hoTen = result.getString("Hoten");
			String namSinh = result.getString("Namsinh");
			String queQuan = result.getString("Quequan");
			String gioiTinh = result.getString("Gioitinh");
			String email =result.getString("Email");
			String dienThoai =result.getString("Dienthoai");
			String maLop = result.getString("Malop");
			
			arrSinhVienDB.add(new SinhVien_Bean(maSv, hoTen, namSinh, queQuan, gioiTinh, email, dienThoai, maLop));
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrSinhVienDB;
	}
	
	public void delete(String maSv) {
		try {
			String sql="delete from Sinh_vien where Masv= ?" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maSv);
			ps.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public int insert(SinhVien_Bean sinhVien) throws SQLException {
		String sql = "INSERT INTO Sinh_vien (Masv, Hoten, Namsinh, Quequan, Gioitinh, Email, Dienthoai, MaLop) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, sinhVien.getMaSv());
		ps.setString(2, sinhVien.getHoTen());
		ps.setString(3, sinhVien.getNamSinh());
		ps.setString(4, sinhVien.getQueQuan());
		ps.setString(5, sinhVien.getGioiTinh());
		ps.setString(6, sinhVien.getEmail());
		ps.setString(7, sinhVien.getDienThoai());
		ps.setString(8, sinhVien.getMaLop());
	
		return ps.executeUpdate();
	}
	
	public int checkExist(String maSv) {
		int exist = 0;
		try {
			String sql = "select count(*) from Sinh_vien where Masv= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maSv);
			ResultSet result= ps.executeQuery();
			while(result.next())
			{
				exist = result.getInt("COUNT(*)");
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return exist;
	}
	
	public void editSinhVienRecord(String maSv) throws SQLException {
		SinhVien_Bean editRecord = new SinhVien_Bean();

		java.util.Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		String sql = "SELECT * FROM Sinh_vien WHERE Masv = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, maSv);
		
		ResultSet result=ps.executeQuery();
		
		while(result.next())
		{
			editRecord.setMaSv(result.getString("Masv"));
			editRecord.setHoTen(result.getString("Hoten"));
			editRecord.setNamSinh(result.getString("Namsinh"));
			editRecord.setQueQuan(result.getString("Quequan"));
			editRecord.setGioiTinh(result.getString("Gioitinh"));
			editRecord.setEmail(result.getString("Email"));
			editRecord.setDienThoai(result.getString("Dienthoai"));
			editRecord.setMaLop(result.getString("Malop"));
			
		}
		sessionMapObj.put("editRecordObj", editRecord);
	}
	
	public void update(SinhVien_Bean sinhVien) throws SQLException {
		 String sql = "UPDATE Sinh_vien SET Hoten = ?, Namsinh = ?, Quequan = ?, Gioitinh = ?, Email = ?, Dienthoai = ?, Malop = ?";
	        sql += " WHERE Masv = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        
	        ps.setString(1, sinhVien.getHoTen());
	        ps.setString(2, sinhVien.getNamSinh());
	        ps.setString(3, sinhVien.getQueQuan());
	        ps.setString(4, sinhVien.getGioiTinh());
	        ps.setString(5, sinhVien.getEmail());
	        ps.setString(6, sinhVien.getDienThoai());
	        ps.setString(7, sinhVien.getMaLop());
	        ps.setString(8, sinhVien.getMaSv());
	        
	        ps.executeUpdate();
	}
	
	public double count() {
		try {
			String sql = "select count(*) from Sinh_vien";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet result= ps.executeQuery();
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
