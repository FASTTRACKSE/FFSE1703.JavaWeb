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

import assignment5.bean.SinhVien;

public class SinhVienDao {
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}
	public List<SinhVien> listSinhVien(int start, int end){  
	    return template.query("select * from quanlysinhvien2 limit ?,?",new Object[]{start, end} ,new RowMapper<SinhVien>(){  
	        /* (non-Javadoc)
	         * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	         */
	        public SinhVien mapRow(ResultSet rs, int row) throws SQLException {  
	            SinhVien sv=new SinhVien();   
	            sv.setMaSv(rs.getString(2));  
	            sv.setTen(rs.getString(3));  
	            sv.setNamSinh(rs.getString(4));
	            sv.setEmail(rs.getString(5)); 
	            sv.setSdt(rs.getString(6)); 
	            sv.setDiaChi(rs.getString(7));
	            sv.setLop(rs.getString(8)); 
	            sv.setHinhAnh(rs.getString(9));
	            return sv;  
	        }  
	    });  
	} 
	
	public void delete(String maSv) {
		String sql="delete from quanlysinhvien2 where ma_sv= ?" ;
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, maSv);
				return ps.execute(); // bollean
			}
		});
	}
	
	public SinhVien getEdit(String maSv) {
		String sql="select * from quanlysinhvien2 where ma_sv= ?" ;
		return template.queryForObject(sql, new Object[]{maSv}, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));  
	}
	
	public void update(final SinhVien sv) {
		String sql="update quanlysinhvien2 set ten= ?, namsinh= ?, email= ?, sdt= ?, diachi= ?, lop= ?, hinhanh= ? where ma_sv= ?";
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, sv.getTen());
				ps.setString(2, sv.getNamSinh());
				ps.setString(3, sv.getEmail());
				ps.setString(4, sv.getSdt());
				ps.setString(5, sv.getDiaChi());
				ps.setString(6, sv.getLop());
				ps.setString(7, sv.getHinhAnh());
				ps.setString(8, sv.getMaSv());
//				System.out.println("ma lop" + sv.getMaLop());
				return ps.execute(); // bollean
			}
		});
	}
	
	public void insert(SinhVien sv) {
		String sql="insert into quanlysinhvien2 (ma_sv, ten, namsinh, email, sdt, diachi, lop, hinhanh) value (?, ?, ?, ?, ?, ?, ?, ?)";
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, sv.getMaSv());
				ps.setString(2, sv.getTen());
				ps.setString(3, sv.getNamSinh());
				ps.setString(4, sv.getEmail());
				ps.setString(5, sv.getSdt());
				ps.setString(6, sv.getDiaChi());
				ps.setString(7, sv.getLop());
				ps.setString(8, sv.getHinhAnh());
				return ps.execute(); // bollean
			}
		});
	}
	
	public int checkExistMaSv(String maSv) {
		String sql = "select count(*) from quanlysinhvien2 WHERE ma_sv = ?";

        int count = template.queryForObject(sql, new Object[] { maSv }, Integer.class);
        return count;
	}
	
	public double totalRecord() {
		String sql = "select count(*) from quanlysinhvien2";
		
		double total = template.queryForObject(sql, Double.class);
		return total;
	}
	
}
