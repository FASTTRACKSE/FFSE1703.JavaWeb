package vn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import vn.model.Student;

public class StudentDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Student p) {
		String sql = "insert into student(masv,name,lop,email,address,age, author)" + " values('" + p.getMasv() + "','"
				+ p.getName() + "','" + p.getLop() + "','" + p.getEmail() + "','" + p.getAddress() + "'," + p.getAge() + ",'"
				+ p.getAuthor() + "')";
	
		return template.update(sql);
	}

	public int update(Student p) {
		String sql = "update student set masv='"+p.getMasv()+"', name='" + p.getName() + "', lop='" + p.getLop()
				+ "', email='" + p.getEmail() + "', address='" + p.getAddress() + "', age=" + p.getAge() + " , author='"
				+ p.getAuthor() + "' where id=" + p.getId() + "";
		System.out.println(sql);
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from student where id=" + id + "";
		return template.update(sql);
	}

	public Student getEmpById(int id) {
		String sql = "select * from student where id=?";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Student>(Student.class));
	}

	public List<Student> getEmployees() {
		return template.query("select * from student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student e = new Student();
				e.setId(rs.getInt(1));
				e.setMasv(rs.getString(2));
				e.setName(rs.getString(3));
				e.setLop(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setAddress(rs.getString(6));
				e.setAge(rs.getInt(7));
				e.setAuthor(rs.getString(8));
				return e;
			}
		});
	}
}
