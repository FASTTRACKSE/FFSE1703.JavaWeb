package hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.dao.SinhVienDao;
import hibernate.entity.SinhVien;

@Service
public class SinhVienServiceImpl implements SinhVienService {
	@Autowired
	private SinhVienDao sinhVienDao;
	
	public void setSinhVienDao(SinhVienDao sinhVienDao) {
		this.sinhVienDao = sinhVienDao;
	}

	@Override
	@Transactional
	public List<SinhVien> sinhVienList(int start, int end) {
		return this.sinhVienDao.sinhVienList(start, end);
	}

	@Override
	@Transactional
	public void delete(int id) {
		sinhVienDao.delete(id);
		
	}

	@Override
	@Transactional
	public SinhVien getEdit(int id) {
		return sinhVienDao.getEdit(id);
	}

	@Override
	@Transactional
	public void update(SinhVien sv) {
		sinhVienDao.update(sv);
		
	}

	@Override
	@Transactional
	public void insert(SinhVien sv) {
		sinhVienDao.insert(sv);
		
	}

	@Override
	@Transactional
	public boolean checkExistMaSv(String maSv) {
		// TODO Auto-generated method stub
		return sinhVienDao.checkExistMaSv(maSv);
	}

	@Override
	@Transactional
	public long totalRecord() {
		return sinhVienDao.totalRecord();
	}

}
