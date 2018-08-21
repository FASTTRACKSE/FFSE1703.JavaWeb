package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.javatpoint.beans.SinhVien;

public class SVDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(SinhVien p) {
		String sql = "INSERT INTO sinhh_vienn( maSV, tenSV, namSinh, Email, diaChi, lopHoc) VALUES ('" + p.getMaSV()
				+ "','" + p.getTenSV() + "'," + p.getNamSinh() + ",'" + p.getEmail() + "','" + p.getDiaChi() + "','"
				+ p.getLopHoc() + "')";
		return template.update(sql);
	}

	public int update(SinhVien p) {
		String sql = "UPDATE sinhh_vienn SET maSV='" + p.getMaSV() + "',tenSV='" + p.getTenSV() + "',namSinh="
				+ p.getNamSinh() + ",Email='" + p.getEmail() + "',diaChi='" + p.getDiaChi() + "',lopHoc='"
				+ p.getLopHoc() + "' WHERE id=" + p.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from sinhh_vienn where id=" + id + "";
		return template.update(sql);
	}

	public SinhVien getEmpById(int id) {
		String sql = "select * from sinhh_vienn where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	public List<SinhVien> getEmployees() {
		return template.query("select * from sinhh_vienn", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));
				e.setMaSV(rs.getString(2));
				e.setTenSV(rs.getString(3));
				e.setNamSinh(rs.getInt(4));
				e.setEmail(rs.getString(5));
				e.setDiaChi(rs.getString(6));
				e.setLopHoc(rs.getString(7));
				return e;
			}
		});
	}

	public List<SinhVien> getEmployeesByPage(int pageid, int total) {
		String sql = "select * from sinhh_vienn limit " + (pageid) + "," + total;
		return template.query(sql, new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));
				e.setMaSV(rs.getString(2));
				e.setTenSV(rs.getString(3));
				e.setNamSinh(rs.getInt(4));
				e.setEmail(rs.getString(5));
				e.setDiaChi(rs.getString(6));
				e.setLopHoc(rs.getString(7));
				return e;
			}
		});
	}
	
	public int countSV() throws SQLException {
		String sql="select count(*) from sinhh_vienn";
		return template.queryForObject(sql, Integer.class);
	}
}