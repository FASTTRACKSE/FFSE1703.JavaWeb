package bean.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.StudentBean;

@ManagedBean
@SessionScoped
public class studentDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/student";
	private String jdbcUsername = "tungtt";
	private String jdbcPassword = "12345";
	private Connection jdbcConnection;

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	// public List<StudentBean> getAllRecords() {
	// List<StudentBean> list = new ArrayList<StudentBean>();
	//
	// try {
	// connect();
	// PreparedStatement ps = jdbcConnection.prepareStatement("select * from
	// student_record");
	// ResultSet rs = ps.executeQuery();
	// while (rs.next()) {
	// StudentBean u = new StudentBean();
	// u.setId(rs.getInt("id"));
	// u.setName(rs.getString("name"));
	// u.setEmail(rs.getString("email"));
	// u.setPassword(rs.getString("password"));
	// u.setGender(rs.getString("gender"));
	// u.setAddress(rs.getString("address"));
	// list.add(u);
	// }
	// disconnect();
	// } catch (Exception e) {
	// System.out.println(e);
	// }
	// return list;
	// }

	public String addNew(StudentBean u) {
		int status = 0;
		try {
			connect();
			PreparedStatement ps = jdbcConnection.prepareStatement(
					"insert into student_record(name,email,password,gender,address) values(?,?,?,?,?)");

			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getGender());
			ps.setString(5, u.getAddress());
			status = ps.executeUpdate();
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		if (status != 0) {
			return "/index.xhtml?faces-redirect=true";
		} else {
			return "/create.xhtml?faces-redirect=true";
		}
	}

	public String getById(int Id) {
		StudentBean u = null;
		Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		try {
			connect();
			PreparedStatement ps = jdbcConnection.prepareStatement("select * from student_record where id=?");
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new StudentBean();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setGender(rs.getString("gender"));
				u.setAddress(rs.getString("address"));
			}
			sessionMapObj.put("editRecordObj", u);
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "/edit.xhtml?faces-redirect=true";
	}

	public String Update(StudentBean u) {
		PreparedStatement ps;
		try {
			connect();
			ps = jdbcConnection.prepareStatement(
					"update student_record set name=?,email=?,password=?,gender=?,address=? where id=?");
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getGender());
			ps.setString(5, u.getAddress());
			ps.setInt(6, u.getId());

			ps.executeUpdate();
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "/index.xhtml?faces-redirect=true";
	}

	public String delete(int Id) {
		try {
			connect();
			PreparedStatement ps = jdbcConnection.prepareStatement("delete from student_record where id=?");
			ps.setInt(1, Id);
			ps.executeUpdate();
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}

		return "/index.xhtml?faces-redirect=true";
	}

	public int countRecords() {
		try {
			connect();
			PreparedStatement ps = jdbcConnection.prepareStatement("select count(*) from student_record");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt("count(*)");
			disconnect();
			return count;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public List<StudentBean> getRecords(int fromIndex, int records) {
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			connect();
			PreparedStatement ps = jdbcConnection
					.prepareStatement("select * from student_record limit " + (fromIndex) + "," + records);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentBean u = new StudentBean();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setGender(rs.getString("gender"));
				u.setAddress(rs.getString("address"));
				list.add(u);
			}
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
