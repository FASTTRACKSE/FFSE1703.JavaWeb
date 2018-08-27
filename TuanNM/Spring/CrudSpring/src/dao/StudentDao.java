package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entity.Student;

public class StudentDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Student> getStudent(int start,int total) {

		return template.query("SELECT * FROM studentplus limit "+start+","+total+"", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs,int row) throws SQLException {
				Student st = new Student();
				st.setCode(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setBirthYear(rs.getString(3));
				st.setEmail(rs.getString(4));
				st.setAddress(rs.getString(5));
				st.setClassSv(rs.getString(6));
				st.setAvatar(rs.getString(7));
				return st;
			}
		});
	}
	
	public int countStudent() {
	    String sql = "SELECT count(*) FROM studentplus";
		int count = template.queryForObject(sql, Integer.class);	
		return count;
	  }

	public int insert(Student st,String avatar) {
		System.out.println(avatar);
		String sql = "insert into studentplus values('0','" + st.getName() + "','" + st.getBirthYear() + "','"
				+ st.getAddress() + "','" + st.getEmail() + "','" + st.getClassSv() + "','"+avatar+"')";
		return template.update(sql);
	}

	public int delete(int code) {
		String sql = "DELETE FROM `studentplus` WHERE code = '" + code + "'";
		return template.update(sql);
	}
	public Student getStudentById(int code) {
		String sql = "select * from Studentplus where code = ?";
		return template.queryForObject(sql, new Object[] { code }, new BeanPropertyRowMapper<Student>(Student.class));
	}

	public int updateStudent(Student st) {
		String sql = "UPDATE Studentplus SET name='" + st.getName() + "',birthyear = '" + st.getBirthYear() + "'"
				+ ",address='" + st.getAddress() + "',email = '" + st.getEmail() + "',class = '" + st.getClassSv()
				+ "'where code = '" + st.getCode() + "'";         
		return template.update(sql);
	}
}
