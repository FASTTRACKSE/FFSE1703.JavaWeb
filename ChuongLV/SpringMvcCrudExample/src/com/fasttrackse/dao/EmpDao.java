package com.fasttrackse.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.*;

import com.fasttrackse.beans.Emp;

public class EmpDao {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}
public int save(Emp p){
	String sql="insert into users_spring (id,name,address,lop,image) values('"+p.getId()+"','"+p.getName()+"','"+p.getAddress()+"','"+p.getLop()+"', '"+p.getImage()+"')";
	return template.update(sql);
}
public int update(Emp p){
	String sql="update users_spring set id='"+p.getId()+"', name='"+p.getName()+"', address='"+p.getAddress()+"', lop='"+p.getLop()+"', image='"+p.getImage()+"' where id="+p.getId()+"";
	return template.update(sql);
}
public int delete(int id){
	String sql="delete from users_spring where id="+id+"";
	return template.update(sql);
}
public Emp getEmpById(int id){
	String sql="select * from users_spring where id=?";
	return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));
}
public List<Emp> getEmployees(int start,int total){
	return template.query("select * from users_spring limit "+ start +","+ total +"",new RowMapper<Emp>(){
		public Emp mapRow(ResultSet rs, int row) throws SQLException {
			Emp e=new Emp();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setAddress(rs.getString(3));
			e.setLop(rs.getString(4));
			e.setImage(rs.getString(5));
			return e;
		}
	});
}

public int countSV() throws SQLException {
	String sql="select count(*) from users_spring";
	return template.queryForObject(sql, Integer.class);
}
}