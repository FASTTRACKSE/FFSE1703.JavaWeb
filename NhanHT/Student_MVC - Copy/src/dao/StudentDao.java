package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import beans.Student;

public class StudentDao {
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	public List<Student> getStudent(){  
	    return template.query("select * from SinhVien",new RowMapper<Student>(){  
	        public Student mapRow(ResultSet rs, int row) throws SQLException {  
	            Student e=new Student(); 
	            e.setId(rs.getString(1));
	            e.setMaSv(rs.getString(2));
	            e.setTenSv(rs.getString(3));
	            e.setNamSinh(rs.getString(4));
	            e.setEmail(rs.getString(5));
	            e.setDiaChi(rs.getString(6));
	            e.setLopHoc(rs.getString(7));
	            return e;  
	        }  
	    });
	}
	public int save(Student p){  
	    String sql="insert into SinhVien(MaSv,TenSv,NamSinh,Email,DiaChi,LopHoc) values('"+p.getMaSv()+"','"+p.getTenSv()+"','"+p.getNamSinh()+"','"+p.getEmail()+"','"+p.getDiaChi()+"','"+p.getLopHoc()+"')";  
	    return template.update(sql);  
	}  
	public int delete(int id){  
	    String sql="delete from SinhVien where id="+id+"";  
	    return template.update(sql);  
	}
	public Student getStudentId(int id){  
	    String sql="select * from SinhVien where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));  
	}  
	public int update(Student p){  
	    String sql="update SinhVien set MaSv='"+p.getMaSv()+"', TenSv='"+p.getTenSv()+"', NamSinh='"+p.getNamSinh()+"', Email='"+p.getEmail()+"', DiaChi='"+p.getDiaChi()+"', LopHoc='"+p.getLopHoc()+"' where id='"+p.getId()+"'";  
	    return template.update(sql);  
	}  
}
