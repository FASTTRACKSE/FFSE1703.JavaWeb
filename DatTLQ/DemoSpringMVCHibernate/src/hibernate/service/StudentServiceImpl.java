package hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hibernate.dao.StudentDao;
import hibernate.entity.Student;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao=studentDao;
	}
	@Override
	@Transactional
	public void addStudent(Student sv) {
		// TODO Auto-generated method stub
		this.studentDao.addStudent(sv);
	}

	@Override
	@Transactional
	public void updateStudent(Student sv) {
		// TODO Auto-generated method stub
		this.studentDao.updateStudent(sv);
	}

	@Override
	@Transactional
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		return this.studentDao.listStudent();
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return this.studentDao.getStudentById(id);
	}

	@Override
	@Transactional
	public void removeStudent(int id) {
		// TODO Auto-generated method stub
		this.studentDao.removeStudent(id);
	}
	@Override
	@Transactional
	public List<Student> listStudent(int start, int limit) {
		return this.studentDao.listStudent(start, limit);
	}

	@Override
	@Transactional
	public int countStudents() {
		return this.studentDao.countStudents();
	}

}
