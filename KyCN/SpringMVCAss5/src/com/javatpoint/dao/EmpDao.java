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


public int countStudent() {
	String sql = "SELECT COUNT(*) FROM Emp99";
	return template.queryForObject(sql, Integer.class);
}

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}
public int save(Emp p){
	String sql="insert into Emp99(name,ngaysinh,lop,image) values('"+p.getName()+"','"+p.getNgaySinh()+"','"+p.getLop()+"','"+p.getImage()+"')";
	return template.update(sql);
}

public int update(Emp p){
	String sql="update Emp99 set name='"+p.getName()+"', ngaysinh='"+p.getNgaySinh()+"', lop='"+p.getLop()+"', image='"+p.getImage()+"' where id="+p.getId()+"";
	return template.update(sql);
}
public int delete(int id){
	String sql="delete from Emp99 where id="+id+"";
	return template.update(sql);
}
public Emp getEmpById(int id){
	String sql="select * from Emp99 where id=?";
	return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));
}

public List<Emp> getEmployees(int start, int limit){  
    String sql="select * from emp99 limit "+start+","+limit;  
    return template.query(sql,new RowMapper<Emp>(){  
        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
            Emp e=new Emp();  
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
			e.setNgaySinh(rs.getString(3));
			e.setLop(rs.getString(4)); 
			e.setImage(rs.getString(5)); 
            return e;  
        }  
    });  
}  
}
