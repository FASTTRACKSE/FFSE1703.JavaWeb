package com.javatpoint.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.javatpoint.beans.Emp;  
  
public class EmpDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Emp p){  
    String sql="INSERT INTO emp99( maSV, tenSV, namSinh, Email, diaChi, lopHoc, avatar) VALUES ('"+ p.getMaSV() +"','"+ p.getTenSV() +"',"+ p.getNamSinh() +",'"+ p.getEmail() +"','"+ p.getDiaChi() +"','"+ p.getLopHoc() +"','"+ p.getAvatar() +"')";  
    return template.update(sql);  
}  
public int update(Emp p){  
    String sql="UPDATE emp99 SET maSV='"+ p.getMaSV() +"',tenSV='"+ p.getTenSV() +"',namSinh="+ p.getNamSinh() +",Email='"+ p.getEmail() +"',diaChi='"+ p.getDiaChi() +"',lopHoc='"+ p.getLopHoc() +"',avatar='"+  p.getAvatar() +"' WHERE id="+ p.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from emp99 where id="+id+"";  
    return template.update(sql);  
}  
public Emp getEmpById(int id){  
    String sql="select * from emp99 where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
} 
public List<Emp> getSVbyPage(int start,int total){
	String sql="select * from emp99 limit "+start+","+total+"";
	return template.query(sql,new RowMapper<Emp>(){
		public Emp mapRow(ResultSet rs,int row) throws SQLException {
			Emp sv = new Emp();
			sv.setId(rs.getInt("id"));
			sv.setMaSV(rs.getInt("maSV"));
			sv.setTenSV(rs.getString("tenSV"));
			sv.setNamSinh(rs.getString("namSinh"));
			sv.setEmail(rs.getString("Email"));
			sv.setDiaChi(rs.getString("diaChi"));
			sv.setLopHoc(rs.getString("lopHoc"));
			sv.setAvatar(rs.getString("avatar"));
			
			return sv;
		}
	});
}
public int countSV() throws SQLException {
	String sql="select count(*) from emp99";
	return template.queryForObject(sql, Integer.class);
}
public List<Emp> getEmployees(){  
    return template.query("select * from emp99",new RowMapper<Emp>(){  
        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
            Emp e=new Emp();  
            e.setId(rs.getInt(1));  
            e.setMaSV(rs.getInt(2));  
            e.setTenSV(rs.getString(3));  
            e.setNamSinh(rs.getString(4)); 
            e.setEmail(rs.getString(5));  
            e.setDiaChi(rs.getString(6));  
            e.setLopHoc(rs.getString(7));
            e.setAvatar(rs.getString(8));
            return e;  
        }  
    });  
}  
}  