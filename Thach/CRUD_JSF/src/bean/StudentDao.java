package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

public class StudentDao {
	// kết nối Database
	private String jdbcURL = "jdbc:mysql://localhost:3306/ffse1703011_qlsv2?useUnicode=true&characterEncoding=utf-8";
	private String jdbcUsername = "ducthach1999";
	private String jdbcPassword = "123456";
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

	ArrayList<Student_Bean> arrStudentDB = new ArrayList<>();
	double total;

	public ArrayList<Student_Bean> studentList(int start, int end) {
		arrStudentDB.clear();
		try {
			connect();
			String sql = "select * from quanlysinhvien2 limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String hoDem = result.getString("Ho_dem");
				String Ten = result.getString("ten");
				String namSinh = result.getString("namsinh");
				String gioiTinh = result.getString("gioitinh");
				String email = result.getString("email");
				String dienThoai = result.getString("sdt");
				String diaChi = result.getString("diachi");
				String maLop = result.getString("lop");

				arrStudentDB.add(new Student_Bean(id, hoDem, Ten, namSinh, gioiTinh, email, dienThoai, diaChi, maLop));
			}
			disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrStudentDB;
	}

	public void delete(int id) {
		try {
			connect();
			String sql = "delete from quanlysinhvien2 where id= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(Student_Bean student) throws SQLException {
		connect();
		String sql = "INSERT INTO quanlysinhvien2 ( ho_dem, ten, namsinh, gioitinh, email, sdt, diachi, lop) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, student.getHoDem());
		ps.setString(2, student.getTen());
		ps.setString(3, student.getNamSinh());
		ps.setString(4, student.getGioiTinh());
		ps.setString(5, student.getEmail());
		ps.setString(6, student.getSdt());
		ps.setString(7, student.getDiaChi());
		ps.setString(8, student.getMaLop());
		ps.executeUpdate();
		disconnect();

	}

	public int checkExist(String maSt) {
		int exist = 0;
		try {
			connect();
			String sql = "select count(*) from quanlysinhvien2 where id= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maSt);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				exist = result.getInt("COUNT(*)");
			}
			disconnect();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return exist;
	}

	public Student_Bean getEditRecord(int id) throws SQLException {
		connect();
		Student_Bean editRecord = new Student_Bean();

		String sql = "SELECT * FROM quanlysinhvien2 WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, id);

		ResultSet result = ps.executeQuery();

		while (result.next()) {
			editRecord.setHoDem(result.getString("ho_dem"));
			editRecord.setTen(result.getString("ten"));
			editRecord.setNamSinh(result.getString("namsinh"));
			editRecord.setGioiTinh(result.getString("gioitinh"));
			editRecord.setEmail(result.getString("email"));
			editRecord.setSdt(result.getString("sdt"));
			editRecord.setDiaChi(result.getString("diachi"));
			editRecord.setMaLop(result.getString("lop"));

		}
		disconnect();
		return editRecord;
	}

	public void update(Student_Bean student) throws SQLException {
		connect();
		String sql = "UPDATE quanlysinhvien2 SET ho_dem = ?, ten = ?, namsinh = ?, gioitinh = ?, email = ?, sdt = ?, diachi = ?, lop = ?";
		sql += " WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, student.getHoDem());
		ps.setString(2, student.getTen());
		ps.setString(3, student.getNamSinh());
		ps.setString(4, student.getGioiTinh());
		ps.setString(5, student.getEmail());
		ps.setString(6, student.getSdt());
		ps.setString(7, student.getDiaChi());
		ps.setString(8, student.getMaLop());

		ps.executeUpdate();
		disconnect();
	}

	public double count() {
		try {
			connect();
			String sql = "select count(*) from quanlysinhvien2";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				total = result.getDouble("COUNT(*)");

			}
			disconnect();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return total;
	}
}
