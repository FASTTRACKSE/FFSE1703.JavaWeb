package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

import model.entity.*;

public class SinhVienDAO {
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<SinhVien> getAllStudent(int start, int limit) {
		String sql = "SELECT * FROM sinhvien_spring ORDER BY MaSV ASC LIMIT "+start+","+limit;
		return template.query(sql, new ResultSetExtractor<List<SinhVien>>() {
			@Override
			public List<SinhVien> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				List<SinhVien> list = new ArrayList<SinhVien>();
				while (rs.next()) {
					String maSV = rs.getString("MaSV");
					String tenSV = rs.getString("TenSV");
					String namSinh = rs.getString("NamSinh");
					String email = rs.getString("Email");
					String diaChi = rs.getString("DiaChi");
					String lopHoc = rs.getString("LopHoc");
					String avatar = rs.getString("Avatar");
					SinhVien sv = new SinhVien(maSV, tenSV, namSinh, email, diaChi, lopHoc, avatar);
					list.add(sv);
				}
				return list;
			}
		});
	}

	public boolean insertStudent(SinhVien sv) {
		String sql = "INSERT INTO sinhvien_spring (MaSV, TenSV, NamSinh, Email, DiaChi, LopHoc, Avatar) VALUES(?,?,?,?,?,?,?)";
		return template.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, sv.getMaSV());
				ps.setString(2, sv.tenSV);
				ps.setString(3, sv.namSinh);
				ps.setString(4, sv.email);
				ps.setString(5, sv.diaChi);
				ps.setString(6, sv.lopHoc);
				ps.setString(7, sv.avatar);

				return ps.execute();

			}
		});
	}

	public SinhVien getStudent(String maSV) {
		String sql = "SELECT * FROM sinhvien_spring WHERE MaSV = ?";
		return template.execute(sql, new PreparedStatementCallback<SinhVien>() {

			@Override
			public SinhVien doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				SinhVien extSV = new SinhVien();
				ps.setString(1, maSV);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String maSV = rs.getString("MaSV");
					String tenSV = rs.getString("TenSV");
					String namSinh = rs.getString("NamSinh");
					String email = rs.getString("Email");
					String diaChi = rs.getString("DiaChi");
					String lopHoc = rs.getString("LopHoc");
					String avatar = rs.getString("Avatar");
					extSV = new SinhVien(maSV, tenSV, namSinh, email, diaChi, lopHoc, avatar);
				}
				return extSV;
			}
		});
	}

	public boolean updateStudent(SinhVien sv) {
		String sql = "UPDATE sinhvien_spring SET TenSV = ?, NamSinh = ?, Email = ?, DiaChi = ?, LopHoc = ?, Avatar = ? WHERE MaSV = ?";
		return template.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, sv.tenSV);
				ps.setString(2, sv.namSinh);
				ps.setString(3, sv.email);
				ps.setString(4, sv.diaChi);
				ps.setString(5, sv.lopHoc);
				ps.setString(6, sv.avatar);
				ps.setString(7, sv.maSV);
				

				return ps.execute();

			}
		});
	}

	public boolean deleteStudent(String maSV) {
		String sql = "DELETE FROM sinhvien_spring WHERE MaSV = ? ";
		return template.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, maSV);

				return ps.execute();

			}
		});
	}

	public boolean checkStudent(String maSV) {
		String sql = "SELECT * FROM sinhvien_spring WHERE MaSV = ? ";
		return template.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, maSV);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return true;
				}
				return false;

			}
		});
	}
	
	public int countStudent() {
		String sql = "SELECT COUNT(*) FROM sinhvien_spring";
		return template.queryForObject(sql, Integer.class);
	}
}
