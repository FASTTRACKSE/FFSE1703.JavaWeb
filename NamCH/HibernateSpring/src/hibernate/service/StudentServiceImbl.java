package hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.dao.StudentDao;
import hibernate.entity.Student;

@Service
public class StudentServiceImbl implements StudentService{
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
	public void addStudent(Student std) {
		this.studentDao.addStudent(std);
	}

	@Override
	@Transactional
	public void updateStudent(Student std) {
		this.studentDao.updateStudent(std);
	}

	@Override
	@Transactional
	public List<Student> listStudent(int start,int end) {
		return this.studentDao.listStudent(start, end);
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

	@Override
	@Transactional
	public Long countStudent() {
		// TODO Auto-generated method stub
		return this.studentDao.countStudent();
	}

}
