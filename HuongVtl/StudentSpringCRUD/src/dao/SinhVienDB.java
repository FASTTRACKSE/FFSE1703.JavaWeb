package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import bean.SinhVien;

public class SinhVienDB {
	static JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    SinhVienDB.template = template;  
	}  
	
	public List<SinhVien> listSinhVien(){  
	  return template.query(("select * from sinhvien"), new RowMapper<SinhVien>() {
		  public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien sv = new SinhVien();
				
				sv.setId(rs.getInt("id"));
				sv.setMaSv(rs.getString("masv"));
				sv.setTenSv(rs.getString("tensv"));
				sv.setNamSinh(rs.getString("nam_sinh"));
				sv.setDiaChi(rs.getString("diachi"));
				sv.setEmail(rs.getString("email"));
				sv.setLop(rs.getString("lop"));
				
				return sv;
		  }	
	  });
	}
	public int save(SinhVien p){  
	    String sql="insert into sinhvien (masv,tensv,nam_sinh,email,diachi,lop)values('"+p.getMaSv()+"','"+p.getTenSv()+"','"+p.getNamSinh()+"','"+p.getEmail()+"','"+p.getDiaChi()+"','"+p.getLop()+"')";  
	    return template.update(sql);  
	} 
	
	public SinhVien edit(int id){  
	    String sql="select * from sinhvien where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<SinhVien>(SinhVien.class));  
	} 
	
	public int update(SinhVien sv){  
	    String sql="update sinhvien set masv='"+sv.getMaSv()+"',tensv='"+sv.getTenSv()+"',nam_sinh='"+sv.getNamSinh()+"',email='"+sv.getEmail()+"', diaChi='"+sv.getDiaChi()+"', lop='"+sv.getLop()+"'";  
	    return template.update(sql);  
	}

	public int delete(int id){  
	    String sql="delete from sinhvien where id="+id+"";  
	    return template.update(sql);  
	}   
}
