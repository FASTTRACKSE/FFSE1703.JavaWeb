package fasttrackse.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.*;

import fasttrackse.beans.Emp;

public class EmpDao {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}
public int save(Emp p){
	String sql="insert into Emp99(ten,tuoi,lop,diachi) values('"+p.getTen()+"','"+p.getTuoi()+"','"+p.getLop()+"','"+p.getDiachi()+"')";
	return template.update(sql);
}
public int update(Emp p){
	String sql="update Emp99 set ten='"+p.getTen()+"', tuoi='"+p.getTuoi()+"', lop='"+p.getLop()+"', diachi='"+p.getDiachi()+"' where id="+p.getId()+"";
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
public List<Emp> getEmployees(int start,int total){
	return template.query("select * from Emp99 limit "+ start +","+ total +"",new RowMapper<Emp>(){
		public Emp mapRow(ResultSet rs, int row) throws SQLException {
			Emp e=new Emp();
			e.setId(rs.getInt(1));
			e.setTen(rs.getString(2));
			e.setTuoi(rs.getString(3));
			e.setLop(rs.getString(4));
			e.setDiachi(rs.getString(5));
			return e;
		}
	});
}

public int countSV() throws SQLException {
	String sql="select count(*) from Emp99";
	return template.queryForObject(sql, Integer.class);
}
}
