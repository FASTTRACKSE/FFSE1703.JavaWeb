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
			String sql = "insert into danhsachsv (ten, ma, ngay_sinh, lp1,"
					+ "lp2) "
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, sv.getTenSv());
			stm.setString(2, sv.getMaSv());
			stm.setString(3, sv.getNgaySinh());
			stm.setDouble(4, sv.getDiemLP1());
			stm.setDouble(5, sv.getDiemLP2());
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
				sv.setTenSv(rs.getString("ten"));
				sv.setMaSv(rs.getString("ma"));
				sv.setNgaySinh(rs.getString("ngay_sinh"));
				sv.setDiemLP1(rs.getDouble("lp1"));
				sv.setDiemLP1(rs.getDouble("lp2"));
				arrSv.add(sv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrSv;
	}
	
	public static int update(SinhVien sv) {
		try {
			String sql = "update danhsachsv set ten = ?, ma = ?, ngay_sinh = ?, "
					+ "lp1 = ?, lp2 = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, sv.getTenSv());
			stm.setString(2, sv.getMaSv());
			stm.setString(3, sv.getNgaySinh());
			stm.setDouble(4, sv.getDiemLP1());
			stm.setDouble(5, sv.getDiemLP2());

			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
}

