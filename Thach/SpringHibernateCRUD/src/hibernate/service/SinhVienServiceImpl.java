package hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hibernate.dao.SinhVienDao;
import hibernate.entity.SinhVien;

@Service
public class SinhVienServiceImpl implements SinhVienService{
	
	private SinhVienDao sinhvienDao;
	
	@Autowired
	public void setSinhVienDao(SinhVienDao sinhvienDao) {
		this.sinhvienDao = sinhvienDao;
	}
	@Override
	@Transactional
	public List<SinhVien> listSinhVien(int start, int limit) {
		return this.sinhvienDao.listSinhVien(start, limit);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.sinhvienDao.delete(id);
		
	}

	@Override
	@Transactional
	public SinhVien getEdit(int id) {
		return this.sinhvienDao.getEdit(id);
	}

	@Override
	@Transactional
	public void update(SinhVien sv) {
		this.sinhvienDao.update(sv);
		
	}

	@Override
	@Transactional
	public void insert(SinhVien sv) {
		 this.sinhvienDao.insert(sv);
	}

	@Override
	@Transactional
	public boolean checkExistMaSv(String maSv) {
		return sinhvienDao.checkExistMaSv(maSv);
	}

	@Override
	@Transactional
	public long totalRecord() {
		return this.sinhvienDao.totalRecord();
	}
	
	
}
