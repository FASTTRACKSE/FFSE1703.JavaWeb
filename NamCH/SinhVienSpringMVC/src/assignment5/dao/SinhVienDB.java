package assignment5.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;


import assignment5.entity.SinhVien;

public class SinhVienDB {
	JdbcTemplate template;  
	
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}
	
	public List<SinhVien> getStudent(int start,int end){  
	    return template.query("select * from sinhvien ORDER by id DESC limit "+start+","+end+" " ,new RowMapper<SinhVien>(){  
	        public SinhVien mapRow(ResultSet rs, int row) throws SQLException {  
	        	SinhVien std = new SinhVien();
				std.setId(rs.getInt("id"));
				std.setName(rs.getString("name"));
				std.setYear(rs.getInt("year"));
				std.setSex(rs.getString("sex"));
				std.setEmail(rs.getString("email"));
				std.setPhone(rs.getString("phone"));	
				std.setAdress(rs.getString("adress"));
				std.setClasses(rs.getString("classes"));				 
	            return std;  
	        }  
	    });  
	} 
	
	public SinhVien getStudentId(int id){  
	    String sql="select * from sinhvien where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<SinhVien>(SinhVien.class));  
	}  
	
	public void update(final SinhVien sv) {
		String sql="update sinhvien set name = ?, year = ?, sex = ?,email = ?,phone = ?,adress= ?,classes = ? where id = ?";
		template.execute(sql,  new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, sv.getName());
				ps.setInt(2, sv.getYear());
				ps.setString(3, sv.getSex());
				ps.setString(4, sv.getEmail());;
				ps.setString(5, sv.getPhone());
				ps.setString(6, sv.getAdress());
				ps.setString(7, sv.getClasses());	
				ps.setInt(8, sv.getId());
				return ps.execute();
			}
		});
	}
	public void add(final SinhVien std) {
		String sql="insert into sinhvien (name, year, sex, email,phone,adress,classes) values (?, ?, ?, ?, ?,?,?)";
		template.execute(sql,  new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement stm) throws SQLException, DataAccessException {
				stm.setString(1, std.getName());
				stm.setInt(2, std.getYear());
				stm.setString(3, std.getSex());
				stm.setString(4, std.getEmail());;
				stm.setString(5, std.getPhone());
				stm.setString(6, std.getAdress());
				stm.setString(7, std.getClasses());
				return stm.execute();
			}
		});
	}
	public int delete(int id){  
	    String sql="delete from sinhvien where id="+id+"";  
	    return template.update(sql);  
	} 
	public int count() {
		int result = template.queryForObject(
			    "SELECT COUNT(*) FROM sinhvien", Integer.class);
		return result;
	}
	
//	public Boolean update(SinhVien std){
//		
//		 String query="update sinhvien set name = ?, year = ?, sex = ?,email = ?,phone = ?,adress= ?,classes = ? where id = ?";  
//		    return template.execute(query,new PreparedStatementCallback<Boolean>(){  		    
//		    	
//			@Override
//			public Boolean doInPreparedStatement(java.sql.PreparedStatement stm)
//					throws SQLException, DataAccessException {
//				// TODO Auto-generated method stub
//				stm.setString(1, std.getName());
//				stm.setInt(2, std.getYear());
//				stm.setString(3, std.getSex());
//				stm.setString(4, std.getEmail());;
//				stm.setString(5, std.getPhone());
//				stm.setString(6, std.getAdress());
//				stm.setString(7, std.getClasses());	
//				stm.setInt(8, std.getId());	
//				System.out.println(stm.execute());
//				return stm.execute();  
//				
//			}  
//		    });    
//	}
}
