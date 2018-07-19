package crud.db.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.SinhVienBean;

@ManagedBean(name = "DAO")
@SessionScoped

public class DAOSV {
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// public static ArrayList getStudentsListFromDB() throws SQLException {
	// Connection conn = connect.getConnect();
	//
	// ArrayList sVList = new ArrayList();
	// String sql = "SELECT * FROM SinhVien";
	// Statement statement = conn.createStatement();
	// ResultSet resultSet = statement.executeQuery(sql);
	//
	// while (resultSet.next()) {
	// SinhVienBean stuObj = new SinhVienBean();
	// stuObj.setMaSinhVien(resultSet.getString("Ma_Sinh_Vien"));
	// stuObj.setName(resultSet.getString("Name"));
	// stuObj.setSex(resultSet.getString("SEX"));
	// stuObj.setAge(resultSet.getString("Age"));
	// stuObj.setLop(resultSet.getString("Class"));
	// stuObj.setDress(resultSet.getString("Dress"));
	// sVList.add(stuObj);
	//
	// }
	//
	// return sVList;
	// }

	public static String saveStudent(SinhVienBean newStudentObj) throws SQLException {
		Connection conn = connect.getConnect();

		int saveResult = 0;
		String navigationResult = "";
		String sql = "INSERT INTO SinhVien(Ma_Sinh_Vien,Name,SEX,Age,Class,Dress)" + " VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, newStudentObj.getMaSinhVien());
		statement.setString(2, newStudentObj.getName());
		statement.setString(3, newStudentObj.getSex());
		statement.setString(4, newStudentObj.getAge());
		statement.setString(5, newStudentObj.getLop());
		statement.setString(6, newStudentObj.getDress());

		saveResult = statement.executeUpdate();
		conn.close();

		if (saveResult != 0) {
			navigationResult = "ListSinhVien.xhtml?faces-redirect=true";
		} else {
			navigationResult = "ListSinhVien.xhtml?faces-redirect=true";
		}
		return navigationResult;
	}

	public static String deleteStudentRecordInDB(String maSinhVien) throws SQLException {
		Connection conn = connect.getConnect();

		String sql = "DELETE FROM SinhVien where Ma_Sinh_Vien  = ?";
		PreparedStatement statement = conn.prepareStatement(sql);

		statement.setString(1, maSinhVien);

		statement.executeUpdate();
		return "/ListSinhVien.xhtml?faces-redirect=true";
	}

	public static String updateStudentDetailsInDB(SinhVienBean updateStudentObj) throws SQLException {
		Connection conn = connect.getConnect();
		String sql = "UPDATE SinhVien SET Ma_Sinh_Vien = ?, Name = ?, SEX = ?,Age=?,Class=?,Dress=? where Ma_Sinh_Vien=? ";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, updateStudentObj.getMaSinhVien());
		statement.setString(2, updateStudentObj.getName());
		statement.setString(3, updateStudentObj.getSex());
		statement.setString(4, updateStudentObj.getAge());
		statement.setString(5, updateStudentObj.getLop());
		statement.setString(6, updateStudentObj.getDress());
		statement.setString(7, updateStudentObj.getMaSinhVien());

		statement.executeUpdate();

		return "/ListSinhVien.xhtml?faces-redirect=true";
	}

	public static String editStudentRecordInDB(String maSinhVien) throws SQLException {
		SinhVienBean editRecord = null;
		Connection conn = connect.getConnect();

		/* Setting The Particular Student Details In Session */
		Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		String sql = "select * from SinhVien where Ma_Sinh_Vien = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, maSinhVien);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			editRecord = new SinhVienBean();
			editRecord.setMaSinhVien(resultSet.getString("Ma_Sinh_Vien"));
			editRecord.setName(resultSet.getString("Name"));
			editRecord.setSex(resultSet.getString("SEX"));
			editRecord.setAge(resultSet.getString("Age"));
			editRecord.setLop(resultSet.getString("Class"));
			editRecord.setDress(resultSet.getString("Dress"));
		}
		sessionMapObj.put("editRecordObj", editRecord);

		return "/editSinhVien.xhtml?faces-redirect=true";
	}

	public int count() throws SQLException {
		int count = 0;
		Connection conn = connect.getConnect();
		String sql = "select count(Ma_Sinh_Vien) from SinhVien";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			count = rs.getInt("count(Ma_Sinh_Vien)");
		}
		return count;
	}

	public static List<SinhVienBean> getRecords(int fromIndex, int records) {
		List<SinhVienBean> sinhVienList = new ArrayList<SinhVienBean>();
		try {
			Connection conn = connect.getConnect();
			PreparedStatement ps = conn.prepareStatement("select * from SinhVien limit " + fromIndex + "," + records);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SinhVienBean e = new SinhVienBean();
				e.setMaSinhVien(rs.getString("Ma_Sinh_Vien"));
				e.setName(rs.getString("Name"));
				e.setSex(rs.getString("SEX"));
				e.setAge(rs.getString("Age"));
				e.setLop(rs.getString("Class"));
				e.setDress(rs.getString("Dress"));
				sinhVienList.add(e);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return sinhVienList;
	}

}
