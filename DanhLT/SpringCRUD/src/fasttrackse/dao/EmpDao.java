package fasttrackse.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import fasttrackse.beans.Emp;

public class EmpDao {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}
public int save(Emp p){
	String sql="insert into danhlt(masv,ten,tuoi,lop,diachi) values('"+p.getMasv()+"','"+p.getTen()+"','"+p.getTuoi()+"','"+p.getLop()+"','"+p.getDiachi()+"')";
	return template.update(sql);
}
public int update(Emp p){
	String sql="update danhlt set masv='"+p.getMasv()+"', ten='"+p.getTen()+"',tuoi='"+p.getTuoi()+"', lop='"+p.getLop()+"',diachi='"+p.getDiachi()+"' where id="+p.getId()+"";
	return template.update(sql);
}
public int delete(int id){
	String sql="delete from danhlt where id="+id+"";
	return template.update(sql);
}
public Emp getEmpById(int id){
	String sql="select * from danhlt where id=?";
	return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));
}
public List<Emp> getEmployees(){
	return template.query("select * from danhlt",new RowMapper<Emp>(){
		public Emp mapRow(ResultSet rs, int row) throws SQLException {
			Emp e=new Emp();
			e.setId(rs.getInt(1));
			e.setMasv(rs.getInt(2));
			e.setTen(rs.getString(3));
			e.setTuoi(rs.getInt(4));
			e.setLop(rs.getString(5));
			e.setDiachi(rs.getString(6));
			return e;
		}
	});
}
public List<Emp> getSVbyPage(int start,int total){
	String sql="select * from danhlt limit "+start+","+total+"";
	return template.query(sql,new RowMapper<Emp>(){
		public Emp mapRow(ResultSet rs,int row) throws SQLException {
			Emp sv = new Emp();
			sv.setId(rs.getInt("id"));
			sv.setMasv(rs.getInt("masv"));
			sv.setTen(rs.getString("ten"));
			sv.setTuoi(rs.getInt("tuoi"));
			sv.setDiachi(rs.getString("diachi"));
			sv.setLop(rs.getString("lop"));
			return sv;
		}
	});
}
public int countSV() throws SQLException {
	String sql="select count(*) from danhlt";
	return template.queryForObject(sql, Integer.class);
}
}
