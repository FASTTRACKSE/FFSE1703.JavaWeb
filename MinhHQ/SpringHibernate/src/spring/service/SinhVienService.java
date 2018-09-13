package spring.service;

import java.util.List;

import spring.model.entity.SinhVien;

public interface SinhVienService {
	public List<SinhVien> listStudent();
	public SinhVien findById(int id);
	public void add(SinhVien sinhvien);
	public void update(SinhVien sinhvien);
	public void delete(int id);
	public List<SinhVien> findAllForPaging(int startPosition,int maxResult);
}
