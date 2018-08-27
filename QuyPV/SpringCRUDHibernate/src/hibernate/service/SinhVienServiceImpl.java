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
		// TODO Auto-generated method stub
		return sinhVienDao.getEdit(id);
	}

	@Override
	public void update(SinhVien sv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void insert(SinhVien sv) {
		sinhVienDao.insert(sv);
		
	}

	@Override
	@Transactional
	public String checkExistMaSv(String maSv) {
		// TODO Auto-generated method stub
		return sinhVienDao.checkExistMaSv(maSv);
	}

	@Override
	@Transactional
	public long totalRecord() {
		return sinhVienDao.totalRecord();
	}

}
