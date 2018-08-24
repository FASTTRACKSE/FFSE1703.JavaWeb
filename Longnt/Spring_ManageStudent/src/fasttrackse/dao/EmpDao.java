package fasttrackse.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import fasttrackse.entity.Student;  
 
public class EmpDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  

}
 public List<Student> getAllStudent(int pageid,int total){
	 String sql = "SELECT * FROM student limit " + pageid + "," + total;
	 return template.query(sql, new ResultSetExtractor<List<Student>>(){
			@Override
		 public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
			 List<Student> list = new ArrayList<Student>();
			 
				while (rs.next()) {
					Integer maSV = rs.getInt("masv");
					String tenSV = rs.getString("tensv");
					String tuoiSV = rs.getString("tuoisv");
					String email = rs.getString("email");
					String diaChi = rs.getString("diachi");
					String lop = rs.getString("lop");
					String avatar = rs.getString("avatar");
					Student sv = new Student(maSV, tenSV, tuoiSV, email, diaChi, lop, avatar);
					list.add(sv);
				}
				return list;
			}
		});
	}

	
 public boolean insertStudent(Student sv) {
		String sql = "INSERT INTO student (masv,tensv,tuoisv,email,diachi,lop,avatar) VALUES(?,?,?,?,?,?,?)";
		return template.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, sv.getMaSV());
				ps.setString(2, sv.tenSV);
				ps.setString(3, sv.tuoiSV);
				ps.setString(4, sv.email);
				ps.setString(5, sv.diaChi);
				ps.setString(6, sv.lop);
				ps.setString(7, sv.avatar);

				return ps.execute();

			}
		});
	}

 public Student getStudent(String maSV) {
		String sql = "SELECT * FROM student WHERE masv = ?";
		return template.execute(sql, new PreparedStatementCallback<Student>() {

			@Override
			public Student doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				Student extSV = new Student();
				ps.setString(1, maSV);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Integer maSV = rs.getInt("masv");
					String tenSV = rs.getString("tensv");
					String namSinh = rs.getString("tuoisv");
					String email = rs.getString("email");
					String diaChi = rs.getString("diachi");
					String lopHoc = rs.getString("lop");
					String avatar = rs.getString("avatar");
					extSV = new Student(maSV, tenSV, namSinh, email, diaChi, lopHoc,avatar);
				}
				return extSV;
			}
		});	
	}
 public boolean updateStudent(Student sv) {
		String sql = "UPDATE student SET tensv = ?, tuoisv = ?, email = ?, diachi = ?, lop = ?, avatar = ? WHERE masv = ?";
		return template.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, sv.tenSV);
				ps.setString(2, sv.tuoiSV);
				ps.setString(3, sv.email);
				ps.setString(4, sv.diaChi);
				ps.setString(5, sv.lop);
				ps.setString(6, sv.avatar);
				ps.setInt(7, sv.maSV);

				return ps.execute();

			}
		});
	}

	public boolean deleteStudent(String maSV) {
		String sql = "DELETE FROM student WHERE masv = ? ";
		return template.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, maSV);

				return ps.execute();

			}
		});
	}
	public int countStudent() {
		String sql = "select count(*) from student";
		int intStudent = template.queryForObject(sql,Integer.class);  
		return intStudent;
	}
	
	public int check(int masv) {
		String sql = "select count(*) from student where masv = ?";
		int intStudent = template.queryForObject(sql,new Object[] { masv },Integer.class);  
		return intStudent;
	} 
}