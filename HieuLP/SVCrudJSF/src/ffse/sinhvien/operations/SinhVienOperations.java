package ffse.sinhvien.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ffse.sinhvien.bean.SinhVienBean;
@ManagedBean(name = "DAO")
@SessionScoped
public class SinhVienOperations {
	public static Statement stmtObj;
	public static Connection connObj;
	public static ResultSet resultSetObj;
	public static PreparedStatement pstmt;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db_url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8",
					db_userName = "admin1", db_password = "12345";
			connObj = DriverManager.getConnection(db_url, db_userName, db_password);
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return connObj;
	}

//	public static ArrayList getStudentsListFromDB() {
//		// TODO Auto-generated method stub
//		ArrayList listSinhvien = new ArrayList();
//		try {
//			stmtObj = getConnection().createStatement();
//			resultSetObj = stmtObj.executeQuery("select * from student");
//			while (resultSetObj.next()) {
//				SinhVienBean sv = new SinhVienBean();
//				sv.setId(resultSetObj.getInt("id"));
//				sv.setHodem(resultSetObj.getString("student_hodem"));
//				sv.setTen(resultSetObj.getString("student_ten"));
//				sv.setNamsinh(resultSetObj.getString("student_namsinh"));
//				sv.setGioitinh(resultSetObj.getString("student_gioitinh"));
//				sv.setEmail(resultSetObj.getString("student_email"));
//				sv.setDienthoai(resultSetObj.getString("student_dienthoai"));
//				sv.setDiachi(resultSetObj.getString("student_diachi"));
//				sv.setLop(resultSetObj.getString("student_lop"));
//				listSinhvien.add(sv);
//			}
//			connObj.close();
//		} catch (Exception sqlException) {
//			sqlException.printStackTrace();
//		}
//		return listSinhvien;
//	}

	public static String addSvInDB(SinhVienBean newSinhvien) {
		int saveResult = 0;
		String navigationResult = "";
		try {
			pstmt = getConnection().prepareStatement(
					"INSERT INTO student ( student_hodem, student_ten, student_namsinh, student_gioitinh, student_email, student_dienthoai,student_diachi, student_lop) VALUES (?,?,?,?,?,?,?,?)");
			pstmt.setString(1, newSinhvien.getHodem());
			pstmt.setString(2, newSinhvien.getTen());
			pstmt.setString(3, newSinhvien.getNamsinh());
			pstmt.setString(4, newSinhvien.getGioitinh());
			pstmt.setString(5, newSinhvien.getEmail());
			pstmt.setString(6, newSinhvien.getDienthoai());
			pstmt.setString(7, newSinhvien.getDiachi());
			pstmt.setString(8, newSinhvien.getLop());
			saveResult = pstmt.executeUpdate();
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		if (saveResult != 0) {
			navigationResult = "listSinhvien.xhtml?faces-redirect=true";
		} else {
			navigationResult = "addSinhvien.xhtml?faces-redirect=true";
		}
		return navigationResult;
	}

	public static String editSvInDB(int studentId) {
		SinhVienBean editSinhvien = null;
		Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		try {
			stmtObj = getConnection().createStatement();
			resultSetObj = stmtObj.executeQuery("select * from student where id = " + studentId);
			if (resultSetObj != null) {
				resultSetObj.next();
				editSinhvien = new SinhVienBean();
				editSinhvien.setId(resultSetObj.getInt("id"));
				editSinhvien.setHodem(resultSetObj.getString("student_hodem"));
				editSinhvien.setTen(resultSetObj.getString("student_ten"));
				editSinhvien.setNamsinh(resultSetObj.getString("student_namsinh"));
				editSinhvien.setGioitinh(resultSetObj.getString("student_gioitinh"));
				editSinhvien.setEmail(resultSetObj.getString("student_email"));
				editSinhvien.setDienthoai(resultSetObj.getString("student_dienthoai"));
				editSinhvien.setDiachi(resultSetObj.getString("student_diachi"));
				editSinhvien.setLop(resultSetObj.getString("student_lop"));
			}
			sessionMapObj.put("editSinhvien", editSinhvien);
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/editSinhvien.xhtml?faces-redirect=true";
	}

	public static String updateSvInDB(SinhVienBean updateStudentObj) {
		try {
			pstmt = getConnection().prepareStatement(
					"update student set student_hodem=?, student_ten=?, student_namsinh=?, student_gioitinh=?, student_email=?, student_dienthoai=?, student_diachi=?, student_lop=? where id=?");
			pstmt.setString(1, updateStudentObj.getHodem());
			pstmt.setString(2, updateStudentObj.getTen());
			pstmt.setString(3, updateStudentObj.getNamsinh());
			pstmt.setString(4, updateStudentObj.getGioitinh());
			pstmt.setString(5, updateStudentObj.getEmail());
			pstmt.setString(6, updateStudentObj.getDienthoai());
			pstmt.setString(7, updateStudentObj.getDiachi());
			pstmt.setString(8, updateStudentObj.getLop());
			pstmt.setInt(9, updateStudentObj.getId());
			pstmt.executeUpdate();
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/listSinhvien.xhtml?faces-redirect=true";
	}

	public static String deleteSvInDB(int studentId) {
			try {
				pstmt = getConnection().prepareStatement("delete from student where id = " + studentId);
				pstmt.executeUpdate();
				connObj.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "/listSinhvien.xhtml?faces-redirect=true";
	}

	public static List<SinhVienBean> getRecords(int fromIndex, int records) {
		List<SinhVienBean> sinhVienList = new ArrayList<SinhVienBean>();
		try {
			PreparedStatement ps = getConnection().prepareStatement("select * from student limit " + fromIndex + "," + records);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				SinhVienBean e = new SinhVienBean();		
				e.setId(rs.getInt("id"));
				e.setHodem(rs.getString("student_hodem"));
				e.setTen(rs.getString("student_ten"));
				e.setNamsinh(rs.getString("student_namsinh"));
				e.setGioitinh(rs.getString("student_gioitinh"));
				e.setEmail(rs.getString("student_email"));
				e.setDienthoai(rs.getString("student_dienthoai"));
				e.setDiachi(rs.getString("student_diachi"));
				e.setLop(rs.getString("student_lop"));
				sinhVienList.add(e);
			}
			ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return sinhVienList;
	}

	public int count() throws SQLException {
		int count = 0;
		pstmt = getConnection().prepareStatement("select count(id) from student" );
		resultSetObj = pstmt.executeQuery();
		

		while (resultSetObj.next()) {
			count = resultSetObj.getInt("count(id)");
		}
		connObj.close();
		return count;
	}

}
