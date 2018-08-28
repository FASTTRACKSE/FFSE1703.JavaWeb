package hibernate.dao;

import java.util.List;

import hibernate.entity.SinhVien;


public interface SinhVienDao {
	public List<SinhVien> listSinhVien(int start, int limit);
	public void delete(int id);
	public SinhVien getEdit(int id);
	public void update(final SinhVien sv);
	public void insert(SinhVien sv);
	public int checkExistMaSv(String maSv);
	public long totalRecord();
}
