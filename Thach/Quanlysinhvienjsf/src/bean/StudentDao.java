package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import connectdb.ConnectDb;

public class StudentDao {
	final static Connection conn = ConnectDb.getConnect("localhost", "ffse1703011_qlsv2", "ducthach1999", "123456");
	ArrayList<Student> arrStudent = new ArrayList<>();
	 double total;

	public static String addSt(Student St) throws SQLException {
		String rd = null;
		String sql = "INSERT INTO quanlysinhvien2 (ho_dem, ten, namsinh, gioitinh, email, sdt, diachi, lop) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, St.getHodem());
		pstm.setString(2, St.getTen());
		pstm.setString(3, St.getNamsinh());
		pstm.setString(4, St.getGioitinh());
		pstm.setString(5, St.getEmail());
		pstm.setString(6, St.getSdt());
		pstm.setString(7, St.getDiachi());
		pstm.setString(8, St.getLop());

		boolean rowInserted = pstm.executeUpdate() > 0;
		if (rowInserted == true) {
			rd = "index.xhtml";
		} else {
			rd = "addStudent.xhtml";
		}
		pstm.close();
		return rd;
	}

	public ArrayList<Student> listAllStudent(int start,int end) throws SQLException {
		arrStudent.clear();
		String sql = "SELECT * FROM quanlysinhvien2 limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet resultSet = ps.executeQuery();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			System.out.println("đay là id:" + id);
			String hodem = resultSet.getString("ho_dem");
			String ten = resultSet.getString("ten");
			String namsinh = resultSet.getString("namsinh");
			String gioitinh = resultSet.getString("gioitinh");
			String email = resultSet.getString("email");
			String sdt = resultSet.getString("sdt");
			String diachi = resultSet.getString("diachi");
			String lop = resultSet.getString("lop");

			Student St = new Student(id, hodem, ten, namsinh, gioitinh, email, sdt, diachi, lop);
			arrStudent.add(St);
		}

		return arrStudent;
	}

	public static String updateStudent(Student St) throws SQLException {
		String sql = "UPDATE quanlysinhvien2 SET ho_dem = ?, ten = ?, namsinh = ?, gioitinh = ?, email = ?, sdt = ?, diachi = ?, lop = ?";
		sql += " WHERE id = ?";

		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, St.getHodem());
		pstm.setString(2, St.getTen());
		pstm.setString(3, St.getNamsinh());
		pstm.setString(4, St.getGioitinh());
		pstm.setString(5, St.getEmail());
		pstm.setString(6, St.getSdt());
		pstm.setString(7, St.getDiachi());
		pstm.setString(8, St.getLop());
		pstm.setFloat(9, St.getId());
		pstm.executeUpdate();

		return "index?faces-redirect=true";
	}

	public static String editStudent(int id) throws SQLException {
		Student editSt = null;

		Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String sql = "SELECT * FROM quanlysinhvien2 WHERE id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);

		ResultSet resultSet = pstm.executeQuery();

		if (resultSet.next()) {
			int Id = resultSet.getInt("id");
			String hodem = resultSet.getString("ho_dem");
			String ten = resultSet.getString("ten");
			String namsinh = resultSet.getString("namsinh");
			String gioitinh = resultSet.getString("gioitinh");
			String email = resultSet.getString("email");
			String sdt = resultSet.getString("sdt");
			String diachi = resultSet.getString("diachi");
			String lop = resultSet.getString("lop");

			editSt = new Student(Id, hodem, ten, namsinh, gioitinh, email, sdt, diachi, lop);
			sessionMapObj.put("editRecord", editSt);

		}
		return "editStudent?faces-redirect=true";
	}

	public static String deleteStudent(int studentId) {
		try {
			String sql = "DELETE FROM quanlysinhvien2 where id =  " + studentId;
			PreparedStatement ps = conn.prepareStatement(sql);
			int x = ps.executeUpdate(sql);
			if (x > 0) {
				System.out.println("Xoa Thanh Cong !!");
			} else {
				System.out.println("Xoa That Bai !!");
			}
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "index?faces-redirect=true";
	}
	public double count() {
		try {
			String sql = "select count(*) from quanlysinhvien2";
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
