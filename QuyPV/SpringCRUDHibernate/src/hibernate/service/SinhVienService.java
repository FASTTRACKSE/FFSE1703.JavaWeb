package hibernate.service;

import java.util.List;

import hibernate.entity.SinhVien;

public interface SinhVienService {
	public List<SinhVien> sinhVienList(int start, int end);
	public List<SinhVien>sinhVienListExport();
	public void delete(int id);
	public SinhVien getEdit(int id);
	public void update(final SinhVien sv);
	public void insert(SinhVien sv);
	public boolean checkExistMaSv(String maSv);
	public long totalRecord();
	
	// test hibernate
	public List<SinhVien> sinhVienListHibernate(Integer start, Integer maxResult);
}
