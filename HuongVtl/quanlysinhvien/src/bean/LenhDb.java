package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LenhDb {
	static ConnectDB myDb = new ConnectDB();
	@SuppressWarnings("static-access")
	static
	Connection conn = myDb.getConnect("localhost", "quanlysv", "huong", "12345");
	public static int themSV(SinhVien sv) {
		try {
			String sql = "insert into danhsachsv (ten_dem, ten, ma,ngay_sinh, que_quan, gioi_tinh, lp1,"
					+ "lp2) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, sv.getHoDem());
			stm.setString(2, sv.getTenSv());
			stm.setString(3, sv.getMaSv());
			stm.setString(4, sv.getNgaySinh());
			stm.setString(5, sv.getQueQuan());
			stm.setString(6, sv.getGioiTinh());
			stm.setDouble(7, sv.getDiemLP1());
			stm.setDouble(8, sv.getDiemLP2());
			int i = stm.executeUpdate();						
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static ArrayList<SinhVien> SinhVien() {
		ArrayList<SinhVien> arrSv = new ArrayList<SinhVien>();
		try {
			String sql = "select * from danhsachsv ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setHoDem(rs.getString("ten_dem"));
				sv.setTenSv(rs.getString("ten"));
				sv.setMaSv(rs.getString("ma"));
				sv.setNgaySinh(rs.getString("ngay_sinh"));
				sv.setQueQuan(rs.getString("que_quan"));
				sv.setGioiTinh(rs.getString("gioi_tinh"));
				sv.setDiemLP1(rs.getDouble("lp1"));
				sv.setDiemLP2(rs.getDouble("lp2"));
				arrSv.add(sv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrSv;
	}
	
	public static ArrayList<SinhVien> selectSv(String ma){
		ArrayList<SinhVien> arrSv=new ArrayList<SinhVien>();
		try {
			String sql ="select * from danhsachsv where ma = ? ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, ma );
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				SinhVien sv = new SinhVien();
				sv.setHoDem(rs.getString("ten_dem"));
				sv.setTenSv(rs.getString("ten"));
				sv.setMaSv(rs.getString("ma"));
				sv.setNgaySinh(rs.getString("ngay_sinh"));
				sv.setQueQuan(rs.getString("que_quan"));
				sv.setGioiTinh(rs.getString("gioi_tinh"));
				sv.setDiemLP1(rs.getDouble("lp1"));
				sv.setDiemLP2(rs.getDouble("lp2"));
				arrSv.add(sv);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrSv;
		
	}	
	
	public static int update(SinhVien sv) {
		try {
			String sql = "update danhsachsv set ten_dem = ? , ten = ?, ngay_sinh=?, que_quan=?, gioi_tinh=? ,"
					+ "lp1 = ?, lp2 = ? where ma = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, sv.getHoDem());
			stm.setString(2, sv.getTenSv());
			stm.setString(3, sv.getNgaySinh());
			stm.setString(4, sv.getQueQuan());
			stm.setString(5, sv.getGioiTinh());
			stm.setDouble(6, sv.getDiemLP1());
			stm.setDouble(7, sv.getDiemLP2());
			stm.setString(8, sv.getMaSv());
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int deleteSv(String ma) {
		try {
			String sql = "DELETE FROM danhsachsv WHERE ma = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, ma);

			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int countSv() {
		int i=0;
		try {
			String sql = "SELECT COUNT(*) AS total FROM danhsachsv ";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet hang = preparedStatement.executeQuery();
			while(hang.next())
			{
				i=hang.getInt("total");
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return i;
	}
}
