package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;



//import connector.GetConnect;

public class DAO {
	//static final  Connection conn= (new GetConnect()).getConnect("localhost", "Quan_Li_Sinh_Vien_JSF", "phamquy481", "a0163763123");
	
	
	// kết nối Database
	private String jdbcURL = "jdbc:mysql://localhost:3306/Quan_Li_Sinh_Vien_JSF?useUnicode=true&characterEncoding=utf-8";
	private String jdbcUsername = "phamquy481";
	private String jdbcPassword = "a0163763123";
	private Connection conn;

	protected void connect() throws SQLException {
		if (conn == null || conn.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}
	
	
	ArrayList<SinhVien_Bean> arrSinhVienDB = new ArrayList<>();
	double total;
	
	
	public ArrayList<SinhVien_Bean> sinhVienList(int start, int end){
		arrSinhVienDB.clear();
		try {
		connect();
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
		disconnect();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrSinhVienDB;
	}
	
	public void delete(String maSv) {
		try {
			connect();
			String sql="delete from Sinh_vien where Masv= ?" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maSv);
			ps.executeUpdate();
			disconnect();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void insert(SinhVien_Bean sinhVien) throws SQLException {
		connect();
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
		ps.executeUpdate();
		disconnect();
		
		
	}
	
	public int checkExist(String maSv) {
		int exist = 0;
		try {
			connect();
			String sql = "select count(*) from Sinh_vien where Masv= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maSv);
			ResultSet result= ps.executeQuery();
			while(result.next())
			{
				exist = result.getInt("COUNT(*)");
			}
			disconnect();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return exist;
	}
	
	public SinhVien_Bean editSinhVienRecord(String maSv) throws SQLException {
		connect();
		SinhVien_Bean editRecord = new SinhVien_Bean();

		String sql = "SELECT * FROM Sinh_vien WHERE Masv = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, maSv);
		
		ResultSet result=ps.executeQuery();
			result.next();
		
			editRecord.setMaSv(result.getString("Masv"));
			editRecord.setHoTen(result.getString("Hoten"));
			editRecord.setNamSinh(result.getString("Namsinh"));
			editRecord.setQueQuan(result.getString("Quequan"));
			editRecord.setGioiTinh(result.getString("Gioitinh"));
			editRecord.setEmail(result.getString("Email"));
			editRecord.setDienThoai(result.getString("Dienthoai"));
			editRecord.setMaLop(result.getString("Malop"));
			
			disconnect();
		
			return editRecord;
	}
	
	public void update(SinhVien_Bean sinhVien) throws SQLException {
		 connect();
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
	        disconnect();
	}
	
	public double count() {
		try {
			connect();
			String sql = "select count(*) from Sinh_vien";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet result= ps.executeQuery();
			while(result.next())
			{
				total = result.getDouble("COUNT(*)");
				
			}
			disconnect();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		return total;
	}
	
}
