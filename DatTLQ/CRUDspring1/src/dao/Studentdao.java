package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entity.Student;

public class Studentdao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Student> getStudent() {
		return template.query("select * from SVSpring", new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student sv= new Student();
				sv.setId(rs.getString(1));
				sv.setTenSV(rs.getString(2));
				sv.setNamSinh(rs.getString(3));
				sv.setEmail(rs.getString(4));
				sv.setDiaChi(rs.getString(5));
				sv.setLopHoc(rs.getString(6));
				return sv;
			}
		});

	}
	public Student getStudentByID(int id) {
	    String sql="select * from SVSpring where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));  

	}
	public int update(Student sv){  
	    String sql="update SVSpring set Tensv='"+sv.getTenSV()+"', Namsinh='"+sv.getNamSinh()+"', Email= '"+sv.getEmail()+"',Diachi ='"+sv.getDiaChi()+"',"
	    		+ "Lophoc='"+sv.getLopHoc()+"' where id="+sv.getId()+"";  
	    return template.update(sql);  
	}  
	public int delete(int id){  
	    String sql="delete from SVSpring where id="+id+"";  
	    return template.update(sql);  
	} 
	public int save(Student sv){  
	    String sql="insert into SVSpring(Tensv,Namsinh,Email,Diachi,LopHoc	)   "
	         + "values('"+sv.getTenSV()+"',"+sv.getNamSinh()+",'"+sv.getEmail()+"','"+sv.getDiaChi()+"','"+sv.getLopHoc()+"')";  
	    return template.update(sql);  
	}  
}
