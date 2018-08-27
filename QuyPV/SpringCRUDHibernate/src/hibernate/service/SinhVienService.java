package hibernate.service;

import java.util.List;

import hibernate.entity.SinhVien;

public interface SinhVienService {
	public List<SinhVien> sinhVienList(int start, int end);
	public void delete(int id);
	public SinhVien getEdit(int id);
	public void update(final SinhVien sv);
	public void insert(SinhVien sv);
	public String checkExistMaSv(String maSv);
	public long totalRecord();
}
