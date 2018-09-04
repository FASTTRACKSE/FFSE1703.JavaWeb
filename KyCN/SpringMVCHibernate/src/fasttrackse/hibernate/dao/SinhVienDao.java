package fasttrackse.hibernate.dao;

import java.util.List;

import fasttrackse.hibernate.entity.*;

public interface SinhVienDao {
	public List<SinhVien> listStudent();

	public SinhVien findById(int id);

	public void delete(int id);

	public void update(SinhVien sinhvien);

	public void create(SinhVien sinhvien);
	
	public List<SinhVien> findAllForPaging(int startPosition,int maxResult);
}