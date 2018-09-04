package hibernate.service;

import java.util.List;

import hibernate.entity.SinhVien;

public interface SinhVienService {
	public List<SinhVien> listSinhVien(int start, int limit);
	public void delete(int id);
	public SinhVien getEdit(int id);
	public void update(final SinhVien sv);
	public void insert(SinhVien sv);
	public boolean checkExistMaSv(String maSv);
	public long totalRecord();
}
