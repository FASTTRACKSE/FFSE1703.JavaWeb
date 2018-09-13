package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.StudentDao;
import com.spring.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	 StudentDao studentDao;
	
	public void setStudentDAO(StudentDao studentDao) {
		this.studentDao = studentDao;
	
	}
	@Override
	@Transactional
	public void create(Student student){
		studentDao.create(student);
	}
	@Override
	@Transactional
	public List<Student> listStudent(){
		return studentDao.listStudent();
	}
	@Override
	@Transactional
	public Student findById(int id) {
		return studentDao.findById(id);
	}
	@Override
	@Transactional
	public void delete(int id) {
		studentDao.delete(id);
	}
	@Override
	@Transactional
	public void update(Student student) {
		studentDao.update(student);
	}
	@Override
	@Transactional
	public List<Student> findAllForPaging(int startPosition,int maxResult){
		return studentDao.findAllForPaging(startPosition, maxResult);
	}
}
