package com.fasttrack.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasttrack.dao.StudentDao;
import com.fasttrack.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	 StudentDao studentDao;
	
	public void setStudentDAO(StudentDao studentDao) {
		this.studentDao = studentDao;
	
	}

	public void create(Student student){
		studentDao.create(student);
	}
	
	public List<Student> listStudent(){
		return studentDao.listStudent();
	}
	
	public Student findById(int id) {
		return studentDao.findById(id);
	}
	
	public void delete(int id) {
		studentDao.delete(id);
	}
	
	public void update(Student student) {
		studentDao.update(student);
	}
	
	public List<Student> findAllForPaging(int startPosition,int maxResult){
		return studentDao.findAllForPaging(startPosition, maxResult);
	}
}
