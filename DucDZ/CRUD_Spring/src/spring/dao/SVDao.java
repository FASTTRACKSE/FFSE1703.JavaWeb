package spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.entity.SinhVien;

public class SVDao {
	static JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		SVDao.template = template;
	}

	public static int save(SinhVien sv,String filename) {
		int masv = sv.getMa_sv();
		String hoten = sv.getHo_ten();
		String namsinh = sv.getNam_sinh();
		String email = sv.getEmail();
		String diachi = sv.getDia_chi();
		String lophoc = sv.getLop_hoc();
		String file = filename;
		String descrip = sv.getDescription();
		String sql = "insert into `spring_sinhvien`(`ma_sv`,`ho_ten`,"
				+ "`nam_sinh`,`email`,`dia_chi`,`lop_hoc`,`myimage`,`description`) values('"+masv+"','"+hoten+
				"','"+namsinh+"','"+email+"','"+diachi+"','"+lophoc+"','"+file+"','"+descrip+"')";
		return template.update(sql);
	}

	public int update(SinhVien sv) {
		int masv = sv.getMa_sv();
		String hoten = sv.getHo_ten();
		String namsinh = sv.getNam_sinh();
		String email = sv.getEmail();
		String diachi = sv.getDia_chi();
		String lophoc = sv.getLop_hoc();
		String sql = "update spring_sinhvien set ho_ten='"+hoten+"',nam_sinh='"
				+namsinh+"',email='"+email+"',dia_chi='"+diachi+"',lop_hoc='"+lophoc+
				"' where ma_sv='"+masv+"' ";
		return template.update(sql);
	}

	public int delete(int id) {
		int masv = id;
		String sql = "delete from spring_sinhvien where ma_sv='"+masv+"'";
		return template.update(sql);
	}

	public SinhVien getSV(int masv) {
		String sql = "select * from spring_sinhvien where ma_sv=?";
		return template.queryForObject(sql, new Object[] {masv},
				new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}
	
	public List<SinhVien> getSVbyPage(int start,int total){
		String sql="select * from spring_sinhvien limit "+start+","+total+"";
		return template.query(sql,new RowMapper<SinhVien>(){
			public SinhVien mapRow(ResultSet rs,int row) throws SQLException {
				SinhVien sv = new SinhVien();
				sv.setMa_sv(rs.getInt("ma_sv"));
				sv.setHo_ten(rs.getString("ho_ten"));
				sv.setNam_sinh(rs.getString("nam_sinh"));
				sv.setEmail(rs.getString("email"));
				sv.setDia_chi(rs.getString("dia_chi"));
				sv.setLop_hoc(rs.getString("lop_hoc"));
				sv.setAvatar(rs.getString("myimage"));
				sv.setDescription(rs.getString("description"));
				return sv;
			}
		});
	}
	
	public int countSV() throws SQLException {
		String sql="select count(*) from spring_sinhvien";
		return template.queryForObject(sql, Integer.class);
	}
}