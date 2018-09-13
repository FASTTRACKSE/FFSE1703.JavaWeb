package hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hibernate.dao.StudentDao;
import hibernate.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;
	
	

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	@Transactional
	public void addStudent(Student p) {
		this.studentDao.addStudent(p);
		
	}

	@Override
	@Transactional
	public void updateStudent(Student p) {
		this.studentDao.updateStudent(p);
		
	}

	@Override
	@Transactional
	public List<Student> listStudent(int start,int maxRows) {
		return this.studentDao.listStudent(start,maxRows);
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		
		return this.studentDao.getStudentById(id);
	}

	@Override
	@Transactional
	public void removeStudent(int id) {
		this.studentDao.removeStudent(id);
		
	}
	
	@Transactional
	public Long countStudent() {
		return this.studentDao.countStudent();
	}

}
