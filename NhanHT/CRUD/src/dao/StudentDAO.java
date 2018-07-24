package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import bean.StudentBean;
import controller.StudentController;

public class StudentDAO {
	final static Connection conn = ConnectDB.getConnect("localhost", "admin", "admin", "admin");
	public static ArrayList<StudentController> studentList = new ArrayList<>();
	public static ArrayList<StudentBean> studentCrud = new ArrayList<>();

	public ArrayList<StudentBean> getStudentsListFromDB(int start,int end) throws SQLException {
		studentCrud.clear();
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("select * from Student LIMIT " + start + ", " + end + "");
		while (result.next()) {
			StudentBean stu = new StudentBean();
			stu.setId(result.getInt("id"));
			stu.setHoDem(result.getString("HoDem"));
			stu.setTen(result.getString("Ten"));
			stu.setNamSinh(result.getString("NamSinh"));
			stu.setGioiTinh(result.getString("GioiTinh"));
			stu.setEmail(result.getString("Email"));
			stu.setDienThoai(result.getString("DienThoai"));
			stu.setDiaChi(result.getString("DiaChi"));
			stu.setLop(result.getString("Lop"));
			studentCrud.add(stu);
		}
		return studentCrud;
	}

	public String insertStudentDetailsInDB(StudentBean stu) {
	
		int insertResult = 0;
		String navigationResult = "";
		try {
			String sql = "insert into Student(HoDem,Ten,NamSinh,GioiTinh,Email,DienThoai,DiaChi,Lop) values (?,?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, stu.getHoDem());
			st.setString(2, stu.getTen());
			st.setString(3, stu.getNamSinh());
			st.setString(4, stu.getGioiTinh());
			st.setString(5, stu.getEmail());
			st.setString(6, stu.getDienThoai());
			st.setString(7, stu.getDiaChi());
			st.setString(8, stu.getLop());
			insertResult = st.executeUpdate();
			studentCrud.clear();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (insertResult > 0) {
			System.out.println("Thêm Thành Công !!");
			navigationResult = "index.xhtml?faces-redirect=true";
		} else {
			System.out.println("Thêm Thất Bại");
			navigationResult = "createStudent.xhtml?faces-redirect=true";
		}
		return navigationResult;
	}

	public String deleteStudentRecordInDB(int studentId) {
		System.out.println("deleteStudentRecordInDB() : Student Id: " + studentId);
		try {
			Statement statement = conn.createStatement();
			String sql = "delete from Student where id = " + studentId;
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				System.out.println("Xoa Thanh Cong !!");
			} else {
				System.out.println("Xoa That Bai !!");
			}
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "index.xhtml";
	}

	public String editStudentRecordInDB(int idst) throws SQLException {

		StudentBean sv = null;
		Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String sql = "SELECT * FROM Student WHERE id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, idst);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			int id = resultSet.getInt("id");
			String hoDem = resultSet.getString("HoDem");
			String ten = resultSet.getString("Ten");
			String namSinh = resultSet.getString("NamSinh");
			String gioiTinh = resultSet.getString("GioiTinh");
			String email = resultSet.getString("Email");
			String dienThoai = resultSet.getString("DienThoai");
			String diaChi = resultSet.getString("DiaChi");
			String lop = resultSet.getString("Lop");

			sv = new StudentBean(id,hoDem, ten, namSinh, gioiTinh, email, dienThoai, diaChi, lop);
			sessionMapObj.put("editRecordObj", sv);
		}

		return "editStudent.xhtml";
	}
	public String updateStudentDetailsInDB(StudentBean updateStudentObj) throws SQLException {
		
		String sql = "UPDATE Student SET HoDem = ?, Ten = ?,NamSinh = ?,GioiTinh = ?, Email = ?,DienThoai = ?,DiaChi = ?,Lop = ?";
		sql += " WHERE id = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, updateStudentObj.getHoDem());
		statement.setString(2, updateStudentObj.getTen());
		statement.setString(3, updateStudentObj.getNamSinh());
		statement.setString(4, updateStudentObj.getGioiTinh());
		statement.setString(5, updateStudentObj.getEmail());
		statement.setString(6, updateStudentObj.getDienThoai());
		statement.setString(7, updateStudentObj.getDiaChi());
		statement.setString(8, updateStudentObj.getLop());
		statement.setInt(9, updateStudentObj.getId());
		statement.executeUpdate();
		
		
		
		return "index.xhtml";
	}
	public double countSv() throws SQLException {
		double total = 0;
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM Student");
		while (result.next()) {
			total = result.getDouble("COUNT(*)");
		}
		return total;

	}
}
