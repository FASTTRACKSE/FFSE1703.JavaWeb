package hiberspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hiberspring.model.dao.StudentDAO;
import hiberspring.model.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	@Transactional
	public List<Student> listStudent(int start, int limit) {
		return this.studentDAO.listStudent(start, limit);
	}

	@Override
	@Transactional
	public boolean checkStudent(String maSV) {
		return this.studentDAO.checkStudent(maSV);
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		this.studentDAO.addStudent(student);
	}

	@Override
	@Transactional
	public Student getStudentById(String maSV) {
		return this.studentDAO.getStudentById(maSV);
	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		this.studentDAO.updateStudent(student);
	}

	@Override
	@Transactional
	public void deleteStudent(String maSV) {
		this.studentDAO.deleteStudent(maSV);
	}

	@Override
	@Transactional
	public int countStudents() {
		return this.studentDAO.countStudents();
	}

}
