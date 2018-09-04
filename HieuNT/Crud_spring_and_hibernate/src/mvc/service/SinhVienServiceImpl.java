package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvc.dao.SinhVienDao;
import mvc.entity.Student;

@Service
public class SinhVienServiceImpl implements SinhVienService {

	@Autowired
	private SinhVienDao sinhVienDao;

	// @Override
	// @Transactional
	// public List<Student> getAll() {
	// return sinhVienDao.getAll();
	// }

	@Override
	@Transactional
	public void addSV(Student p) {
		sinhVienDao.addSV(p);
	}

	@Override
	@Transactional
	public void deleteSinhVien(int id) {
		sinhVienDao.deleteSinhVien(id);
	}

	@Override
	@Transactional
	public Student getSinhVienByID(int id) {
		return sinhVienDao.getSinhVienByID(id);

	}

	@Override
	@Transactional
	public void updateSV(Student p) {
		sinhVienDao.updateSV(p);
	}

	@Override
	@Transactional
	public List<Student> findAll(Integer offset, Integer maxResult) {
		return sinhVienDao.findAll(offset, maxResult);
	}

	@Override
	@Transactional
	public int count() {
		return sinhVienDao.count();
	}

}
