package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import entity.SinhVien;

public class SinhVienDao {
	JdbcTemplate template;
	

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<SinhVien> sinhVienList(int start, int end) {
		
		return template.query("select * from Sinh_vien order by Id DESC limit ?,?",new Object[]{start, end} ,new RowMapper<SinhVien>() {

			@Override
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien sv = new SinhVien();
				sv.setMaSv(rs.getString(2));
				sv.setHoTen(rs.getString(3));
				sv.setNamSinh(Integer.parseInt(rs.getString(4)) );
				sv.setQueQuan(rs.getString(5));
				sv.setEmail(rs.getString(6));
				sv.setDienThoai(Integer.parseInt(rs.getString(7)) );
				sv.setMaLop(rs.getString(8));
				sv.setHinhAnh(rs.getString(9));
				return sv;
			}
		});
	}
	
	public void delete(String maSv) {
		String sql="delete from Sinh_vien where Masv= ?" ;
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, maSv);
				return ps.execute(); // bollean
			}
		});
	}
	
	public SinhVien getEdit(String maSv) {
		String sql="select * from Sinh_vien where Masv= ?" ;
		return template.queryForObject(sql, new Object[]{maSv}, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));  
	}
	
	public void update(final SinhVien sv) {
		String sql="update Sinh_vien set Hoten= ?, Namsinh= ?, Quequan= ?, Email= ?, Dienthoai= ?, Malop= ?, Hinhanh= ? where Masv= ?";
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, sv.getHoTen());
				ps.setString(2, String.valueOf(sv.getNamSinh()) );
				ps.setString(3, sv.getQueQuan());
				ps.setString(4, sv.getEmail());
				ps.setString(5, String.valueOf(sv.getDienThoai()) );
				ps.setString(6, sv.getMaLop());
				ps.setString(7, sv.getHinhAnh());
				ps.setString(8, sv.getMaSv());
//				System.out.println("abx" + sv.getHinhAnh());
//				System.out.println("ma lop" + sv.getMaLop());
				return ps.execute(); // bollean
			}
		});
	}
	
	public void insert(SinhVien sv) {
		String sql="insert into Sinh_vien (Masv, Hoten, Namsinh, Quequan, Email, Dienthoai, Malop, Hinhanh) value (?, ?, ?, ?, ?, ?, ?, ?)";
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, sv.getMaSv());
				ps.setString(2, sv.getHoTen());
				ps.setString(3, String.valueOf(sv.getNamSinh()) );
				ps.setString(4, sv.getQueQuan());
				ps.setString(5, sv.getEmail());
				ps.setString(6, String.valueOf(sv.getDienThoai()) );
				ps.setString(7, sv.getMaLop());
				ps.setString(8, sv.getHinhAnh());
//				System.out.println("abx" + sv.getMaSv());
//				System.out.println("ma lop" + sv.getMaLop());
				return ps.execute(); // bollean
			}
		});
	}
	
	public int checkExistMaSv(String maSv) {
		String sql = "select count(*) from Sinh_vien WHERE Masv = ?";

        int count = template.queryForObject(sql, new Object[] { maSv }, Integer.class);
        return count;
	}
	
	public double totalRecord() {
		String sql = "select count(*) from Sinh_vien";
		
		double total = template.queryForObject(sql, Double.class);
		return total;
	}
}	
