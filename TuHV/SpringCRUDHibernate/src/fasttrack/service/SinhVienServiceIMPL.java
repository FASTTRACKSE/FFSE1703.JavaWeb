package fasttrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrack.dao.SinhVienDao;
import fasttrack.entity.SinhVien;

@Service
public class SinhVienServiceIMPL implements SinhVienService {
	@Autowired
	SinhVienDao sinhVienDao;

	public void setStudentDAO(SinhVienDao sinhVienDao) {
		this.sinhVienDao = sinhVienDao;

	}

	@Override
	@Transactional
	public List<SinhVien> listStudent() {
		return this.sinhVienDao.listStudent();
	}

	@Override
	@Transactional
	public SinhVien findById(int id) {
		return this.sinhVienDao.findById(id) ;
	}

	@Override
	@Transactional
	public void add(SinhVien sinhvien) {
		this.sinhVienDao.create(sinhvien);
	}

	@Override
	@Transactional
	public void update(SinhVien sinhvien) {
		this.sinhVienDao.update(sinhvien);

	}

	@Override
	@Transactional
	public void delete(int id) {
		this.sinhVienDao.delete(id);

	}

	@Override
	@Transactional
	public List<SinhVien> findAllForPaging(int startPosition, int maxResult) {
		return this.sinhVienDao.findAllForPaging(startPosition, maxResult);
	}

}