package fasttrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrack.dao.SinhVienDao;
import fasttrack.entity.Student;

@Service
@Transactional
public class SinhVienServiceIPM implements SinhVienService {

	@Autowired
	SinhVienDao sinhVienDao;
	
	
	public void setStudentDAO(SinhVienDao sinhVienDao) {
		this.sinhVienDao = sinhVienDao;
	
	}

	public void create(Student student){
		sinhVienDao.create(student);
	}
	
	public List<Student> listStudent(){
		return sinhVienDao.listStudent();
	}
	
	public Student findById(int id) {
		return sinhVienDao.findById(id);
	}
	
	public void delete(int id) {
		sinhVienDao.delete(id);
	}
	
	public void update(Student student) {
		sinhVienDao.update(student);
	}
	
	public List<Student> findAllForPaging(int startPosition,int maxResult){
		return sinhVienDao.findAllForPaging(startPosition, maxResult);
	}
}
