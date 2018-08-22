package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import entity.SinhVien;

public class SinhVienDao {
	JdbcTemplate template;  
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<SinhVien> getSinhVien(){  
	    return template.query("select * from sinhvien",new RowMapper<SinhVien>(){  
	        public SinhVien mapRow(ResultSet rs, int row) throws SQLException {  
	            SinhVien sv=new SinhVien();  
	            sv.setMaSv(rs.getString("maSv"));
	            sv.setTenSv(rs.getString("tenSv"));
	            sv.setNamSinh(rs.getInt("namSinh"));
	            sv.setEmail(rs.getString("email"));
	            sv.setSoDt(rs.getString("soDt"));
	            sv.setDiaChi(rs.getString("diaChi"));
	            sv.setLop(rs.getString("lop"));
	            sv.setId(rs.getInt("id"));
	            return sv;  
	        }  
	    });  
	} 
	
	
	public void addSinhVien(final SinhVien std) {
		String sql="insert into sinhvien (maSv,tenSv, namSinh, email,soDt,diaChi,lop) values (?, ?, ?, ?, ?,?,?)";
		template.execute(sql,  new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, std.getMaSv());
				ps.setString(2, std.getTenSv());
				ps.setInt(3, std.getNamSinh());
				ps.setString(4, std.getEmail());;
				ps.setString(5, std.getSoDt());
				ps.setString(6, std.getDiaChi());
				ps.setString(7, std.getLop());
				return ps.execute();
			}
		});
	}
	public SinhVien getStudentId(int id){  
	    String sql="select * from sinhvien where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<SinhVien>(SinhVien.class));  
	}  
	
	public void update(final SinhVien sv) {
		String sql="update sinhvien set tenSV = ?, namSinh = ?, email = ?,soDt = ?,diaChi = ?,lop= ? where id = ?";
		template.execute(sql,  new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, sv.getTenSv());
				ps.setInt(2, sv.getNamSinh());
				ps.setString(3, sv.getEmail());
				ps.setString(4, sv.getSoDt());
				ps.setString(5, sv.getDiaChi());
				ps.setString(6, sv.getLop());	
				ps.setInt(7, sv.getId());
				return ps.execute();
			}
		});
	}
	
	public int delete(int id){  
	    String sql="delete from sinhvien where id="+id+"";  
	    return template.update(sql);  
	}  
}
